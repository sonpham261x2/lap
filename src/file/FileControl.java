package file;

import entity.LapTop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileControl {
    public static final String LINKFILE = "C:\\Users\\84962\\javas\\projLaptop\\src\\file\\";

    public static <T> void write(List<T> l) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LINKFILE +"dataLaptop.txt"))) {
            oos.writeObject(l);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static <T> void write(List<T> l,String nameFile) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LINKFILE +"data"+nameFile+".txt"))) {
            oos.writeObject(l);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    public static <T> void writeOneElement(List<T> l) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LINKFILE +"dataLaptop.txt"))) {
//            oos.writeObject(l);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

    public static <T> List<T> read(String filename) {
        List<T> l = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(LINKFILE +"data"+filename+".txt"))) {
            l = (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return l;
    }



}
