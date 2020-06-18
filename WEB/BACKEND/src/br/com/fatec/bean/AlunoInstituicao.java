// create table db2020.aluno_instituicao (
  // id BIGINT NOT NULL AUTO_INCREMENT,
  // idAlu BIGINT,
  // idIns BIGINT, 
  // observacao VARCHAR(255),
  // primary key (id));
package br.com.fatec.bean;

public class AlunoInstituicao {
    
    private int idAluIns;
    private int idAlu;
    private int idIns;
    private String observervacao;
    private Aluno alu;
    private Instituicao ins;

    public AlunoInstituicao(int idAluIns, int idAlu, int idIns, String observervacao) {
        this.idAluIns = idAluIns;
        this.idAlu = idAlu;
        this.idIns = idIns;
        this.observervacao = observervacao;
    }

    public int getIdAluIns() {
        return idAluIns;
    }

    public void setIdAluIns(int idAluIns) {
        this.idAluIns = idAluIns;
    }

    public int getIdAlu() {
        return idAlu;
    }

    public void setIdAlu(int idAlu) {
        this.idAlu = idAlu;
    }

    public int getIdIns() {
        return idIns;
    }

    public void setIdIns(int idIns) {
        this.idIns = idIns;
    }

    public String getObservervacao() {
        return observervacao;
    }

    public void setObservervacao(String observervacao) {
        this.observervacao = observervacao;
    }

    public Aluno getAlu() {
        return alu;
    }

    public void setAlu(Aluno alu) {
        this.alu = alu;
    }

    public Instituicao getIns() {
        return ins;
    }

    public void setIns(Instituicao ins) {
        this.ins = ins;
    }

    @Override
    public String toString() {
        return "AlunoInstuituicao{" + "idAluIns=" + idAluIns + ", idAlu=" + idAlu + ", idIns=" + idIns + ", observervacao=" + observervacao + ", alu=" + alu.getNome() + ", ins=" + ins.getNome() + '}';
    }
}
