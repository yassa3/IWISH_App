/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.time.LocalDate;

/**
 *
 * @author Resal
 */
public class dtoWallet {
    private int walletId;
    private String creditNumber;
    private int cvv;
    private String name;
    // it will pass in sql as date dataType
    private String date ;
    private double amount;
    private String User_name;
    

    public dtoWallet(String creditNumber, int cvv, String name, String date, double amount) {
        this.creditNumber = creditNumber;
        this.cvv = cvv;
        this.name = name;
        this.date = date;
        this.amount = amount;
    }
        public dtoWallet(String creditNumber, int cvv, String name, String date,String username) {
        this.creditNumber = creditNumber;
        this.cvv = cvv;
        this.name = name;
        this.date = date;
        this.User_name = username;
    }
        public dtoWallet(String creditNumber, double amount) {
        this.creditNumber = creditNumber;
        this.amount = amount;
    }
     public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }
    public String getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(String creditNumber) {
        this.creditNumber = creditNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUserName() {
        return User_name;
    }

    public void setUserName(String name) {
        this.User_name = name;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
