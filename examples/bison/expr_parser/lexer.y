%option c++
%option noyywrap
%option warn nodefault
%option prefix="expr"
    /* А ещё лексер с этой опцией кидает маленький warning. */
%option yylineno

%{
    #include <string>

    #define EXPR_FLEX_LEXER_H // Hack to avoid recursive include
    #include "lexer.h"
    #include "location.hh"

    // Declaration header for lexing function
    typedef yyexpr::expr_parser expr_parser;
    #define YY_DECL expr_parser::symbol_type expr_lexer::next_token()

    // End of stream.
    #define yyterminate() return yyexpr::expr_parser::make_END(last_loc);

    // We don't need this function because it has wrong return type:
    int exprFlexLexer::yylex() { return -1; }

    // Track location information
    #define YY_USER_ACTION \
        last_loc = yyexpr::location(pos, pos + yyleng); pos += yyleng;
%}

%%

    /* skip spaces */
[ \t\r\n\v]+

    /* floating-point number */
([[:digit:]]+(\.[[:digit:]]*)?)  return expr_parser::make_NUMBER(std::stod(yytext), last_loc);

    /* emit single charater*/
. return expr_parser::symbol_type(static_cast<expr_parser::token::yytokentype>(*yytext), last_loc);

%%
