package GrandeEcra;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GeneralLibrary {
    public static void printFile(String pathFile) {
        try {
            File file = new File(pathFile);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.print("O respetivo ficheiro não foi encontrado.");
        }
    }

    public static void exit() {
        String pathFile = "ficheiros/txt/GrandeEcra_Copyright.txt";
        printFile(pathFile);
    }
}
