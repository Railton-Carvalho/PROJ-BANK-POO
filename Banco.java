
import java.util.ArrayList;

//RAILTON ROSA DE CARVALHO //VINICIUS LIRA CALDAS //JULIANA GONCALVES CAMARA //GIULIA DE ARAUJO FREULON
public class Banco {
    private String nome;
    private int agencia;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private int senhaGerente;

    public Banco(String nome, int agencia, int senhaGerente) {
        this.nome = nome;
        this.agencia = agencia;
        this.senhaGerente = senhaGerente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public int getSenhaGerente() {
        return senhaGerente;
    }

    public void setSenhaGerente(int senhaGerente) {
        this.senhaGerente = senhaGerente;
    }

    public void cadastrarCliente(Cliente Novo) {
        clientes.add(Novo);
        System.out.println("Cliente cadastrado com sucesso");
    }

    public void excluirCliente(long Cpf) {
        boolean error = true;
        for (Cliente users : clientes) {
            if (users.getCPF() == Cpf) {
                clientes.remove(users);
                error = false;
                System.out.println("Cliente excluído com sucesso!");
                break;
            }
        }
        if (error) {
            System.out.println("CPF não consta na base de dados!");
        }
    }

    public void Listagem() {// apenas para debugar
        System.out.println("\tLISTA DE CLIENTES");

        for (Cliente user : clientes) {
            System.out.printf("\n|Nome = %s| CPF = %d| Conta: %d|\n", user.getNome(), user.getCPF(),
                    user.getConta().getNumero());
        }
    }

    public ArrayList<Cliente> GetClientes() {
        return clientes;
    }

    public Conta getSpecificAccount(int numconta) {
        for (Cliente user : clientes) {
            if (user.getConta().getNumero() == numconta) {
                return user.getConta();
            }
        }
        return null;

    }
}