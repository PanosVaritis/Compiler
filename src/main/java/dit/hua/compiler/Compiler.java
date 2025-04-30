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
        parser p = new parser(l);

        try {
            Object result = p.parse().value;
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        }
}

