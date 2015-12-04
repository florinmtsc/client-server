package clientserverchat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CClient {

    String hostName;
    int portNumber;
    boolean close = false;
    String response;
    
    public CClient(String hostName, String portNumber) {
        this.hostName = hostName;
        this.portNumber = Integer.parseInt(portNumber);
    }
    
    public String connect(String text) {
        try (
            Socket echoSocket = new Socket(this.hostName, this.portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        ) {
            if (text != "") {
                out.println(text);
                this.response = in.readLine();
            }
        } catch(Exception ex) {
            System.out.println("client error");
        }
        return "";
    };
    
    public String getResponse() {
        String response = this.response;
        this.response = "";
        return response;
    }
};
