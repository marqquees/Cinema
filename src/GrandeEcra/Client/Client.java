package GrandeEcra.Client;

import GrandeEcra.GeneralLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
    public static void menuCustomer() {
        try {
            Scanner input = new Scanner(System.in);
            int option;

            do {
                System.out.println("\nMENU DO CLIENTE");
                System.out.println("\n1. Novo registo.");
                System.out.println("2. Consultar cartaz cinematográfico.");
                System.out.println("3. Pesquisar filmes.");
                System.out.println("4. Visualizar mapa de uma sala.");
                System.out.println("5. Reservar bilhetes.");
                System.out.println("6. Recomendar filmes.");
                System.out.println("7. Quiz cinematográfico.");
                System.out.println("0. Voltar.");

                System.out.print("\nOpção: ");
                option = input.nextInt();

                switch (option) {
                    case 1:
                        newCustomer();
                        break;
                    case 2:
                        viewMoviePosters();
                        break;
                    case 3:
                        searchMovie();
                        break;
                    case 4:
                        viewRoomMap();
                        break;
                    default:
                        break;
                }
            } while (option != 0);
        } catch (InputMismatchException ex) {
            System.out.println("O tipo de dados inserido é inválido! Digite um número inteiro.");
        }
    }

    /**
     * A função simular o registo de um novo cliente. Solicita o nome, contacto telefónico e o endereço eletrónico.
     * Apresentar a mensagem “Cliente inserido com sucesso” e os dados introduzidos.
     */
    public static void newCustomer() {
        Scanner input = new Scanner(System.in);
        String name, phone, e_mail;

        System.out.println("\nNOVO CLIENTE");
        System.out.print("\nNome: ");
        name = input.next();

        System.out.print("Contacto telefónico: ");
        phone = input.next();

        System.out.print("E-mail: ");
        e_mail = input.next();

        System.out.println("\n" + name + " | " + phone + " | " + e_mail);
        System.out.println("Cliente inserido com sucesso!");
    }

    /**
     * A função imprime integralmente o conteúdo do Cartaz.
     */
    public static void viewMoviePosters() {
        GeneralLibrary.printFile("ficheiros/txt/GrandeEcra_Cartaz.txt");
    }

    /**
     * Esta função solicita um género cinematográfico e lista os filmes correspondentes, apresentando o título,
     * o realizador, o ano, a duração, a idade mínima e a classificação.
     * A pesquisa ignora a diferença entre maiúscula e minúscula.
     * Se não for encontrado o filme, informar ao utilizador.
     */
    public static void searchMovie() {
        try {
            File file = new File("ficheiros/csv/GrandeEcra_Filmes.csv");
            Scanner scanner = new Scanner(file);
            Scanner input = new Scanner(System.in);
            String nameMovie;
            boolean filmFound = false;

            System.out.println("\nCONSULTAR CARTAZ CINEMATOGRÁFICO");
            System.out.print("\nNome do filme: ");
            nameMovie = input.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] itensLine = line.split(";");

                if (nameMovie.equalsIgnoreCase(itensLine[1])) {
                    System.out.println("\nTítulo: " + itensLine[1]);
                    System.out.println("Realizador: " + itensLine[3]);
                    System.out.println("Ano: " + itensLine[4]);
                    System.out.println("Duração: " + itensLine[5]);
                    System.out.println("Idade mínima: " + itensLine[6]);
                    System.out.println("Classificação: " + itensLine[7]);

                    filmFound = true;
                    scanner.close();
                }
            }
            if (!filmFound)
                System.out.println("O filme " + nameMovie + " não foi encontrado.");

        } catch (FileNotFoundException ex) {
            System.out.println("O respetivo ficheiro não foi encontrado.");
        }
    }

    /**
     * Permitir selecionar uma das três salas. Lê o respetivo CSV e apresentar o mapa.
     */
    public static void viewRoomMap() {
        Scanner input = new Scanner(System.in);
        int option;

        try {
            do {
                System.out.println("\nVISUALIZAR O MAPA DE UMA SALA");

                System.out.println("\n1. Sala Mar");
                System.out.println("2. Sala Terra");
                System.out.println("3. Sala Sol");

                System.out.print("\nSelecione uma sala: ");
                option = input.nextInt();

                switch (option) {
                    case 1:
                        LibraryClient.room("ficheiros/csv/Sala_Mar.csv", "MAR");
                        break;
                    case 2:
                        LibraryClient.room("ficheiros/csv/Sala_Terra.csv", "TERRA");
                        break;
                    case 3:
                        LibraryClient.room("ficheiros/csv/Sala_Sol.csv", "SOL");
                        break;
                    default:
                        System.out.println("Opção inválida. Digite um número inteiro entre 1 e 3.");
                        break;
                }
            } while (option != 1 && option != 2 && option != 3);
        } catch (InputMismatchException ex) {
            System.out.println("O tipo de dados inserido é inválido! Digite um número inteiro.");
        }
    }
}
