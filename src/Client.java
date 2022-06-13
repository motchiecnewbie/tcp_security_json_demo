import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.crypto.Cipher;

import org.json.simple.JSONObject;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 2022);
			Scanner scanner = new Scanner(System.in);
			
			AESDemo aes = new AESDemo("helloworld");
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			while(true) {
				String message = scanner.nextLine();
				JSONObject jo = new JSONObject();
				
				jo.put("message", aes.encrypt(message));
				jo.put("key", aes.getKey());
				
				dos.writeUTF(jo.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
