/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverchat;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author flori
 */
public class ServerThread extends Thread {
    
    public CServer server;
    
    public void run() {
        this.server = new CServer("5555");
        this.server.connect();
        
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch(InterruptedException ex) {
//            Thread.currentThread().interrupt();
//        }
    }

    public static void main(String args[]) {
//        (new HelloThread()).start();
    }
    
}
