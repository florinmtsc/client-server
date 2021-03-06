package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CServer {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java Server <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
            String inputLine, outputLine;
            System.out.println("Server opened");

            // initiate conversation with client
//            CsProtocol csp = new CsProtocol();

            while ((inputLine = in.readLine()) != null) {
                out.println("Client said: " + inputLine + " and this is the server responding");
                System.out.println("Client: " + inputLine);
            }

//            while ((inputLine = in.readLine()) != null) {
//                outputLine = csp.processInput(inputLine);
//                out.println(outputLine);
//                if (outputLine.equals("Bye."))
//                    break;
//            }

        }
    }

}