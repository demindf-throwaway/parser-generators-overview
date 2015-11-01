// Generated from /home/dmitriy/stuff/projects/A4200/parser-generators-overview/examples/antlr/src/ru/parserexamples/Arithm.g4 by ANTLR 4.5.1
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
public class ArithmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NUMBER=8, WS=9;
	public static final int
		RULE_expr = 0;
	public static final String[] ruleNames = {
		"expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'^'", "'*'", "'/'", "'+'", "'-'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "NUMBER", "WS"
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
	public String getGrammarFileName() { return "Arithm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArithmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public double val;
		public ExprContext left;
		public ExprContext inner;
		public Token NUMBER;
		public ExprContext right;
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(ArithmParser.NUMBER, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmListener ) ((ArithmListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArithmListener ) ((ArithmListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(3);
				match(T__5);
				setState(4);
				((ExprContext)_localctx).inner = expr(0);
				setState(5);
				match(T__6);
				 ((ExprContext)_localctx).val =  ((ExprContext)_localctx).inner.val; 
				}
				break;
			case NUMBER:
				{
				setState(8);
				((ExprContext)_localctx).NUMBER = match(NUMBER);
				 ((ExprContext)_localctx).val =  Double.parseDouble((((ExprContext)_localctx).NUMBER!=null?((ExprContext)_localctx).NUMBER.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(29);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(27);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(12);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(13);
						match(T__0);
						setState(14);
						((ExprContext)_localctx).right = expr(5);
						 ((ExprContext)_localctx).val =  Math.pow(((ExprContext)_localctx).left.val, ((ExprContext)_localctx).right.val); 
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(17);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(18);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__1 || _la==T__2) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(19);
						((ExprContext)_localctx).right = expr(5);
						 ((ExprContext)_localctx).val =  ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null).equals("*")) ? ((ExprContext)_localctx).left.val * ((ExprContext)_localctx).right.val
						                                                                                       : ((ExprContext)_localctx).left.val / ((ExprContext)_localctx).right.val; 
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(22);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(23);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__3 || _la==T__4) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(24);
						((ExprContext)_localctx).right = expr(4);
						 ((ExprContext)_localctx).val =  ((((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null).equals("+")) ? ((ExprContext)_localctx).left.val + ((ExprContext)_localctx).right.val
						                                                                                       : ((ExprContext)_localctx).left.val - ((ExprContext)_localctx).right.val; 
						}
						break;
					}
					} 
				}
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13#\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\r\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\2\3\2\3\2\2\4"+
		"\3\2\4\5\3\2\6\7%\2\f\3\2\2\2\4\5\b\2\1\2\5\6\7\b\2\2\6\7\5\2\2\2\7\b"+
		"\7\t\2\2\b\t\b\2\1\2\t\r\3\2\2\2\n\13\7\n\2\2\13\r\b\2\1\2\f\4\3\2\2\2"+
		"\f\n\3\2\2\2\r\37\3\2\2\2\16\17\f\7\2\2\17\20\7\3\2\2\20\21\5\2\2\7\21"+
		"\22\b\2\1\2\22\36\3\2\2\2\23\24\f\6\2\2\24\25\t\2\2\2\25\26\5\2\2\7\26"+
		"\27\b\2\1\2\27\36\3\2\2\2\30\31\f\5\2\2\31\32\t\3\2\2\32\33\5\2\2\6\33"+
		"\34\b\2\1\2\34\36\3\2\2\2\35\16\3\2\2\2\35\23\3\2\2\2\35\30\3\2\2\2\36"+
		"!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \3\3\2\2\2!\37\3\2\2\2\5\f\35\37";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}