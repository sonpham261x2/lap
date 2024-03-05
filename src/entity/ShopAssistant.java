package entity;

import java.io.Serializable;

public class ShopAssistant implements Serializable {
    private String idShopAssistant;
    private int pass;
    private String nameShopAssistant;
    private String phoneNumber;

    public ShopAssistant(String idShopAssistant, int pass, String nameShopAssistant, String phoneNumber) {
        this.idShopAssistant = idShopAssistant;
        this.pass = pass;
        this.nameShopAssistant = nameShopAssistant;
        this.phoneNumber = phoneNumber;
    }

    public String getIdShopAssistant() {
        return idShopAssistant;
    }

    public void setIdShopAssistant(String idShopAssistant) {
        this.idShopAssistant = idShopAssistant;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getNameShopAssistant() {
        return nameShopAssistant;
    }

    public void setNameShopAssistant(String nameShopAssistant) {
        this.nameShopAssistant = nameShopAssistant;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ShopAssistant{" +
                "idShopAssistant='" + idShopAssistant + '\'' +
                ", pass=" + pass +
                ", nameShopAssistant='" + nameShopAssistant + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }


}
