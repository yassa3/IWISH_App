/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DB.DAO;
import DB.DtoUser;
import DB.dtoContribute;
import DB.dtoItem;
import DB.dtoRelationShip;
import DB.dtoRequest;
import DB.dtoWallet;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Yassa
 */
public class MainThread extends Thread{
    ServerSocket serverSocket;
    public MainThread() {
        try {
            serverSocket = new ServerSocket(5000);
        } catch (IOException ex) {
            Logger.getLogger(MainThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() {
        try {
            while (true) {
                Socket ss = serverSocket.accept();
                new ChatHandler(ss);
            }
        } catch (IOException ex) {
            Logger.getLogger(MainThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void closeServerSocket() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(MainThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
        class ChatHandler extends Thread{
            DataInputStream ear;
            PrintStream mouth;
            dtoContribute contribution = null;
            static String res = null;
            static String friend_name = null;
            static int barcod = 0;
            static ArrayList<ChatHandler> clientsVector = new ArrayList<ChatHandler>();
            static ArrayList<DtoUser> users = new ArrayList<DtoUser>();
            private static Map<DtoUser, ChatHandler> userchatHandlerMap = new HashMap<>();
            public ChatHandler(Socket cs){
                try {
                    ear = new DataInputStream(cs.getInputStream());
                    mouth = new PrintStream(cs.getOutputStream());
                    clientsVector.add(this);
                    start();
                } catch (IOException ex) {
                    Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
                } 
            @Override
            public void run(){
                while(true)
                {
                    String str;
                    String key = null;
                    String value = null;
                    Gson gson = null;
                    JSONObject J_obj = null;
                    DtoUser user = null;
                    DtoUser userInfo = null;
                    try {
                        
                        str = ear.readLine();
                        J_obj = new JSONObject(str);
                        key = J_obj.getString("key");
                        gson = new Gson();
                        value = J_obj.getString("value");
                        if ("L".equals(key)){
                            user = gson.fromJson(value, DtoUser.class);
                            userInfo = DAO.userLogin(user);
                            users.add(userInfo);
                            userchatHandlerMap.put(userInfo,this);
                            String json = gson.toJson(userInfo);
                            JsonObject J_obj_R = new JsonObject();
                            J_obj_R.addProperty("key", "R");
                            J_obj_R.addProperty("value",json);
                            mouth.println(J_obj_R);
                            mouth.flush();
                        }
                        else if ("R".equals(key)){
                            int result = 0;
                            user = gson.fromJson(value, DtoUser.class);
                            result = DAO.SelectUser(user.getUserName());
                            if (result > 0){
                                mouth.println("UserInvalid");
                                mouth.flush();
                                break;
                            }
                            result  = DAO.getEmail(user.getEmail());
                            if (result > 0){
                                mouth.println("EmailInvalid");
                                mouth.flush();
                                break;
                            }
                            result = DAO.addUser(user);
                            mouth.println(result);
                            mouth.flush();
                        }
                        else if ("SF".equals(key)){
                            ArrayList<DtoUser> contacts = new ArrayList<>();
                            value = value.replaceAll("^\"|\"$", "");
                            String value2 = J_obj.getString("value2");
                            System.out.println(value2);
                            contacts = DAO.SearchFriend(value,value2);  
                            String json = gson.toJson(contacts);
                            JsonObject J_obj_R = new JsonObject();
                            J_obj_R.addProperty("key", "SR");
                            J_obj_R.addProperty("value",json);
                            mouth.println(J_obj_R);
                            mouth.flush();
                        }
                        else if ("AF".equals(key)){
                            dtoRequest friend = gson.fromJson(value, dtoRequest.class);
                            int result = DAO.AddFriend(friend);
                            if (result >= 1){
                               mouth.println("Done");
                               mouth.flush();
                            }
                            else{
                                mouth.println("AlreadyFriend");
                                mouth.flush();
                            }
                        }
                        else if ("ShowFriendsRequests".equals(key)){
                            ArrayList<DtoUser> Friends = new ArrayList<>();
                            ArrayList<DtoUser> Requests = new ArrayList<>();
                            user = gson.fromJson(value, DtoUser.class);
                            String username = user.getUserName();
                            Friends = DAO.ShowFriends(username);
                            Requests = DAO.ShowRequests(username);  
                            String json1 = gson.toJson(Friends);
                            String json2 = gson.toJson(Requests);
                            JsonObject J_obj_R = new JsonObject();
                            J_obj_R.addProperty("key", "FRR");
                            J_obj_R.addProperty("value1",json1);
                            J_obj_R.addProperty("value2",json2);
                            if (Friends != null || Requests != null){
                                mouth.println(J_obj_R);
                                mouth.flush();
                            }
                            else{
                                System.out.println("ShowRequestsError");
                            }
                        }
                        else if ("showrequests".equals(key)){
                            System.out.println("test");
                            ArrayList<DtoUser> Requests = new ArrayList<>();
                            user = gson.fromJson(value, DtoUser.class);
                            String username = user.getUserName();
                            Requests = DAO.ShowRequests(username); 
                            System.out.println(Requests.size());
                            String json = gson.toJson(Requests);
                            JsonObject J_obj_R = new JsonObject();
                            J_obj_R.addProperty("key", "NR");
                            J_obj_R.addProperty("value",json);
                            if (Requests != null){
                                mouth.println(J_obj_R);
                                mouth.flush();
                            }
                            else{
                                System.out.println("ShowRequestsError");
                            }
                        }
                        else if ("ShowFriends".equals(key)){
                            ArrayList<DtoUser> Friends = new ArrayList<>();
                            user = gson.fromJson(value, DtoUser.class);
                            String username = user.getUserName();
                            Friends = DAO.ShowFriends(username);
                            String json = gson.toJson(Friends);
                            JsonObject J_obj_R = new JsonObject();
                            J_obj_R.addProperty("key", "FR");
                            J_obj_R.addProperty("value",json);
                            if (Friends != null){
                                mouth.println(J_obj_R);
                                mouth.flush();
                            }
                            else{
                                System.out.println("ShowFriendsError");
                            }
                        }
                        else if ("ShowFriendItems".equals(key)){
                            ArrayList<dtoItem> items = new ArrayList<>();
                            user = gson.fromJson(value, DtoUser.class);
                            String username = user.getUserName();
                            items = DAO.ShowItems(username);
                            String json1 = gson.toJson(items);
                            JsonObject J_obj_R = new JsonObject();
                            J_obj_R.addProperty("key", "FIR");
                            J_obj_R.addProperty("value",json1);
                            if (items != null){
                                mouth.println(J_obj_R);
                                mouth.flush();
                            }
                        }
                        else if ("contribute".equals(key)){
                                contribution = gson.fromJson(value, dtoContribute.class);  
                                res = DAO.Contribute(contribution);
                                barcod = contribution.getBarcode();
                                friend_name = contribution.getFriend_name();
                                JsonObject J_obj_R = new JsonObject();
                                J_obj_R.addProperty("key", "CR");
                                J_obj_R.addProperty("value",res);
                                mouth.println(J_obj_R);
                                mouth.flush();
                        }
                        
                        else if("Showstatus".equals(key)){
                            ArrayList<dtoContribute> contribute = new ArrayList<>();
                            ArrayList<dtoContribute> names = new ArrayList<>();
                            user = gson.fromJson(value, DtoUser.class);
                            String username = user.getUserName();
                            contribute = DAO.getStatusCon(username);
                            names = DAO.getStatusRes(username);
                            String json1 = gson.toJson(contribute);
                            String json2 = gson.toJson(names);
                            JsonObject J_obj_R = new JsonObject();
                            J_obj_R.addProperty("key", "CCR");
                            J_obj_R.addProperty("value1",json1);
                            J_obj_R.addProperty("value2",json2);
                            mouth.println(J_obj_R);
                            mouth.flush();
                        }

                        else if ("ShowBalance".equals(key)){
                            user = gson.fromJson(value, DtoUser.class);
                            String username = user.getUserName();
                            double balance = DAO.getBalance(username);
                            DtoUser use = new DtoUser();
                            System.out.println(balance);
                            use.setBalance(balance);
                            String json = gson.toJson(use);
                            JsonObject J_obj_R = new JsonObject();
                            J_obj_R.addProperty("key", "HR");
                            J_obj_R.addProperty("value",json);
                            mouth.println(J_obj_R);
                            mouth.flush();
                        }
                        else if ("enter".equals(key)){
                            user = gson.fromJson(value, DtoUser.class);
                            String name = DAO.Enter(user);
                            if (name == null)
                                name = "WrongAnswer";
                            mouth.println(name);
                            mouth.flush();
                        }
                        else if ("recharge".equals(key)){
                            dtoWallet wallet = gson.fromJson(value, dtoWallet.class);
                            String value2 = J_obj.getString("value2");
                            String st = DAO.rechargeCredit(wallet, value2);
                            if ("Done".equals(st)){
                                double balance = DAO.getBalance(value2);
                                mouth.println(balance);
                                mouth.flush();
                            }
                            else{
                                mouth.println(st);
                                mouth.flush();
                            }
                            
                        }
                        else if ("save".equals(key)){
                            int result =0;
                            String stat = null;
                            user = gson.fromJson(value, DtoUser.class);
                            result =DAO.save(user);
                            if (result >=1)
                                stat = "Success";
                            else
                                stat = "Failed";
                            mouth.println(stat);
                        }
                        else if ("P".equals(key)){
                            user = gson.fromJson(value, DtoUser.class);
                            user = DAO.userProfile(user.getUserName());
                            String json = gson.toJson(user);
                            JsonObject J_obj_P = new JsonObject();
                            J_obj_P.addProperty("key", "PR");
                            J_obj_P.addProperty("value",json);
                            mouth.println(J_obj_P);
                            mouth.flush();
                        }
                        
                        else if ("AcceptFriend".equals(key)){
                            dtoRequest acc = gson.fromJson(value, dtoRequest.class);
                            int res = DAO.AcceptFriend(acc);
                            
                            String json = gson.toJson(res);
                            JsonObject J_obj_P = new JsonObject();
                            J_obj_P.addProperty("key", "ACCR");
                            J_obj_P.addProperty("value",json);
                            mouth.println(J_obj_P);
                            mouth.flush();

                            }
                            
                            else if ("AddCredit".equals(key)){
                            int result = 0;
                            dtoWallet wallet = gson.fromJson(value, dtoWallet.class);
                            result = DAO.addCredit(wallet);
                            
                            mouth.println(result);
                            mouth.flush();
                            
                        }
                        
                        else if ("CP".equals(key)) {
                                  DtoUser userToUpdate = gson.fromJson(value, DtoUser.class);
                                  String value2 = J_obj.getString("value2");
                                  int result = DAO.changepassword(userToUpdate,value2);
                                  mouth.println(result);
                                  mouth.flush();
                              } 
                        
                        else if ("ShowWishList".equals(key)){
                            ArrayList<dtoItem> items =new ArrayList<>();
                            user =gson.fromJson(value, DtoUser.class);
                            String username=user.getUserName();
                            items =DAO.ShowItems(username);
                            String json1=gson.toJson(items);
                            JsonObject J_obj_W=new JsonObject();
                            J_obj_W.addProperty("key","WishListResponse");
                            J_obj_W.addProperty("value",json1);
                            if (items != null){
                                mouth.println(J_obj_W);
                                mouth.flush();
                            }
                        }
                        else if ("SearchHandler".equals(key)){
                            ArrayList<dtoItem> items =new ArrayList<>();
                            value = value.replaceAll("^\"|\"$", "");
                            items =DAO.searchItems(value);
                            String json =gson.toJson(items);
                            JsonObject J_obj_R=new JsonObject();
                            J_obj_R.addProperty("key", "SearchResponse");
                            J_obj_R.addProperty("value",json );
                            if (items != null){
                                mouth.println(J_obj_R);
                                mouth.flush();
                            }
                            else {
                                System.out.println("ShowItemError");
                            }
                            
                        }
                        else if ("DF".equals(key)) {
                            dtoRequest friendRequest = gson.fromJson(value, dtoRequest.class);
                            int declineResult = DAO.DeclineFriend(friendRequest);
                            
                            mouth.println(declineResult);
                            mouth.flush();
                            
                        }
                        else if ("RemoveFriend".equals(key)){
                            dtoRelationShip remove  = gson.fromJson(value, dtoRelationShip.class);
                            int rm = DAO.DeleteFriend(remove);
                            mouth.println(rm);
                            mouth.flush();
                        }
                        else if ("Additem".equals(key)){
                            dtoItem items =gson.fromJson(value,dtoItem.class);
                            System.out.println(items.getuserName());
                            int result=DAO.addWish(items);
                            
                                mouth.println(result);
                                mouth.flush();
                           
                        
                        }
                        else if ("RemoveFromWishlist".equals(key)) {
                                dtoItem itemToRemove = gson.fromJson(value, dtoItem.class);
                                System.out.println(itemToRemove.getuserName());
                                int result = DAO.removeSelectedItem(itemToRemove);
                                mouth.println(result);
                                mouth.flush();
                        }
                        else if ("insertitems".equals(key)) {
                                dtoItem insertItem = gson.fromJson(value, dtoItem.class);
                                int result = DAO.InsertItems(insertItem);
                                mouth.println(result);
                                mouth.flush();
                        }
                        } catch (SQLException | IOException ex) {
                        Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
            }       
        }
            
}
        

        

    

