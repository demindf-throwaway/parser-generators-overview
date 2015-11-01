#include <iostream>
#include <string>
#include <sstream>
#include <cstring>

#include "expr_parser/lexer.h"
#include "expr_parser/parser.hpp"
#include "xml_parser/lexer.h"
#include "xml_parser/parser.hpp"

std::string input()
{
    char const* prompt = "=> ";
    std::cout << prompt;
    std::string answer;
    std::getline(std::cin, answer);
    return answer;
}

template <typename Lexer, typename Parser, typename ResultType>
void repl(std::ostream& out)
{
    Lexer lexer(0, &out);
    ResultType result;
    Parser parser(lexer, result);
    while (true)
    {
        auto request = input();
        if (request == "exit") break;
        std::stringstream stream_in(request);
        lexer.restart(stream_in);
        if (0 == parser.parse())
        {
            std::cout << result << std::endl;
        }
    }    
}

int main(int argc, char** argv)
{
    bool xml = false;
    for (int i = 0; i < argc; ++i)
        if (0 == strcmp("xml", argv[i]))
            xml = true;

    // XML парсер не работает.
    if (xml) repl<xml_lexer, yyxml::xml_parser, std::string>(std::cerr);
    else repl<expr_lexer, yyexpr::expr_parser, double>(std::cerr);
}
