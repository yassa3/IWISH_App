/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author Resal
 */
public class DtoUser {
    private int userId;
    private String firstName;
    private String lastName ;
    private String userName ;
    private String email;
    private String securityAns;
    private double balance ;
    private String passwd ;

    public DtoUser( String userName, String firstName, String lastName, String securityAns, String email, String passwd, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.securityAns = securityAns;
        this.balance = balance;
        this.passwd = passwd;
    }
    public DtoUser( String userName, String firstName, String lastName, String securityAns, String email, String passwd) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.securityAns = securityAns;
        this.passwd = passwd;
    }
    public DtoUser(String userName ,double balance){
        this.userName=userName;
        this.balance=balance;
    }
    public DtoUser(String userName ,String passwd){
        this.userName=userName;
        this.passwd=passwd;
    }
    public DtoUser(String userName ,String email,String Fname){
        this.userName=userName;
        this.email=email;
        this.firstName = Fname;
    }
    public DtoUser(){
        super();
    }
    public DtoUser(String userName, String firstName, String lastName, String securityAns, String email, double balance){
        this.userName=userName;
        this.firstName=firstName;
        this.lastName=lastName;
        this.securityAns=securityAns;
        this.email=email;
        this.balance=balance;
    }

     public int getuserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurityAns() {
        return securityAns;
    }

    public void setSecurityAns(String securityAns) {
        this.securityAns = securityAns;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String toString(){
        return"DTOUser{"+
                "userName is "+userName+'\'' +
                "firstName is"+firstName+'\''+
                "lastName is"+lastName+'\''+
                "Security Ans is"+securityAns+'\''+
                "email is "+email+'\''+
                "password user is "+passwd+'\''+
                "user balance is "+balance;           
    }
    
}
