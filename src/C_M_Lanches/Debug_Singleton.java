package C_M_Lanches;

public class Debug_Singleton {

    private static Debug_Singleton instance;

    private Debug_Singleton() {

    }

    public static Debug_Singleton getInstance() {
        if (instance == null) {
            instance = new Debug_Singleton();
            System.out.println("--- MÓDULO DEBUG ATIVO ---");
        }
        return instance;
    }


    public void log(String origem, String acao, Object valor) {


        String mensagemFormatada = "[DEBUG] => Origem: " + origem + " | Ação: " + acao;


        if (valor != null) {
            mensagemFormatada += " | Resultado: " + valor.toString();
        }

        System.out.println(mensagemFormatada);
    }
}
