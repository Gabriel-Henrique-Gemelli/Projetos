package Map;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercisio {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> votos = new LinkedHashMap<>();

		System.out.println("Enter path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				String username = fields[0];
				int count = Integer.parseInt(fields[1]);
				if (votos.containsKey(username)) {
					int votesSoFar = votos.get(username);
					votos.put(username, count + votesSoFar);
				} else {
					votos.put(username, count);
				}

				line = br.readLine();
			}
			for (String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));

			}

		} catch (Exception e) {
			System.out.println("Deu merda: " + e.getMessage());
		}

		sc.close();

	}

}
