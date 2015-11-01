lexer grammar XMLLexer;

tokens { STRING }

COMMENT : '<!--' .*? '-->' -> skip;
CLOSING_TAG_OPEN : '</' -> pushMode(INSIDE_TAG);
TAG_OPEN : '<' -> pushMode(INSIDE_TAG) ;
TEXT : ~'<'+ ;

mode INSIDE_TAG;

NAME : [a-zA-Z0-9]+ ;
EQUALS : '=' ;
TAG_CLOSE : '>' -> popMode ;
SIGNLE : '\'' .*? '\'' -> type(STRING);
DOUBLE : '"' .*? '"' -> type(STRING);

WS : [ \t\r\n]+ -> skip ;
