// Generated from /home/dmitriy/stuff/projects/A4200/parser-generators-overview/examples/antlr/src/ru/parserexamples/XMLParser.g4 by ANTLR 4.5.1
package ru.parserexamples;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XMLParser#xmlTree}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXmlTree(XMLParser.XmlTreeContext ctx);
	/**
	 * Visit a parse tree produced by {@link XMLParser#attributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributes(XMLParser.AttributesContext ctx);
}