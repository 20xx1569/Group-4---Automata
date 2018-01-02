/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.ArrayList;
import automata.ChuyenTrangThai;

/**
 *
 * @author thanh
 */
public class Goal {
    public ArrayList<State> gold = new ArrayList<State>();
    private String nameGoal;
    public ArrayList<State> getGold() {
        return gold;
    }

    public void setGold(ArrayList<State> gold) {
        this.gold = gold;
    }

    public String getNameGoal() {
        return nameGoal;
    }

    public void setNameGoal(String nameGoal) {
        this.nameGoal = nameGoal;
    }

    public Goal() {
    }
    
}
