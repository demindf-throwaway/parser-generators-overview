{
module Main where

import Data.Char
import System.IO
}

%name expression
%tokentype { Token }
%error { parseError }

%token
    number { TokenNumber $$ }
    '+'    { TokenPlus   }
    '-'    { TokenMinus  }
    '*'    { TokenTimes  }
    '/'    { TokenDiv    }
    '^'    { TokenPow    }
    '('    { TokenOB     }
    ')'    { TokenCB     }

%left '+' '-'
%left '*' '/'
%right '^'

%%

Exp : Exp '+' Exp { $1 + $3 }
    | Exp '-' Exp { $1 - $3 }
    | Exp '*' Exp { $1 * $3 }
    | Exp '/' Exp { $1 / $3 }
    | Exp '^' Exp { $1 ** $3 }
    | '(' Exp ')' { $2 }
    | number      { $1 }

{
data Token
    = TokenNumber Double
    | TokenPlus
    | TokenMinus
    | TokenTimes
    | TokenDiv
    | TokenPow
    | TokenOB
    | TokenCB
    deriving Show

-- Халтурная обработка ошибок:
parseError :: [Token] -> a
parseError _ = error "Parse error"

lexer :: String -> [Token]
lexer [] = []
lexer (c:cs)
    | isDigit c = lexNum (c:cs)
    | isSpace c = lexer cs
lexer ('+':cs) = TokenPlus : lexer cs
lexer ('-':cs) = TokenMinus : lexer cs
lexer ('*':cs) = TokenTimes : lexer cs
lexer ('/':cs) = TokenDiv : lexer cs
lexer ('(':cs) = TokenOB : lexer cs
lexer (')':cs) = TokenCB : lexer cs

lexNum cs = TokenNumber (read num :: Double) : lexer rest
    where (num,rest) = span (\c -> isDigit c || c == '.') cs

-- Copy paste from parsec example
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
handler str = putStr "Ok: " >> (print . expression . lexer) str

main :: IO ()
main = repl handler

}
