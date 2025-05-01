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
    return createSymbol (sym.EOF);
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

    "and"           { return createSymbol(sym.AND); }
    "fun"           { return createSymbol(sym.FUN); }
    "nothing"       { return createSymbol(sym.NOTHING); }
    "var"           { return createSymbol(sym.VAR); }
    "char"          { return createSymbol(sym.CHAR); }
    "if"            { return createSymbol(sym.IF); }
    "or"            { return createSymbol(sym.OR); }
    "while"         { return createSymbol(sym.WHILE); }
    "div"           { return createSymbol(sym.DIV); }
    "int"           { return createSymbol(sym.INT); }
    "ref"           { return createSymbol(sym.REF); }
    "do"            { return createSymbol(sym.DO); }
    "mod"           { return createSymbol(sym.MOD); }
    "return"        { return createSymbol(sym.RETURN); }
    "else"          { return createSymbol(sym.ELSE); }
    "not"           { return createSymbol(sym.NOT); }
    "then"          { return createSymbol(sym.THEN); }

    /* Identifiers */

    {Identifier}    { return createSymbol(sym.IDENTIFIER, yytext()); }

    /* Number */

    {Integer}       { return createSymbol(sym.INT_LITERAL, Integer.valueOf(yytext())); }

    /* Any single constant character */

    {Match}   { return createSymbol(sym.CHAR_LITERAL, yytext()); }

    /* Operators */

    "+"             { return createSymbol(sym.PLUS); }
    "-"             { return createSymbol(sym.MINUS); }
    "*"             { return createSymbol(sym.MULTIPLY); }
    "#"             { return createSymbol(sym.NEQUAL); }
    "="             { return createSymbol(sym.ASSIGN); }
    "<"             { return createSymbol(sym.LT); }      
    ">"             { return createSymbol(sym.GT); }
    "<="            { return createSymbol(sym.LE); }
    ">="            { return createSymbol(sym.GE); }

    /* Spacers */

    "("             { return createSymbol(sym.LPAREN); }
    ")"             { return createSymbol(sym.RPAREN); }
    "["             { return createSymbol(sym.LBRACKET); }
    "]"             { return createSymbol(sym.RBRACKET); }
    "{"             { return createSymbol(sym.LCURLY); }
    "}"             { return createSymbol(sym.RCURLY); }
    ","             { return createSymbol(sym.COMMA); }
    ";"             { return createSymbol(sym.SEMICOLON); }
    ":"             { return createSymbol(sym.COLON); }
    "<-"            { return createSymbol(sym.PLIKE); }


    /* Change state (Go and match strings) */
    \"              { sb.setLength(0); sb.append(yytext()); yybegin(STRING); }


    /* Tokens that should be recognised but ignored*/

    {Empty}          {}
    
    {Comment}        {}
    
    {MultiComment}   {}

}

<STRING>{

    \"                      { sb.append(yytext()); yybegin(YYINITIAL); 
                                 return createSymbol(sym.STRING_LITERAL, sb.toString()); }

    [^\n\r\"\'\\]+          { sb.append(yytext()); }
    \\n                     { sb.append(yytext()); }
    \\t                     { sb.append(yytext()); }
    \\r                     { sb.append(yytext()); }
    \\\"                    { sb.append(yytext()); }
    \\\'                    { sb.append(yytext()); }

}




[^]             { throw new RuntimeException((yyline+1) + ":" + (yycolumn+1) + ": illegal character <"+ yytext()+">"); }