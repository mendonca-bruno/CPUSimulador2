/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpusimulador;

/**
 *
 * @author BrunoPC
 */
public class Split {
    private String code;
    public Split(){
        this.code = code;
    }
    
    public void printaCodigo(String code){
        System.out.println(code);
    }
    
    public String[] splitar(String code){
        
        String[] test = code.split("\n");
        return test;
        
        
            
        
        
    }
    
    
    
}
