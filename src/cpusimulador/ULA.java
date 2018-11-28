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
public class ULA {
    private AC ac;
    private RC rc;
    private DC dc;
    private PC pc;
    private LD ld;
    private RAM ram;
    private int cont;
    private int his;
    
    public ULA(RAM r){
        pc = new PC();
        ac = new AC();
        rc = new RC();
        dc = new DC();
        ld = new LD();
        this.ram = r;
        this.cont = 0;
        this.his = 0;
    }  
      
    
    public void Detecta(String[] c){
        int operando = 0;

        for(int i=0; i<c.length; i++){
            String[] t = c[i].split(" ");
            for(int j=0; j<t.length-1; j++){
                String teste = t[j];
                if(teste.toUpperCase().equals("ADD")){
                    
                    try {
                        operando = Integer.parseInt(t[j+1]);
                        pc.setPc(pc.getPc()+1);
                        Soma(operando);
                        
                    } catch (Exception e) {
                        pc.setPc(pc.getPc()+1);
                        Soma2(t[j+1]);
                    }
                }
                if(teste.toUpperCase().equals("SUB")){
                    try {
                        operando = Integer.parseInt(t[j+1]);
                        pc.setPc(pc.getPc()+1);
                        Sub(operando);
                    } catch (Exception e) {
                        pc.setPc(pc.getPc()+1);
                        Sub2(t[j+1]);
                    }
                }
                if(teste.toUpperCase().equals("MUL")){
                    try {
                        operando = Integer.parseInt(t[j+1]);
                        pc.setPc(pc.getPc()+1);
                        Mult(operando);
                    } catch (Exception e) {
                        pc.setPc(pc.getPc()+1);
                        Mult2(t[j+1]);
                    }
                }
                if(teste.toUpperCase().equals("DIV")){
                    try {
                        operando = Integer.parseInt(t[j+1]);
                        pc.setPc(pc.getPc()+1);
                        Div(operando);
                    } catch (Exception e) {
                        pc.setPc(pc.getPc()+1);
                        Div2(t[j+1]);
                    }
                }
                if(teste.toUpperCase().equals("STR")){
                    try {
                        operando = Integer.parseInt(t[j+1]);
                        pc.setPc(pc.getPc()+1);
                        ram.achaPos(operando,ram,ac.getAc());
                    } catch (Exception e) {
                        pc.setPc(pc.getPc()+1);
                        store(t[j+1]);
                    }
                    
                }
                if(teste.toUpperCase().equals("SET")){
                    operando = Integer.parseInt(t[j+1]);
                    pc.setPc(pc.getPc()+1);
                    ac.setAc(operando);
                }
                if(teste.toUpperCase().equals("LOAD")){
                    operando = Integer.parseInt(t[j+1]);
                    ram.retorna(operando, ram, ld);
                }
            }
        }
        
    }
    
    public void Step(String[] c, int cont){
        int operando = 0;
        this.cont = 1;
       
        
        for(int i=his; i<c.length&&this.cont>0; i++){
            String[] t = c[i].split(" ");
            for(int j=0; j<t.length-1; j++){
                String teste = t[j];
                if(teste.toUpperCase().equals("ADD")){
                    
                    try {
                        operando = Integer.parseInt(t[j+1]);
                        pc.setPc(pc.getPc()+1);
                        this.cont = 0;
                        his++;
                        Soma(operando);
                        
                    } catch (Exception e) {
                        pc.setPc(pc.getPc()+1);
                        this.cont = 0;
                        his++;
                        Soma2(t[j+1]);
                    }
                }
                if(teste.toUpperCase().equals("SUB")){
                    try {
                        operando = Integer.parseInt(t[j+1]);
                        pc.setPc(pc.getPc()+1);
                        this.cont = 0;
                        his++;
                        Sub(operando);
                    } catch (Exception e) {
                        pc.setPc(pc.getPc()+1);
                        this.cont = 0;
                        his++;
                        Sub2(t[j+1]);
                    }
                }
                if(teste.toUpperCase().equals("MUL")){
                    try {
                        operando = Integer.parseInt(t[j+1]);
                        pc.setPc(pc.getPc()+1);
                        this.cont = 0;
                        his++;
                        Mult(operando);
                    } catch (Exception e) {
                        pc.setPc(pc.getPc()+1);
                        this.cont = 0;
                        his++;
                        Mult2(t[j+1]);
                    }
                }
                if(teste.toUpperCase().equals("DIV")){
                    try {
                        operando = Integer.parseInt(t[j+1]);
                        pc.setPc(pc.getPc()+1);
                        this.cont = 0;
                        his++;
                        Div(operando);
                    } catch (Exception e) {
                        pc.setPc(pc.getPc()+1);
                        this.cont = 0;
                        his++;
                        Div2(t[j+1]);
                    }
                }
                if(teste.toUpperCase().equals("STR")){
                    try {
                        operando = Integer.parseInt(t[j+1]);
                        pc.setPc(pc.getPc()+1);
                        this.cont = 0;
                        his++;
                        ram.achaPos(operando,ram,ac.getAc());
                    } catch (Exception e) {
                        pc.setPc(pc.getPc()+1);
                        this.cont = 0;
                        his++;
                        store(t[j+1]);
                    }
                    
                }
                if(teste.toUpperCase().equals("SET")){
                    operando = Integer.parseInt(t[j+1]);
                    pc.setPc(pc.getPc()+1);
                    this.cont = 0;
                    his++;
                    ac.setAc(operando);
                }
                if(teste.toUpperCase().equals("LOAD")){
                    operando = Integer.parseInt(t[j+1]);
                    pc.setPc(pc.getPc()+1);
                    this.cont = 0;
                    his++;
                    ram.retorna(operando, ram, ld);
                }
            }
        }
    }
    
