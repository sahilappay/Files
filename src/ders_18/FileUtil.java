package ders_18;

import com.sun.corba.se.impl.io.IIOPInputStream;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileUtil {

    ////////////////////////// IO \\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public static void writeFileWriter(String fileName, String text, boolean append) throws Exception {
        try (FileWriter fileWriter = new FileWriter(fileName, append)) {
            if (append) {
                fileWriter.write("\n" + (text)); // yeni setirden yazir
            } else {
                fileWriter.write(text);
            }
        }
    }

    public static void writeWithBufferedWriter(String fileName, String text, boolean append) throws Exception {
        try (FileWriter fw = new FileWriter(fileName, append);
                BufferedWriter bw = new BufferedWriter(fw);) {
            if (append) {
                bw.newLine(); // yeni setirden yazir
            } else {
                bw.write(text);
            }
        }
        System.out.println("Done");
    }

    public static void writeBytes(String fileName, byte[] data) throws Exception {
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
//            byte[] bytes = object.toString().getBytes();
            fos.write(data);
            fos.flush(); // topladigi melumatlari yazir ve prosesi tesdiqleyir
        }
        System.out.println("Done");
    }

    public static String readFileWithScanner(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        String line = "";
        while (reader.hasNextLine()) {
            if (line.length() == 0) {
                line += reader.nextLine();
            } else {
                line += "\n" + reader.nextLine();
            }
        }
        return line;
    }

    public static byte[] readBytes(String fileName) throws Exception {/// yarimchiq
        File file = new File(fileName);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            return bytes;
        }
    }

    public static String readWithBufferedReader(String fileName) throws Exception {

        try (FileInputStream fis = new FileInputStream(fileName);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);) {
            String line = null;
            String result = "";

            while ((br.readLine()) != null) {
                result += br.readLine() + "\n";
            }

            return result;
        }
    }

    ////////////////////////// NIO \\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public static void writeBytesNIO(String fileName, byte[] data) throws Exception {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, data);
    }

    public static byte[] readBytesNIO(String fileName) throws Exception {
        Path filePath = Paths.get(fileName);
        byte[] bytes = FilesNIO.readFileAsByte(fileName);

        return bytes;
    }

    ////////////////////////// OBJECT \\\\\\\\\\\\\\\\\\\\\\\\\\\\
    // private static final long serialVersionUID = 1L; yazacagimiz obyektin ichinde qeyd edirik
    public static void writeObjectToFile(String fileName, Serializable object) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(object);
        }
    }
    
    public static Object readObject(String fileName) throws Exception{
        Object object = null;
        try(FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);){
        object = ois.readObject();
        }
        return object;
    }
}
