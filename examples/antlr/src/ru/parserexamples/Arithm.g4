// Калькулятор простых арифметических выражений
grammar Arithm;

// Несмотря на то, что Antlr основывается на LL(*) парсере, он принимает грамматики с непосредственной левой рекурсией.
// К тому же эта грамматика неодназначна. Но Antlr справляется с этим, полагая, что операторы по умолчанию
// лево-ассоциативны. Приоритет операторов определяется неявно, из порядка правил в грамматике.
expr returns [double val]
    : <assoc=right> left=expr '^' right=expr { $val = Math.pow($left.val, $right.val); }
    | left=expr op=('*'|'/') right=expr      { $val = ($op.text.equals("*")) ? $left.val * $right.val
                                                                             : $left.val / $right.val; }
    | left=expr op=('+'|'-') right=expr      { $val = ($op.text.equals("+")) ? $left.val + $right.val
                                                                             : $left.val - $right.val; }
    | '(' inner=expr ')'                     { $val = $inner.val; }
    | NUMBER                                 { $val = Double.parseDouble($NUMBER.text); }
    ;

// Лексер
NUMBER : [0-9]+ ('.' [0-9]*)? ;
WS : [ \t\r\n]+ -> skip ;
