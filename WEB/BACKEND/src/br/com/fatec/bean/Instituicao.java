  // create table db2020.instituicao (
  // id BIGINT NOT NULL AUTO_INCREMENT,
  // nome VARCHAR(255),
  // ano_fund VARCHAR(4),
  // endereco VARCHAR(255),
  // primary key (id));
package br.com.fatec.bean;

public class Instituicao {
    private int id;
    private String nome;
    private String ano_fund;
    private String endereco;

    public Instituicao(int id, String nome, String ano_fund, String endereco) {
        this.id = id;
        this.nome = nome;
        this.ano_fund = ano_fund;
        this.endereco = endereco;
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

    public String getAno_fund() {
        return ano_fund;
    }

    public void setAno_fund(String ano_fund) {
        this.ano_fund = ano_fund;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Instituicao{" + "id=" + id + ", nome=" + nome + ", ano_fund=" + ano_fund + ", endereco=" + endereco + '}';
    }
}
