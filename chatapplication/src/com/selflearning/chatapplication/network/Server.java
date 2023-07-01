package com.selflearning.chatapplication.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.selflearning.chatapplication.utils.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers =new ArrayList<>();//contains all the client socket
	public Server() throws IOException {
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket=new ServerSocket(PORT);
		System.out.println("Server starts and is waiting for the clients to join");
		handleClientRequest();
		
	}
	//Multiple client handshaking
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket=serverSocket.accept();
			//Per client per thread
			ServerWorker serverWorker=new ServerWorker(clientSocket,this);// creating a new worker//this represents current server
			workers.add(serverWorker);
			serverWorker.start();
		}
		
	}
	/*public Server() throws IOException {
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
	serverSocket=new ServerSocket(PORT);
	System.out.println("Server Started and waiting for the client connection...");
	Socket socket =serverSocket.accept();//Handshaking
	System.out.println("Client joins the server");
	InputStream in=socket.getInputStream();
	byte arr[]=in.readAllBytes();
	String str=new String(arr);//Bytes converted to string
	System.out.println("Message received from the client "+str);
	in.close();
	socket.close();
	}*/

	public static void main(String[] args) throws IOException {
		Server server=new Server();
		// TODO Auto-generated method stub

	}

}
