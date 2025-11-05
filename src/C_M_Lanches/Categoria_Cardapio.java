package C_M_Lanches;

import java.util.ArrayList;
import java.util.List;


public class Categoria_Cardapio implements ItemCardapio {
    private List<ItemCardapio> itens = new ArrayList<>();
    private String nomeCategoria;
    String descricao = "Categorias";


    //OBRIGATORIO O GET E O COST
    @Override
    public String getDescricao() {
        return descricao;
    }
    public double cost(){
        return 0.0;
    }

    public Categoria_Cardapio(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
    }

    public void removerItem(ItemCardapio item) {
        itens.remove(item);
    }

    // 2. O método do Composite!
    @Override
    public String getDescricaoFormatada() {
        // Cria a formatação da categoria
        StringBuilder builder = new StringBuilder();
        builder.append("\n---- " + this.nomeCategoria + " ----");

        // Chama o mesmo método em todos os filhos
        for (ItemCardapio item : itens) {
            builder.append("\n  - " + item.getDescricaoFormatada());
        }

        return builder.toString();
    }
}