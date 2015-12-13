package clientserverchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CClient {

    String hostName;
    int portNumber;
    String response;
    Socket echoSocket;
    PrintWriter out;
    BufferedReader in;
    
    public CClient(String hostName, String portNumber) throws IOException {
        this.hostName = hostName;
        this.portNumber = Integer.parseInt(portNumber);
        
        this.echoSocket = new Socket(this.hostName, this.portNumber);
        this.out = new PrintWriter(echoSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
    }
    
    public String connect(String text) throws IOException {

        if (text != "") {
            out.println(text);
            this.response = in.readLine();
        }

        return "";
    };
    
    public String getResponse() {
        String response = this.response;
        this.response = "";
        return response;
    }
    
    public void closeConnection() throws IOException
    {
    	this.echoSocket.close();
    	this.out.close();
    	this.in.close();
    }
};
