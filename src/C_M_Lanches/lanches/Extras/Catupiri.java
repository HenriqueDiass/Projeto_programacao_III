package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.Pastel;


public class Catupiri extends Extras {
    Pastel pastel;

    public Catupiri(Pastel pastel){
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