package Try;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Finaly {

	public static void main(String[] args) {
		File file = new File("C:\\Temp//Lanche.txtt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.err.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Erro:" + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
				System.out.println("End of program ");
			}
		}
	}

}
