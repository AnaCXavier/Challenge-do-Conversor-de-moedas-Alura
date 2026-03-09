import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        ConsultaMoeda consulta = new ConsultaMoeda();

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("""
                    *****************************
                    Conversor de Moedas
                    
                    1 - USD -> BRL
                    2 - BRL -> USD
                    3 - EUR -> BRL
                    4 - BRL -> EUR
                    5 - Sair
                    *****************************
                    """);

            System.out.print("Escolha uma opção: ");
            opcao = leitura.nextInt();

            if (opcao == 5) {
                System.out.println("Programa encerrado.");
                break;
            }

            System.out.print("Digite o valor: ");
            double valor = leitura.nextDouble();

            switch (opcao) {

                case 1 -> Conversor.converter("USD", "BRL", valor, consulta);

                case 2 -> Conversor.converter("BRL", "USD", valor, consulta);

                case 3 -> Conversor.converter("EUR", "BRL", valor, consulta);

                case 4 -> Conversor.converter("BRL", "EUR", valor, consulta);

                default -> System.out.println("Opção inválida.");

            }
        }
    }
}