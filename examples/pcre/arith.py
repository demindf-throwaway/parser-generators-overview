# `regex` на данный момент не является стандартным модулем в python,
# однако в какой-то момент может им стать. Здесь не используются никакие из
# возможностей в regex, которых небыло бы в PCRE.
# Пока-что нужно дополнительно устанавливать `regex`:
# pip install regex

# К сожалению эта библиотека не позволяет восстанавливать AST по результату.
# Это можно было бы теоретически сделать, используя m.spans, но у меня сейчас
# нет на это времени. Так же теоретически можно написать генератор парсеров,
# который бы из embedded dsl генерировал бы PRCE выражение, его парсящее,
# и предоставлял функцию, восстанавливающую AST по результату.
import regex 

def repl(f):
    while True:
        request = input("=>")
        if request == "exit" or request == "quit": break
        f(request)

# Используемая конвенция: каждый нетерминал предполагает, что он окружён
# слева и справа пробелами, поэтому ему нужно только расставлять пробелы внутри
# своих токенов.
arith_grammar = r"""
    (?(DEFINE) # Таблица с нетерминалами:
    #      sum  :     prod  (       (      '+'|'-')       prod  )*
        (?<sum>    (?&prod) (?: {s} (?<s_op>\+|\-) {s} (?&prod) )* )

    #      prod :     exp   (       (      '*'|'÷')       exp   )*
        (?<prod>   (?&exp ) (?: {s} (?<p_op>\*|\\) {s} (?&exp ) )* )

    #      exp  :     val   (        ^        val  )*
        (?<exp>    (?&val ) (?: {s} \^ {s} (?&val) )*              )

    #      val  :     number  |  (        sum       )
        (?<val>    (?&number) | \( {s} (?&sum) {s} \)              )

    #      number: \d+
        (?<number> \d+)
    )

    {s}(?&sum){s}
""".format(s=r'\s*')

def calculator(expr):
    m = regex.fullmatch(arith_grammar, expr, regex.X)
    if m is None: print("Syntax error")
    else:
        print("Ok")
        print(m.spans("prod"))
        print(m.spans("val"))
        print(m.capturesdict())



def main():
    repl(calculator)

if __name__ == "__main__":
    main()