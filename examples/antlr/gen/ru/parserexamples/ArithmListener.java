// Generated from /home/dmitriy/stuff/projects/A4200/parser-generators-overview/examples/antlr/src/ru/parserexamples/Arithm.g4 by ANTLR 4.5.1
package ru.parserexamples;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArithmParser}.
 */
public interface ArithmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArithmParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ArithmParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArithmParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ArithmParser.ExprContext ctx);
}