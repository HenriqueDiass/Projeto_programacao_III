package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.Pastel;

public class Milho extends Extras {
    Pastel pastel;

    public Milho(Pastel pastel){
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
