
//RAILTON ROSA DE CARVALHO //VINICIUS LIRA CALDAS //JULIANA GONCALVES CAMARA //GIULIA DE ARAUJO FREULON
public class Cliente {
    private String nome;
    private long CPF;
    private Conta conta;

    public Cliente(String nome, long cpf, Conta conta) {
        this.nome = nome;
        this.CPF = cpf;
        this.conta = conta;
    }

    // getters
    public String getNome() {
        return nome;
    }

    public long getCPF() {
        return CPF;
    }

    public Conta getConta() {
        return conta;
    }

    // setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
