// Generated from /home/dmitriy/stuff/projects/A4200/parser-generators-overview/examples/antlr/src/ru/parserexamples/XMLParser.g4 by ANTLR 4.5.1
package ru.parserexamples;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link XMLParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class XMLParserBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements XMLParserVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitXmlTree(XMLParser.XmlTreeContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitAttributes(XMLParser.AttributesContext ctx) { return visitChildren(ctx); }
}