package entity;

import management.InvoiceDetailsManagement;
import management.InvoiceManagement;

import java.io.Serializable;
import java.util.Date;

public class Invoice implements Serializable {
    private static int invoice = InvoiceManagement.getListInvoice().size();
    private String idInvoice;
    private String idShopAssistant;
    private String nameCustomer;
    private double totalPrice;
    private String tradingDate;

    public Invoice(String idInvoice, String nameShopAssistant, String nameCustomer, double totalPrice, String tradingDate) {
        this.idInvoice = idInvoice;
        this.idShopAssistant = nameShopAssistant;
        this.nameCustomer = nameCustomer;
        this.totalPrice = totalPrice;
        this.tradingDate = tradingDate;
    }

    public static String getIdInvoice() {
        return "I"+invoice;
    }

    public static void setIdInvoice() {
        invoice++;
    }

    public String getNameShopAssistant() {
        return idShopAssistant;
    }

    public void setNameShopAssistant(String nameShopAssistant) {
        this.idShopAssistant = nameShopAssistant;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTradingDate() {
        return tradingDate;
    }

    public void setTradingDate(String tradingDate) {
        this.tradingDate = tradingDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "idInvoice='" + idInvoice + '\'' +
                ", idShopAssistant='" + idShopAssistant + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", totalPrice=" + String.format("%.02f", totalPrice) +
                ", tradingDate='" + tradingDate + '\'' +
                '}';
    }
}
