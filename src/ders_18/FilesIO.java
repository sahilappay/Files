/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ders_18;

import java.io.*;

/**
 *
 * @author Admin
 */
public class FilesIO {

    /*
    >>>>>>>>>>>>>>>>Write with IO<<<<<<<<<<<<<<<<<
     */
    private static final String FILENAME = "test.txt";

    public static void writeUsingOutputStream(String data) {
        OutputStream os = null;
        try {
            File f = new File(FILENAME);
            os = new FileOutputStream(f);
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /*
    Yuxaridaki metodu "try-with-resources" tetbiq etmekle
    ashagidaki kimi yaza bilerik. Bu zaman try closeable olan obyekt
    teleb etdiyine gore finally merhelesine ehtiyac duymayaciq.
    Obyektin closeable olmasi onun Closeable interfeysine implement
    etmeyi demekdir.
     */
    public static void writeUsingOutputStreamCloseable(String data) {
        File f = new File(FILENAME);
        try (OutputStream os = new FileOutputStream(f)) {
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeUsingFileWriter(String data, boolean append) { //FileWriter class`i da Closeable`dir
        File file = new File(FILENAME);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file , append);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void writeUsingFileWriter(String data){
        writeUsingFileWriter(data, false);
    }

    public static void writeUsingBufferedWriter(String data) {
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(FILENAME);
            bw = new BufferedWriter(fw);
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void writeUsingBufferedWriterCloseable(String data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {// en qisa shekilde bele de yazmaq olar
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    >>>>>>>>>>>>>>>>Read with IO<<<<<<<<<<<<<<<<<
     */
    public static void readUsingInputStream() {
        try (InputStream in = new FileInputStream(FILENAME); BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readUsingFilereader() throws Exception {
        FileReader fr = new FileReader(FILENAME);
        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
    }

    public static void readUsingBufferedReader() {
        BufferedReader br = null;
        FileReader fr = null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void readUsingBufferedReaderCloseable() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readUsingByte() throws Exception {
        //baytlari istenilen yerden oxumaq olar (shekil, video, musiqi ve s.)
        //burada biz fayldan oxuyaciq
        File file = null;
        FileInputStream fileStream = new FileInputStream(file = new File(FILENAME));
        //numune array`i
        byte[] arr = new byte[(int) file.length()];
        // baytlari file stream`den oxumaq
        fileStream.read(arr, 0, arr.length);
        for (int x : arr) {
            System.out.print((char) x);
        }
    }

}
