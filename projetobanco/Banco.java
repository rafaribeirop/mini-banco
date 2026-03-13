package projetobanco;
import java.util.Scanner;

public class Banco {
    private int numConta;
    private String tipo;
    private String dono;
    private double saldo;
    private boolean status;
    
    public void statusConta(){
    // Se a conta estiver fechada o status não é mostrado
    System.out.println("Status: " + (status? "Aberta": "Fechada"));
       if (isStatus()){
            System.out.println("Número da conta: " + this.numConta);
            System.out.println("Nome: " + this.dono);
            System.out.println("Tipo da conta: "+ this.tipo);
            System.out.println("Saldo: " + this.saldo);
       } 
    }

    public void tipoConta(Scanner entrada){
        int tipoConta;
        do {
            System.out.println(getDono() +", Qual tipo de conta deseja abrir? ");
            System.out.println("[1] - Conta corrente | [2]- Conta poupança");
            tipoConta = entrada.nextInt();
            if (tipoConta !=1 && tipoConta !=2) {
                System.out.println("Opção invalida - Tente novamente!");
            }
        } while (tipoConta != 1 && tipoConta !=2);

        if (tipoConta == 1){
            setTipo("Corrente");
        } else if (tipoConta == 2){
            setTipo("Poupança");
        }
    }
    

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void abrirConta(){
        this.status = true;
        mensalidadePaga = false;

    }
    
    public void fecharConta(){
        if (saldo > 0){
            System.out.println("Sua conta contém um saldo de R$" + saldo);
            System.out.println("Sua conta não pode ser fechada!");
        } else {
            this.status = false;
            System.out.println("Conta fechada com sucesso!");
        }
    }

    //Saques e depositos só são possiveis se a conta estiver aberta
    public void saque(double saque){
        if (!isStatus()){
            System.out.println("Conta fechada");
        } else {
            if (saldo >= saque){
                this.saldo -= saque;
                System.out.println("Seu Saque de R$" + saque + " foi realizado com sucesso!");
                System.out.println("Seu saldo agora é: " + saldo);
            } else {
                System.out.println("VALOR INSUFICIENTE");
            }
        }
    }  

    public void deposito(double deposito){
        if (!isStatus()){
            System.out.println("Conta fechada");
        } else {
            this.saldo += deposito;
            System.out.println("Seu deposito de R$" + deposito + " foi realizado com sucesso!");
             System.out.println("Seu saldo agora é: " + saldo);
        }
    }

    //Mensalidade
    private boolean mensalidadePaga = false;
    public void pagarMensal(){
        if(!isStatus()){
            System.out.println("Conta fechada");
        } else {
            //Taxa de conta corrente = R$12 | taxa de conta poupança = R$20
            int taxa = (tipo.equalsIgnoreCase("Corrente")? 12:20);
             if (mensalidadePaga){
                System.out.println("Sua mensalidade já foi paga");
            }
            if ( !mensalidadePaga){
                if (this.saldo >= taxa){
                    this.saldo -= taxa;
                    System.out.println("Mensalidade de R$" + taxa + " paga");
                    mensalidadePaga = true;
                } else {
                    System.out.println("Saldo insuficiente");
                }
            }
        }
    }
}
