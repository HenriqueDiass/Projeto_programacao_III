package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.Pastel_Abstrato;
import C_M_Lanches.Debug_Singleton;

public class Extra_Factory {


    public static Pastel_Abstrato adicionarExtra(int tipoExtra, Pastel_Abstrato pastelParaDecorar) {

        Debug_Singleton.getInstance().log("Extra_Factory", "Tentando adicionar extra", tipoExtra);
        Debug_Singleton.getInstance().log("Extra_Factory", "Decorando Pastel base", pastelParaDecorar.getDescricao());

        Pastel_Abstrato pastelComExtra = null;

        switch (tipoExtra) {
            case 1:
                pastelComExtra = new Catupiri(pastelParaDecorar);
                break;
            case 2:
                pastelComExtra = new Cheddar(pastelParaDecorar);
                break;
            case 3:
                pastelComExtra = new Milho(pastelParaDecorar);
                break;
            default:

        }

        if (pastelComExtra != null) {
            Debug_Singleton.getInstance().log("Extra_Factory", "Decorator aplicado com sucesso", pastelComExtra.getDescricao());
        } else {
            Debug_Singleton.getInstance().log("Extra_Factory", "Opção de extra inválida", tipoExtra);
        }

        return pastelComExtra;
    }
}