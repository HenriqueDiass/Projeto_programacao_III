package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.PastelAbstrato;


public class Catupiri extends ExtrasAbstrato {
    PastelAbstrato pastel;

    public Catupiri(PastelAbstrato pastel){
        this.pastel = pastel;
    }

    @Override
    public String getDescricao(){
        return pastel.getDescricao()  + ", Catupiri";
    }

    @Override
    public double cost() {
        return 2.70 + pastel.cost();
    }
}