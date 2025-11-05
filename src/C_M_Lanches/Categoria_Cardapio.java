package C_M_Lanches;

import java.util.ArrayList;
import java.util.List;


public class Categoria_Cardapio implements ItemCardapio {


    private List<ItemCardapio> itens = new ArrayList<>();

    // 2. O NOME DA CATEGORIA
    private String nomeCategoria;

    // (Opcional, mas bom para completar a interface)
    String descricao = "Categoria de Itens";

    // 3. O CONSTRUTOR (ESSENCIAL)
    //    É chamado no Main com: new Categoria_Cardapio("PASTÉIS")
    public Categoria_Cardapio(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    // 4. O MÉTODO PARA ADICIONAR "FILHOS" (ESSENCIAL)
    //    É chamado no Main com: categoriaPasteis.adicionarItem(new Pastel_Carne())
    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
    }

    // ----- MÉTODOS DA INTERFACE ItemCardapio -----

    // Você adicionou este, o que é ótimo para cumprir o contrato da interface
    @Override
    public String getDescricao() {
        return this.descricao;
    }

    // Você adicionou este. O custo de uma "categoria" em si é 0.
    @Override
    public double cost(){
        return 0.0;
    }

    // O MÉTODO PRINCIPAL DO COMPOSITE (que analisamos)
    @Override
    public String getDescricaoFormatada() {
        // Começa com o título da própria categoria
        String textoFormatado = "\n---- " + this.nomeCategoria + " ----";

        // Delega para todos os "filhos"
        for (ItemCardapio item : itens) {
            // Chama o MESMO método no filho (seja ele um Pastel ou outra Categoria)
            textoFormatado = textoFormatado + "\n  - " + item.getDescricaoFormatada();
        }

        return textoFormatado;
    }
}