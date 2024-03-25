/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import javafx.scene.image.ImageView;



/**
 *
 * @author Resal
 */
public class dtoItem {
    private int itemId;
    private String name ;
    private double price ;
    private String description;
    private String category;
    private int barcode;
    private String user_name;
    public int getItemId() {
        return itemId;
    }

    public void setItemId (int itemId) {
        this.itemId = itemId;
    }
    public String getName() {
        return name;
    }
    public void setItembarcode (int barcode) {
        this.barcode = barcode;
    }
    public int getItembarcode() {
        return barcode;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setuserName(String name) {
        this.user_name = name;
    }
    public String getuserName() {
        return user_name;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public dtoItem(String name, double price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }
    public dtoItem(int barcode, String name, String description, String category, double price) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.barcode = barcode;
    }
    
}
