/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ders_18;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

/**
 *
 * @author Admin
 */
public class FilesNIO {

    private static final String FILENAME = "test.txt";

    public static void writeUsingPath(String data, boolean append) {
        try {
            Path path = Paths.get(FILENAME);
            Files.write(path, data.getBytes(), StandardOpenOption.APPEND);
        }catch(IOException e){
            e.printStackTrace();
        }
    }


    public static void writeUsingPath(String data) {
        writeUsingPath(data, false);
    }

    //Files`in write metodu close`a ehtiyac duymur, ozu arxa planda close edir
    public static void writeUsingBufferedWriter(String data){
        Path path = Paths.get(FILENAME);
        try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))){
            writer.write(data);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static byte[] readFileAsByte(String fileName){
        try{
            Path path = Paths.get(fileName);
            return Files.readAllBytes(path);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static String readFileAsString(String fileName)throws Exception{
        byte[] data = readFileAsByte(fileName);
        String dataStr = new String (data);
        return dataStr;
    }
}
