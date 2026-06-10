package ui;

import character.Player;
import character.Enemy;

import java.util.Scanner;

public class ConsoleUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void exibirSeparador() {
        System.out.println("\n──────────────────────────────────────");
    }

    public static void exibirStatus(Player player, Enemy enemy) {
        System.out.println("\nSTATUS:");
        player.getPersonagem().exibirStatus();
        enemy.getPersonagem().exibirStatus();
    }

    public static void exibirMensagemSuper(String nomeSuper) {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║  ★ SUPER ATIVADO: " + String.format("%-19s", nomeSuper) + "║");
        System.out.println("╚══════════════════════════════════════╝");
    }

    public static String lerResposta() {
        return scanner.nextLine().trim();
    }

    public static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    public static int lerOpcao(String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem);
            try {
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                if (opcao >= min && opcao <= max) return opcao;
                System.out.println("Digite um número entre " + min + " e " + max);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Tente novamente.");
            }
        }
    }
}
