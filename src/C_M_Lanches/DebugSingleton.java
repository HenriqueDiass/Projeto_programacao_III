package C_M_Lanches;

public class DebugSingleton {

    private static DebugSingleton instance;

    private DebugSingleton() {

    }

    public static DebugSingleton getInstance() {
        if (instance == null) {
            instance = new DebugSingleton();
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
