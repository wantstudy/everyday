package scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	
	private Socket socket;
	
	public Server(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			String data = bufferedReader.readLine();
			printWriter.println("i'm server : " + data);
			printWriter.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		while(true){
			new Server((new ServerSocket(8080)).accept()).start();
		}
	}

}
