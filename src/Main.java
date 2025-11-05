import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import C_M_Lanches.ItemCardapio;
import C_M_Lanches.Bebidas.*; // Importa Suco, Suco_Laranja, etc.
import C_M_Lanches.lanches.*; // Importa Pastel, Pastel_Carne, etc.
import C_M_Lanches.lanches.Extras.*; // Importa Catupiri, etc.

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<ItemCardapio> pedido = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("========= BEM-VINDO À LANCHONETE =========");

        while (true) {
            mostrarMenuPrincipal();
            int escolha = lerOpcao();

            switch (escolha) {
                case 1:
                    montarPastel();
                    break;
                case 2:
                    adicionarBebida();
                    break;
                case 3:
                    finalizarPedido();
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Montar Pastel");
        System.out.println("2. Adicionar Bebida");
        System.out.println("3. Finalizar Pedido");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Guia o usuário pela montagem de um pastel com extras (Decorator)
     */
    private static void montarPastel() {
        System.out.println("\n--- Escolha o Sabor do Pastel ---");
        System.out.println("1. Carne");
        System.out.println("2. Frango");
        System.out.println("3. Queijo");
        System.out.println("4. Calabresa");
        System.out.print("Escolha o sabor: ");
        int escolhaPastel = lerOpcao();

        Pastel pastelBase = null;
        switch (escolhaPastel) {
            case 1: pastelBase = new Pastel_Carne(); break;
            case 2: pastelBase = new Pastel_Frango(); break;
            case 3: pastelBase = new Pastel_Queijo(); break;
            case 4: pastelBase = new Pastel_Calabresa(); break;
            default:
                System.out.println("Sabor inválido.");
                return;
        }

        while (true) {
            System.out.println("\n--- Adicionar Extra? ---");
            System.out.println("Item atual: " + pastelBase.getDescricaoFormatada());
            System.out.println("1. Catupiri");
            System.out.println("2. Cheddar");
            System.out.println("3. Milho");
            // (adicione os outros extras)
            System.out.println("0. NÃO (Concluir este pastel)");
            System.out.print("Escolha o extra: ");
            int escolhaExtra = lerOpcao();

            if (escolhaExtra == 0) {
                break;
            }

            switch (escolhaExtra) {
                case 1: pastelBase = new Catupiri(pastelBase); break;
                case 2: pastelBase = new Cheddar(pastelBase); break;
                case 3: pastelBase = new Milho(pastelBase); break;
                // (adicione os outros extras)
                default:
                    System.out.println("Extra inválido.");
            }
        }

        pedido.add(pastelBase);
        System.out.println(">>> Pastel (" + pastelBase.getDescricao() + ") adicionado ao pedido! <<<");
    }

    /**
     * CORREÇÃO 3: Adiciona uma bebida usando suas classes concretas
     */
    private static void adicionarBebida() {
        System.out.println("\n--- Escolha a Bebida ---");
        System.out.println("1. Suco de Laranja");
        System.out.println("2. Suco de Uva");
        System.out.println("3. Suco de Limão");
        System.out.println("4. Suco de Maracujá");
        System.out.print("Escolha a bebida: ");
        int escolhaBebida = lerOpcao();

        ItemCardapio bebida = null; // Correto, usamos a interface
        switch (escolhaBebida) {
            // Agora usamos suas classes concretas!
            case 1: bebida = new Suco_Laranja(); break;
            case 2: bebida = new Suco_Uva(); break;
            case 3: bebida = new Suco_Limao(); break;
            case 4: bebida = new Suco_Maracuja(); break;
            default:
                System.out.println("Bebida inválida.");
                return;
        }

        pedido.add(bebida);
        System.out.println(">>> " + bebida.getDescricao() + " adicionado ao pedido! <<<");
    }

    /**
     * Mostra o resumo do pedido e o custo total
     */
    private static void finalizarPedido() {
        if (pedido.isEmpty()) {
            System.out.println("\nSeu carrinho está vazio.");
            return;
        }

        System.out.println("\n\n========= SEU PEDIDO FINAL ==========");
        double total = 0.0;

        for (ItemCardapio item : pedido) {
            System.out.println(item.getDescricaoFormatada());
            total += item.cost();
        }

        System.out.println("-------------------------------------");
        System.out.printf("TOTAL DO PEDIDO: R$%.2f\n", total);
        System.out.println("=====================================");
    }
}