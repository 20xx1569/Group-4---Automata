/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import automata.Alphabet;
import automata.ChuyenTrangThai;
import automata.Goal;
import automata.NGA;
import automata.State;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import xml_parser.XML_Parser;
 



/**
 *
 * @author thanh
 */
public class Infile {
   
    public static NGA nga = new NGA();
    public static void infile() throws FileNotFoundException{
         XML_Parser.main1(); 
        File file= new File("folder\\outfile.txt");
        Scanner sc= new Scanner(file);
        int numberStateQ = sc.nextInt();// so trang thai cua Q
        sc.nextLine();
        
        for(int i=1; i<= numberStateQ; i++){
            String name = sc.nextLine();
            State s = new State();
            s.setName(name);
            nga.Q.add(s);
        }
        
        int numberAlphabet = sc.nextInt();//so chu cai
        sc.nextLine();
        for (int i=1; i<= numberAlphabet; i++){
            String name = sc.nextLine();
            Alphabet a = new Alphabet();
            a.setName(name);
            nga.alphabet.add(a);
        }
        int numberStateQ0 = sc.nextInt();// so trang thai ban dau
        sc.nextLine();
        for(int i=1; i<= numberStateQ0; i++){
            String name = sc.nextLine();
            State s = new State();
            s.setName(name);
            nga.Q0.add(s);
        }
        
        int numberDenta = sc.nextInt();//so chuyen trang thai
        sc.nextLine();
        for(int i=1 ; i<= numberDenta; i++){
            ChuyenTrangThai ctt = new ChuyenTrangThai();
            State one = new State();
            State two = new State();
            Alphabet a = new Alphabet();
            one.setName(sc.next());
            a.setName(sc.next());
            two.setName(sc.next());
            ctt.setOne(one);
            ctt.setTwo(two);
            ctt.setName(a);
            nga.denta.add(ctt);
        }
        
        int numberF = sc.nextInt();
       
    //    sc.nextLine();
        for(int i=1; i<= numberF; i++){
            
            Goal g = new Goal();
            int numberStateOfGoal = sc.nextInt();
            sc.nextLine();
            for(int j=1; j <= numberStateOfGoal; j++){
                String name = sc.nextLine();
                State a = new State();
                a.setName(name);
                g.gold.add(a);
                if(i==1){
                    nga.F0.add(a);
                }
            }
            
            nga.F.add(g);
           
        }
        
    }
    
}
