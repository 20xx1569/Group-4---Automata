/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Data.Infile;
import Data.OutFile;
import NBA.ChuyenTrangThai1;
import NBA.NBA;
import NBA.State1;
import NBAtoRE.Alphabet_1;
import NBAtoRE.InfileNBA;
import static NBAtoRE.InfileNBA.nba_1;
import NBAtoRE.NFAtoRE;
import NBAtoRE.State_1;
import NBAtoRE.Trans_1;
import automata.Alphabet;
import automata.Goal;
import automata.State;
import java.io.FileNotFoundException;
import xml_create.CreateXml;

/**
 *
 * @author thanh
 */
public class Action {

    public static NBA nba = new NBA();

    public static void main(String args[]) throws FileNotFoundException {
        Infile.infile();
//       State1 s1 = new State1();
//       State1 s2 = new State1();
//       State1 s3 = new State1();
//       State1 s4 = new State1();
//       
//       State a1 = new State();
//       State a2 = new State();
//        State a3 = new State();
//       
//       
//       a1.setName("q");
//       a2.setName("r");
//       a3.setName("t");
//       
//       s1.setName(a1);s1.setI(0);s2.setName(a1);s2.setI(1);
//       s3.setName(a2);s3.setI(0);s4.setName(a3);s4.setI(0);
//       
//       nba.Q01.add(s1);
//       nba.Q01.add(s2);
//       nba.Q01.add(s3);
//       
//       System.out.println(nba.kiemtraxemcothuocQ01(s4));

        for (State s : Infile.nga.Q0) {
            State1 s1 = new State1();
            // System.out.println("=="+s.getName());
            s1.setName(s);
            s1.setI(0);
            nba.Q01.add(s1);
            nba.W.enqueue(s1);
            nba.W0.enqueue(s1);
        }
        // System.out.println(nba.W.peek().getName().getName());
        int id = 0;
        while (nba.W.size() > 0) {

            System.out.println("kich co tap W: " + nba.W.size());
            State1 s1 = nba.W.dequeue();
            nba.W0.dequeue();

            //System.out.println(Infile.nga.Q.size()*Infile.nga.F.size());
            while (nba.kiemtraxemcothuocQ1(s1)) {
                s1 = nba.W.dequeue();
                if (s1 == null) {
                    break;
                }
            }
            if (s1 == null) {
                break;
            }
            System.out.println("Trang thai dc xet:");
            System.out.println(s1.getName().getName() + ";" + s1.getI());
            s1.setiD(id);
            nba.Q1.add(s1);
            id++;
            boolean checked = false;
            //   System.out.println(Infile.nga.F0.get(0).getName());
            for (State a : Infile.nga.F0) {
                if (a.getName().equals(s1.getName().getName())) {
                    checked = true;
                }
            }
            if (checked == true && s1.getI() == 0) {
                nba.F1.add(s1);// kiem tra xem co them [q,i] vao tap dich F1 khong
            }         //  System.out.println(nba.F1.get(0).getName().getName());
            for (Alphabet a : Infile.nga.alphabet) {
                // System.out.println(a.getName());
                String y = Infile.nga.chuyen(s1.getName().getName(), a.getName());
                State sO = new State();//sO chinh laf q'
                sO.setName(y);

                if (sO.getName() != null) {

                    boolean checked1 = false;
                    Goal g = Infile.nga.F.get(s1.getI());
                    for (State x : g.getGold()) {
                        if (x.getName().equals(s1.getName().getName()) == true) {
                            checked1 = true;
                        }
                    }

                    if (checked1 == false) {

                        State1 state1 = new State1();
                        state1.setName(sO);
                        state1.setI(s1.getI());
                        System.out.println("111" + sO.getName() + ";" + s1.getI());

                        System.out.println("111" + nba.kiemtraxemcothuocQ1(state1));
                        if (nba.kiemtraxemcothuocQ1(state1) == false) {
                            nba.W.enqueue(state1);
                            nba.W0.enqueue(state1);

                        }
                        System.out.println("Tap Q1:");
                        for (State1 ss1 : nba.Q1) {
                            System.out.println(ss1.getName().getName() + ";" + ss1.getI() + ";" + ss1.getiD());
                        }
                        ChuyenTrangThai1 ctt = new ChuyenTrangThai1();
                        ctt.setOne(s1);
                        ctt.setTwo(state1);
                        ctt.setA(a);
                        nba.denta1.add(ctt);
                    } else {
                        State1 state1 = new State1();
                        state1.setName(sO);
                        System.out.println("222" + sO.getName() + ";" + Infile.nga.congTrucTiep(s1.getI()));
                        state1.setI(Infile.nga.congTrucTiep(s1.getI()));

                        System.out.println("222" + nba.kiemtraxemcothuocQ1(state1));
                        if (nba.kiemtraxemcothuocQ1(state1) == false) {
                            nba.W0.enqueue(state1);
                            nba.W.enqueue(state1);
                        }
                        System.out.println("Tap Q1:");
                        for (State1 ss1 : nba.Q1) {
                            System.out.println(ss1.getName().getName() + ";" + ss1.getI());
                        }
                        ChuyenTrangThai1 ctt = new ChuyenTrangThai1();
                        ctt.setOne(s1);
                        ctt.setTwo(state1);
                        ctt.setA(a);
                        nba.denta1.add(ctt);
                    }

                }
            }

        }

        System.out.println("Tap denta1===========================================:");
        System.out.println(nba.denta1.size());
        for (ChuyenTrangThai1 ctt : nba.denta1) {
            System.out.println("[" + ctt.getOne().getName().getName() + ";" + ctt.getOne().getI() + "];"
                    + ctt.getA().getName() + ";[" + ctt.getTwo().getName().getName() + ";" + ctt.getTwo().getI() + "]");
        }
        System.out.println("Tap Q1:");
        for (State1 ss1 : nba.Q1) {
            System.out.println(ss1.getName().getName() + ";" + ss1.getI() + ";id: " + ss1.getiD());
        }
//           System.out.println("Tap F1:");
//           for(State1 ss1: nba.F1){
//               System.out.println(ss1.getName().getName()+";"+ss1.getI());
//           }
        System.out.println("Tap W:");
        while (nba.W0.size() > 0) {
            State1 ss1 = nba.W0.dequeue();
            System.out.println(ss1.getName().getName() + ";" + ss1.getI());

        }
        for (Alphabet a : Infile.nga.alphabet) {
            nba.alphabet1.add(a);
        }
        for (Alphabet a : nba.alphabet1) {
            System.out.println(a.getName());
        }
        OutFile.ghiFile(nba);

        //============================================
        //NBA to regex
        System.out.println("======");

        for (State1 s1 : nba.F1) {
            int fina = s1.getiD();
            System.out.println("===============================" + s1.getName().getName());

        }

//                int init = 0;
//                String e="";
//               for(State1 s1: nba.F1){
//                   int fina = s1.getiD();
//                   System.out.println(s1.getName().getName());
//                   
//                   e =nfatore.dot(nfatore.plus(e,nfatore.RE(nba, init, fina)),nfatore.omega(nfatore.RE(nba, 0, 0)));
//               }
//               System.out.println("e = "+e);
        //System.out.println("e = "+nfatore.NBAtoRE(nba));
        //================================================================
        InfileNBA.infile();
        NFAtoRE nfatore = new NFAtoRE();
        for (State_1 s : nba_1.Q_1) {
            System.out.println(s.getiD());
        }
        for (State_1 s : nba_1.Q_01) {
            System.out.println(s.getiD());
        }
        for (State_1 s : nba_1.F_1) {
            System.out.println(s.getiD());
        }
        for (Trans_1 t : nba_1.denta_1) {
            System.out.println(t.getOne().getiD() + " " + t.getA().getName() + " " + t.getTwo().getiD());
        }
        for (Alphabet_1 s : nba_1.alphabet_1) {
            System.out.println(s.getName());
        }
        System.out.println("e_1 = " + nfatore.NBAtoRE(nba_1));

        //
        

        CreateXml createXml = new CreateXml();
        createXml.createXML(nba);
    }
}
