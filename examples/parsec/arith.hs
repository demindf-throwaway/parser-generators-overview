{-# LANGUAGE TupleSections #-}
import Control.Applicative ((<$>), (<*))
import Control.Monad
import Data.Text (Text, pack)
import System.IO

import Text.Parsec

type Parser = Parsec Text ()

infixr 5 <++>
(<++>) = liftM2 (++)

whitespace :: Parser ()
whitespace = void $ oneOf " \n\r\t\v\f"

lexeme :: Parser a -> Parser a
lexeme p = try p <* skipMany whitespace

lexemeStr :: String -> Parser String
lexemeStr = lexeme . string

number :: Parser Double
number = lexeme $ read <$> many1 digit <++> option "" (string "." <++> (many digit))

binOp :: [(String, a -> a -> a)] -> Parser a -> Parser a
binOp [] subExpr = subExpr
binOp operators subExpr = do
    init <- subExpr
    tail <- many $ foldl1 (<|>) $ map prepareChoice operators 
    return $ foldl opChoice init tail
  where
        opChoice left (op, right) = left `op` right
        prepareChoice (opStr, op) = lexemeStr opStr >> subExpr >>= return . (op, )

expr :: Parser Double
expr = skipMany whitespace >> summands

summands :: Parser Double
summands = binOp [("+", (+)), ("-", (-))] prod

prod :: Parser Double
prod = binOp [("*", (*)), ("/", (/))] power

power :: Parser Double
power = do
    left <- value
    right <- option 1 (lexemeStr "^" >>  power)
    return $ left ** right

value :: Parser Double
value = number
     <|> (lexemeStr "(" >> summands <* lexemeStr ")")

repl :: (String -> IO ()) -> IO ()
repl f = do
    putStr "=> "
    hFlush stdout
    request <- getLine
    if request == "exit" then
        return()
    else do 
        f request
        repl f

printLn :: Show a => a -> IO ()
printLn x = print x >> putStr "\n"

handler :: String -> IO ()
handler str = case (parse expr "" (pack str)) of
    Left err -> putStr "Error" >> print err
    Right result -> putStr "Ok: " >> print result 

main :: IO ()
main = repl handler
