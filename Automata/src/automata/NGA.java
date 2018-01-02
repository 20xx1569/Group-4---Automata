/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author thanh
 */
public class NGA {
    public ArrayList<State> Q = new ArrayList<State>();
    public ArrayList<State> Q0 = new ArrayList<State>();
    public ArrayList<Alphabet> alphabet = new ArrayList<Alphabet>();
    public ArrayList<ChuyenTrangThai> denta = new ArrayList<ChuyenTrangThai>();
    public ArrayList<Goal> F = new ArrayList<Goal>();
    public ArrayList<State> F0 = new ArrayList<State>();

    public ArrayList<Goal> getF() {
        return F;
    }

    public void setF(ArrayList<Goal> F) {
        this.F = F;
    }
   
    public ArrayList<ChuyenTrangThai> getDenta() {
        return denta;
    }

    public void setDenta(ArrayList<ChuyenTrangThai> denta) {
        this.denta = denta;
    }
    
    public ArrayList<State> getQ() {
        return Q;
    }

    public void setQ(ArrayList<State> Q) {
        this.Q = Q;
    }

    public ArrayList<State> getQ0() {
        return Q0;
    }

    public ArrayList<State> getF0() {
        return F0;
    }

    public void setF0(ArrayList<State> F0) {
        this.F0 = F0;
    }

    public void setQ0(ArrayList<State> Q0) {
        this.Q0 = Q0;
    }

    public ArrayList<Alphabet> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(ArrayList<Alphabet> alphabet) {
        this.alphabet = alphabet;
    }

    public NGA() {
    }
    
    public String chuyen(String a, String b){// a la trang thai xuat phat, b la bang chu cai, x la trang thai chuyen den neu co
        String x = new String();
        for(int i=0 ; i< denta.size(); i++){
            if(denta.get(i).getOne().getName().equals(a) && denta.get(i).getName().getName().equals(b)){
                x = ""+(denta.get(i).getTwo().getName());
                break;
            }
               
            else x = null;
        }
        return x;
    }
    
    public int congTrucTiep(int i){
        int x;
        if(i+1 <= F.size()-1) x= i+1;
        else x= 0; 
        return x;
    }
    
}
