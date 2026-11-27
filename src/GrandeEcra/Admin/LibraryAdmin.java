package GrandeEcra.Admin;

import GrandeEcra.GeneralLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryAdmin {

    /**
     * Esta função verifica se o utilizador tem a permissão para acessar o menu de Administrador.
     *
     * @return true se os dados inseridos estiverem corretos e false se não estiverem.
     */
    public static boolean isAdministrator() {
        try {
            File file = new File("ficheiros/csv/GrandeEcra_AdminLogin.csv");
            Scanner scanner = new Scanner(file);
            Scanner input = new Scanner(System.in);
            String userName, password;

            System.out.println("\nADMINISTRADOR");

            System.out.print("\nNome do Usuário: ");
            userName = input.next();

            System.out.print("Senha: ");
            password = input.next();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] itensLine = line.split(";");

                if (userName.equals(itensLine[0]) && password.equals(itensLine[1])) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado.");
        }
        return false;
    }

    /**
     * Apresentar um submenu com os nove ficheiros do projeto e permite selecionar cada um deles.
     * Imprime o conteúdo integral do ficheiro escolhido, incluindo o cabeçalho quando existir.
     * O ficheiro de autenticação é exclusivamente de consulta ADMIN.
     */
    public static void consultFile() {

        try {
            Scanner input = new Scanner(System.in);
            int option;

            System.out.println("\nCONSULTAR FICHEIROS");
            System.out.println("\n1. GrandeEcra_AdminLogin.csv");
            System.out.println("2. GrandeEcra_Bilhetes.csv");
            System.out.println("3. GrandeEcra_Filmes.csv");
            System.out.println("4. GrandeEcra_Quiz.csv");
            System.out.println("5. Sala_Mar.csv");
            System.out.println("6. Sala_Sol.csv");
            System.out.println("7. Sala_Terra.csv");
            System.out.println("8. GrandeEcra_Cartaz.txt");
            System.out.println("9. GrandeEcra_Copyright.txt");

            System.out.print("\nOpção: ");
            option = input.nextInt();
            System.out.println();

            switch (option) {
                case 1:
                    GeneralLibrary.printFile("ficheiros/csv/GrandeEcra_AdminLogin.csv");
                    break;
                case 2:
                    GeneralLibrary.printFile("ficheiros/csv/GrandeEcra_Bilhetes.csv");
                    break;
                case 3:
                    GeneralLibrary.printFile("ficheiros/csv/GrandeEcra_Filmes.csv");
                    break;
                case 4:
                    GeneralLibrary.printFile("ficheiros/csv/GrandeEcra_Quiz.csv");
                    break;
                case 5:
                    GeneralLibrary.printFile("ficheiros/csv/Sala_Mar.csv");
                    break;
                case 6:
                    GeneralLibrary.printFile("ficheiros/csv/Sala_Sol.csv");
                    break;
                case 7:
                    GeneralLibrary.printFile("ficheiros/csv/Sala_Terra.csv");
                    break;
                case 8:
                    GeneralLibrary.printFile("ficheiros/txt/GrandeEcra_Cartaz.txt");
                    break;
                case 9:
                    GeneralLibrary.printFile("ficheiros/txt/GrandeEcra_Copyright.txt");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } catch (InputMismatchException ex) {
            System.out.println("O tipo de dados inserido é inválido! Digite um número inteiro.");
        }
    }
}
