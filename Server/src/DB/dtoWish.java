/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtouser;

/**
 *
 * @author Resal
 */
public class dtoWish {
    private int userId ;
    private int itemId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public dtoWish(int userId, int itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }
}
