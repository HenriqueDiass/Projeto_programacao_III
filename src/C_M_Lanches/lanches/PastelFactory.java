package C_M_Lanches.lanches;

import C_M_Lanches.DebugSingleton;

public class PastelFactory {

    public static PastelAbstrato criarPastel(int opcaoMenu) {

        DebugSingleton.getInstance().log("Pastel_Factory", "Iniciando criação de Pastel, opção menu", opcaoMenu);

        PastelAbstrato novoPastel = null;

        switch (opcaoMenu) {
            case 1:
                novoPastel = new PastelCarne();
                break;
            case 2:
                novoPastel = new PastelFrango();
                break;
            case 3:
                novoPastel = new PastelQueijo();
                break;
            case 4:
                novoPastel = new PastelCalabresa();
                break;
            default:

        }

        if (novoPastel != null) {
            DebugSingleton.getInstance().log("Pastel_Factory", "Pastel base criado com sucesso", novoPastel.getDescricao());
        } else {
            DebugSingleton.getInstance().log("Pastel_Factory", "Opção de pastel inválida (retornando null)", null);
        }

        // O return final agora é alcançável!
        return novoPastel;
    }
}