import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import C_M_Lanches.Categoria_Cardapio;
import C_M_Lanches.ItemCardapio_Interface;
import C_M_Lanches.Gerenciador_Vendas; // Nome com underscore
import C_M_Lanches.Bebidas.*;
import C_M_Lanches.lanches.*;
import C_M_Lanches.lanches.Extras.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<ItemCardapio_Interface> pedido = new ArrayList<>();
    private static ItemCardapio_Interface cardapioCompleto;

    public static void main(String[] args) {

        System.out.println("========= BEM-VINDO À LANCHONETE =========");
        montarCardapioParaExibicao();

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
                    mostrarCardapioCompleto();
                    break;
                case 4:
                    fecharContaCliente();
                    break;
                case 5:
                    Gerenciador_Vendas.getInstance().imprimirRelatorioGeral();
                    break;
                case 0:
                    System.out.println("\nEncerrando sistema... Até logo!");
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
        System.out.println("3. Mostrar Cardápio Completo");
        System.out.println("4. FECHAR CONTA (Finalizar Pedido Atual)");
        System.out.println("5. VER RELATÓRIO DE VENDAS (Histórico)");
        System.out.println("0. Sair do Programa");
        System.out.print("Escolha uma opção: ");
    }

    private static void montarCardapioParaExibicao() {

        Categoria_Cardapio categoriaPasteis = new Categoria_Cardapio("PASTÉIS");
        Categoria_Cardapio categoriaBebidas = new Categoria_Cardapio("BEBIDAS");

        categoriaPasteis.adicionarItem(new Pastel_Carne());
        categoriaPasteis.adicionarItem(new Pastel_Frango());
        categoriaPasteis.adicionarItem(new Pastel_Queijo());
        categoriaPasteis.adicionarItem(new Pastel_Calabresa());

        categoriaBebidas.adicionarItem(new Suco_Laranja());
        categoriaBebidas.adicionarItem(new Suco_Uva());
        categoriaBebidas.adicionarItem(new Suco_Limao());
        categoriaBebidas.adicionarItem(new Suco_Maracuja());

        cardapioCompleto = new Categoria_Cardapio("CARDÁPIO DA LANCHONETE");
        ((Categoria_Cardapio) cardapioCompleto).adicionarItem(categoriaPasteis);
        ((Categoria_Cardapio) cardapioCompleto).adicionarItem(categoriaBebidas);
    }

    private static void mostrarCardapioCompleto() {
        System.out.println("\n\n========================================");
        System.out.println(cardapioCompleto.getDescricaoFormatada());
        System.out.println("\n========================================");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void fecharContaCliente() {
        if (pedido.isEmpty()) {
            System.out.println("\nA mesa está vazia. Adicione itens antes de fechar a conta.");
            return;
        }

        StringBuilder recibo = new StringBuilder();
        double total = 0.0;

        recibo.append("\n========= CUPOM FISCAL ==========\n");
        for (ItemCardapio_Interface item : pedido) {
            recibo.append(item.getDescricaoFormatada()).append("\n");
            total += item.cost();
        }
        recibo.append("----------------------------------\n");
        recibo.append(String.format("TOTAL A PAGAR: R$%.2f\n", total));
        recibo.append("==================================\n");

        String textoFinal = recibo.toString();
        System.out.println(textoFinal);


        Gerenciador_Vendas.getInstance().salvarPedido(textoFinal);
        System.out.println(">> Venda registrada no sistema com sucesso! <<");
        pedido.clear();
        System.out.println("\nPronto para o próximo atendimento...");
    }

    private static void montarPastel() {
        System.out.println("\n--- Escolha o Sabor do Pastel ---");
        System.out.println("1. Carne");
        System.out.println("2. Frango");
        System.out.println("3. Queijo");
        System.out.println("4. Calabresa");
        System.out.print("Escolha o sabor: ");
        int escolhaPastel = lerOpcao();


        Pastel_Abstrato pastelBase = Pastel_Factory.criarPastel(escolhaPastel);

        if (pastelBase == null) {
            System.out.println("Sabor de pastel inválido.");
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

            Pastel_Abstrato pastelComExtra = Extra_Factory.adicionarExtra(escolhaExtra, pastelBase);

            if (pastelComExtra != null) {
                pastelBase = pastelComExtra;
                System.out.println(">>> Extra adicionado com sucesso! <<<");
            } else {
                System.out.println("Opção de extra inválida.");
            }
        }
        pedido.add(pastelBase);
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

        ItemCardapio_Interface bebida = Suco_Factory.criarSuco(escolhaBebida);

        if (bebida == null) {
            System.out.println("Opção de bebida inválida.");
            return;
        }

        pedido.add(bebida);
        System.out.println(">>> " + bebida.getDescricao() + " adicionado ao pedido! <<<");
    }
}