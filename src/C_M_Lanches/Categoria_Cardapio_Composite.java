package C_M_Lanches;

import java.util.ArrayList;
import java.util.List;


public class Categoria_Cardapio_Composite implements ItemCardapio_Interface {


    private List<ItemCardapio_Interface> itens = new ArrayList<>();
    private String nomeCategoria;

    String descricao = "Categoria de Itens";

    @Override
    public String getDescricao() {
        return this.descricao;
    }
    @Override
    public double cost(){
        return 0.0;
    }



    public Categoria_Cardapio_Composite(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public void adicionarItem(ItemCardapio_Interface item) {
        itens.add(item);
    }
    @Override
    public String getDescricaoFormatada() {
        String textoFormatado = "\n---- " + this.nomeCategoria + " ----";
        for (ItemCardapio_Interface item : itens) {
            textoFormatado = textoFormatado + "\n  - " + item.getDescricaoFormatada();
        }
        return textoFormatado;
    }
}