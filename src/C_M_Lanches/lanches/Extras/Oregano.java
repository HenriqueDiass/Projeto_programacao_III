package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.PastelAbstrato;

public class Oregano extends ExtrasAbstrato {
    PastelAbstrato pastel;

    public Oregano(PastelAbstrato pastel){
        this.pastel = pastel;
    }

    @Override
    public String getDescricao(){
        return pastel.getDescricao()  + ", C_M_Lanches.lanches.Extras.Oregano";
    }

    @Override
    public double cost() {
        return 0.70 + pastel.cost();
    }
}