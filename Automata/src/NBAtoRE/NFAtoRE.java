/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NBAtoRE;
import NBA.NBA;

import Action.Action;
import NBA.ChuyenTrangThai1;
import NBA.State1;
import static NBAtoRE.InfileNBA.nba_1;
import automata.Alphabet;
/**
 *
 * @author thanh
 */
public class NFAtoRE {
    int m = nba_1.Q_1.size();
    public String L[][] = new String[m][m];
    public String [][][] R= new String[m+1][m+1][m+1];
    public static String ep = "epsilon";
    public static String emp ="";
    
    public String star(String x){
        if( x.equals(ep))
            return ep;
        else if(x.equals(emp)) return ep;
        else return "("+x+")*";
    }
    
    public String dot(String x, String y){
        if(x.equals(emp) || y.equals(emp)) return emp;
        else if(x.equals(ep)) return y;
        else if(y.equals(ep)) return x;
        else return "("+x+y+")";
    }
    
    public String plus(String x, String y){
        String z="";
        if(x.equals(ep) && y.equals(emp)) z = x;
        else if(x.equals(ep) && y.equals(emp)==false) z = y;
        else if(x.equals(emp)) z = y;
        else if(x.equals(emp) == false && x.equals(ep)==false){
            if(y.equals(emp) || y.equals(ep)) z = x;
            else z = x + "+" + y; 
        }
        return z;
    }
    
    public String omega(String x){
        String z ="";
        if(x.equals(emp)) z = emp;
        else if(x.equals(ep)) z = ep;
        else z = "("+x+")W";
        return z;
    }
    
//    public void changeDenta_1(NBA_1 nba){
//        for(Trans_1 ctt: nba.denta_1){
//            for(State_1 s1: nba.Q_1){
//                if(ctt.getOne().getName().getName().equals(s1.getName().getName()) && ctt.getOne().getI() == s1.getI())
//                    ctt.getOne().setiD(s1.getiD());
//                if(ctt.getTwo().getName().getName().equals(s1.getName().getName()) && ctt.getTwo().getI() == s1.getI())
//                    ctt.getTwo().setiD(s1.getiD());
//            }
//        }
//    }
    public boolean trans(NBA_1 nba, int i, int j, String a){
        boolean check = false;
        for(Trans_1 ctt: nba.denta_1){
            if(ctt.getOne().getiD()==i && ctt.getTwo().getiD()==j && ctt.getA().getName().equals(a)){
                check =true;
                break;
            }
        }
        return check;
    }
    public void regexQitoQj(NBA_1 nba){
      
        System.out.println("m:"+m);
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                if(i==j) L[i][j]= ep;
                else L[i][j] = emp;
                
                for( Alphabet_1 a: nba.alphabet_1){
                    if(trans(nba, i, j, a.getName()))
                    L[i][j] =plus(L[i][j],a.getName()); 
                }
            }
        }   
    }
    
//    public void removeQk(int k){
//        int t =0;
//        for(int i=0; i<n; i++){
//            for(int j=i+1; j<n; j++){
//                System.out.println("k="+k);
//                L[i][i] = plus(L[i][i] , dot(dot(L[i][k], star(L[k][k])), L[k][i]));
//                
                //L[j][j] = plus(L[j][j] , dot(dot(L[j][k], star(L[k][k])), L[k][j]));
              
              //  L[i][j] = plus(L[i][j] , dot(dot(L[i][k], star(L[k][k])), L[k][j]));
              //  L[j][i] = plus(L[j][i] , dot(dot(L[j][k], star(L[k][k])), L[k][i]));
//                
//            }
//        }
//           
//    }
    //========================
