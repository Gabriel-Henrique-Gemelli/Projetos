package File;

import java.io.*;
import java.util.Scanner;

public class ExCorrigidoPeloGpt {

    public static void main(String[] args) {
        String path = "C:\\Users\\gabif\\OneDrive\\Documentos\\GitHub\\Projetos\\ws-Eclipse\\Gabizera\\src\\File\\All.csv";
        File csvFile = new File(path);
        File outputDir = new File(csvFile.getParent() + "\\out");

        if (!outputDir.exists()) {
            boolean success = outputDir.mkdir();
            System.out.println("Sucesso ao criar pasta: " + success);
        }

        File csvFile2 = new File(outputDir, "all.csv");

        // Escrever no novo arquivo
        try (Scanner scanner = new Scanner(csvFile);
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile2, true))) {

            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(",");
                if (lines.length >= 3) {
                    String col1 = lines[0];
                    try {
                        int number1 = Integer.parseInt(lines[1]);
                        int number2 = Integer.parseInt(lines[2]);
                        int number3 = number1 * number2;
                        bw.write(col1 + "," + number3);
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

        // Aguarda um pequeno tempo antes de ler o arquivo para garantir que ele foi fechado corretamente
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Ler o novo arquivo
        System.out.println("Novo arquivo gerado:");
        try (Scanner sc = new Scanner(csvFile2)) {
            while (sc.hasNextLine()) {
                String[] lines = sc.nextLine().split(",");
                if (lines.length >= 2) {
                    System.out.println(lines[0] + " - " + lines[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o novo arquivo: " + e.getMessage());
        }
    }
}
