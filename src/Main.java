import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import C_M_Lanches.CategoriaCardapioComposite;
import C_M_Lanches.ItemCardapioInterface;
import C_M_Lanches.GerenciadorVendasSingleton;
import C_M_Lanches.Bebidas.*;
import C_M_Lanches.lanches.*;
import C_M_Lanches.lanches.Extras.*;
import C_M_Lanches.DebugSingleton;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<ItemCardapioInterface> pedido = new ArrayList<>();
    private static ItemCardapioInterface cardapioCompleto;

    public static void main(String[] args) {

        System.out.println("========= BEM-VINDO À LANCHONETE =========");
        montarCardapioParaExibicao();

        while (true) {
            mostrarMenuPrincipal();
            int escolha = lerOpcao();

            DebugSingleton.getInstance().log("Main::main", "Opção de menu principal escolhida", escolha);

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
                    GerenciadorVendasSingleton.getInstance().imprimirRelatorioGeral();
                    break;
                case 0:
                    DebugSingleton.getInstance().log("Main::main", "Encerrando o programa", null);
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
        DebugSingleton.getInstance().log("Main::montarCardapioParaExibicao", "Iniciando montagem do Cardápio Composite", null);

        CategoriaCardapioComposite categoriaPasteis = new CategoriaCardapioComposite("PASTÉIS");
        CategoriaCardapioComposite categoriaBebidas = new CategoriaCardapioComposite("BEBIDAS");

        DebugSingleton.getInstance().log("Main::montarCardapioParaExibicao", "Pastris base adicionados às categorias", null);
        categoriaPasteis.adicionarItem(new PastelCarne());
        categoriaPasteis.adicionarItem(new PastelFrango());
        categoriaPasteis.adicionarItem(new PastelQueijo());
        categoriaPasteis.adicionarItem(new PastelCalabresa());


        DebugSingleton.getInstance().log("Main::montarCardapioParaExibicao", "Sucos base adicionados às categorias", null);
        categoriaBebidas.adicionarItem(new SucoLaranja());
        categoriaBebidas.adicionarItem(new SucoUva());
        categoriaBebidas.adicionarItem(new SucoLimao());
        categoriaBebidas.adicionarItem(new SucoMaracuja());

        cardapioCompleto = new CategoriaCardapioComposite("CARDÁPIO DA LANCHONETE");
        ((CategoriaCardapioComposite) cardapioCompleto).adicionarItem(categoriaPasteis);
        ((CategoriaCardapioComposite) cardapioCompleto).adicionarItem(categoriaBebidas);
        DebugSingleton.getInstance().log("Main::montarCardapioParaExibicao", "Montagem do Cardápio Completo finalizada", null);
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
            DebugSingleton.getInstance().log("Main::fecharContaCliente", "Tentativa de fechar conta, mas pedido está vazio", null);
            System.out.println("\nA mesa está vazia. Adicione itens antes de fechar a conta.");
            return;
        }

        DebugSingleton.getInstance().log("Main::fecharContaCliente", "Iniciando fechamento da conta", "Itens no pedido: " + pedido.size());

        StringBuilder recibo = new StringBuilder();
        double total = 0.0;

        recibo.append("\n========= CUPOM FISCAL ==========\n");
        for (ItemCardapioInterface item : pedido) {
            recibo.append(item.getDescricaoFormatada()).append("\n");
            total += item.cost();
        }
        DebugSingleton.getInstance().log("Main::fecharContaCliente", "Total calculado", total);
        recibo.append("----------------------------------\n");
        recibo.append(String.format("TOTAL A PAGAR: R$%.2f\n", total));
        recibo.append("==================================\n");

        String textoFinal = recibo.toString();
        System.out.println(textoFinal);


        GerenciadorVendasSingleton.getInstance().salvarPedido(textoFinal);
        DebugSingleton.getInstance().log("Main::fecharContaCliente", "Chamando Gerenciador_Vendas para salvar o pedido", null);
        System.out.println(">> Venda registrada no sistema com sucesso! <<");
        pedido.clear();
        DebugSingleton.getInstance().log("Main::fecharContaCliente", "Lista de pedidos limpa", null);
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

        DebugSingleton.getInstance().log("Main::montarPastel", "Opção de sabor de pastel lida", escolhaPastel);


        PastelAbstrato pastelBase = PastelFactory.criarPastel(escolhaPastel);

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

            DebugSingleton.getInstance().log("Main::montarPastel", "Opção de extra lida", escolhaExtra);

            if (escolhaExtra == 0) {
                DebugSingleton.getInstance().log("Main::montarPastel", "Usuário finalizou o pastel sem mais extras", null);
                break;
            }

            PastelAbstrato pastelComExtra = ExtraFactory.adicionarExtra(escolhaExtra, pastelBase);

            if (pastelComExtra != null) {
                pastelBase = pastelComExtra;
                System.out.println(">>> Extra adicionado com sucesso! <<<");
            } else {
                System.out.println("Opção de extra inválida.");
            }
        }
        pedido.add(pastelBase);
        DebugSingleton.getInstance().log("Main::montarPastel", "Pastel finalizado e adicionado à lista de pedido", pastelBase.getDescricao());
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
        DebugSingleton.getInstance().log("Main::adicionarBebida", "Opção de bebida lida", escolhaBebida);

        ItemCardapioInterface bebida = SucoFactory.criarSuco(escolhaBebida);

        if (bebida == null) {
            System.out.println("Opção de bebida inválida.");
            return;
        }

        pedido.add(bebida);
        DebugSingleton.getInstance().log("Main::adicionarBebida", "Bebida criada e adicionada à lista de pedido", bebida.getDescricao());
        System.out.println(">>> " + bebida.getDescricao() + " adicionado ao pedido! <<<");
    }
}