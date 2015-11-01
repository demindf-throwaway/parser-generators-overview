/*
    Взято с микромодификациями из: 
    http://souptonuts.sourceforge.net/readme_lemon_tutorial.html
*/
#include <cstdlib>
#include "expr.h"

void* ParseAlloc(void* (*allocProc)(size_t));
void Parse(void*, int, double);
void ParseFree(void*, void(*freeProc)(void*));

int main()
{
  void* pParser = ParseAlloc (malloc);

  /* First input: 
      15 / 5
                                */
  Parse (pParser, INTEGER, 15);
  Parse (pParser, DIVIDE, 0);
  Parse (pParser, INTEGER, 5);
  Parse (pParser, 0, 0);

  /*  Second input:
        50 + 125
                               */
  Parse (pParser, INTEGER, 50);
  Parse (pParser, PLUS, 0);
  Parse (pParser, INTEGER, 125);
  Parse (pParser, 0, 0);

  /*  Third input:
        50 * 125 + 125
                               */
  Parse (pParser, INTEGER, 50);
  Parse (pParser, TIMES, 0);
  Parse (pParser, INTEGER, 125);
  Parse (pParser, PLUS, 0);
  Parse (pParser, INTEGER, 125);
  Parse (pParser, 0, 0);

  ParseFree(pParser, free);
}
