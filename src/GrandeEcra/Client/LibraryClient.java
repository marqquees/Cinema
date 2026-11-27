package GrandeEcra.Client;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryClient {
    /**
     * A função realiza a contagem do número de colunas de um ficheiro delimitado pelo separador.
     *
     * @param pathFile  caminho do ficheiro.
     * @param separator separador.
     */
    public static int columnTotal(String pathFile, String separator) {
        try {
            File file = new File(pathFile);
            Scanner scanner = new Scanner(file);

            String line = scanner.nextLine();
            String[] itemLine = line.split(separator);

            scanner.close();
            return itemLine.length;
        } catch (FileNotFoundException ex) {
            System.out.print("O respetivo ficheiro não foi encontrado.");
        }
        return 0;
    }

    /**
     * A função realiza a contagem do número de linhas de um ficheiro.
     *
     * @param pathFile caminho do ficheiro.
     */
    public static int rowTotal(String pathFile) {
        try {
            File file = new File(pathFile);
            Scanner scanner = new Scanner(file);
            int lineNumber = 0;

            while (scanner.hasNextLine()) {
                lineNumber++;
                scanner.nextLine();
            }
            scanner.close();
            return lineNumber;
        } catch (FileNotFoundException ex) {
            System.out.print("O respetivo ficheiro não foi encontrado.");
        }
        return 0;
    }

    /**
     * Esta função lê o respetivo CSV e apresentar o mapa,
     * identificando as filas por letras (A, B, C, …) e os lugares por números, a partir de 1.
     * Usar O para lugares disponíveis e X para lugares ocupados.
     * Apresentar ainda a lotação total, lugares livres, lugares ocupados e taxa de ocupação atual.
     *
     * @param pathFile caminho do ficheiro.
     * @param roomName nome da sala.
     */
    public static void room(String pathFile, String roomName) {
        try {
            File file = new File(pathFile);
            Scanner scanner = new Scanner(file);
            int rowTotal = rowTotal(pathFile);
            int columnTotal = columnTotal(pathFile, ";");

            int[][] matrixRoom = new int[rowTotal][columnTotal];
            int totalCapacity, availableSeats = 0, occupiedSeats = 0, lineFill = 0;
            float occupancyRate;

            System.out.println("\nSALA " + roomName);
            System.out.println("\n     ECRÃ        ");
            System.out.println("===================");

            // Imprime os números das colunas.
            System.out.print("  ");
            for (int column = 1; column <= columnTotal; column++)
                System.out.print(column + " ");
            System.out.println();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] itemsLine = line.split(";");

                for (int i = 0; i < itemsLine.length; i++)
                    matrixRoom[lineFill][i] = Integer.parseInt(itemsLine[i]);
                lineFill++;
            }

            for (int row = 0; row < rowTotal; row++) {
                // Imprime as letras das filas.
                char letterRow = (char) ('A' + row);
                System.out.print(letterRow + " ");

                for (int column = 0; column < columnTotal; column++) {
                    if (matrixRoom[row][column] == 0) {
                        System.out.print("0 ");
                        availableSeats++;
                    } else {
                        System.out.print("X ");
                        occupiedSeats++;
                    }
                }
                System.out.println();
            }
            System.out.println("===================");
            System.out.println("\nO: Disponível");
            System.out.println("X: Ocupado");

            totalCapacity = rowTotal * columnTotal;
            System.out.println("\nLotação total: " + totalCapacity + " lugares.");

            System.out.println("Lugares disponíveis: " + availableSeats);
            System.out.println("Lugares ocupados: " + occupiedSeats);

            occupancyRate = ((float) occupiedSeats / totalCapacity) * 100;
            System.out.printf("Taxa de Ocupação: %.2f%% %n", occupancyRate, "%");

            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Ficheiro não encontrado.");
        } catch (InputMismatchException ex) {
            System.out.println("O tipo de dados é inválido neste contexto!");
        }
    }
}