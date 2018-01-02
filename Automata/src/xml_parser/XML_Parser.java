/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml_parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MyUniverse
 */
public class XML_Parser {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//        String xmlFilename = "src/xml/123.jff";
//        Map<String, DemoXmlParser> parsers  = new LinkedHashMap<>();
//        
//        parsers.put("DOMParser", new DemoDOMParser(xmlFilename));
//        
//        for(Map.Entry<String, DemoXmlParser> entry:parsers.entrySet()) {
//            System.out.println("Parsing automata.xml using " + entry.getKey() + ":");
//            List<State> result = entry.getValue().getAllState();
//            for (State state : result) {
//                System.out.println("++"+state);
//            }
//        }
//        
//        for(Map.Entry<String, DemoXmlParser> entry:parsers.entrySet()) {
//            System.out.println("Parsing automata.xml using " + entry.getKey() + ":");
//            List<Transition> result = entry.getValue().getAllTransition();
////            System.out.println("So luong " + result.size());
//            int i = 0;
//            for (Transition transition : result) {
//                System.out.println("Lần " + (i+1));
//                System.out.println(transition);
//                ++i;
//            }
//        }
//    }
    //==============================================================================
public static void main1() {
        int numState = 0;
        int numFinalSet = 0;
        ArrayList<ArrayList> finalSet = new ArrayList<>();
        ArrayList<String> nameStates = new ArrayList<String>();
        ArrayList<String> trans = new ArrayList<String>();
        ArrayList<String> alphabet = new ArrayList<>();
        String xmlFilename ="folder//NGA1.jff";
        Map<String, DemoXmlParser> parsers  = new LinkedHashMap<>();
        String star="";
        parsers.put("DOMParser", new DemoDOMParser(xmlFilename));
       
        for(Map.Entry<String, DemoXmlParser> entry:parsers.entrySet()) {
            System.out.println("Parsing automata.xml using== " + entry.getKey() + ":");
            List<State> result = entry.getValue().getAllState();
            numState = result.size();
            for (State state : result) {
                if(state.property==null);
                else star= state.getId();
                 System.out.println("===========:"+star);   
                
                String name = state.getId();
                nameStates.add(name);
                System.out.println("Group:"+state.getGroup());
                if(numFinalSet<state.getGroup()) numFinalSet = state.getGroup();
                System.out.println("numFinalSet:"+numFinalSet);
            }
            
       
              
                for(int i =0; i<= numFinalSet; i++){
                    ArrayList<String> fs = new ArrayList<>();
                    for (State state : result) {
                        if(state.getGroup()==i) fs.add(state.getId());
                       
                        System.out.println("..."+finalSet.size());
                    }    
                     finalSet.add(fs);
                }
                
            
        }
        
        
        
        for(Map.Entry<String, DemoXmlParser> entry:parsers.entrySet()) {
            System.out.println("Parsing automata.xml using::: " + entry.getKey() + ":");
            List<Transition> result = entry.getValue().getAllTransition();
            for (Transition transition : result) {
                String s = transition.getStartState()+" "+ transition.getReadWord() +" "+ transition.getEndState();
                trans.add(s);
                boolean check = false;
                for(String a: alphabet){
                    if(transition.getReadWord().equals(a)) check =true;
                }
                System.out.println(check);
                if(check==false) alphabet.add(transition.getReadWord());
            }
        }
        
        //=================================================================================
        FileOutputStream fop = null;
        File file = new File("folder//outfile.txt");
        byte[] contentInBytes;
        try {
            fop = new FileOutputStream(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            
            contentInBytes = (numState + "\r\n").getBytes();
            fop.write(contentInBytes);
            for(String s: nameStates){
                String content = s +"\r\n";
                contentInBytes = content.getBytes();
                fop.write(contentInBytes);
            }
            
            contentInBytes = (alphabet.size()+"\r\n").getBytes();
            fop.write(contentInBytes);
            for(String a : alphabet){
                String content = a +"\r\n";
                contentInBytes = content.getBytes();
                fop.write(contentInBytes);
            }
            
            contentInBytes = ("1" + "\r\n").getBytes();
            fop.write(contentInBytes);
            
            contentInBytes = (star + "\r\n").getBytes();
            fop.write(contentInBytes);
            contentInBytes = (trans.size()+"\r\n").getBytes();
            fop.write(contentInBytes);
            for(String s: trans){
                String content = s + "\r\n";
                contentInBytes = content.getBytes();
                fop.write(contentInBytes);
            }
            
            contentInBytes = (numFinalSet+1+"\r\n").getBytes();
            fop.write(contentInBytes);
            for(int i=0; i<= numFinalSet; i++){
                ArrayList<String> fs = finalSet.get(i);
                String content = fs.size()+"\r\n";
                contentInBytes = content.getBytes();
                fop.write(contentInBytes);
                for(String s: fs){
                    String content1 = s + "\r\n";
                    contentInBytes = content1.getBytes();
                    fop.write(contentInBytes);
                }

            }
            
//            
            System.out.println("Ghi file thanh cong");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //===========================================================
          System.out.println(numState);
         for(String a: nameStates){
             System.out.println(a);
         }
         for(String s: trans){
             System.out.println(s);
         }
         System.out.println(alphabet.size());
         for(String s: alphabet){
             System.out.println("++");
             System.out.println("++"+s);
         }
         for(int i=0; i< finalSet.size(); i++){
             System.out.println("Tap F("+i+":");
             for(int j =0; j < finalSet.get(i).size(); j++){
                 
                 System.out.println(finalSet.get(i).get(j));
             }
         }

}

    
    


    
    
}
