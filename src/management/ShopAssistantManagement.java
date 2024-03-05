package management;

import entity.ShopAssistant;
import file.FileControl;

import java.util.List;

public class ShopAssistantManagement {
//    public static final String IDLOGIN ;
    public static String IDLOGIN ;
    public static List<ShopAssistant> listShopAssistant = FileControl.read("ShopAssistant");

    public static void setListShopAssistant() {
        FileControl.write(listShopAssistant,"ShopAssistant");
        listShopAssistant = FileControl.read("ShopAssistant");
    }
    public static List<ShopAssistant> getListShopAssistant(){ return listShopAssistant;}

    public static void displayListShopAssistant(){
        for (ShopAssistant shopAssistant : listShopAssistant)
            System.out.println(shopAssistant);
    }

    public static void addShopAssistant(ShopAssistant shopAssistant){
        listShopAssistant.add(shopAssistant);
        setListShopAssistant();
    }

    public static boolean checkShopAssistant (String id , int password){
        for (ShopAssistant shopAssistant : listShopAssistant)
            if (shopAssistant.getIdShopAssistant().equals(id) && shopAssistant.getPass()==password)
                return true;
        return false;
    }

    public static boolean checkIdShopAssistant (String id ){
        for (ShopAssistant shopAssistant : listShopAssistant)
            if (shopAssistant.getIdShopAssistant().equals(id))
                return true;
        return false;
    }

//    public static ShopAssistant getShopAssistant (){
//        for (ShopAssistant shopAssistant :listShopAssistant)
//            if (shopAssistant.getIdShopAssistant().equals())
//    }

}
