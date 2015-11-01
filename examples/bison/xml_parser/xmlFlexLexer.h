#ifndef XML_FLEX_LEXER_H
#define XML_FLEX_LEXER_H

#undef yyFlexLexer
#define yyFlexLexer xmlFlexLexer
#include <FlexLexer.h>
#undef yyFlexLexer

#endif // XML_FLEX_LEXER_H
