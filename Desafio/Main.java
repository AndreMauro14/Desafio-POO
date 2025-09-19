import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        double salarioBruto = 0;
        String nome,cargo = "";
        boolean valido = true;

        System.out.println("----CADASTRO DE FUNCIONARIOS----");
        System.out.print("Digite o nome:");
        nome = scanner.nextLine();

        do{
            System.out.println("Digite o numero referente ao seu cargo: ");
            System.out.println("[1]Programador");
            System.out.println("[2]Analista de dados");
            System.out.println("[3]Pentester");
            System.out.println("[4]Estagiario");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    cargo = "Programador";
                    salarioBruto = 7785.89;
                    break;
                case 2:
                    cargo = "Analista de Dados";
                    salarioBruto = 6885.57;
                    break;
                case 3:
                    cargo = "Pentester";
                    salarioBruto = 6355.00;
                    break;
                case 4:
                    cargo = "Estagiario";
                    salarioBruto = 1788.99;
                    break;
                default:
                    System.out.println("ERRO! VOCE DIGITOU O NUMERO ERRADO");
                    valido=false;
            }
        }while (!valido);

        Funcionario funcionario =new Funcionario(nome,cargo,salarioBruto);

        System.out.println();

        System.out.println("Seu salario bruto é :"+funcionario.getSalarioBruto());

        System.out.print("Valor descontado do inss foi: ");
        System.out.printf("R$ %.2f\n",funcionario.inss());
        System.out.print("O valor descontado do imposto de renda foi :");
        System.out.printf("%.2f\n",funcionario.impostoDeRenda());
        System.out.print("O valor descontado para o Vale trasnporte foi:");
        System.out.printf("R$ %.2f\n",funcionario.valeTransporte());

        System.out.println();

        System.out.println(funcionario);

    }
}