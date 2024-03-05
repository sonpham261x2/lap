package management;

import entity.LapTop;
import file.FileControl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LaptopManagement {
    private static List<LapTop> listLaptop = FileControl.read("Laptop");

    public static void setListLaptop (){
        FileControl.write(listLaptop,"Laptop");
        listLaptop = FileControl.read("Laptop");
    }

    public static List<LapTop> getListLaptop (){
        return listLaptop;
    }

    public static void displayListLaptop () {
        int i=0;
        for (LapTop lapTop : listLaptop) {
            System.out.println(i + "-=-" + lapTop);
            i++;
        }
    }

    public static void displayWithPrice(){
        Collections.sort(listLaptop, new Comparator<LapTop>() {
            @Override
            public int compare(LapTop o1, LapTop o2) {
                return Double.compare(o1.getPrice(),o2.getPrice());
            }
        });
        displayListLaptop();
    }

    public static void displayWithQuatity(){
        Collections.sort(listLaptop, new Comparator<LapTop>() {
            @Override
            public int compare(LapTop o1, LapTop o2) {
                return Integer.compare(o1.getQuantity(),o2.getQuantity());
            }
        });
        displayListLaptop();
    }

    public static boolean findWithName(String name){
        boolean check=false;
        for (LapTop lapTop : listLaptop)
            if (lapTop.getNameLaptop().matches(".*"+name+".*")){
                System.out.println(lapTop);
                check= true;
            }
        return check;
    }

    public static boolean findWithRangePrice(double max, double min){
        for (LapTop lapTop : listLaptop)
            if(max >= lapTop.getPrice()  && lapTop.getPrice() >= min) {
                System.out.println(lapTop);
                return true;
            }
        return false;
    }
}
