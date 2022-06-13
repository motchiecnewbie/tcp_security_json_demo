import org.json.simple.JSONObject;

public class JSON {
	public static void main(String[] args) {
		JSONObject jo = new JSONObject();
		jo.put("username", "ncuy0110");
		jo.put("password", "hello");
		
		System.out.println(jo);
		System.out.println(jo.get("username"));
	}
}