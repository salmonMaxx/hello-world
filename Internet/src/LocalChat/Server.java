package LocalChat;

import java.io.*;
import java.net.*;

public class Server {
    private final ServerSocket server;
    private final Socket theSocket;
    
    Server(int portNumber) throws IOException{
        server = new ServerSocket(portNumber);
        theSocket = serverConnect();
        ChatParticipant Rolf = new ChatParticipant(theSocket);
    }
        public Socket serverConnect() throws IOException{
            Socket serverSocket = server.accept();
            if(serverSocket.isConnected()){
                System.out.println("Server is connected!");
            }
        return serverSocket;
        }
        
        public Socket getServerSocket(){
            return theSocket;
        }
}