//    String B[] = new String[m];
//    public void fillB(int fina){
//        for(int i=0; i< m; i++){
//            if(i==fina) B[i]=ep;
//            else B[i] = emp;
//        
//        }
//    }
//    
//    public void computeL(NBA nba){
//        changeDenta1(nba);
//        for(int i=0; i< m; i++){
//            for(int j=0; j<m; j++){
//               L[i][j]=emp;
//               for( Alphabet a: nba.alphabet1){
//                    if(trans(nba, i, j, a.getName()))
//                    L[i][j] =plus (L[i][j],a.getName());
//                    
////                   // System.out.println("L["+i+"]["+j+"]: "+L[i][j]);
//                } 
//            }
//        }
//        
//        
//    }
//    
//    public void solving(int fina){
//        for(int n= m-1; n>=0; n--){
//             System.out.println(B[n]+":B[["+n+"]");
////            
//            B[n] = dot(star(L[n][n]), B[n]);
//            for(int j=0; j<=n; j++){
//               
//                L[n][j] = dot(star(L[n][n]), L[n][j]);
//            }
//            System.out.println("B[0]=:"+B[0]);
//            for(int i =0; i<=n; i++){
//                B[i] = plus(B[i], dot(L[i][n], B[n]));
//              
//                for(int j = 0; j<=n; j++){
//                    L[i][j] = plus(L[i][j], dot(L[i][n], L[n][j]));
//                   
//                }
//            }
//        }
//    }
//    public String RE(NBA nba, int init, int fina){
//        fillB(fina);
//        //computeL(nba);
//        regexQitoQj(nba);
//        solving(fina);
//        for(int i=0; i< m; i++){
//            for(int j=0; j<m; j++){
//               System.out.println("L["+i+"]["+j+"]: "+L[i][j]);
//            }
//        }
//        String e = B[0];
//        for(int i=0; i<m; i++){
//            System.out.println("B["+i+"]="+B[i]);
//        }
//        return e;
//    }
//    
    
    
    //=========================================
//    public String RE(NBA nba, int init, int fina){
//        regexQitoQj(nba);
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                System.out.println("L["+i+"]["+j+"]="+L[i][j]);
//            }
//        }
//        String e="";
//        String e1="";
//        String e2="";
//        System.out.println("n la :"+n);
//        for(int i=0; i<n; i++){
//            System.out.println("i="+i);
//           if(i != init && i != fina){
//               removeQk(i);//neeus hamf chir cos 2 trangj thais thif khoong toonf taij i
//           }
//        }
//         System.out.println("1="+star(L[init][init]));
//         System.out.println("2="+(L[init][init]));
//        e1 = dot(star(L[init][init]),L[init][fina]);
//        e2 =     star(plus(dot(dot(L[fina][init],star(L[init][init])),L[init][fina]), L[fina][fina]));
//        System.out.println("e1="+e1);
//         System.out.println("e2="+e2);
//        e = star(dot(e1,e2));
//        return e;
//}
    
    public void initialization(NBA_1 nba){
        
       
      //  changeDenta1(nba);
        System.out.println("m:"+m);
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                if(i==j) R[i+1][j+1][0]= ep;
                else R[i+1][j+1][0] = emp;
                
                for( Alphabet_1 a: nba.alphabet_1){
                    if(trans(nba, i, j, a.getName()))
                    R[i+1][j+1][0] =plus(R[i+1][j+1][0],a.getName()); 
                }
            }
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=m; j++){
                System.out.println("R["+i+"]["+j+"]:"+R[i][j][0]);
            }
        }
    }
    
    public void closure(){
        for(int k=1; k<=m; k++){
            for(int i=1; i<=m; i++){
                for(int j=1; j<=m; j++){
                    int t=k-1;
                    System.out.println("R["+i+"]["+j+"]["+t+"]=:"+R[i][j][k-1]);
                    System.out.println("R["+i+"]["+k+"]["+t+"]=:"+R[i][k][k-1]);
                    System.out.println("R["+k+"]["+k+"]["+t+"]=:"+R[k][k][k-1]);
                    System.out.println("R["+k+"]["+j+"]["+t+"]=:"+R[k][j][k-1]);
                    R[i][j][k]=   plus(R[i][j][k-1],dot(dot(R[i][k][k-1],star(R[k][k][k-1])),R[k][j][k-1]));
                System.out.println("===R["+i+"]["+j+"]["+k+"]=:"+R[i][j][k]);
                }
            }
        }     
    }
    
    public String RE(NBA_1 nba,int init, int fina){
        initialization(nba);
        for(int i=1; i<=m; i++){
            for(int j=1; j<=m; j++){
                System.out.println("R["+i+"]["+j+"][0]=:"+R[i][j][0]);}
            }
        closure();
        String e =emp;
        for(int i=0; i<m; i++){
            if(i==fina) e = plus(e,R[init+1][i+1][m]);
        }
        return e;
        
        
    }
    
    public String NBAtoRE(NBA_1 nba){
                int init =0;
                String e="";
               for(State_1 s1: nba.F_1){
                   int fina = s1.getiD();
                   System.out.println(s1.getiD());
                   
                   e =plus(e,dot(plus(e,RE(nba, init, fina)),omega(RE(nba, fina, fina))));
               }
               return e;
              
    }
}
