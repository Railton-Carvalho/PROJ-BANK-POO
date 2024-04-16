import java.util.Scanner;

//RAILTON ROSA DE CARVALHO //VINICIUS LIRA CALDAS //JULIANA GONCALVES CAMARA //GIULIA DE ARAUJO FREULON
public class Conta {
    private Scanner input = new Scanner(System.in);
    private int numero;
    private float saldo;
    private int senha;

    public Conta() {
    }

    public Conta(int numero, float saldo, int senha) {
        this.numero = numero;
        this.saldo = saldo;
        this.senha = senha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void depositar(float valor) {
        if (valor > 0) {
            System.out.println("Valor depositado com sucesso");
            System.out.println("---------------------------------");
            saldo += valor;
        } else {
            System.err.println("ERRO: Valor negativo");
            System.out.println("---------------------------------");
        }
    }

    public void sacar(float valor, int senha) {
        int controlador = 0;
        boolean run = true;
        do {
            if (senha == this.senha) {
                while (valor < 0) {
                    System.err.print("Digite um valor positivo: ");
                    valor = input.nextFloat();
                    controlador++;
                    if (controlador == 3) {
                        run = false;
                        break;
                    }
                }
                while (this.saldo < valor) {
                    System.err.println("Valor de saque maior que o saldo disponível");
                    System.out.print("Digite o valor novamente: ");
                    valor = input.nextFloat();
                    controlador++;
                    if (controlador == 3) {
                        run = false;
                        break;
                    }
                }
                if (controlador == 3) {
                    System.err.println("Muitas tentativas");
                    System.out.println("---------------------------------");
                    run = false;
                } else {
                    saldo -= valor;
                    run = false;
                    System.out.println("Valor retirado com sucesso");
                }

            } else {
                while (this.senha != senha) {
                    System.err.println("Senha incorreta: ");
                    senha = input.nextInt();
                    controlador++;
                    if (controlador == 3) {
                        System.err.println("Muitas tentativas");
                        run = false;
                        break;
                    }
                }
            }
        } while (run);// matem os verificadores funcionando
    } // endfunction

    public float verificarSaldo(int senha) {
        int controlador = 0;
        System.out.println("Verificando...");
        while (this.senha != senha && controlador != 3) {
            System.err.println("Senha incorreta");
            senha = input.nextInt();
            controlador++;
        }
        if (this.senha == senha) {
            return saldo;
        } else {
            return -1;
        }
    }
}