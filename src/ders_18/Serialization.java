/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ders_18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Admin
 */
public class Serialization {

    public static void writeObjectToFile(Object object, String name) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream(name);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(object);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Object readFileDeserialize(String name) {
        Object obj = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(name))) {
            obj = in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return obj;
        }
    }
}
