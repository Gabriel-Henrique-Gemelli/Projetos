package File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderr {
	// dessa maneira o codigo fica mais enchuto e mais facil de leitura

	public static void main(String[] args) {
		String path = "C://temp//Lanche.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while (line!= null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: "+ e.getMessage());
		}

	}

}
