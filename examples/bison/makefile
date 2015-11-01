FLEX = flex
CXXFLAGS = -std=c++11 -Wall -g -Wno-unused-variable
C++ = g++
BISON = bison
RM = rm -f
OUTPUT = example_calculator
BUILDDIR = build
EXPR_PARSER = expr_parser/parser.cpp  \
              expr_parser/parser.hpp  \
              expr_parser/stack.hh    \
              expr_parser/location.hh \
              expr_parser/position.hh
EXPR_LEXER =  expr_parser/lexer.cpp
XML_PARSER = xml_parser/parser.cpp  \
             xml_parser/parser.hpp  \
             xml_parser/stack.hh    \
             xml_parser/location.hh \
             xml_parser/position.hh
XML_LEXER =  xml_parser/lexer.cpp

SOURCES = expr_parser/parser.cpp \
		  expr_parser/lexer.cpp \
		  xml_parser/parser.cpp \
		  xml_parser/lexer.cpp \
		  main.cpp

all: ${OUTPUT}

${OUTPUT}: main.cpp ${EXPR_PARSER} ${EXPR_LEXER} ${XML_PARSER} ${XML_LEXER}
	${C++} ${CXXFLAGS} ${SOURCES} -o ${OUTPUT}

main.cpp: expr_parser/lexer.h

${EXPR_PARSER}: expr_parser/parser.ypp expr_parser/lexer.h
	${BISON} -o expr_parser/parser.cpp expr_parser/parser.ypp

${EXPR_LEXER}: expr_parser/lexer.y expr_parser/lexer.h expr_parser/lexer.patch
	${FLEX} -o expr_parser/lexer.cpp expr_parser/lexer.y
	# Small fix to fix -Wsign-compare warning:
	patch expr_parser/lexer.cpp < expr_parser/lexer.patch

${XML_PARSER}: xml_parser/parser.ypp xml_parser/lexer.h
	${BISON} -o xml_parser/parser.cpp xml_parser/parser.ypp
	# I think, but not sure, it is a bug in bison but it's can be easily fixed
	patch xml_parser/parser.cpp < xml_parser/parser.patch

${XML_LEXER}: xml_parser/lexer.y xml_parser/lexer.h xml_parser/lexer.patch
	${FLEX} -o xml_parser/lexer.cpp xml_parser/lexer.y
	# Small fix to fix -Wsign-compare warning:
	patch xml_parser/lexer.cpp < xml_parser/lexer.patch

clean-xml-parser:
	${RM} ${XML_LEXER} ${XML_PARSER}

clean-expr-parser:
	${RM} ${EXPR_LEXER} ${EXPR_PARSER}

clean: clean-expr-parser clean-xml-parser

clean-all: clean
	${RM} ${OUTPUT}
