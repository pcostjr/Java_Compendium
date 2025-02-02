
import java.io.*;
import java.net.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
     GUI SimpleChatClient 
      Enhanced FA17 by Dave Webber to display broadcast messages

**/

public class SimpleChatClientA
{
    JTextField outgoing;
    PrintWriter writer;
    Socket sock;
    
    BufferedReader reader;
    
	private JTextArea textArea;
	private JScrollPane scroll;
	
	private String username;
    
    public void go() {
    	
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        username = (String)JOptionPane.showInputDialog(frame, "Enter username: \n", "Enter Username", JOptionPane.QUESTION_MESSAGE);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sbw added
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        outgoing = new JTextField(28);
//        outgoing.setFont(new Font("monospaced", Font.PLAIN, 12));
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.add(BorderLayout.SOUTH, mainPanel);
        
        textArea = new JTextArea(25, 20);
		scroll = new JScrollPane(textArea, 
								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
	    textArea.setEditable(false);
	    
	    frame.add(scroll, BorderLayout.CENTER);
        
        setUpNetworking();
        frame.setSize(400, 500);
        frame.setVisible(true);
    }
    
    private void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(sock.getOutputStream());
            if(sock.isConnected())
            	System.out.println("Lol Gottem"); //prints out a message if we are confirmed connected to the chat server
            
            InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(isReader);           
            
            new Thread(new Runnable() {
            	public void run() {
                    String message;
                    try {
                        while ((message = reader.readLine()) != null) {
//                            System.out.println("client read: " + message);
                            println("> " + message);
                        }
                    } catch (Exception ex) { ex.printStackTrace(); }
                }
    		}).start();
            
            System.out.println("networking established");
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
	public void println(String text) {
		textArea.append(text + String.format("%n"));
		
		textArea.setCaretPosition(textArea.getDocument().getLength());	// auto-scroll
	}
    
    public class SendButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            try {
                writer.println(username + "> " + outgoing.getText());
                writer.flush();
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
    
    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }
}
