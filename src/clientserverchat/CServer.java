package clientserverchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CServer {
    
    public int portNumber;
    ServerSocket serverSocket;
    PrintWriter out;
    BufferedReader in;
    
    public CServer() {}
    
    public void connect(int portNumber) throws IOException {
        System.out.println("Server IN");

    	this.serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = serverSocket.accept();
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            out.println("Client said: " + inputLine + " and this is the server responding");
            System.out.println("Client: " + inputLine);
        }

        
        System.out.println("Server OUT");
    }
    
    public void closeConnection() throws IOException
    {
    	this.serverSocket.close();
    	this.out.close();
    	this.in.close();
    }
    
    public static void main(String[] args) throws IOException {
    	int portNumber = 8888;
        ServerSocket serverSocket;
        PrintWriter out;
        BufferedReader in;


        System.out.println("Server IN");

    	serverSocket = new ServerSocket(portNumber);
        Socket clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String inputLine, outputLine;

        while ((inputLine = in.readLine()) != null) {
            out.println("Client said: " + inputLine + " and this is the server responding");
            System.out.println("Client: " + inputLine);
        }

       
    }

}