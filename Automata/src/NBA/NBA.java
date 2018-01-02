/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NBA;


import automata.Alphabet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 *
 * @author thanh
 */
public class NBA {
    public ArrayList<State1> Q1 = new ArrayList<State1>();
    public ArrayList<State1> Q01 = new ArrayList<State1>();
    public ArrayList<State1> F1 = new ArrayList<State1>();
    public GenQueue<State1> W = new GenQueue<State1>();
    public GenQueue<State1> W0 = new GenQueue<State1>();
    public ArrayList<Alphabet> alphabet1 = new ArrayList<Alphabet>();
    public ArrayList<ChuyenTrangThai1> denta1 = new ArrayList<ChuyenTrangThai1>();

    public GenQueue<State1> getW0() {
        return W0;
    }

    public void setW0(GenQueue<State1> W0) {
        this.W0 = W0;
    }
    
    public ArrayList<State1> getQ1() {
        return Q1;
    }

    public void setQ1(ArrayList<State1> Q1) {
        this.Q1 = Q1;
    }

    public ArrayList<State1> getQ01() {
        return Q01;
    }

    public void setQ01(ArrayList<State1> Q01) {
        this.Q01 = Q01;
    }

    public ArrayList<State1> getF1() {
        return F1;
    }

    public void setF1(ArrayList<State1> F1) {
        this.F1 = F1;
    }

    public GenQueue<State1> getW() {
        return W;
    }

    public void setW(GenQueue<State1> W) {
        this.W = W;
    }

    public ArrayList<Alphabet> getAlphabet1() {
        return alphabet1;
    }

    public void setAlphabet1(ArrayList<Alphabet> alphabet1) {
        this.alphabet1 = alphabet1;
    }

   
    public ArrayList<ChuyenTrangThai1> getDenta1() {
        return denta1;
    }

    public void setDenta1(ArrayList<ChuyenTrangThai1> denta1) {
        this.denta1 = denta1;
    }

    public NBA() {
    }
    
    public boolean kiemtraxemcothuocQ1(State1 s1){
        boolean kt = false;
        String a =s1.getName().getName();
        int b= s1.getI();
        for(State1 s01: Q1){
            
            String x =s01.getName().getName();
            int y= s01.getI();
            
            if(x.equals(a)&& b==y)
                kt = true;
            
        }
        return kt;
    } 
}
