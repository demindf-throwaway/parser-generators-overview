#ifndef EXPR_LEXER_H
#define EXPR_LEXER_H

#include <istream>

#include "exprFlexLexer.h"
#include "parser.hpp"
#include "position.hh"
#include "location.hh"

struct expr_lexer : exprFlexLexer
{
    using exprFlexLexer::exprFlexLexer;
    yyexpr::position pos;
    yyexpr::location last_loc;
    yyexpr::expr_parser::symbol_type next_token();
    void restart(std::istream& in)
    {
        pos.initialize();
        yyrestart(&in);
    }
};

#endif // EXPR_LEXER_H
