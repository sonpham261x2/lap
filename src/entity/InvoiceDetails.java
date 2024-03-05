package entity;

import java.io.Serializable;

public class InvoiceDetails implements Serializable {
    private String idInvoice;
    private String idLaptop;
    private String nameLaptop;
    private double price;
    private int quantity;

    public InvoiceDetails(String idInvoice, String idLaptop, String nameLaptop, double price, int quantity) {
        this.idInvoice = idInvoice;
        this.idLaptop = idLaptop;
        this.nameLaptop = nameLaptop;
        this.price = price;
        this.quantity = quantity;
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getIdLaptop() {
        return idLaptop;
    }

    public void setIdLaptop(String idLaptop) {
        this.idLaptop = idLaptop;
    }

    public String getNameLaptop() {
        return nameLaptop;
    }

    public void setNameLaptop(String nameLaptop) {
        this.nameLaptop = nameLaptop;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public String toString(int i) {
        return "InvoiceDetails{" +
                "idInvoice='" + idInvoice + '\'' +
                ", idLaptop='" + idLaptop + '\'' +
                ", nameLaptop='" + nameLaptop + '\'' +
                ", price=" + String.format("%.02f", price) +
                ", quantity=" + quantity +
                '}';
    }
    @Override
    public String toString() {
        return "InvoiceDetails{" +
                ", idLaptop='" + idLaptop + '\'' +
                ", nameLaptop='" + nameLaptop + '\'' +
                ", price=" + String.format("%.02f", price) +
                ", quantity=" + quantity +
                '}';
    }
}
