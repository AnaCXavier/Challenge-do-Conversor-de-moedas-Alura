public class Conversor {

    public static void converter(String origem, String destino, double valor, ConsultaMoeda consulta) {

        double taxa = consulta.buscaTaxa(origem, destino);

        double resultado = valor * taxa;

        System.out.printf("Valor convertido: %.2f %s%n", resultado, destino);
    }
}