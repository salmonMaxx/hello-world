package LocalChat;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.*;

public class ChatParticipant {
    Socket socket;
    OutputStream outputStream;
    PrintWriter out;
    InputStream inputStream;
    Scanner in;
    JTextArea textArea;
    JTextField textField;
    
    ChatParticipant(Socket theSocket) throws IOException{
        socket = theSocket;
        createTextStreams(socket);
        createTheWindow();
        
    }
    
        public void createTextStreams(Socket socket) throws IOException{
            outputStream = socket.getOutputStream();
            out = new PrintWriter(outputStream);
            
            inputStream = socket.getInputStream();
            in = new Scanner(inputStream);
        }
    
        public void createTheWindow(){
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(400,400));

            JPanel primary = new JPanel();

            textArea = new JTextArea(5,20);
            textField = new JTextField(20);
            textField.addActionListener((ActionListener) textField);
            primary.setLayout(new BorderLayout());
            primary.add(textField, BorderLayout.SOUTH);
            primary.add(textArea, BorderLayout.CENTER);

            frame.add(primary);
            frame.pack();
            frame.setVisible(true);
        }
        
        public void actionPerformed(ActionEvent e) {
            textField = (JTextField) e.getSource();
            String text = textField.getText();
            textArea.append(text + "\n");
    }
        public void closeTheStreams() throws IOException{
            inputStream.close();
            outputStream.close();
        }
}