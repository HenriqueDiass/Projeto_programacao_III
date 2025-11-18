package C_M_Lanches.Bebidas;

public class Suco_Laranja extends Suco_Abstrato {
    public Suco_Laranja() {
        descricao = "Suco de laranja";
    }


    public double cost() {
        return 10.00;
    }
}