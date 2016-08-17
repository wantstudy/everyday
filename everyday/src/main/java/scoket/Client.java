package scoket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 8080);
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		printWriter.println("hello ,i'm client");
		printWriter.flush();
		System.out.println(reader.readLine());
		socket.close();

	}
}
