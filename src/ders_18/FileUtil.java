package ders_18;

import java.io.*;
import java.util.Scanner;

public class FileUtil {

    public static void writeFW(String fileName, String text, boolean append) throws Exception {
        try(FileWriter fileWriter = new FileWriter(fileName, append)){
            if(append){
                fileWriter.write("\n"+(text)); // yeni setirden yazir
            }else {
                fileWriter.write(text);
            }
        }
    }

    public static void writeWithBufferedWriter(String fileName, String text, boolean append) throws Exception {
        try (FileWriter fw = new FileWriter(fileName, append);
             BufferedWriter bw = new BufferedWriter(fw);) {
            if(append) {
                bw.newLine(); // yeni setirden yazir
            }else {
                bw.write(text);
            }
        }
        System.out.println("Done");
    }


    public static void writeAsBytes(String fileName, Object object) throws Exception {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] bytes = object.toString().getBytes();
            fos.write(bytes);
        }
        System.out.println("Done");
    }

    public static String readFileWithScanner(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner reader  = new Scanner(file);
        String line = "";
        while (reader.hasNextLine()){
            if(line.length() == 0){
                line += reader.nextLine();
            }else {
                line += "\n" + reader.nextLine();
            }
        }
        return line;
    }

    public static byte[] readAsBytes(String fileName) throws Exception{/// yarimchiq
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        return bytes;
    }


}
