#ifndef XML_LEXER_H
#define XML_LEXER_H

#include <istream>

#include "xmlFlexLexer.h"
#include "parser.hpp"
#include "position.hh"
#include "location.hh"

struct xml_lexer : xmlFlexLexer
{
    using xmlFlexLexer::xmlFlexLexer;
    yyxml::position pos;
    yyxml::location last_loc;
    yyxml::xml_parser::symbol_type next_token();
    void restart(std::istream& in)
    {
        pos.initialize();
        yyrestart(&in);
    }
};

#endif // XML_LEXER_H
