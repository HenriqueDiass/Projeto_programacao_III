package C_M_Lanches.lanches;

import C_M_Lanches.Debug_Singleton;

public class Pastel_Factory {

    public static Pastel_Abstrato criarPastel(int opcaoMenu) {

        Debug_Singleton.getInstance().log("Pastel_Factory", "Iniciando criação de Pastel, opção menu", opcaoMenu);

        Pastel_Abstrato novoPastel = null;

        switch (opcaoMenu) {
            case 1:
                novoPastel = new Pastel_Carne();
                break;
            case 2:
                novoPastel = new Pastel_Frango();
                break;
            case 3:
                novoPastel = new Pastel_Queijo();
                break;
            case 4:
                novoPastel = new Pastel_Calabresa();
                break;
            default:

        }

        if (novoPastel != null) {
            Debug_Singleton.getInstance().log("Pastel_Factory", "Pastel base criado com sucesso", novoPastel.getDescricao());
        } else {
            Debug_Singleton.getInstance().log("Pastel_Factory", "Opção de pastel inválida (retornando null)", null);
        }

        // O return final agora é alcançável!
        return novoPastel;
    }
}