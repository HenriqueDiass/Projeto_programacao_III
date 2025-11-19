package C_M_Lanches;

import java.util.ArrayList;
import java.util.List;


public class CategoriaCardapioComposite implements ItemCardapioInterface {


    private List<ItemCardapioInterface> itens = new ArrayList<>();
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



    public CategoriaCardapioComposite(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public void adicionarItem(ItemCardapioInterface item) {
        itens.add(item);
    }
    @Override
    public String getDescricaoFormatada() {
        String textoFormatado = "\n---- " + this.nomeCategoria + " ----";
        for (ItemCardapioInterface item : itens) {
            textoFormatado = textoFormatado + "\n  - " + item.getDescricaoFormatada();
        }
        return textoFormatado;
    }
}