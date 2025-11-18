package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.Pastel_Abstrato;

public class Milho extends Extras_Abstrato {
    Pastel_Abstrato pastel;

    public Milho(Pastel_Abstrato pastel){
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
