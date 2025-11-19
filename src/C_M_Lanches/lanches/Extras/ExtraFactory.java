package C_M_Lanches.lanches.Extras;

import C_M_Lanches.lanches.PastelAbstrato;
import C_M_Lanches.DebugSingleton;

public class ExtraFactory {


    public static PastelAbstrato adicionarExtra(int tipoExtra, PastelAbstrato pastelParaDecorar) {

        DebugSingleton.getInstance().log("Extra_Factory", "Tentando adicionar extra", tipoExtra);
        DebugSingleton.getInstance().log("Extra_Factory", "Decorando Pastel base", pastelParaDecorar.getDescricao());

        PastelAbstrato pastelComExtra = null;

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
            DebugSingleton.getInstance().log("Extra_Factory", "Decorator aplicado com sucesso", pastelComExtra.getDescricao());
        } else {
            DebugSingleton.getInstance().log("Extra_Factory", "Opção de extra inválida", tipoExtra);
        }

        return pastelComExtra;
    }
}