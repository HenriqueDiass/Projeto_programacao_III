package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.PastelAbstrato;

public class Cheddar extends ExtrasAbstrato {
    PastelAbstrato pastel;

    public Cheddar(PastelAbstrato pastel){
        this.pastel = pastel;
    }

    @Override
    public String getDescricao(){
        return pastel.getDescricao() + ", Cheddar";
    }

    @Override
    public double cost() {
        return 0.50 + pastel.cost();
    }
}
