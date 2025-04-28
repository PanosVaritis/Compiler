/**
This code is part of the compiler class in hua university
*/
package dit.hua.compiler;

import static java.lang.System.out;

%%

%class Lexer 
%unicode
%integer
%line
%column


%{

    StringBuffer sb = new StringBuffer();

%}

Identifier   = [a-zA-Z][:jletterdigit:]*

Integer      = [0-9]+

Hexadecimal  = "\x"[0-9a-fA-F]{2}

Escape_char  = \\n | \\t | \\r | \\ | \' | \" | {Hexadecimal} | \0

Delim        = [ \t\n\r]

Empty        = {Delim}+

Comment      = \$[^\n\$]*

MultiComment = \$\$(.|\n)*\$\$

%state STRING

%%
<YYINITIAL>{
    /* Reserved Keywords */

    "and"           { out.println("token: "+yytext()); }
    "fun"           { out.println("token: "+yytext()); }
    "nothing"       { out.println("token: "+yytext()); }
    "var"           { out.println("token: "+yytext()); }
    "char"          { out.println("token: "+yytext()); }
    "if"            { out.println("token: "+yytext()); }
    "or"            { out.println("token: "+yytext()); }
    "while"         { out.println("token: "+yytext()); }
    "div"           { out.println("token: "+yytext()); }
    "int"           { out.println("token: "+yytext()); }
    "ref"           { out.println("token: "+yytext()); }
    "do"            { out.println("token: "+yytext()); }
    "mod"           { out.println("token: "+yytext()); }
    "return"        { out.println("token: "+yytext()); }
    "else"          { out.println("token: "+yytext()); }
    "not"           { out.println("token: "+yytext()); }
    "then"          { out.println("token: "+yytext()); }

    /* Identifiers */

    {Identifier}    { out.println("identifier: "+yytext()); }

    /* Number */

    {Integer}       { out.println("number: "+yytext()); }

    /* Operators */

    "+"             { out.println("oper: PLUS"); }
    "-"             { out.println("oper: MINUS"); }
    "*"             { out.println("oper: MULTILPLY"); }
    "/"             { out.println("oper: DIVIDE"); }
    "#"             { out.println("oper: NOT EQUAL"); }
    "="             { out.println("oper: ASSIGN"); }
    "<"             { out.println("oper: LESS_THAN"); }       
    ">"             { out.println("oper: GREATER_THAN"); }
    "<="            { out.println("oper: LESS_THAN_OR_EQUAL"); }
    ">="            { out.println("oper: GREATER_THAN_OR_EQUAL"); }

    /* Spacers */

    "("             { out.println("space: LEFT_PAR"); }
    ")"             { out.println("space: RIGHT_PAR"); }
    "["             { out.println("space: LEFT_BRACKET"); }
    "]"             { out.println("space: RIGHT_BRACKET"); }
    "{"             { out.println("space: LEFT_CURLY_BRAC"); }
    "}"             { out.println("space: RIGHT_CURLY_BRAC"); }
    ","             { out.println("space: COMMA"); }
    ";"             { out.println("space: SEMICOLON"); }
    ":"             { out.println("space: COLON"); }
    "<-"            { out.println("space: POINTER_LIKE"); }


    /* Change state */
    \"              { sb.setLength(0); sb.append(yytext()); yybegin(STRING); }


    /* Tokens that should be recognised but ignored*/

    {Empty}          {}
    
    {Comment}        {}
    
    {MultiComment}   {}

}

<STRING>{

    \"                      { sb.append(yytext()); yybegin(YYINITIAL); out.println("string: "+sb.toString());}

    [^\n\r\"\'\\]+          { sb.append(yytext()); }
    \\n                     { sb.append(yytext()); }
    \\t                     { sb.append(yytext()); }
    \\r                     { sb.append(yytext()); }
    \\\"                    { sb.append(yytext()); }
    \\\'                    { sb.append(yytext()); }

}




[^]             { throw new RuntimeException((yyline+1) + ":" + (yycolumn+1) + ": illegal character <"+ yytext()+">"); }
    
