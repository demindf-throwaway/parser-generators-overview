%option c++
%option noyywrap
%option warn nodefault
%option prefix="xml"
    /* А ещё лексер с этой опцией кидает маленький warning. */
%option yylineno

%{
    #include <string>

    #define XML_FLEX_LEXER_H // Hack to avoid recursive include
    #include "lexer.h"
    #include "location.hh"

    // Declaration header for lexing function
    typedef yyxml::xml_parser xml_parser;
    #define YY_DECL xml_parser::symbol_type xml_lexer::next_token()

    // End of stream.
    #define yyterminate() return yyxml::xml_parser::make_END(last_loc);

    // We don't need this function because it has wrong return type:
    int xmlFlexLexer::yylex() { return -1; }

    // Track location information
    #define YY_USER_ACTION \
        last_loc = yyxml::location(pos, pos + yyleng); pos += yyleng;

    #define EMIT_JUST(name) return xml_parser::make_ ## name(last_loc)
    #define EMIT(name, value) return xml_parser::make_ ## name(value, last_loc)
    #define EMIT_CHAR return xml_parser::symbol_type(static_cast<xml_parser::token::yytokentype>(*yytext), last_loc)
%}

%x INSIDE_TAG

%%

    /* skip comments */
\<!--(([^-]*-)+-)+>
    
    /* closing tag open */
\<\/             yy_push_state(INSIDE_TAG); EMIT_JUST(CLOSE_TAG);

    /* open tag */
\<              yy_push_state(INSIDE_TAG); EMIT_CHAR;
    
    /* everything before open tag */
[^<]            EMIT(TEXT, yytext);


<INSIDE_TAG>{

[ \t\r\n\v]+    /* skip spaces */
[a-zA-Z0-9]+    EMIT(NAME, yytext);
'[^']*'         EMIT(STRING, yytext);
\"[^"]*\"       EMIT(STRING, yytext);
>               yy_pop_state(); EMIT_CHAR;
=               EMIT_CHAR;
.               yy_pop_state(); throw yyxml::xml_parser::syntax_error(last_loc, "invalid character");

}

%%
