/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker5;

/**
 *
 * @author EB
 * @author Marc
 * 
 */
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 *
 * @author Marc
 */
public class TextFile {
    File F;
    FileWriter fw;
    BufferedWriter bw;

    /**
     *
     * @param name
     */
    public void createFile(String name) {

        F = new File(name+".txt");
        try {
            fw = new FileWriter(F);
            bw = new BufferedWriter(fw);
        } catch (Exception e) {

        }

    }

    /**
     *
     * @param s
     */
    public void addFile(String s) {
        try {
            bw.write(s);
        } catch (Exception e) {

        }

    }
    
    /**
     *
     */
    public void doneFile() {
        try {
            bw.close();
        } catch (Exception e) {

        }

    }
    
}
