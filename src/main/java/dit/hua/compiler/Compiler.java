/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dit.hua.compiler;
import java.io.*;

/**
 *
 * @author panos-varitis
 */

public class Compiler {

    public static void main(String[] args) {
    
        Reader r = new InputStreamReader(System.in);
        Lexer l = new Lexer(r);

        try {
        int token = l.yylex();
        while (token != Lexer.YYEOF) { 
            System.out.println("Token type: "+ token + " lexeme: " + l.yytext());
            token = l.yylex();
        }

        } catch (IOException e) { 
            System.err.println(e.getMessage());
        }
    }
}

