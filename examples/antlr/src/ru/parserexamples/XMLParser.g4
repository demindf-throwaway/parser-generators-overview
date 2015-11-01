// Парсер небольшого подмножества XML как пример парсинга контекстно-зависимого языка.
parser grammar XMLParser;

options { tokenVocab = XMLLexer; }

xmlTree :
    (
        TEXT
        | '<' open_tag=NAME attributes* '>' xmlTree '</' close_tag=NAME ({ $open_tag.text.equals($close_tag.text) }? '>')
    )* ;

attributes : NAME '=' STRING;
