package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.Pastel;

public class Cheddar extends Extras {
    Pastel pastel;

    public Cheddar(Pastel pastel){
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
