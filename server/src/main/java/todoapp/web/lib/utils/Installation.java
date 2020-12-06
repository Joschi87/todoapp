package todoapp.web.lib.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Installation {
	
	private static Socket socket = new Socket();

	public static void main(String[] args) throws IOException {
		socket.connect(new InetSocketAddress("google.com", 80));
		String localIPAddress = socket.getLocalAddress().toString();
		
		File file = new File("ipAddress.json");
		if(file.createNewFile()) {
			FileWriter fw = new FileWriter(file);
			fw.write("{\"IPAddress\": \"" + localIPAddress + "\"}");
			fw.close();
		}else {
			System.out.println("File exists!");
		}
	}
}
