package Cientela;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;

    public Cliente(int id, String nome, String cpf, String email, String endereco, String cep) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.cep = cep;
    }

    public Cliente() {}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCep() { return cep; }

    public void setCep(String cep) { this.cep = cep; }

    public String imprimeCliente() {
        return "Cliente Id: " + getId() + " nome: " + getNome() + " cpf: " + getCpf() + " email: " + getEmail() + " endereco: " + getEndereco() + " cep: " + getCep();
    }
}
