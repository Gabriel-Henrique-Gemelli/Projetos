package File;

import java.io.File;
import java.util.Scanner;

public class Manipulando_pastas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();

		File path = new File(strPath);

		if (!path.exists() || !path.isDirectory()) {
			System.err.println("Erro: o caminho especificado nao foi encontrado");
			sc.close();
			return;
		}

		File[] folders = path.listFiles(File::isDirectory);

		System.out.println("FOLDERS: ");
		if (folders == null || folders.length == 0) {
			System.out.println("Nao existem pastas neste diretorio");
		}
		else {
			for (File folder : folders) {

				System.out.println(folder);
			}
		}

		
		File[] files = path.listFiles(File::isFile); // esses aqui lista os arquivos
		System.out.println("FILES: ");
		if (files == null || files.length == 0) {
			System.out.println("Nao existem arquivos neste diretorio");
		}
		else {
			for (File file : files) {

				System.out.println(file);
			}
	
		}
		
		boolean sucess = new File(strPath + "//Lanche criado com sucesso").mkdir(); // esse comando cria um apasta
		System.out.println("Diretorio criado com sucesso: " + sucess);
				sc.close();

	}

}
