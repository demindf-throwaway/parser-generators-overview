%token_type {double}

%left PLUS MINUS.
%left DIVIDE TIMES.

%include {
#include <iostream>
#include <cassert>
}

%syntax_error {  
  std::cout << "Syntax error!" << std::endl;
}

program ::= expr(A).   { std::cout << "Result=" << A <<std::endl; }
   
expr(A) ::= expr(B) MINUS  expr(C).  { A = B - C; }
expr(A) ::= expr(B) PLUS  expr(C).   { A = B + C; }
expr(A) ::= expr(B) TIMES  expr(C).  { A = B * C; }
expr(A) ::= expr(B) DIVIDE expr(C).  { A = B / C; }

expr(A) ::= INTEGER(B). { A = B; }
