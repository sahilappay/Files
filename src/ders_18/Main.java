/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ders_18;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
//        User user = new User("Sahil", "Appayev", 24);

//        FilesIO.writeUsingFileWriter("\ntest2", true);
//        FilesIO.readUsingFilereader();
//        FilesNIO.writeUsingPath("\ntest3", true);
//        System.out.println(FilesNIO.readFileAsString("test.txt"));


//        User user = (User) Serialization.readFileDeserialize("userSahil");
//        System.out.println(user.getName());
//        System.out.println(user.getSurname());
//        System.out.println(user.getAge());

          byte [] bytes = FileUtil.readBytesNIO("C:\\Users\\Sahil\\Desktop\\test.jpg");
          FileUtil.writeBytesNIO("C:\\Users\\Sahil\\Desktop\\test2.jpg", bytes);

   
    }

}
