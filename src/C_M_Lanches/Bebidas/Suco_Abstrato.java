package C_M_Lanches.Bebidas;


import C_M_Lanches.ItemCardapio_Interface;

public abstract class Suco_Abstrato implements ItemCardapio_Interface {
    String descricao = "Tipo de suco";

    public String getDescricao() {
        return descricao;
    }
    public abstract double cost();

    @Override
    public String getDescricaoFormatada() {
        return this.getDescricao() + " - R$" + String.format("%.2f", this.cost());
    }
}
