package File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterr {
	// esse codigo ele tambem cria o arquivo se nao for achado.
	//mas tbm se definir true no Filewriter ele nao cria apenas escreve embaixco, ou seja cria se nao tiver e se tiver apenas adiciona

	public static void main(String[] args) {

		String[] lines = new String[] { "Bom dia", "Boa tarde", "Boa noite" };
		String path = "C://temp//Lanche2.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))) {
			for (String line: lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			System.err.println("Erro ao arir o arquivo");
		}
	}

}
