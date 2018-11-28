/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpusimulador;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author BrunoPC
 */
public class RAM {
    List<String> ends;
    public RAM(){
        ends = new ArrayList<String>();
    }
    public void fill(){
        for(int i=0; i<=47; i++){
            ends.add("00000000");
        }
    }

    public List<String> getEnds() {
        return ends;
    }

    public void setEnds(List<String> ends) {
        this.ends = ends;
    }
    
    public void achaPos(int a, RAM r, int ac){
        
        StringBuilder pattern = new StringBuilder();
        for(int i=0; i<8; i++) {
            pattern.append("0");
            
        }
        DecimalFormat df = new DecimalFormat(pattern.toString());
        String t = (df.format(Integer.parseInt(Integer.toBinaryString(ac))));
        r.ends.set(a, t);
        
        
        
    }
    
    public void retorna(int a, RAM r, LD ld){
        int novo = Integer.parseInt(r.ends.get(a), 2);
        ld.setLd(novo);
    }
}
