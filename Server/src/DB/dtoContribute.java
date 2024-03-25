/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Resal
 */
public class dtoContribute {
    private int barcode;
    private String item_name;
    private String user_name ;
    private String friend_name;
    private double cAmount ;
    private Date conDate; 
    private double remaining;

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
    public double getRemaining() {
        return remaining;
    }

    public void setRemaining(double remain) {
        this.remaining = remain;
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item) {
        this.item_name = item;
    }

    public String getFriend_name() {
        return friend_name;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;
    }

    public double getcAmount() {
        return cAmount;
    }

    public void setcAmount(double cAmount) {
        this.cAmount = cAmount;
    }

    public Date getConDate() {
        return conDate;
    }

    public void setConDate(Date conDate) {
        this.conDate = conDate;
    }

    public dtoContribute(int barcode, String user_name, String friend_name, double cAmount, Date conDate) {
        this.barcode = barcode;
        this.user_name = user_name;
        this.friend_name = friend_name;
        this.cAmount = cAmount;
        this.conDate = conDate;
    }
    public dtoContribute(String item,String friend_name) {
        this.item_name = item;
        this.friend_name = friend_name;
    }
    
    public dtoContribute(double remain) {
        this.remaining = remain;
    }
   
}
