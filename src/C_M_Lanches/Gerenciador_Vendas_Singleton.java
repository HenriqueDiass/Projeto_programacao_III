package C_M_Lanches;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Gerenciador_Vendas_Singleton {

    private static Gerenciador_Vendas_Singleton instance;
    private static final String CAMINHO_ARQUIVO = "historico_vendas.txt";

    private Gerenciador_Vendas_Singleton() {
    }

    public static Gerenciador_Vendas_Singleton getInstance() {
        if (instance == null) {
            instance = new Gerenciador_Vendas_Singleton();
        }
        return instance;
    }

    public void salvarPedido(String reciboPedido) {

        Debug_Singleton.getInstance().log("Gerenciador_Vendas", "Iniciando salvamento de pedido", CAMINHO_ARQUIVO);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO, true))) {
            writer.write(reciboPedido);
            writer.newLine();
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o pedido no arquivo: " + e.getMessage());
            Debug_Singleton.getInstance().log("Gerenciador_Vendas", "ERRO ao salvar pedido", e.getMessage());
        }
    }


    public void imprimirRelatorioGeral() {
        Debug_Singleton.getInstance().log("Gerenciador_Vendas", "Acessando relatório de vendas", null);
        System.out.println("\n\n#########################################");
        System.out.println("      RELATÓRIO GERAL DE VENDAS (ARQUIVO)   ");
        System.out.println("#########################################");

        File arquivo = new File(CAMINHO_ARQUIVO);

        if (!arquivo.exists()) {
            System.out.println("Nenhuma venda realizada ainda (Arquivo não existe).");
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_ARQUIVO))) {
                String linha;

                while ((linha = reader.readLine()) != null) {
                    System.out.println(linha);
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo de vendas: " + e.getMessage());
            }
        }
        System.out.println("\n");
    }
}