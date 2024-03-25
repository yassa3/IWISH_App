/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.HomePageController;
import Controllers.LoginController;
import DB.DtoUser;
import Scenes.AdminBase;
import Scenes.FriendWLBase;
import Scenes.HomePageBase;
import Scenes.JumiaBase;
import Scenes.RegisterBase;
import Scenes.friendsBase;
import Scenes.loginBase;
import Scenes.passwordresetBase;
import Scenes.profileBase;
import Scenes.sceneAboutBase;
import Scenes.sceneNewPasswdBase;
import Scenes.securitySceneBase;
import Scenes.walletRegistrationBase;
import Scenes.walletinformationBase;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Yassa Rashad
 */
public class SceneController {


    private Stage stage;
    private Scene scene;
    private Parent root;
    public SceneController(Stage stage) {
        this.stage = stage;
    }
    public void switchToHomeScene(String userName, double balance) {
            HomePageBase root = new HomePageBase();
            // Pass user information to the Home scene controller
            HomePageController homePageController = new HomePageController(stage,root);
            homePageController.initData(userName, balance, root);

            Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
       
    }
    public void switchtosceneAdmin() throws IOException{
            AdminBase root = new AdminBase();
            AdminController admincontroller = new AdminController(stage, root);
            Scene scene = new Scene(root);
            
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
        
    }
    public void switchtoscenelogin() throws IOException{
            loginBase root = new loginBase();
            LoginController loginController = new LoginController(stage, root);
            Scene scene = new Scene(root);
            
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
        
    }
    public void switchtosceneregister() throws IOException{
            RegisterBase root = new RegisterBase();
            RegisterController registerController = new RegisterController(stage, root);
            Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
        
    }
    public void switchtoscenesecurity() throws IOException{
            securitySceneBase root = new securitySceneBase();
            securitySceneController securityController = new securitySceneController(stage, root);
            Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
        
    }
    public void switchtoscenesecuritypasswd() throws IOException{
            sceneNewPasswdBase root = new sceneNewPasswdBase();
            sceneNewPasswdController newpassController = new sceneNewPasswdController(stage, root);
            Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
        
    }
    void switchtosceneprofile(DtoUser user) {
        profileBase root = new profileBase();
        profileController procontroller = new profileController(stage, root);
        root.setLastName(user.getLastName());
        root.setFirstName(user.getFirstName());
        root.setEmail(user.getEmail());
        root.setUserName(user.getUserName());
       
        Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
    }
    
    public void switchtoscenefriends() throws IOException{
            friendsBase root = new friendsBase();
            friendsController ffriendsController = new friendsController(stage, root);
            Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
    }
    public void switchtoscenesceneAbout() throws IOException{
            sceneAboutBase root = new sceneAboutBase();
            sceneAboutController AboutController = new sceneAboutController(stage, root);
            Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
        
    }
    
    public void switchtosceneFriendWL() throws IOException{
            FriendWLBase root = new FriendWLBase();
            FriendWLController FfriendWLController = new FriendWLController(stage, root);
            Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
        
    }      

    public void switchtoscenewalletRegistration() throws IOException{
            walletRegistrationBase root = new walletRegistrationBase();
            walletRegistrationController wwalletRegistrationController = new walletRegistrationController(stage, root);
            Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            } 
    }
    public void switchtoscenepasswordreset() throws IOException{
            passwordresetBase root = new passwordresetBase();
        passwordresetController  passwordreseController = new passwordresetController(stage, root);
            Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
        
    }
    public void switchToWalletInformation(){
        walletinformationBase root = new walletinformationBase();
        walletinformationController walletinfoController = new walletinformationController(stage,root);
        Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
        
    }
    public void switchToJumiaScene(){
        JumiaBase root = new JumiaBase();
        JumiaController jumiacontroller = new JumiaController(stage,root);
        Scene scene = new Scene(root);
            if (stage != null) {
                stage.setScene(scene);
                stage.show();
            } else {
                System.err.println("Error: Stage is not initialized.");
            }
        
    }

}