// create table db2020.aluno (
  // id BIGINT NOT NULL AUTO_INCREMENT,
  // nome VARCHAR(255),
  // sexo CHAR(1),
  // idade VARCHAR(3),
  // cpf VARCHAR(11),
  // primary key (id));
package br.com.fatec.bean;

public class Aluno {
    private int id;
    private String nome;
    private String  sexo;
    private String idade;
    private String cpf;

    public Aluno(int id, String nome, String sexo, String idade, String cpf) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", idade=" + idade + ", cpf=" + cpf + '}';
    }
}
