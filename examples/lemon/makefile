
all: expr

expr: expr.c main.c
	g++ expr.c main.c -o expr

main.c: expr.h

expr.c expr.h: expr.y lemon lempar.c
	./lemon expr.y

lemon: lemon.c
	g++ lemon.c -o lemon

clean:
	rm -f expr.h expr.c expr.out

clean-all: clean
	rm -f lemon expr
