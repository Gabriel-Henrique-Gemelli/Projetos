package Map;

import java.util.Map;
import java.util.TreeMap;

public class Program {

	public static void main(String[] args) {
		
		Map<String,String> cookies = new TreeMap<>();
		
		cookies.put("UserName", "Maria");
		cookies.put("Email", "Maria@gmail");
		cookies.put("Phone", "123456789");
		
		
		System.out.println("ALL COOKIES: ");
		for(String key : cookies.keySet()) {
			System.out.println(key + ": " + cookies.get(key));
		}
	}

}
