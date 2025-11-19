package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.PastelAbstrato;

public class Ervilha extends ExtrasAbstrato {

    PastelAbstrato pastel;

    public Ervilha(PastelAbstrato pastel){
        this.pastel = pastel;
    }

    @Override
    public String getDescricao(){
        return pastel.getDescricao() + ", Ervilha";
    }

    @Override
    public double cost() {
        return 0.50 + pastel.cost();
    }
}
