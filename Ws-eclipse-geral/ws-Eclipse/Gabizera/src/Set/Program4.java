package Set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Set.entities.LogEntry;

public class Program4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter file full path");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Set<LogEntry> set = new HashSet<>();
			
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(" ");
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				set.add(new LogEntry(username, moment));
				
				line = br.readLine();
			}
			System.out.println("Total users: " + set.size());
			
		} catch (Exception e) {
			System.out.println("Deu pau: " + e.getMessage());
		}
		
		sc.close();

	}

}
