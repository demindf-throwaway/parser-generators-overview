# Корректно матчит xml.
import regex 

def repl(f):
    while True:
        request = input("=>")
        if request == "exit" or request == "quit": break
        f(request)

xml_grammar = r"""
    (?(DEFINE) # Таблица с нетерминалами:
        (?<xmlNode> \< {s} (?<val> (?&NAME)) {s} (?&attributes)* {s} \>
                        {s} (?&xmlTree) {s}
                    \<\/ {s} (?P=val) {s} \>                 )

        (?<xmlTree> (?: (?&xmlNode) | (?&TEXT))*             )


        (?<attributes> (?&NAME) \= (?&STRING)                )
        
        (?<STRING>  "[^"]*"                                  )
        (?<NAME>    \w+                                      )
        (?<TEXT>    [^<]+                                    )
    )
    {s}(?&xmlTree){s}
""".format(s=r'\s*')

def xml_validator(expr):
    m = regex.fullmatch(xml_grammar, expr, regex.X | regex.DOTALL)
    print(m)
    if m is None: print("Syntax error")
    else:
        print("Ok, valid xml")
        print(m.capturesdict())



def main():
    repl(xml_validator)

if __name__ == "__main__":
    main()
