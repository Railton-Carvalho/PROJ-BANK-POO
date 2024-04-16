import java.util.Scanner;
import java.util.Random;

//RAILTON ROSA DE CARVALHO //VINICIUS LIRA CALDAS //JULIANA GONCALVES CAMARA //GIULIA DE ARAUJO FREULON
public class AutoAtendimento {
    private Banco banco;
    private Random geraint = new Random();// existe apenas para gerar numeros de contas
    private int numCobaia;
    private boolean run;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        Banco b1 = new Banco("Banco Bonini", 1002, 1369);
        AutoAtendimento Interface = new AutoAtendimento(b1);

        do {
            int option = 0;
            System.out.printf("\t%s MENU", Interface.getbanco().getNome().toUpperCase());
            System.out.print("\n| 1.Login Gerente \n| 2.Login Cliente\n| 3.Sair do Sistema\n");
            System.out.print("Sua Opção: ");
            System.out.print("");
            while (!input.hasNextInt() || option > 3) {
                System.out.print("Digite uma opção válida: ");
                input.next();
            }
            option = input.nextInt();
            /* int valGc; */
            int contaCobaia, senhaCobaia;
            switch (option) {
                case 1:
                    System.out.println("Para prosseguir informe alguns dados");
                    System.out.print("Insira o número da conta: ");
                    contaCobaia = Interface.validadorInt("um número de conta válida");
                    System.out.print("Insira a sua senha: ");
                    senhaCobaia = Interface.validadorInt("uma senha válida");
                    Interface.loginGerente(contaCobaia, senhaCobaia);
                    break;
                case 2:
                    System.out.println("Para prosseguir informe alguns dados");
                    System.out.print("Insira o número da conta: ");
                    contaCobaia = Interface.validadorInt("um número de conta válida");
                    System.out.print("Insira a sua senha: ");
                    senhaCobaia = Interface.validadorInt("uma senha válida");
                    Interface.loginCliente(contaCobaia, senhaCobaia);
                    break;
                case 3:
                    run = false;// encerra a interface
            }
        } while (run);// faz a interface ficar vivaBonnini
    }// endmain

    public AutoAtendimento(Banco banco) {
        this.banco = banco;
    }

    public void loginGerente(int numAgencia, int senha) {
        // Banco b1 = new Banco("Banco do Brasil", 1002, 1369);
        Scanner input = new Scanner(System.in);
        do {
            if (numAgencia == banco.getAgencia()) {
                int option = 0;
                if (banco.getSenhaGerente() != senha) {
                    int numTentativas = 0;
                    while (banco.getSenhaGerente() != senha || numTentativas < 3) {
                        System.out.print("Senha incorreta, digite novamente: ");
                        senha = validadorInt("uma senha válida");
                        numTentativas++;
                        if (banco.getSenhaGerente() == senha) {
                            break;
                        }
                        if (numTentativas == 3) {
                            System.out.println("Muitas tentativas");
                            run = false;
                            break;
                        }
                    }
                }
                if (banco.getSenhaGerente() == senha) {
                    System.out.println("Acesso Permitido");
                    do {
                        System.out.println("---------------------------------");
                        System.out.println("\tMENU GERENTE ");
                        System.out.printf("|Número de Agencia: %d|\n", banco.getAgencia());
                        System.out.print("\n|1-Cadastrar Cliente\n|2-Excluir Cliente\n|3-Listar Clientes\n|4-Logout\n");
                        System.out.println("---------------------------------");
                        System.out.print("Sua opção: ");
                        option = input.nextInt();
                        int info3;
                        String info1;// swicthstr
                        long info2;// swicthlong
                        switch (option) {
                            case 1:
                                System.out.print("Digite o nome do novo cliente: ");
                                info1 = validadorString();
                                System.out.print("Digite o número do CPF o novo cliente: ");
                                info2 = validadorLong();
                                System.out.print("Digite a senha númerica do novo cliente: ");
                                info3 = validadorInt("uma senha númerica válida");
                                Conta nova = new Conta(geraint.nextInt(1111, 9999), 0.0F, info3);// random no numconta
                                Cliente novo = new Cliente(info1, info2, nova);
                                gerenteCadastrarCliente(novo);
                                ;
                                break;
                            case 2:
                                long swicthlong;
                                System.out.print("Digite o CPF do cliente que deseja excluir: ");
                                swicthlong = validadorLong();
                                gerenteExcluirCliente(swicthlong);
                                break;
                            case 3:
                                banco.Listagem();
                                break;
                            // case 4:
                            // break;
                        }// ENDSWICTH
                    } while (option != 4);
                } // IFSENHA
            } // IFCONTA
            else {
                System.out.println("Conta não encontrada");
            }
        } while (run);
    }

    public void loginCliente(int numConta, int senha) {
        boolean error = false;
        do {
            for (Cliente user : banco.GetClientes()) {
                if (user.getConta().getNumero() == numConta) {
                    if (user.getConta().getSenha() != senha) {
                        int numTentativas = 0;
                        while (user.getConta().getSenha() != senha || numTentativas < 3) {
                            System.out.print("Senha incorreta, digite novamente: ");
                            senha = validadorInt("uma senha válida");
                            numTentativas++;
                            if (user.getConta().getSenha() == senha) {
                                break;
                            }
                            if (numTentativas == 3) {
                                System.out.println("Muitas tentativas");
                                run = false;
                                break;
                            }
                        }
                    }

                    error = false;

                    if (user.getConta().getSenha() == senha) {
                        numCobaia = numConta;
                        Scanner input = new Scanner(System.in);
                        System.out.println("Acesso Permitido");
                        int option, senhaCobaia;
                        float fcobaia;
                        do {
                            System.out.println("---------------------------------");
                            System.out.println("\tMENU CLIENTE ");
                            System.out.printf("|Conta: %d|Agencia: %d|", user.getConta().getNumero(),
                                    banco.getAgencia());
                            System.out.print("\n|1-Depositar\n|2-Ver Saldo \n|3-Sacar\n|4-Logout\n");
                            System.out.println("---------------------------------");
                            System.out.print("Sua opção: ");
                            option = input.nextInt();
                            switch (option) {
                                case 1:
                                    System.out.print("Digite o valor para deposito: ");
                                    fcobaia = validadorFloat();
                                    clienteDepositar(fcobaia);
                                    break;
                                case 2:
                                    System.out.print("Digite sua senha novamente para prosseguir: ");
                                    senhaCobaia = validadorInt("uma senha válida");
                                    clienteVerificarSaldo(senhaCobaia);
                                    // user.getConta().verificarSaldo(senha);
                                    // System.out.printf("\n%s seu saldo atual é de R$ %.2f\n", user.getNome(),
                                    // user.getConta().getSaldo());
                                    break;
                                case 3:
                                    System.out.print("Digite o valor para saque: ");
                                    fcobaia = validadorFloat();
                                    System.out.print("Digite sua senha novamente para prosseguir: ");
                                    senhaCobaia = validadorInt("uma senha válida");
                                    clienteSacar(fcobaia, senhaCobaia);
                                    // user.getConta().sacar(fcobaia, user.getConta().getSenha());

                                case 4:
                                    break;// logout_option
                            }
                        } while (option != 4);
                        break;
                    } // limit if

                } else {
                    error = true;
                }
            }
            if (error) {
                System.out.println("Conta não encontrada");
            }
        } while (run);
    }

    public void gerenteCadastrarCliente(Cliente novo) {
        banco.cadastrarCliente(novo);
    }

    public void gerenteExcluirCliente(long CPF) {
        banco.excluirCliente(CPF);
    }

    public void clienteSacar(float valor, int senha) {
        banco.getSpecificAccount(numCobaia).sacar(valor, senha);
    }

    public void clienteDepositar(float valor) {
        banco.getSpecificAccount(numCobaia).depositar(valor);
    }

    public void clienteVerificarSaldo(int senha) {
        float cobaia = banco.getSpecificAccount(numCobaia).verificarSaldo(senha);
        if (cobaia != -1) {
            System.out.printf("Seu saldo é de R$ %.2f\n", cobaia);
        } else {
            System.out.println("Muitas tentativas");
        }
    }

    public Banco getbanco() {
        return banco;
    }

    // Metodos de validação
    public int validadorInt(String text) {
        Scanner input = new Scanner(System.in);
        int valor;
        while (!input.hasNextInt()) {
            System.err.print("Digite " + text + ": ");
            input.next();
        }
        valor = input.nextInt();
        return valor;
    }

    public float validadorFloat() {
        Scanner input = new Scanner(System.in);
        float valor;
        while (!input.hasNextFloat()) {
            System.err.print("Digite um valor válido: ");
            input.next();
        }
        valor = input.nextFloat();
        return valor;
    }

    public long validadorLong() {
        Scanner input = new Scanner(System.in);
        long valor;
        while (!input.hasNextLong()) {
            System.err.print("Digite um CPF válido: ");
            input.next();
        }
        valor = input.nextLong();
        return valor;
    }

    public String validadorString() {
        Scanner input = new Scanner(System.in);
        String valor;
        while (input.hasNextFloat() || input.hasNextInt()) {
            System.err.print("Digite um nome válido: ");
            input.next();
        }
        valor = input.next();
        return valor;
    }
}
