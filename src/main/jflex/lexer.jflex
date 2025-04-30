/**
This code is part of the compiler class in hua university
*/
package dit.hua.compiler;

import static java.lang.System.out;
import java_cup.runtime.Symbol;

%%

%class Lexer 
%unicode
%integer
%line
%column
%cup

%eofval{
    return createSymbol (Symbols.EOF);
%eofval}


%{

    private StringBuffer sb = new StringBuffer();

    private Symbol createSymbol (int type){
        return new Symbol (type, yyline+1, yycolumn+1);
    }

    private Symbol createSymbol (int type, Object value){
        return new Symbol (type, yyline+1, yycolumn+1, value);
    }

%}

Identifier   = [a-zA-Z][:jletterdigit:]*

Integer      = [0-9]+

Hexadecimal  = "\x"[0-9a-fA-F]{2}

Escape_char  = \\n | \\t | \\r | \\ | \\\' | \\\" | {Hexadecimal} | [:jletter:] | \\0

Quote        = \'   

Match        = {Quote}{Escape_char}{Quote}

Delim        = [ \t\n\r]

Empty        = {Delim}+

Comment      = \$[^\n\$]*

MultiComment = \$\$(.|\n)*\$\$

%state STRING

%%
<YYINITIAL>{
    /* Reserved Keywords */

    "and"           { return createSymbol(Symbols.AND); }
    "fun"           { return createSymbol(Symbols.FUN); }
    "nothing"       { return createSymbol(Symbols.NOTHING); }
    "var"           { return createSymbol(Symbols.VAR); }
    "char"          { return createSymbol(Symbols.CHAR); }
    "if"            { return createSymbol(Symbols.IF); }
    "or"            { return createSymbol(Symbols.OR); }
    "while"         { return createSymbol(Symbols.WHILE); }
    "div"           { return createSymbol(Symbols.DIV); }
    "int"           { return createSymbol(Symbols.INT); }
    "ref"           { return createSymbol(Symbols.REF); }
    "do"            { return createSymbol(Symbols.DO); }
    "mod"           { return createSymbol(Symbols.MOD); }
    "return"        { return createSymbol(Symbols.RETURN); }
    "else"          { return createSymbol(Symbols.ELSE); }
    "not"           { return createSymbol(Symbols.NOT); }
    "then"          { return createSymbol(Symbols.THEN); }

    /* Identifiers */

    {Identifier}    { return createSymbol(Symbols.IDENTIFIER, yytext()); }

    /* Number */

    {Integer}       { return createSymbol(Symbols.INT_LITERAL, Integer.valueof(yytext())); }

    /* Any single constant character */

    {Match}   { return createSymbol(Symbols.CHAR_LITERAL, yytext()); }

    /* Operators */

    "+"             { return createSymbol(Symbols.PLUS); }
    "-"             { return createSymbol(Symbols.MINUS); }
    "*"             { return createSymbol(Symbols.MULTILPLY); }
    "/"             { return createSymbol(Symbols.DIVISION); }
    "#"             { return createSymbol(Symbols.NEQUAL); }
    "="             { return createSymbol(Symbols.ASSIGN); }
    "<"             { return createSymbol(Symbols.LT); }      
    ">"             { return createSymbol(Symbols.GT); }
    "<="            { return createSymbol(Symbols.LE); }
    ">="            { return createSymbol(Symbols.GE); }

    /* Spacers */

    "("             { return createSymbol(Symbols.LPAREN); }
    ")"             { return createSymbol(Symbols.RPAREN); }
    "["             { return createSymbol(Symbols.LBRACKET); }
    "]"             { return createSymbol(Symbols.RBRACKET); }
    "{"             { return createSymbol(Symbols.LCURLY); }
    "}"             { return createSymbol(Symbols.RCURLY); }
    ","             { return createSymbol(Symbols.COMMA); }
    ";"             { return createSymbol(Symbols.SEMICOLON); }
    ":"             { return createSymbol(Symbols.COLON); }
    "<-"            { return createSymbol(Symbols.PLIKE); }


    /* Change state (Go and match strings) */
    \"              { sb.setLength(0); sb.append(yytext()); yybegin(STRING); }


    /* Tokens that should be recognised but ignored*/

    {Empty}          {}
    
    {Comment}        {}
    
    {MultiComment}   {}

}

<STRING>{

    \"                      { sb.append(yytext()); yybegin(YYINITIAL); 
                                 return createSymbol(Symbols.STRING_LITERAL, sb.toString()); }

    [^\n\r\"\'\\]+          { sb.append(yytext()); }
    \\n                     { sb.append(yytext()); }
    \\t                     { sb.append(yytext()); }
    \\r                     { sb.append(yytext()); }
    \\\"                    { sb.append(yytext()); }
    \\\'                    { sb.append(yytext()); }

}




[^]             { throw new RuntimeException((yyline+1) + ":" + (yycolumn+1) + ": illegal character <"+ yytext()+">"); }
    
