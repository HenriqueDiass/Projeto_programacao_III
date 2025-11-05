import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import C_M_Lanches.Categoria_Cardapio;
import C_M_Lanches.ItemCardapio;
import C_M_Lanches.Bebidas.*;
import C_M_Lanches.lanches.*;
import C_M_Lanches.lanches.Extras.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<ItemCardapio> pedido = new ArrayList<>(); // O "Carrinho de Compras"
    private static ItemCardapio cardapioCompleto; // O "Menu Impresso" (Composite)

    public static void main(String[] args) {
        System.out.println("========= BEM-VINDO À LANCHONETE =========");

        // Monta o cardápio (Composite) para exibição
        montarCardapioParaExibicao();

        while (true) {
            mostrarMenuPrincipal(); // Menu principal atualizado
            int escolha = lerOpcao();

            switch (escolha) {
                case 1:
                    montarPastel(); // Usa Decorator
                    break;
                case 2:
                    adicionarBebida(); // Cria Folhas (Leaf)
                    break;
                case 3:
                    // Nova opção 3 (antiga 4)
                    mostrarCardapioCompleto(); // Usa Composite
                    break;
                case 0:
                    // MUDANÇA: Finalizar o pedido agora acontece aqui
                    finalizarPedido(); // Mostra o pedido e o total

                    System.out.println("\nObrigado, volte sempre!");
                    scanner.close();
                    return; // Termina o programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // ----- MENU PRINCIPAL ATUALIZADO -----
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menu Principal ---");
        System.out.println("1. Montar Pastel");
        System.out.println("2. Adicionar Bebida");
        System.out.println("3. Mostrar Cardápio Completo"); // <-- Antiga opção 4
        System.out.println("0. Finalizar Pedido e Sair"); // <-- Opção de sair agora finaliza
        System.out.print("Escolha uma opção: ");
    }

    // ----- MÉTODOS DO COMPOSITE (INTOCADOS) -----

    private static void montarCardapioParaExibicao() {
        // Categorias (Compostos)
        Categoria_Cardapio categoriaPasteis = new Categoria_Cardapio("PASTÉIS");
        Categoria_Cardapio categoriaBebidas = new Categoria_Cardapio("BEBIDAS");

        // Adiciona Itens (Folhas)
        categoriaPasteis.adicionarItem(new Pastel_Carne());
        categoriaPasteis.adicionarItem(new Pastel_Frango());
        categoriaPasteis.adicionarItem(new Pastel_Queijo());
        categoriaPasteis.adicionarItem(new Pastel_Calabresa());

        categoriaBebidas.adicionarItem(new Suco_Laranja());
        categoriaBebidas.adicionarItem(new Suco_Uva());
        categoriaBebidas.adicionarItem(new Suco_Limao());
        categoriaBebidas.adicionarItem(new Suco_Maracuja());

        // Raiz (Composto de Compostos)
        cardapioCompleto = new Categoria_Cardapio("CARDÁPIO DA LANCHONETE");
        ((Categoria_Cardapio) cardapioCompleto).adicionarItem(categoriaPasteis);
        ((Categoria_Cardapio) cardapioCompleto).adicionarItem(categoriaBebidas);
    }

    private static void mostrarCardapioCompleto() {
        System.out.println("\n\n========================================");
        System.out.println(cardapioCompleto.getDescricaoFormatada());
        System.out.println("\n========================================");
        System.out.println("\n(Use as opções 1 e 2 para montar seu pedido.)");
    }



    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

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
                default:
                    System.out.println("Extra inválido.");
            }
        }

        pedido.add(pastelBase); // Adiciona ao carrinho
        System.out.println(">>> Pastel (" + pastelBase.getDescricao() + ") adicionado ao pedido! <<<");
    }

    private static void adicionarBebida() {
        System.out.println("\n--- Escolha a Bebida ---");
        System.out.println("1. Suco de Laranja");
        System.out.println("2. Suco de Uva");
        System.out.println("3. Suco de Limão");
        System.out.println("4. Suco de Maracujá");
        System.out.print("Escolha a bebida: ");
        int escolhaBebida = lerOpcao();

        ItemCardapio bebida = null;
        switch (escolhaBebida) {
            case 1: bebida = new Suco_Laranja(); break;
            case 2: bebida = new Suco_Uva(); break;
            case 3: bebida = new Suco_Limao(); break;
            case 4: bebida = new Suco_Maracuja(); break;
            default:
                System.out.println("Bebida inválida.");
                return;
        }

        pedido.add(bebida); // Adiciona ao carrinho
        System.out.println(">>> " + bebida.getDescricao() + " adicionado ao pedido! <<<");
    }

    /**
     * Mostra o resumo do pedido e o custo total.
     * (Agora só é chamado ao Sair)
     */
    private static void finalizarPedido() {
        if (pedido.isEmpty()) {
            System.out.println("\nVocê não pediu nada.");
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