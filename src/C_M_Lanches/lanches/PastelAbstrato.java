package C_M_Lanches.lanches;

import C_M_Lanches.ItemCardapioInterface;

public abstract class PastelAbstrato implements ItemCardapioInterface {
    String descricao = "Tipo de pastel";

    public String getDescricao() {
        return descricao;
    }
    public abstract double cost();

    @Override
    public String getDescricaoFormatada() {
        return this.getDescricao() + " - R$" + String.format("%.2f", this.cost());
    }
}


