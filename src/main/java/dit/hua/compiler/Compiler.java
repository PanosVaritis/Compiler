/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dit.hua.compiler;
import java.io.*;
import java_cup.runtime.Symbol;


/**
 *
 * @author panos-varitis
 */

public class Compiler {

    public static void main(String[] args) {
    
        try {
            
            Reader r = new InputStreamReader(System.in);

            Lexer l = new Lexer(r);

            //Method used for debuging purposes (Prints all the tokens recognized)
            // Symbol token;
            // while ((token = l.next_token()).sym != sym.EOF) {
            //     System.out.println("Token sym: " + token.sym + " | Value: " + token.value);
            // }

            //Calls the parser in debug mode
            // parser p = new parser(l);
            // p.debug_parse();


            parser p = new parser(l);

            Object result =  p.parse().value;

            System.out.println("Everything went ok");

        } catch (Exception e){
            System.out.println("Syntax error: "+e.getMessage());
        
        }
    }
}

