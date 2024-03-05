package management;

import entity.Invoice;
import entity.InvoiceDetails;
import entity.LapTop;
import file.FileControl;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDetailsManagement {
    private static List<InvoiceDetails> tempListInvoiceDetails = new ArrayList<>();
    private static List<InvoiceDetails> listInvoiceDetails = FileControl.read("InvoiceDetails");

    public static void setListInvoiceDetails() {
        FileControl.write(listInvoiceDetails,"InvoiceDetails");
        listInvoiceDetails = FileControl.read("InvoiceDetails");
    }

    public static void setTempList(){
        listInvoiceDetails = null;
    }
    public static List<InvoiceDetails> getListInvoiceDetails(){ return listInvoiceDetails;}
    public static List<InvoiceDetails> getTempListInvoiceDetails(){ return tempListInvoiceDetails;}

    public static void displayListInvoiceDetails(){
        for (InvoiceDetails invoiceDetails : listInvoiceDetails)
            System.out.println(invoiceDetails.toString(1));
    }

    public static void checkout(){
        for (InvoiceDetails invoiceDetails : tempListInvoiceDetails){
            for(int i = 0;i<LaptopManagement.getListLaptop().size();i++){
                if(invoiceDetails.getIdLaptop().equals(LaptopManagement.getListLaptop().get(i).getIdLaptop()))
                    LaptopManagement.getListLaptop().get(i).setQuantity(LaptopManagement.getListLaptop().get(i).getQuantity()-invoiceDetails.getQuantity());
            }
        }
        LaptopManagement.setListLaptop();
        listInvoiceDetails.addAll(tempListInvoiceDetails);
        setListInvoiceDetails();
    }
    public static void displayTempListInvoiceDetails(){
        int i=0;
        for (InvoiceDetails invoiceDetails : tempListInvoiceDetails) {
            System.out.println(i + "-=-" + invoiceDetails);
            i++;
        }
    }

    public static void addTempListWithIndexAndQuantity(int index, int quantityLaptop){
        String idLaptopadd = LaptopManagement.getListLaptop().get(index).getIdLaptop();
        String nameLaptopadd = LaptopManagement.getListLaptop().get(index).getNameLaptop();
        double priceadd = LaptopManagement.getListLaptop().get(index).getPrice();
        addTempListInvoiceDetails(new InvoiceDetails(Invoice.getIdInvoice(),idLaptopadd,nameLaptopadd,priceadd,quantityLaptop));

    }
    public static void addTempListInvoiceDetails(InvoiceDetails invoiceDetails){
        tempListInvoiceDetails.add(invoiceDetails);
    }
    public static void changeProduct (int index , int quantity){
        tempListInvoiceDetails.get(index).setQuantity(quantity);
    }
    public static void deteleProducts (int index){
        tempListInvoiceDetails.remove(index);
        setListInvoiceDetails();

    }

}
