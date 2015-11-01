SOURCES = pegged/peg.d \
	      pegged/grammar.d \
	      pegged/parser.d \
	      pegged/dynamic/grammar.d \
	      pegged/dynamic/peg.d \
	      arithmetic.d
DMD = dmd
FLAGS = -property -w -wi -O -release -noboundscheck

arith: arithmetic.d
	${DMD} ${FLAGS} ${SOURCES} -ofarith

clean:
	rm -f arith arith.o
