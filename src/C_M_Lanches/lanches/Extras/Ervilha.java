package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.Pastel;

public class Ervilha extends Extras {

    Pastel pastel;

    public Ervilha(Pastel pastel){
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
