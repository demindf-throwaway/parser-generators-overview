#ifndef EXPR_FLEX_LEXER_H
#define EXPR_FLEX_LEXER_H

#undef yyFlexLexer
#define yyFlexLexer exprFlexLexer
#include <FlexLexer.h>
#undef yyFlexLexer

#endif // EXPR_FLEX_LEXER_H
