package entity;

import java.io.Serializable;
import java.util.Comparator;

public class LapTop implements Serializable {
    private String idLaptop;
    private String nameLaptop;
    private double price;
    private String category;
    private int quantity;

    public LapTop(String idLaptop, String nameLaptop, double price, String category, int quantity) {
        this.idLaptop = idLaptop;
        this.nameLaptop = nameLaptop;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "LapTop{" +
                "idLaptop='" + idLaptop + '\'' +
                ", nameLaptop='" + nameLaptop + '\'' +
                ", price=" + String.format("%.02f", price) +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }


}
