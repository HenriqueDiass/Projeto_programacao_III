package C_M_Lanches.Bebidas;
import C_M_Lanches.Debug_Singleton;

public class Suco_Factory {

    public static Suco_Abstrato criarSuco(int opcaoMenu) {

        Debug_Singleton.getInstance().log("Suco_Factory", "Iniciando criação de Suco, opção menu", opcaoMenu);

        Suco_Abstrato novoSuco = null; // Declaramos aqui

        switch (opcaoMenu) {
            case 1:
                novoSuco = new Suco_Laranja();
                break;
            case 2:
                novoSuco = new Suco_Uva();
                break;
            case 3:
                novoSuco = new Suco_Limao();
                break;
            case 4:
                novoSuco = new Suco_Maracuja();
                break;
            default:
        }

        if (novoSuco != null) {
            Debug_Singleton.getInstance().log("Suco_Factory", "Suco criado com sucesso", novoSuco.getDescricao());
        } else {
            Debug_Singleton.getInstance().log("Suco_Factory", "Opção de suco inválida (retornando null)", opcaoMenu);
        }

        return novoSuco;
    }
}