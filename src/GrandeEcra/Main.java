package GrandeEcra;

import GrandeEcra.Admin.Admin;
import GrandeEcra.Client.Client;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        Scanner input = new Scanner(System.in);
        int option;

        try {
            do {
                System.out.println("\nGRANDE ECRÃ");
                System.out.println("\nGrandes histórias merecem um grande ecrã.");
                System.out.println("\n1. ADMINISTRADOR");
                System.out.println("2. CLIENTE");
                System.out.println("0. SAIR");

                System.out.print("\nDigite uma opção: ");
                option = input.nextInt();

                switch (option) {
                    case 1:
                        Admin.menuAdmin();
                        break;
                    case 2:
                        Client.menuCustomer();
                        break;
                    case 0:
                        GeneralLibrary.exit();
                        break;
                    default:
                        System.out.print("Opção inválida! Tente novamente.");
                        break;
                }
            } while (option != 0);

        } catch (InputMismatchException ex) {
            System.out.println("O tipo de dados inserido é inválido! Digite um número inteiro.");
        }
    }
}