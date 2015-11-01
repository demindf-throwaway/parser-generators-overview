package ru.parserexamples;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;


import java.io.IOException;

public class Main {

    // TODO:
    // Java generics are stupid. You have to actually pass class objects around to abstract this code.
    public static ArithmParser.ExprContext expr(String expr) {
        ArithmLexer lexer = new ArithmLexer(new ANTLRInputStream(expr));
        ArithmParser parser = new ArithmParser(new CommonTokenStream(lexer));
        return parser.expr();
    }

    public static XMLParser.XmlTreeContext xmlTree(String xml) {
        XMLLexer lexer = new XMLLexer(new ANTLRInputStream(xml));
        XMLParser parser = new XMLParser(new CommonTokenStream(lexer));
        return parser.xmlTree();
    }

    public static void main(String[] args) {
//        System.out.println(expr("2 + (6-5/5 ^ 7 ^ 0) * 7 + 1").toString());
        System.out.println(xmlTree("<hello> World </hello>").toStringTree());
        xmlTree("<hello> World </hell>");
//        System.out.println(xmlTree("<hello> World </hell>").toStringTree());
    }
}
