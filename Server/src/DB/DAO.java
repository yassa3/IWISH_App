/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Yassa
 */
public class DAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/i_wish?useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    public static int  addUser(DtoUser user) throws SQLException{
        int result=0;
          Connection con =DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
          PreparedStatement statement =con.prepareCall("INSERT INTO user (User_id,User_name,First_name,last_name,security_ans,e_mail,password,balance) VALUES(?,?,?,?,?,?,?,?);");
          statement.setInt(1,user.getuserId());
          statement.setString(2,user.getUserName());
          statement.setString(3,user.getFirstName());
          statement.setString(4,user.getLastName());
          statement.setString(5,user.getSecurityAns());
          statement.setString(6,user.getEmail());
          statement.setString(7,user.getPasswd());
          statement.setDouble(8,user.getBalance());
          result =statement.executeUpdate();
          con.close();
          statement.close();
          return result;
    }
     public static DtoUser userLogin (DtoUser u) throws SQLException{
         //int index = 0;
         Connection con =DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
         PreparedStatement statement=con.prepareStatement("select User_name ,balance from user where User_name =? and password=?");
         statement.setString(1, u.getUserName());
         statement.setString(2,u.getPasswd());
         DtoUser getUserInfo=null;
         ResultSet result=statement.executeQuery();
         while(result.next()){
             getUserInfo =new DtoUser(result.getString(1),result.getDouble(2));
         }
         //if (getUserInfo != null)
           //  index = 1;
         return getUserInfo;
     }
     public static DtoUser userProfile (String user) throws SQLException{
         Connection con =DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
         PreparedStatement statement=con.prepareStatement("select User_name ,First_name ,last_name,security_ans,e_mail,balance from user where User_name =? ");
         statement.setString(1,user);
         DtoUser profileUser = null;
         ResultSet resultSet=statement.executeQuery();
         while(resultSet.next()){
            profileUser=new DtoUser(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
         }
         return profileUser;
     }
    public static String Enter(DtoUser user) throws SQLException{
        String name=null;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps = con.prepareCall("select User_name from user where e_mail = ? and security_ans=?");
        System.out.println(user.getEmail());
        System.out.println(user.getSecurityAns());
        ps.setString(1,user.getEmail());
        ps.setString(2,user.getSecurityAns()); 
        ResultSet resultset = ps.executeQuery();
        while (resultset.next()) {
            name = resultset.getString(1);
        }    
        ps.close();
        con.close();
        return name;
    }
    public static int save(DtoUser user) throws SQLException{
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps = con.prepareCall("update user set password = ? where e_mail=?");
        ps.setString(1,user.getPasswd());
        ps.setString(2,user.getEmail()); 

        int result = ps.executeUpdate(); 
        ps.close();
        con.close();
        return result;
    }
    public static int changepassword(DtoUser user,String oldpass) throws SQLException{
        Connection con = DriverManager.getConnection(DB_URL,DB_USER ,DB_PASSWORD);
        PreparedStatement ps = con.prepareCall("update user set password = ? where User_name = ? and password = ?");
        ps.setString(1,user.getPasswd());
        ps.setString(2,user.getUserName()); 
        ps.setString(3,oldpass); 
        int result = ps.executeUpdate(); 
        ps.close();
        con.close();
        return result;
    }
    
    public static ArrayList<DtoUser> SearchFriend(String s,String user) throws SQLException {
        ArrayList<DtoUser> contacts = new ArrayList<>();
        Connection con = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
        PreparedStatement ps = con.prepareStatement("select User_name,e_mail,First_name from user where User_name like ? and User_name != ?");
        ps.setString(1,s + "%");
        ps.setString(2,user);
        ResultSet resultset = ps.executeQuery();
        while (resultset.next()) {
            contacts.add(new DtoUser(resultset.getString(1),resultset.getString(2),resultset.getString(3)));
        }  
        ps.close();
        con.close();
        return contacts;
    }
    public static ArrayList<DtoUser> ShowRequests(String s) throws SQLException {
        ArrayList<DtoUser> contacts = new ArrayList<>();
        int id = DAO.SelectUserID(s);
        Connection con = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
        PreparedStatement ps = con.prepareStatement("select User_name,e_mail from user inner join request on user.User_id = request.user_id where status = 'PENDING' and friend_id = ?");
        ps.setInt(1,id);
        ResultSet resultset = ps.executeQuery();
        while (resultset.next()) {
            DtoUser user = new DtoUser();
            user.setUserName(resultset.getString(1));
            user.setEmail(resultset.getString(2));
            contacts.add(user);
        }  
        ps.close();
        con.close();
        return contacts;
    }
    public static ArrayList<DtoUser> ShowFriends(String s) throws SQLException {
        ArrayList<DtoUser> contacts = new ArrayList<>();
        int id = DAO.SelectUserID(s);
        Connection con = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
        PreparedStatement ps = con.prepareStatement("select User_name,e_mail from user inner join relationship on user.User_id = relationship.friend_id where relationship.user_id = ?");
        ps.setInt(1,id);
        ResultSet resultset = ps.executeQuery();
        while (resultset.next()) {
            DtoUser user = new DtoUser();
            user.setUserName(resultset.getString(1));
            user.setEmail(resultset.getString(2));
            contacts.add(user);
        }  
        ps.close();
        con.close();
        return contacts;
    }
    public static int AddFriend(dtoRequest p_friend) throws SQLException {
        int result=0;
        int id1,id2;
        int index=0;
        id1 = SelectUserID(p_friend.getUserName());
        id2 = SelectUserID(p_friend.getFriendName());
        Connection con = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select user_id from relationship where friend_id = ?");
        ps_sel.setInt(1,id2);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            index++;
        }
        ps_sel.close();
        if (index ==0){
            
            PreparedStatement ps_ins = con.prepareStatement("INSERT INTO request VALUES (?,?,?)");
            ps_ins.setInt(1,id1);
            ps_ins.setInt(2,id2);
            ps_ins.setString(3,p_friend.getStatus());


            result = ps_ins.executeUpdate();
            ps_ins.close();
        }
        else
            result = 0;
        con.close();
        return result;
    }
    public static int DeleteFriend(dtoRelationShip friend) throws SQLException {
        int result;
        ArrayList<Integer> ids = new ArrayList<>();
        ids = SelectUsers(friend.getUserName(), friend.getFriendName());
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_del = con.prepareStatement("delete from relationship where user_id = ? and friend_id = ?");
        ps_del.setInt(1,ids.get(0));
        ps_del.setInt(2,ids.get(1));
        
        PreparedStatement ps_del2 = con.prepareStatement("delete from relationship where user_id = ? and friend_id = ?");
        ps_del2.setInt(1,ids.get(1));
        ps_del2.setInt(2,ids.get(0));
        PreparedStatement ps_del3 = con.prepareStatement("delete from request where (user_id = ? and friend_id = ?) or (user_id = ? and friend_id = ?)");
        ps_del3.setInt(1,ids.get(1));
        ps_del3.setInt(2,ids.get(0));
        ps_del3.setInt(3,ids.get(0));
        ps_del3.setInt(4,ids.get(1));
        
        result = ps_del.executeUpdate();
        result = ps_del2.executeUpdate();
        result = ps_del3.executeUpdate();
        ps_del.close();
        ps_del2.close();
        ps_del3.close();
        con.close();
        return result;
    }
    public static int AcceptFriend(dtoRequest p_friend) throws SQLException {
        int result;
        ArrayList<Integer> ids = new ArrayList<>();
        ids = SelectUsers(p_friend.getUserName(), p_friend.getFriendName());
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_ins = con.prepareStatement("INSERT INTO relationship VALUES (?,?)");
        ps_ins.setInt(1,ids.get(0));
        ps_ins.setInt(2,ids.get(1));
        result = ps_ins.executeUpdate();
        PreparedStatement ps_ins2 = con.prepareStatement("INSERT INTO relationship VALUES (?,?)");
        ps_ins2.setInt(1,ids.get(1));
        ps_ins2.setInt(2,ids.get(0));
        result = ps_ins2.executeUpdate();
        PreparedStatement ps_upd = con.prepareStatement("update request set status = ? where (user_id = ? and friend_id = ?) or(user_id = ? and friend_id = ?)");
        ps_upd.setString(1,"ACCEPTED");
        ps_upd.setInt(2,ids.get(1));
        ps_upd.setInt(3,ids.get(0));
        ps_upd.setInt(4,ids.get(0));
        ps_upd.setInt(5,ids.get(1));

        result = ps_upd.executeUpdate();
        ps_ins.close();
        ps_upd.close();
        con.close();
        return result;
    }
    public static int DeclineFriend(dtoRequest p_friend) throws SQLException {
        int result;
        ArrayList<Integer> ids = new ArrayList<>();
        ids = SelectUsers(p_friend.getUserName(), p_friend.getFriendName());
        System.out.println(ids.get(0));
        System.out.println(ids.get(1));
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_upd = con.prepareStatement("update request set status = ? where (user_id = ? and friend_id = ?) or (user_id = ? and friend_id = ?)");
        ps_upd.setString(1,"REFUSED");
        ps_upd.setInt(2,ids.get(1));
        ps_upd.setInt(3,ids.get(0));
        ps_upd.setInt(4,ids.get(0));
        ps_upd.setInt(5,ids.get(1));

        result = ps_upd.executeUpdate();
        ps_upd.close();
        con.close();
        return result;
    }
    public static String Contribute(dtoContribute cont) throws SQLException {
        String result = null;
        int item_id;
        double balance = 0;
        double remain = -1;
        double price = 0;
        int user_id = SelectUserID(cont.getUser_name());
        int friend_id = SelectUserID(cont.getFriend_name());
        item_id = SelectItems(cont.getBarcode());
        price = DAO.SelectItemPrice(item_id);
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select balance from user where User_id = ? ");
        ps_sel.setInt(1,user_id);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            balance = resultset.getDouble(1);
        }  
        if (balance - cont.getcAmount() < 0){
            result = "NotEnoughMoney";
        }
        else{
            PreparedStatement ps_upd = con.prepareStatement("update user set balance = ? where User_id = ?");
            ps_upd.setDouble(1,balance-cont.getcAmount());
            ps_upd.setInt(2,user_id);
            ps_upd.executeUpdate();
            PreparedStatement ps_sel1 = con.prepareStatement("select remaining from contribution where friend_id = ? and item_id = ? order by remaining asc limit 1");
            ps_sel1.setInt(1,friend_id);
            ps_sel1.setInt(2,item_id);
            ResultSet resultset1 = ps_sel1.executeQuery();
            while (resultset1.next()) {
                remain = resultset1.getDouble(1);
            }  
            PreparedStatement ps_ins = con.prepareStatement("insert into contribution values (?,?,?,?,?,?)");
            ps_ins.setInt(1,item_id);
            ps_ins.setInt(2,user_id);
            ps_ins.setInt(3,friend_id);
            ps_ins.setDouble(4,cont.getcAmount());
            ps_ins.setDate(5,cont.getConDate());
            if (remain == -1){
                if (price-cont.getcAmount()<= 0){
                    ps_ins.setDouble(6,0);
                    result = "Completed";
                    PreparedStatement ps_upd2 = con.prepareStatement("update contribution set remaining = ? where friend_id = ? and item_id = ?");
                    ps_upd2.setDouble(1,0);
                    ps_upd2.setInt(2,friend_id);
                    ps_upd2.setInt(3,item_id);
                    ps_upd2.executeUpdate();
                    PreparedStatement ps_upd3 = con.prepareStatement("delete from wish where user_id = ? and item_id = ?");
                    ps_upd3.setInt(1,friend_id);
                    ps_upd3.setInt(2,item_id);
                    ps_upd3.executeUpdate();
                    ps_upd3.close();

                }
                else{
                    ps_ins.setDouble(6,price-cont.getcAmount());
                    result = "Done";
                }
            }
            else{
                if (remain-cont.getcAmount()<= 0){
                    ps_ins.setDouble(6,0);
                    result = "Completed";
                    PreparedStatement ps_upd2 = con.prepareStatement("update contribution set remaining = ? where friend_id = ? and item_id = ?");
                    ps_upd2.setDouble(1,0);
                    ps_upd2.setInt(2,friend_id);
                    ps_upd2.setInt(3,item_id);
                    ps_upd2.executeUpdate();
                    PreparedStatement ps_upd4 = con.prepareStatement("delete from wish where user_id = ? and item_id = ?");
                    ps_upd4.setInt(1,friend_id);
                    ps_upd4.setInt(2,item_id);
                    ps_upd4.executeUpdate();
                    ps_upd4.close();
                }
                else{
                    ps_ins.setDouble(6,remain-cont.getcAmount());
                    result = "Done";
                }
            }
            ps_ins.executeUpdate();
            ps_upd.close();
            ps_ins.close();
            ps_sel.close();
            con.close();
            
        }
        System.out.println(result);
        return result;
    }     
    public static ArrayList<Integer> SelectContributers(String friend,int barcode) throws SQLException {
        int friend_id = DAO.SelectUserID(friend);
        int item_id = DAO.SelectItems(barcode);
        ArrayList<Integer> ids = new ArrayList<>();
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select user_id from contribution where friend_id = ? and item_id = ?");
        ps_sel.setInt(1,friend_id);
        ps_sel.setInt(2,item_id);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            ids.add(resultset.getInt(1));
        }
        ps_sel.close();
        con.close();
        return ids;
    }
    public static int addCredit(dtoWallet walletDTO) throws SQLException {
            int id = 0;
            int index1 = 0;
            int index2 = 0;
            int result = 0;
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement ps_sel1 = con.prepareStatement("select wallet_id from wallet where credit_number = ?");
            ps_sel1.setString(1,walletDTO.getCreditNumber());
            ResultSet resultset1 = ps_sel1.executeQuery();
            while (resultset1.next()) {
                index1++;
            }
            ps_sel1.close();
            PreparedStatement ps_sel2 = con.prepareStatement("select wallet_id from wallet where cvv = ?");
            ps_sel2.setInt(1,walletDTO.getCvv());
            ResultSet resultset2 = ps_sel2.executeQuery();
            while (resultset2.next()) {
                index2++;
            }
            ps_sel2.close();
            if (index1 ==0 && index2==0){
                PreparedStatement ps_sel = con.prepareStatement("select User_id from User where User_name = ?");
                ps_sel.setString(1,walletDTO.getUserName());
                ResultSet resultset = ps_sel.executeQuery();
                while (resultset.next()) {
                    id = resultset.getInt(1);
                }
                ps_sel.close();

                String query = "INSERT INTO wallet (credit_number, cvv, date, name, amount, user_id) VALUES (?, ?, ?, ?, ?, ?)";


                double randomAmount = generateRandomAmount();

                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1, walletDTO.getCreditNumber());
                    preparedStatement.setInt(2, walletDTO.getCvv());
                    preparedStatement.setString(3, walletDTO.getDate());
                    preparedStatement.setString(4, walletDTO.getName());
                    preparedStatement.setDouble(5, randomAmount);
                    preparedStatement.setInt(6, id);
                    result = preparedStatement.executeUpdate();

             preparedStatement.close();
            }
            else
                result = 0;
         con.close();    
         return result;
                
}

    
    private static double generateRandomAmount() {
        Random rand = new Random();
        return rand.nextDouble() * 1000000.0 + 1.0;
    }
    
    public static ArrayList<dtoItem> searchItems(String item) throws SQLException{
            ArrayList<dtoItem> items = new ArrayList<>();
            Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            String query = "SELECT * FROM Item WHERE name LIKE ?";
            PreparedStatement ps_sel = con.prepareStatement(query);
            ps_sel.setString(1,item + "%");
            ResultSet resultset = ps_sel.executeQuery();
            while (resultset.next()) {
                items.add(new dtoItem(resultset.getInt(6),resultset.getString(2),resultset.getString(4),resultset.getString(5),resultset.getDouble(3)));
            }  
                
        return items;
    }
    public static ArrayList<dtoItem> ShowItems(String s) throws SQLException {
        ArrayList<dtoItem> Items = new ArrayList<>();
        int id = DAO.SelectUserID(s);
        Connection con = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
        PreparedStatement ps = con.prepareStatement("select barcode,name,describtion,category,price from item inner join wish on item.Item_id = wish.item_id where wish.user_id = ?");
        ps.setInt(1,id);
        ResultSet resultset = ps.executeQuery();
        while (resultset.next()) {
            Items.add(new dtoItem(resultset.getInt(1),resultset.getString(2),resultset.getString(3),resultset.getString(4),resultset.getDouble(5)));
        }  
        ps.close();
        con.close();
        return Items;
    }
    public static int addWish(dtoItem item) throws SQLException{
        int result;
        int user_id;
        int item_id;
        user_id = SelectUserID(item.getuserName());
        item_id = SelectItems(item.getItembarcode());
        System.out.println(user_id);
        System.out.println(item_id);
        Connection con = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
        PreparedStatement ps_ins = con.prepareStatement("INSERT INTO wish VALUES (?,?)");
        ps_ins.setInt(1,user_id);
        ps_ins.setInt(2,item_id);
        result = ps_ins.executeUpdate();
        ps_ins.close();
        con.close();
        return result;
    }
    public static int removeSelectedItem(dtoItem item) throws SQLException{
        int result;
        int user_id;
        int item_id;
        user_id = SelectUserID(item.getuserName());
        item_id = SelectItems(item.getItembarcode());
        Connection con = DriverManager.getConnection(DB_URL,DB_USER, DB_PASSWORD);
        PreparedStatement ps_ins = con.prepareStatement("delete from wish where user_id = ? and item_id = ?");
        ps_ins.setInt(1,user_id);
        ps_ins.setInt(2,item_id);
        result = ps_ins.executeUpdate();
        ps_ins.close();
        con.close();
        return result;
    }
    public static String rechargeCredit(dtoWallet wallet,String user) throws SQLException{
        int id = SelectUserID(user);
        double amount=-1;
        double balance = 0;
        int result = 0;
        String str= null;
        PreparedStatement ps_upd2 = null;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel1 = con.prepareStatement("select amount from wallet where User_id = ? and credit_number = ?");
        ps_sel1.setInt(1,id);
        ps_sel1.setString(2,wallet.getCreditNumber());
        ResultSet resultset1 = ps_sel1.executeQuery();
        while (resultset1.next()) {
            amount = resultset1.getDouble(1);
        }  
        if (amount != -1){
            System.out.println("1");
            PreparedStatement ps_sel2 = con.prepareStatement("select balance from user where User_id = ? ");
            ps_sel2.setInt(1,id);
            ResultSet resultset2 = ps_sel2.executeQuery();
            while (resultset2.next()) {
                balance = resultset2.getDouble(1);
            }  
            double  rest = amount - wallet.getAmount();
            double  increase = balance + wallet.getAmount();
            if (rest>=0){
                System.out.println("2");
                PreparedStatement ps_upd1 = con.prepareStatement("update wallet set amount = ? where user_id = ?");
                ps_upd1.setDouble(1,rest);
                ps_upd1.setInt(2,id);
                result = ps_upd1.executeUpdate();
                ps_upd2 = con.prepareStatement("update user set balance = ? where user_id = ?");
                ps_upd2.setDouble(1,increase);
                ps_upd2.setInt(2,id);
                result = ps_upd2.executeUpdate();
                ps_upd1.close();
                ps_upd2.close();
                str = "Done";
            }
            else{
                str = "NotEnough";
                System.out.println("3");
            }
        }
        else{
            str = "Invalid";
             System.out.println("4");
        }
        con.close();
        return str;
        
    }
    public static ArrayList<Integer> SelectUsers(String user, String friend) throws SQLException {
        ArrayList<Integer> ids = new ArrayList<>();
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select User_id from user where User_name = ? or User_name = ?");
        ps_sel.setString(1,user);
        ps_sel.setString(2,friend);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            ids.add(resultset.getInt(1));
        }
        ps_sel.close();
        con.close();
        return ids;
    }
    public static int SelectItems(int barcode) throws SQLException {
        int id = 0;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select Item_id from item where barcode = ?");
        ps_sel.setInt(1,barcode);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            id = resultset.getInt(1);
        }
        ps_sel.close();
        con.close();
        return id;
    }
    public static int SelectUser(String user) throws SQLException {
        int index=0;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select User_id from user where User_name = ?");
        ps_sel.setString(1,user);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            index++;
        }
        ps_sel.close();
        con.close();
        return index;
    }
     public static String SelectUserName(int id) throws SQLException {
        String name = null;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select User_name from user where User_id = ?");
        ps_sel.setInt(1,id);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            name = resultset.getString(1);
        }
        ps_sel.close();
        con.close();
        return name;
    }
    public static int SelectUserID(String user) throws SQLException {
        int id=0;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select User_id from user where User_name = ?");
        ps_sel.setString(1,user);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            id = resultset.getInt(1);
        }
        ps_sel.close();
        con.close();
        return id;
    }
    public static String SelectEmail(String user) throws SQLException {
        String email = null;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select e_mail from user where User_name = ?");
        ps_sel.setString(1,user);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            email = resultset.getString(1);
        }
        ps_sel.close();
        con.close();
        return email;
    }
    public static int getEmail(String email) throws SQLException {
        int index=0;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select User_id from user where e_mail = ?");
        ps_sel.setString(1,email);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            index++;
        }
        ps_sel.close();
        con.close();
        return index;
    }
    public static double SelectItemPrice(int id) throws SQLException {
        double price = 0;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select price from item where item_id = ?");
        ps_sel.setInt(1,id);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            price = resultset.getDouble(1);
        }
        ps_sel.close();
        con.close();
        return price;
    }
     public static String SelectItemName(int id) throws SQLException {
        String name = null;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select name from item where item_id = ?");
        ps_sel.setInt(1,id);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            name = resultset.getString(1);
        }
        ps_sel.close();
        con.close();
        return name;
    }
    public static double getBalance(String user) throws SQLException {
        double balance = 0;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select balance from user where User_name = ?");
        ps_sel.setString(1,user);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            balance = resultset.getDouble(1);
        }
        ps_sel.close();
        con.close();
        return balance;
    }
    public static ArrayList<dtoContribute> getStatusCon(String user) throws SQLException {
        double balance = 0;
        int user_id = DAO.SelectUserID(user);
        ArrayList<dtoContribute> contribute = new ArrayList<>();
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select friend_id,item_id from contribution where user_id = ? and remaining = ?");
        ps_sel.setInt(1,user_id);
        ps_sel.setDouble(2,0);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            String friend_name = DAO.SelectUserName(resultset.getInt(1));
            int id = resultset.getInt(2);
            String item = DAO.SelectItemName(id);
            contribute.add(new dtoContribute(item,friend_name));
        }
        ps_sel.close();
        con.close();
        return contribute;
    }
    public static ArrayList<dtoContribute> getStatusRes(String user) throws SQLException {
        double balance = 0;
        int user_id = DAO.SelectUserID(user);
        ArrayList<dtoContribute> contribute = new ArrayList<>();
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_sel = con.prepareStatement("select user_id ,item_id from contribution where friend_id = ? and remaining = ?");
        ps_sel.setInt(1,user_id);
        ps_sel.setDouble(2,0);
        ResultSet resultset = ps_sel.executeQuery();
        while (resultset.next()) {
            int id = resultset.getInt(2);
            String item_name = DAO.SelectItemName(id);
            String user_name = DAO.SelectUserName(resultset.getInt(1));
            contribute.add(new dtoContribute(item_name,user_name));
        }
        ps_sel.close();
        con.close();
        return contribute;
    }
    public static int InsertItems(dtoItem item) throws SQLException {
        int result=0;
        Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        PreparedStatement ps_ins2 = con.prepareStatement("insert into item(name,price,describtion,category,barcode) VALUES (?,?,?,?,?)");
        ps_ins2.setString(1,item.getName());
        ps_ins2.setDouble(2,item.getPrice());
        ps_ins2.setString(3,item.getDescription());
        ps_ins2.setString(4,item.getCategory());
        ps_ins2.setInt(5,item.getItembarcode());
        result = ps_ins2.executeUpdate();
        ps_ins2.close();
        con.close();
        return result;
    }
    
    
}
