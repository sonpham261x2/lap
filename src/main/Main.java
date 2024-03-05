package main;

import entity.Invoice;
import entity.InvoiceDetails;
import entity.ShopAssistant;
import file.FileControl;
import management.InvoiceDetailsManagement;
import management.InvoiceManagement;
import management.LaptopManagement;
import entity.LapTop;
import management.ShopAssistantManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        test();
        phamThaiSon();

    }

    public static void phamThaiSon (){
        int choice ;
        boolean check =true;
        while (check){
            System.out.println("====================================");
            System.out.println("1.Login");
            System.out.println("Other.Register");
            System.out.print("Enter your choose : ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:{
                    check=caseLogin(check);
                    break;
                }
                default: {
                    caseRegister();
                    break;
                }
            }
        }
        check=true;
        System.out.println("====================================");
        LaptopManagement.displayListLaptop();
        System.out.println("====================================");
        System.out.println("Your cart : ");
        InvoiceDetailsManagement.displayTempListInvoiceDetails();
        while (check){
            System.out.println("====================================");
            System.out.println("1.Sort products by price");
            System.out.println("2.Sort products by quantity");
            System.out.println("3.Search for products by approximate name");
            System.out.println("4.Search for products by price range");
            System.out.println("5.Add products to cart");
            System.out.println("6.Change the number of products in the cart");
            System.out.println("7.Delete the product in the cart");
            System.out.println("Other.Cart checkout");
            System.out.print("Enter your choose : ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:{
                    LaptopManagement.displayWithPrice();
                    break;
                }
                case 2:{
                    LaptopManagement.displayWithQuatity();
                    break;
                }
                case 3:{
                    System.out.print("Enter the Laptop name you want : ");
                    String nameLaptop = scanner.nextLine();
                    System.out.println("====================================");
                    if(!LaptopManagement.findWithName(nameLaptop)) System.out.println("The name not already existed");
                    break;
                }
                case 4:{
                    System.out.print("Enter max price : ");
                    double maxPrice = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter min price : ");
                    double minPrice = Double.parseDouble(scanner.nextLine());
                    System.out.println("====================================");
                    if(!LaptopManagement.findWithRangePrice(maxPrice,minPrice)) System.out.println("Not exits!");
                    break;
                }
                case 5:{
                    System.out.println("====================================");
                    LaptopManagement.displayListLaptop();
                    System.out.print("Choose product you want to add : ");
                    int indexLaptop = Integer.parseInt(scanner.nextLine());
                    int quatityLaptop;
                    do{
                        System.out.print("Enter quatity : ");
                        quatityLaptop = Integer.parseInt((scanner.nextLine()));
                    }while (quatityLaptop > LaptopManagement.getListLaptop().get(indexLaptop).getQuantity());
                    InvoiceDetailsManagement.addTempListWithIndexAndQuantity(indexLaptop,quatityLaptop);
                    System.out.println("====================================");
                    System.out.println("Your cart : ");
                    InvoiceDetailsManagement.displayTempListInvoiceDetails();
                    break;
                }
                case 6:{
                    System.out.println("====================================");
                    System.out.println("Your cart : ");
                    InvoiceDetailsManagement.displayTempListInvoiceDetails();
                    System.out.println("==================Change");
                    System.out.print("Choose your product want to change quantity: ");
                    int indexLaptop = Integer.parseInt(scanner.nextLine());
                    int quatityLaptop;
                    do{
                        System.out.print("Enter quatity : ");
                        quatityLaptop = Integer.parseInt((scanner.nextLine()));
                    }while (quatityLaptop > LaptopManagement.getListLaptop().get(indexLaptop).getQuantity());
                    InvoiceDetailsManagement.changeProduct(indexLaptop,quatityLaptop);
                    System.out.println("SUCCESSFUL!");
                    System.out.println("====================================");
                    System.out.println("Your cart : ");
                    InvoiceDetailsManagement.displayTempListInvoiceDetails();
                    break;
                }
                case 7:{
                    System.out.println("====================================");
                    System.out.println("Your cart : ");
                    InvoiceDetailsManagement.displayTempListInvoiceDetails();
                    System.out.println("==================Delete");
                    System.out.print("Choose your product want to detele : ");
                    int indexLaptop = Integer.parseInt(scanner.nextLine());
                    InvoiceDetailsManagement.deteleProducts(indexLaptop);
                    System.out.println("SUCCESSFUL!");
                    System.out.println("====================================");
                    System.out.println("Your cart : ");
                    InvoiceDetailsManagement.displayTempListInvoiceDetails();
                    break;
                }
                default: {
                    System.out.println("====================================");
                    System.out.println("Your cart : ");
                    InvoiceDetailsManagement.displayTempListInvoiceDetails();
                    System.out.println("==================Checkout");
                    System.out.print("Enter customer's name : ");
                    String nameCustomer = scanner.nextLine();
//                    InvoiceDetailsManagement.checkout();
                    InvoiceManagement.checkout(nameCustomer);
                    System.out.println("SUCCESSFUL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    test();
//                    check=false;
                    break;
                }
            }
        }
    }

    public static boolean caseLogin (boolean check ){
        while (true){
            System.out.println("==================Login");
            System.out.print("Enter your id : ");
            String id = scanner.nextLine();
            System.out.print("Enter your password : ");
            int pass = Integer.parseInt(scanner.nextLine());
            if (ShopAssistantManagement.checkShopAssistant(id,pass)) {
                System.out.println("Correct!");
                ShopAssistantManagement.IDLOGIN=id;
                check = false ;
                break;
            }
            else {
                System.out.println("Incorrect!");
                System.out.println("1.Re-login");
                System.out.println("Other.Back");
                System.out.print("Enter your choose : ");
                int choice1 = Integer.parseInt(scanner.nextLine());
                if (choice1 != 1) break;
            }
        }
        return check;
    }

    public static void caseRegister (){
        String id;
        do {
            System.out.println("==================Register");
            System.out.print("Enter your id : ");
            id = scanner.nextLine();
            if (ShopAssistantManagement.checkIdShopAssistant(id))
                System.out.println("Id have already existed!");
        } while (ShopAssistantManagement.checkIdShopAssistant(id));
        System.out.print("Enter your password : ");
        int pass = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter your name : ");
        String name = scanner.nextLine();
        System.out.print("Enter your phone number : ");
        String phonenumber = scanner.nextLine();
        ShopAssistantManagement.addShopAssistant(new ShopAssistant(id,pass,name,phonenumber));
        System.out.println("Successful!");
    }
    //////////////////////////////////
    ///////////////////////////////
    ////////////////////////
    ////////////////////
    //////////////
    ///////////
    ///////
    ///
    public static void test (){
//        ShopAssistant shopAssistant1 = new ShopAssistant("ID01",2807,"Pham Thai Son","0962977655");
//        ShopAssistant shopAssistant2 = new ShopAssistant("ID02",2808,"Pham Thai S","0962977666");
//        ShopAssistant shopAssistant3 = new ShopAssistant("ID03",2822,"Pham Thai O","096297777");
//        ShopAssistant shopAssistant4 = new ShopAssistant("ID04",1307,"Pham Thai N","0962977688");
//        List<ShopAssistant> list = new ArrayList<>();
//        list.add(shopAssistant1);
//        list.add(shopAssistant2);
//        list.add(shopAssistant3);
//        list.add(shopAssistant4);
//        FileControl.write(list,"ShopAssistant");
//        ///
        //r
        for (Object shopAssistant : FileControl.read("ShopAssistant")) System.out.println(shopAssistant);
        //r
        ///
//        LapTop lap1 = new LapTop("L123","Lenovo GH74",16000000,"ThinkPad",45);
//        LapTop lap2 = new LapTop("L124","Dell Pro V2",12000000,"IdeaPad",23);
//        LapTop lap3 = new LapTop("L125","Asus Z47",23000000,"ThinkPad",33);
//        LapTop lap4 = new LapTop("L126","Lenovo Gen10",33000000,"Gaming",12);
//        List<LapTop> list1 = new ArrayList<>();
//        list1.add(lap1);
//        list1.add(lap2);
//        list1.add(lap3);
//        list1.add(lap4);
//        FileControl.write(list1,"Laptop");
        ///
        //r
        for (Object lapTop : FileControl.read("Laptop")) System.out.println(lapTop);
        //r
        ///
//        InvoiceDetails ide1 = new InvoiceDetails("I0","L123","Lenovo GH74",16000000,1);
//        InvoiceDetails ide2 = new InvoiceDetails("I0","L124","Dell Pro V2",12000000,1);
//        InvoiceDetails ide3 = new InvoiceDetails("I1","L126","Lenovo Gen10",33000000,1);
//        InvoiceDetails ide4 = new InvoiceDetails("I1","L123","Lenovo GH74",16000000,1);
//        InvoiceDetails ide5 = new InvoiceDetails("I1","L124","Dell Pro V2",12000000,1);
//        InvoiceDetails ide6 = new InvoiceDetails("I2","L126","Lenovo Gen10",33000000,1);
//        InvoiceDetails ide7 = new InvoiceDetails("I3","L125","Asus Z47",23000000,1);
//        InvoiceDetails ide8 = new InvoiceDetails("I4","L124","Dell Pro V2",12000000,1);
//        InvoiceDetails ide9 = new InvoiceDetails("I4","L125","Asus Z47",23000000,1);
//        List<InvoiceDetails> list2 = new ArrayList<>();
//        list2.add(ide1);
//        list2.add(ide2);
//        list2.add(ide3);
//        list2.add(ide4);
//        list2.add(ide5);
//        list2.add(ide6);
//        list2.add(ide7);
//        list2.add(ide8);
//        list2.add(ide9);
//        FileControl.write(list2,"InvoiceDetails");
        ///
        //r
        for (Object invoiceDetails : FileControl.read("InvoiceDetails")) System.out.println(invoiceDetails);
        //r
        ///
//        Invoice invoice1 = new Invoice("I0","ID01","Tran Thanh Dat",28000000,"");
//        Invoice invoice2 = new Invoice("I1","ID01","Pham Thai Son",61000000,"");
//        Invoice invoice3 = new Invoice("I2","ID01","Nguyen Tuan Thanh",33000000,"");
//        Invoice invoice4 = new Invoice("I3","ID01","Luong Xuan Truong",23000000,"");
//        Invoice invoice5 = new Invoice("I4","ID01","Phi Truong Hai",35000000,"");
//        List<Invoice> list3 = new ArrayList<>();
//        list3.add(invoice1);
//        list3.add(invoice2);
//        list3.add(invoice3);
//        list3.add(invoice4);
//        list3.add(invoice5);
//        FileControl.write(list3,"Invoice");
        ///
        //r
        for(Object invoice : FileControl.read("Invoice")) System.out.println(invoice);
        //r
        ///
//        FileControl.read("Laptop");
//        InvoiceDetailsManagement.tempListInvoiceDetails=InvoiceDetailsManagement.listInvoiceDetails;
//        for (InvoiceDetails invoiceDetails : InvoiceDetailsManagement.tempListInvoiceDetails) System.out.println(invoiceDetails);
//        for (InvoiceDetails invoiceDetails : InvoiceDetailsManagement.listInvoiceDetails) System.out.println(invoiceDetails);
//        InvoiceDetailsManagement.changeProducts("L124");
//        InvoiceDetailsManagement.addListInvoiceDetails();
//        for (Object invoiceDetails : FileControl.read("InvoiceDetails")) System.out.println(invoiceDetails);
//        FileControl.read("Laptop");
    }
}
