import tests.*;

public class Program {
    public static void main(String[] args) throws Exception {
        System.out.println("--------------------------");
        System.out.println("Verificando estados");
        System.out.println("--------------------------");
        VerificandoEstados.test();
        System.out.println("--------------------------");
        System.out.println("Model");
        System.out.println("--------------------------");
        Model.test();
    }
}
