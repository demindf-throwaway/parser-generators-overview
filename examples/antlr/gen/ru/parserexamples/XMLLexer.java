// Generated from /home/dmitriy/stuff/projects/A4200/parser-generators-overview/examples/antlr/src/ru/parserexamples/XMLLexer.g4 by ANTLR 4.5.1
package ru.parserexamples;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XMLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING=1, COMMENT=2, CLOSING_TAG_OPEN=3, TAG_OPEN=4, TEXT=5, NAME=6, EQUALS=7, 
		TAG_CLOSE=8, WS=9;
	public static final int INSIDE_TAG = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "INSIDE_TAG"
	};

	public static final String[] ruleNames = {
		"COMMENT", "CLOSING_TAG_OPEN", "TAG_OPEN", "TEXT", "NAME", "EQUALS", "TAG_CLOSE", 
		"SIGNLE", "DOUBLE", "WS"
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


	public XMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XMLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\13_\b\1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\2\3\2\3\2\7\2\37\n\2\f\2\16\2\"\13\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\6\5\64\n\5\r\5\16\5"+
		"\65\3\6\6\69\n\6\r\6\16\6:\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\7\tE\n\t\f"+
		"\t\16\tH\13\t\3\t\3\t\3\t\3\t\3\n\3\n\7\nP\n\n\f\n\16\nS\13\n\3\n\3\n"+
		"\3\n\3\n\3\13\6\13Z\n\13\r\13\16\13[\3\13\3\13\5 FQ\2\f\4\4\6\5\b\6\n"+
		"\7\f\b\16\t\20\n\22\2\24\2\26\13\4\2\3\5\3\2>>\5\2\62;C\\c|\5\2\13\f\17"+
		"\17\"\"c\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\3\f\3\2\2\2\3"+
		"\16\3\2\2\2\3\20\3\2\2\2\3\22\3\2\2\2\3\24\3\2\2\2\3\26\3\2\2\2\4\30\3"+
		"\2\2\2\6)\3\2\2\2\b.\3\2\2\2\n\63\3\2\2\2\f8\3\2\2\2\16<\3\2\2\2\20>\3"+
		"\2\2\2\22B\3\2\2\2\24M\3\2\2\2\26Y\3\2\2\2\30\31\7>\2\2\31\32\7#\2\2\32"+
		"\33\7/\2\2\33\34\7/\2\2\34 \3\2\2\2\35\37\13\2\2\2\36\35\3\2\2\2\37\""+
		"\3\2\2\2 !\3\2\2\2 \36\3\2\2\2!#\3\2\2\2\" \3\2\2\2#$\7/\2\2$%\7/\2\2"+
		"%&\7@\2\2&\'\3\2\2\2\'(\b\2\2\2(\5\3\2\2\2)*\7>\2\2*+\7\61\2\2+,\3\2\2"+
		"\2,-\b\3\3\2-\7\3\2\2\2./\7>\2\2/\60\3\2\2\2\60\61\b\4\3\2\61\t\3\2\2"+
		"\2\62\64\n\2\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2"+
		"\2\66\13\3\2\2\2\679\t\3\2\28\67\3\2\2\29:\3\2\2\2:8\3\2\2\2:;\3\2\2\2"+
		";\r\3\2\2\2<=\7?\2\2=\17\3\2\2\2>?\7@\2\2?@\3\2\2\2@A\b\b\4\2A\21\3\2"+
		"\2\2BF\7)\2\2CE\13\2\2\2DC\3\2\2\2EH\3\2\2\2FG\3\2\2\2FD\3\2\2\2GI\3\2"+
		"\2\2HF\3\2\2\2IJ\7)\2\2JK\3\2\2\2KL\b\t\5\2L\23\3\2\2\2MQ\7$\2\2NP\13"+
		"\2\2\2ON\3\2\2\2PS\3\2\2\2QR\3\2\2\2QO\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7"+
		"$\2\2UV\3\2\2\2VW\b\n\5\2W\25\3\2\2\2XZ\t\4\2\2YX\3\2\2\2Z[\3\2\2\2[Y"+
		"\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\b\13\2\2^\27\3\2\2\2\n\2\3 \65:FQ[\6"+
		"\b\2\2\7\3\2\6\2\2\t\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}