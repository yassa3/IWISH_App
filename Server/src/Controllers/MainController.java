/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Scenes.ServerSceneBase;

/**
 *
 * @author yousef saber
 */
public class MainController extends Thread {
    
    public static void main(String[] args) {
        Thread serverThread = new Thread(() -> {
            MainThread mainThread = new MainThread();
        });

        Thread javafxThread = new Thread(() -> {
            javafx.application.Application.launch(Server.class, args);
        });

        serverThread.start();
        javafxThread.start();

        try {
            serverThread.join();
            javafxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}