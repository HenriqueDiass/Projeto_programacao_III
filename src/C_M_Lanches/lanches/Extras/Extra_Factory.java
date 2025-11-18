package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.Pastel_Abstrato;

public class Extra_Factory {


    public static Pastel_Abstrato adicionarExtra(int tipoExtra, Pastel_Abstrato pastelParaDecorar) {

        switch (tipoExtra) {
            case 1:
                return new Catupiri(pastelParaDecorar);
            case 2:
                return new Cheddar(pastelParaDecorar);
            case 3:
                return new Milho(pastelParaDecorar);
            default:
                return null;
        }
    }
}