    public void Soma(int a){        
        int sum = ac.getAc();
        int resultado = a + sum;
        ac.setAc(resultado);
        
    }
    public void Soma2(String a){
        if(a.toUpperCase().equals("RC")){
            int b = getRCvalue();
            Soma(b);
        }else if(a.toUpperCase().equals("DC")){
            int b = getDCvalue();
            Soma(b);
        }
        else if(a.toUpperCase().equals("LD")){
            int b = getLDvalue();
            Soma(b);
        }
        
    }
    public void Sub(int a){        
        int sub = ac.getAc();
        int resultado = sub - a;
        ac.setAc(resultado);
        
    }
    public void Sub2(String a){        
        if(a.toUpperCase().equals("RC")){
            int b = getRCvalue();
            Sub(b);
        }else if(a.toUpperCase().equals("DC")){
            int b = getDCvalue();
            Sub(b);
        }
        else if(a.toUpperCase().equals("LD")){
            int b = getLDvalue();
            Sub(b);
        }
        
    }
    public void Mult(int a){
        int mult = ac.getAc();
        int resultado = mult*a;
        ac.setAc(resultado);
    }
    public void Mult2(String a){
        if(a.toUpperCase().equals("RC")){
            int b = getRCvalue();
            Mult(b);
        }else if(a.toUpperCase().equals("DC")){
            int b = getDCvalue();
            Mult(b);
        }
        else if(a.toUpperCase().equals("LD")){
            int b = getLDvalue();
            Mult(b);
        }
    }
    public void Div(int a){
        int div = ac.getAc();
        try {
            int resultado = div/a;
            ac.setAc(resultado);
        } catch (Exception e) {
            System.out.println("ERRO CALCULO");
        }
    }
    public void Div2(String a){
        if(a.toUpperCase().equals("RC")){
            int b = getRCvalue();
            Div(b);
        }else if(a.toUpperCase().equals("DC")){
            int b = getDCvalue();
            Div(b);
        }
        else if(a.toUpperCase().equals("LD")){
            int b = getLDvalue();
            Div(b);
        }
    }
    public void store(String a){
        if(a.toUpperCase().equals("RC")){
            int b = getACvalue();
            rc.setRc(b);
        }else if(a.toUpperCase().equals("DC")){
            int b = getACvalue();
            dc.setDc(b);
        }
        else if(a.toUpperCase().equals("LD")){
            int b = getACvalue();
            ld.setLd(b);
        }
    }
    public int getACvalue(){
        return ac.getAc();
    }
    
    public int getPCvalue(){
        return pc.getPc();
    }
    public int getRCvalue(){
        return rc.getRc();
    }
    public int getDCvalue(){
        return dc.getDc();
    }
    public int getLDvalue(){
        return ld.getLd();
    }
    public int getCont() {
        return cont;
    }
    public void setCont(int cont) {
        this.cont = cont;
    }
    
}
