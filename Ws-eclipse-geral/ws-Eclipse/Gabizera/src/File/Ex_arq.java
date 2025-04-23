package File;

import java.io.*;
import java.util.Scanner;

public class Ex_arq {

    public static void main(String[] args) {
        String path = "C:\\Users\\gabif\\OneDrive\\Documentos\\GitHub\\Projetos\\ws-Eclipse\\Gabizera\\src\\File\\All.csv";
        File csvFile = new File(path);
        File outputDir = new File(csvFile.getParent() + "\\out");

        if (!outputDir.exists()) {
            boolean success = outputDir.mkdir();
            System.out.println("Sucesso ao criar pasta: " + success);
        }

        File csvFile2 = new File(outputDir, "all.csv");

        // ✅ Escrever os dados no novo arquivo (e garantir que seja fechado)
        try (Scanner scanner = new Scanner(csvFile);
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile2))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] columns = line.split(",");

                if (columns.length >= 3) {
                    String col1 = columns[0];
                    try {
                        int number1 = Integer.parseInt(columns[1]);
                        int number2 = Integer.parseInt(columns[2]);
                        int result = number1 * number2;

                        bw.write(col1 + "," + result);
                        bw.newLine();
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao converter números: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
            return;
        }

        // ✅ Garantir que o arquivo foi fechado antes de tentar lê-lo
        esperarArquivoLiberar(csvFile2);

        // ✅ Ler o novo arquivo
        System.out.println("Novo arquivo gerado:");
        try (Scanner sc = new Scanner(csvFile2)) {
            while (sc.hasNextLine()) {
                String[] columns = sc.nextLine().split(",");
                if (columns.length >= 2) {
                    System.out.println(columns[0] + " - " + columns[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o novo arquivo: " + e.getMessage());
        }
    }

    // Função para esperar o arquivo ser liberado
    private static void esperarArquivoLiberar(File file) {
        int tentativas = 5;
        while (tentativas > 0) {
            if (file.renameTo(file)) {
                return; // O arquivo foi liberado
            }
            try {
                System.out.println("Aguardando o arquivo ser liberado...");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            tentativas--;
        }
    }
}
