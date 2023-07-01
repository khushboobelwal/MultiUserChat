package com.selflearning.chatapplication.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.selflearning.chatapplication.utils.ConfigReader;

public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	ClientWorker worker;
	JTextArea textArea;
public Client(JTextArea textArea) throws UnknownHostException, IOException {
	int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
	socket=new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
	out=socket.getOutputStream();
	in=socket.getInputStream();
	this.textArea=textArea;
	readMessages();
	/*System.out.println("Client is Active..");
	System.out.println("Enter the message to be sent to the server..");
	Scanner scanner =new Scanner(System.in);
	String message=scanner.nextLine();
	OutputStream out =socket.getOutputStream(); //Write bytes on network
	out.write(message.getBytes());//accept only bytes no string
	System.out.println("Message sent to the server");
	scanner.close();
	out.close();
	socket.close();*/
	
}
public void sendMessage(String message) throws IOException{
	message=message+"\n";
	out.write(message.getBytes());
	
}
public void readMessages() {
	worker=new ClientWorker(in,textArea);
	worker.start();
}
	/*public static void main(String[] args) throws UnknownHostException, IOException {
		Client client =new Client();
		// TODO Auto-generated method stub

	}*/

}
