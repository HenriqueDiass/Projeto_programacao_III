package C_M_Lanches.Bebidas;
import C_M_Lanches.DebugSingleton;

public class SucoFactory {

    public static SucoAbstrato criarSuco(int opcaoMenu) {

        DebugSingleton.getInstance().log("Suco_Factory", "Iniciando criação de Suco, opção menu", opcaoMenu);

        SucoAbstrato novoSuco = null; // Declaramos aqui

        switch (opcaoMenu) {
            case 1:
                novoSuco = new SucoLaranja();
                break;
            case 2:
                novoSuco = new SucoUva();
                break;
            case 3:
                novoSuco = new SucoLimao();
                break;
            case 4:
                novoSuco = new SucoMaracuja();
                break;
            default:
        }

        if (novoSuco != null) {
            DebugSingleton.getInstance().log("Suco_Factory", "Suco criado com sucesso", novoSuco.getDescricao());
        } else {
            DebugSingleton.getInstance().log("Suco_Factory", "Opção de suco inválida (retornando null)", opcaoMenu);
        }

        return novoSuco;
    }
}