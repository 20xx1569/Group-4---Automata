/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import NBA.ChuyenTrangThai1;
import NBA.NBA;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author thanh
 */
public class OutFile {
    public static void ghiFile(NBA nba){
        FileOutputStream fop = null;
        File file = new File("folder//outfile1.txt");
        byte[] contentInBytes;
        try {
            fop = new FileOutputStream(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            
            contentInBytes = (nba.Q1.size()+"\r\n").getBytes();
            fop.write(contentInBytes);
            for(int i=0; i<nba.Q1.size(); i++){
                String content = nba.Q1.get(i).getName().getName()+";"+nba.Q1.get(i).getI()+"\r\n";
                contentInBytes = content.getBytes();
                fop.write(contentInBytes);
            }
            
            contentInBytes = (nba.alphabet1.size()+"\r\n").getBytes();
            fop.write(contentInBytes);
            for(int i=0; i< nba.alphabet1.size(); i++){
                String content = nba.alphabet1.get(i).getName()+"\r\n";
                contentInBytes = content.getBytes();
                fop.write(contentInBytes);
            }
            
            contentInBytes = (nba.Q01.size()+"\r\n").getBytes();
            fop.write(contentInBytes);
            for(int i=0; i< nba.Q01.size(); i++){
                String content = nba.Q01.get(i).getName().getName()+";"+nba.Q01.get(i).getI()+"\r\n";
                contentInBytes = content.getBytes();
                fop.write(contentInBytes);
            }
            
            contentInBytes = (nba.denta1.size()+"\r\n").getBytes();
            fop.write(contentInBytes);
            for(int i=0; i< nba.denta1.size(); i++){
                ChuyenTrangThai1 ctt = nba.denta1.get(i);
                String content = ctt.getOne().getName().getName()+ctt.getOne().getI()+";"+ctt.getA().getName()+";"
                        +ctt.getTwo().getName().getName()+ctt.getTwo().getI()+"\r\n";
                contentInBytes = content.getBytes();
                fop.write(contentInBytes);
            }
            
            contentInBytes = (nba.F1.size()+"\r\n").getBytes();
            fop.write(contentInBytes);
            for(int i=0; i< nba.F1.size(); i++){
                String content = nba.F1.get(i).getName().getName()+";"+nba.F1.get(i).getI()+"\r\n";
                contentInBytes = content.getBytes();
                fop.write(contentInBytes);
            }
            
            System.out.println("Ghi file thanh cong");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
