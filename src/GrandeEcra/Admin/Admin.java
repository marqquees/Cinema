package GrandeEcra.Admin;

import GrandeEcra.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {
    public static void menuAdmin() {

        try {
            Scanner input = new Scanner(System.in);
            int option;

            if (LibraryAdmin.isAdministrator()) {
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
                    option = input.nextInt();

                    switch (option) {
                        case 1:
                            LibraryAdmin.consultFile();
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Opção inválida! Digite novamente.");
                            break;
                    }
                } while (option != 0);
            } else {
                System.out.println("Senha inválida!");
                Main.MainMenu();
            }
        } catch (InputMismatchException ex) {
            System.out.println("O tipo de dados inserido é inválido! Digite um número inteiro.");
        }
    }
}
