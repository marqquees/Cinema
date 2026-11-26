import java.util.Scanner;

public class Menu {

    public static void menu() {
        Scanner input = new Scanner(System.in);
        int option;

        try {
            do {
                System.out.println("GRANDE ECRÃ");
                System.out.println("\nGrandes histórias merecem um grande ecrã.");
                System.out.println("\n1. ADMINISTRADOR");
                System.out.println("2. CLIENTE");
                System.out.println("0. SAIR");

                System.out.print("\nDigite uma opção: ");
                option = input.nextInt();

                switch (option) {
                    case 1:
                        clearScreen();
                        Admin.menu();
                        break;
                    case 2:
                        clearScreen();
                        Client.menu();
                        break;
                    default:
                        System.out.print("Opção inválida! Tente novamente.");
                        clearScreen();
                        break;
                }

            } while (option != 0);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * A função limpa os dados visíveis no ecrã.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
