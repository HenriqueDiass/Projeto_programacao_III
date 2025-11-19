package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.PastelAbstrato;

public class Milho extends ExtrasAbstrato {
    PastelAbstrato pastel;

    public Milho(PastelAbstrato pastel){
        this.pastel = pastel;
    }

    @Override
    public String getDescricao(){
        return pastel.getDescricao()  + ", Milho";
    }

    @Override
    public double cost() {
        return 0.50 + pastel.cost();
    }
}
