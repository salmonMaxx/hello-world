/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalChat;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author maxxw
 */
public class LocalChat {
    public static void main(String[] args){
        try{
            //fixa booleanen!!!!!!!!!!!!!!!!!!!!! 
            boolean isServer = true;
            int port = 8574;
            if(isServer){
                Server server = new Server(port);
            }
            Client client = new Client((InetAddress.getLocalHost().getHostAddress()), port);
        }
        catch(IOException e){System.out.println(e.getMessage());}
    }
}