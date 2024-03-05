package management;

import entity.Invoice;
import entity.InvoiceDetails;
import file.FileControl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class InvoiceManagement {
    public static List<Invoice> listInvoice =FileControl.read("Invoice");

    public static void setListInvoice() {
        FileControl.write(listInvoice,"Invoice");
        listInvoice = FileControl.read("Invoice");
    }
    public static List<Invoice> getListInvoice(){ return listInvoice;}

    public static void displayListInvoice(){
        for (Invoice invoice : listInvoice)
            System.out.println(invoice);
    }
    public static void checkout(String nameCustomer){
        String idInvoice = Invoice.getIdInvoice();
        String idShopAssistant = ShopAssistantManagement.IDLOGIN;
        double totalPrice = getTotalPrice();
        LocalDate day = LocalDate.now();
        String tradingDate = day.atTime(LocalTime.now()).toString();
        listInvoice.add(new Invoice(idInvoice,idShopAssistant,nameCustomer,totalPrice,tradingDate));
        InvoiceDetailsManagement.checkout();
        InvoiceDetailsManagement.setTempList();
        Invoice.setIdInvoice();
        setListInvoice();
    }
//    public static void addInvoice(Invoice invoice){
//        listInvoice.add(invoice);
//        Invoice.setIdInvoice();
//    }
    public static double getTotalPrice (){
        double total = 0.0;
        for (InvoiceDetails invoiceDetails : InvoiceDetailsManagement.getTempListInvoiceDetails())
            total+=invoiceDetails.getPrice();
        return total;
    }


}
