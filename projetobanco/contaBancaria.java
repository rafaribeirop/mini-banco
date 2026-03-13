package projetobanco;
import java.util.Scanner;
public class contaBancaria {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Banco conta = new Banco();
        //Atribuições
        System.out.println(" == Seja bem vindo(a) ao banco da Rafa == ");
        //Nome do usuário
        System.out.println("Digite seu primeiro nome: ");
        conta.setDono(entrada.next());
        //Chama o método para definir o tipo de conta 
        conta.tipoConta(entrada);
        System.out.println("Conta escolhida: " + conta.getTipo());
        //Número da conta definido pelo sistema
        conta.setNumConta(123456);
        System.out.println("O número da sua conta é: " + conta.getNumConta());
        //Cadastro concluido - conta aberta
        conta.abrirConta();

        int resposta = -1;
        do {
            //Menu só é mostrando se a conta estiver aberta
            if (conta.isStatus()){
                //Menu do banco
                System.out.println("======= Banco da Rafa ========");
                System.out.println("[1] Depositar");
                System.out.println("[2] Sacar");
                System.out.println("[3] Pagar mensalidade");
                System.out.println("[4] Ver status da conta");
                System.out.println("[5] Fechar conta");
                System.out.println("[0] Sair");
                resposta = entrada.nextInt();
           
                switch (resposta) {
                    // Deposito
                    case 1:
                    System.out.println("Valor do deposito");
                    double deposito = entrada.nextDouble();
                    conta.deposito(deposito);
                        break;
                    // Saque
                    case 2:
                    System.out.println("Valor do saque: ");
                    double saque = entrada.nextDouble();
                    conta.saque(saque);
                        break;
                    //Pagamento mensal
                    case 3:
                        conta.pagarMensal();
                        break;
                    //Ver o status da conta
                    case 4:
                        conta.statusConta();
                        break;
                    //Fechar a conta
                    case 5:
                        conta.fecharConta();
                        if (!conta.isStatus()){
                        resposta = 0;
                    }
                        break;
                    //Sair do programa
                    case 0:
                        System.out.println("..Saindo..");
                        break;
                    //Caso escolha outro número
                    default:
                        System.out.println("Digito inválido");
                        break;
               }
            } else { 
                System.out.println("Conta fechada");
            }
            System.out.println("");
        } while (resposta !=0);
        entrada.close();

    }
    
}
 