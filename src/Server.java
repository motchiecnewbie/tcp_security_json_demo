import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(2022);
			Socket socket = ss.accept();
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			while (true) {
				// receive message from client
				String receivedMessage = dis.readUTF();
				System.out.println(receivedMessage);
				
				// parse json string to json object
				JSONParser jp = new JSONParser();
				JSONObject jo = (JSONObject) jp.parse(receivedMessage);
				
				// create aes object with key from client
				AESDemo aes = new AESDemo(jo.get("key").toString());
				// decrypt and print message
				System.out.println(aes.decrypt(jo.get("message").toString()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
