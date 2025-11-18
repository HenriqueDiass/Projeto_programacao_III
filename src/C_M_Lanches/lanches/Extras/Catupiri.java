package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.Pastel_Abstrato;


public class Catupiri extends Extras_Abstrato {
    Pastel_Abstrato pastel;

    public Catupiri(Pastel_Abstrato pastel){
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