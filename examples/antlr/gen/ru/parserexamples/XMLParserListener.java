// Generated from /home/dmitriy/stuff/projects/A4200/parser-generators-overview/examples/antlr/src/ru/parserexamples/XMLParser.g4 by ANTLR 4.5.1
package ru.parserexamples;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XMLParser}.
 */
public interface XMLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XMLParser#xmlTree}.
	 * @param ctx the parse tree
	 */
	void enterXmlTree(XMLParser.XmlTreeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XMLParser#xmlTree}.
	 * @param ctx the parse tree
	 */
	void exitXmlTree(XMLParser.XmlTreeContext ctx);
	/**
	 * Enter a parse tree produced by {@link XMLParser#attributes}.
	 * @param ctx the parse tree
	 */
	void enterAttributes(XMLParser.AttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link XMLParser#attributes}.
	 * @param ctx the parse tree
	 */
	void exitAttributes(XMLParser.AttributesContext ctx);
}