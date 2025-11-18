package C_M_Lanches.Bebidas;


public class Suco_Limao extends Suco_Abstrato {
    public Suco_Limao() {
        descricao = "Suco de limao";
    }


    public double cost() {
        return 10.00;
    }
}