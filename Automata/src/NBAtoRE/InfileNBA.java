/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NBAtoRE;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author thanh
 */
public class InfileNBA {
    public static NBA_1 nba_1 = new NBA_1();
    public static void infile() throws FileNotFoundException{
         
        File file= new File("folder\\nba_1.txt");
        Scanner sc= new Scanner(file);
        int numberStateQ = sc.nextInt();// so trang thai cua Q
        sc.nextLine();
        
        for(int i=1; i<= numberStateQ; i++){
            String name = sc.nextLine();
            State_1 s = new State_1();
            s.setiD(Integer.parseInt(name));
            nba_1.Q_1.add(s);
        }
        
        int numberAlphabet = sc.nextInt();//so chu cai
        sc.nextLine();
        for (int i=1; i<= numberAlphabet; i++){
            String name = sc.nextLine();
            Alphabet_1 a = new Alphabet_1();
            a.setName(name);
            nba_1.alphabet_1.add(a);
        }
        int numberStateQ0 = sc.nextInt();// so trang thai ban dau
        sc.nextLine();
        for(int i=1; i<= numberStateQ0; i++){
            String name = sc.nextLine();
            State_1 s = new State_1();
            s.setiD(Integer.parseInt(name));
            nba_1.Q_01.add(s);
        }
        
        int numberDenta = sc.nextInt();//so chuyen trang thai
        sc.nextLine();
        for(int i=1 ; i<= numberDenta; i++){
            Trans_1 ctt = new Trans_1();
            State_1 one = new State_1();
            State_1 two = new State_1();
            Alphabet_1 a = new Alphabet_1();
            one.setiD(Integer.parseInt(sc.next()));
            a.setName(sc.next());
            two.setiD(Integer.parseInt(sc.next()));
            ctt.setOne(one);
            ctt.setTwo(two);
            ctt.setA(a);
            nba_1.denta_1.add(ctt);
        }
        
        int numberStateOfF = sc.nextInt();
       
        sc.nextLine();
        for(int i=1; i<= numberStateOfF; i++){
            
            
           
                String name = sc.nextLine();
                State_1 a = new State_1();
                a.setiD(Integer.parseInt(name));
                
            
               nba_1.F_1.add(a);
           
        }
        
    }
}
