package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import classes.User;
import client.Home;

public class ClientListener implements Runnable {
	private Socket socket;
	private Server server;
	private boolean running;
	
	public ClientListener(Socket socket, Server server) throws IOException {
		this.socket = socket;
		this.server = server;
		this.running = false;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public void run() {
		 running = true;
		 JSONObject request;
		 JSONObject response;
		 String operation;
		 while(running) {
			 try {
				request = Home.utils.receiveMessage();
				operation = request.get("operacao").toString();
				System.out.println("[CLIENTE->SERVIDOR]: " + request.toJSONString());
				
				switch(operation) {
					case "logout": {
						response = User.logout(request);
						Home.utils.sendMessage(response);
						System.out.println("[SERVIDOR->CLIENTE]: " + response.toJSONString());
						break;
					}
				}
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
			}
		 }
	}
}