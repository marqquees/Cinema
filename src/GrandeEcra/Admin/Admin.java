package GrandeEcra.Admin;

import GrandeEcra.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {
    public static void menuAdmin() {
        Scanner input = new Scanner(System.in);
        int opcao;

        if (checkAdministrator()) {
            do {
                System.out.println("\nMENU DO ADMINISTRADOR");
                System.out.println("\n1. Consultar ficheiros.");
                System.out.println("2. Estatísticas gerais de vendas.");
                System.out.println("3. Receita por sala.");
                System.out.println("4. Receita por filme.");
                System.out.println("5. Top 3 filmes com maior receita.");
                System.out.println("6. Restaurar a lotação de uma sala.");
                System.out.println("0. Voltar.");

                System.out.print("\nOpção: ");
                opcao = input.nextInt();
            } while (opcao != 0);
        } else {
            System.out.println("Senha inválida!");
            Main.MainMenu();
        }
    }

    public static boolean checkAdministrator() {
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
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro não encontrado.");
        } catch (InputMismatchException e) {
            System.out.println("O tipo de dados inserido é inválido! Digite apenas caracteres.");
        }
        return false;
    }
}
