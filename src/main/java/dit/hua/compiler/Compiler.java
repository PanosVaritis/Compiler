/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dit.hua.compiler;
import java.io.*;

import dit.hua.compiler.ast.ASTPrettyPrinter;
import dit.hua.compiler.ast.Program;
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

            Program program = (Program) p.parse().value;

            System.out.println("=== AST STRUCTURE ===");

            // Object result =  p.parse().value;

            ASTPrettyPrinter printer = new ASTPrettyPrinter();
            program.accept(printer);
            System.out.println(printer.getOutput());
            System.out.println("====================");


            System.out.println("Everything went ok");

        } catch (Exception e){
            System.out.println("Syntax error: "+e.getMessage());
            e.printStackTrace();
        
        }
    }
}