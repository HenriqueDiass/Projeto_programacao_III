package C_M_Lanches.lanches;

public class Pastel_Factory {

    public static Pastel_Abstrato criarPastel(int opcaoMenu) {
        switch (opcaoMenu) {
            case 1:
                return new Pastel_Carne();
            case 2:
                return new Pastel_Frango();
            case 3:
                return new Pastel_Queijo();
            case 4:
                return new Pastel_Calabresa();
            default:
                return null;
        }
    }
}