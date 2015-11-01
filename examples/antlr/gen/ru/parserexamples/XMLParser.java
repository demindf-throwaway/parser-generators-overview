// Generated from /home/dmitriy/stuff/projects/A4200/parser-generators-overview/examples/antlr/src/ru/parserexamples/XMLParser.g4 by ANTLR 4.5.1
package ru.parserexamples;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XMLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING=1, COMMENT=2, CLOSING_TAG_OPEN=3, TAG_OPEN=4, TEXT=5, NAME=6, EQUALS=7, 
		TAG_CLOSE=8, WS=9;
	public static final int
		RULE_xmlTree = 0, RULE_attributes = 1;
	public static final String[] ruleNames = {
		"xmlTree", "attributes"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'</'", "'<'", null, null, "'='", "'>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "STRING", "COMMENT", "CLOSING_TAG_OPEN", "TAG_OPEN", "TEXT", "NAME", 
		"EQUALS", "TAG_CLOSE", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XMLParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class XmlTreeContext extends ParserRuleContext {
		public Token open_tag;
		public Token close_tag;
		public List<TerminalNode> TEXT() { return getTokens(XMLParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(XMLParser.TEXT, i);
		}
		public List<XmlTreeContext> xmlTree() {
			return getRuleContexts(XmlTreeContext.class);
		}
		public XmlTreeContext xmlTree(int i) {
			return getRuleContext(XmlTreeContext.class,i);
		}
		public List<TerminalNode> NAME() { return getTokens(XMLParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(XMLParser.NAME, i);
		}
		public List<AttributesContext> attributes() {
			return getRuleContexts(AttributesContext.class);
		}
		public AttributesContext attributes(int i) {
			return getRuleContext(AttributesContext.class,i);
		}
		public XmlTreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xmlTree; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).enterXmlTree(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).exitXmlTree(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XMLParserVisitor ) return ((XMLParserVisitor<? extends T>)visitor).visitXmlTree(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XmlTreeContext xmlTree() throws RecognitionException {
		XmlTreeContext _localctx = new XmlTreeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_xmlTree);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_OPEN || _la==TEXT) {
				{
				setState(20);
				switch (_input.LA(1)) {
				case TEXT:
					{
					setState(4);
					match(TEXT);
					}
					break;
				case TAG_OPEN:
					{
					setState(5);
					match(TAG_OPEN);
					setState(6);
					((XmlTreeContext)_localctx).open_tag = match(NAME);
					setState(10);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NAME) {
						{
						{
						setState(7);
						attributes();
						}
						}
						setState(12);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(13);
					match(TAG_CLOSE);
					setState(14);
					xmlTree();
					setState(15);
					match(CLOSING_TAG_OPEN);
					setState(16);
					((XmlTreeContext)_localctx).close_tag = match(NAME);
					{
					setState(17);
					if (!( (((XmlTreeContext)_localctx).open_tag!=null?((XmlTreeContext)_localctx).open_tag.getText():null).equals((((XmlTreeContext)_localctx).close_tag!=null?((XmlTreeContext)_localctx).close_tag.getText():null)) )) throw new FailedPredicateException(this, " $open_tag.text.equals($close_tag.text) ");
					setState(18);
					match(TAG_CLOSE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributesContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(XMLParser.NAME, 0); }
		public TerminalNode STRING() { return getToken(XMLParser.STRING, 0); }
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XMLParserListener ) ((XMLParserListener)listener).exitAttributes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XMLParserVisitor ) return ((XMLParserVisitor<? extends T>)visitor).visitAttributes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_attributes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(NAME);
			setState(26);
			match(EQUALS);
			setState(27);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return xmlTree_sempred((XmlTreeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean xmlTree_sempred(XmlTreeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  (((XmlTreeContext)_localctx).open_tag!=null?((XmlTreeContext)_localctx).open_tag.getText():null).equals((((XmlTreeContext)_localctx).close_tag!=null?((XmlTreeContext)_localctx).close_tag.getText():null)) ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13 \4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\2\7\2\13\n\2\f\2\16\2\16\13\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\27\n\2\f\2\16\2\32\13\2\3\3\3\3\3\3\3\3\3\3\2\2\4\2\4\2\2 \2"+
		"\30\3\2\2\2\4\33\3\2\2\2\6\27\7\7\2\2\7\b\7\6\2\2\b\f\7\b\2\2\t\13\5\4"+
		"\3\2\n\t\3\2\2\2\13\16\3\2\2\2\f\n\3\2\2\2\f\r\3\2\2\2\r\17\3\2\2\2\16"+
		"\f\3\2\2\2\17\20\7\n\2\2\20\21\5\2\2\2\21\22\7\5\2\2\22\23\7\b\2\2\23"+
		"\24\6\2\2\3\24\25\7\n\2\2\25\27\3\2\2\2\26\6\3\2\2\2\26\7\3\2\2\2\27\32"+
		"\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\3\3\2\2\2\32\30\3\2\2\2\33\34"+
		"\7\b\2\2\34\35\7\t\2\2\35\36\7\3\2\2\36\5\3\2\2\2\5\f\26\30";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}