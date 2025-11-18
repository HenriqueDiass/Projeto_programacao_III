package C_M_Lanches.Bebidas;

public class Suco_Factory {

    public static Suco_Abstrato criarSuco(int opcaoMenu) {
        switch (opcaoMenu) {
            case 1:
                return new Suco_Laranja();
            case 2:
                return new Suco_Uva();
            case 3:
                return new Suco_Limao();
            case 4:
                return new Suco_Maracuja();
            default:
                return null;
        }
    }
}