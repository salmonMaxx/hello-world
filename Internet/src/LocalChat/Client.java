package LocalChat;

import java.io.IOException;
import java.net.*;

public class Client {
    Socket socket;
    
    Client(InetAddress IP, int theSocket) throws IOException{
        socket = new Socket(IP, theSocket);
        ChatParticipant Golf = new ChatParticipant(socket);
        //skapa en participant
    }
        
        public Socket getSocket(){
            return socket;
        }
}
