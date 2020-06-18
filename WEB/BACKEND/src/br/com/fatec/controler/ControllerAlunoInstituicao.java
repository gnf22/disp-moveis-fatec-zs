package br.com.fatec.controler;

import br.com.fatec.bean.Aluno;
import br.com.fatec.bean.Instituicao;
import br.com.fatec.bean.AlunoInstituicao;
import br.com.fatec.db.DaoAlunoInstituicao;
import java.sql.SQLException;
import java.util.List;

public class ControllerAlunoInstituicao {
    
    public static ControllerAluno contAlu;
    public static ControllerInstituicao  contIns;
    public static DaoAlunoInstituicao daoAluIns;
    
    public AlunoInstituicao inserirAlunoInstituicao(AlunoInstituicao alunIns) throws SQLException, ClassNotFoundException {
        daoAluIns = new DaoAlunoInstituicao();
        return daoAluIns.inserir(alunIns);
    }
 
    public AlunoInstituicao excluirAlunoInstituicao(AlunoInstituicao alunIns) throws SQLException, ClassNotFoundException {
        daoAluIns = new DaoAlunoInstituicao();
        return daoAluIns.excluir(alunIns);
    }

    public AlunoInstituicao alterarAlunoInstituicao(AlunoInstituicao alunIns) throws SQLException, ClassNotFoundException {
        daoAluIns = new DaoAlunoInstituicao();
        return daoAluIns.alterar(alunIns);
    }

    public AlunoInstituicao buscarAlunoInstituicaoPorId(AlunoInstituicao alunIns) throws SQLException, ClassNotFoundException {

        daoAluIns = new DaoAlunoInstituicao();
        alunIns = daoAluIns.buscar(alunIns);
        
        contAlu = new ControllerAluno();
        contIns = new ControllerInstituicao();

        Aluno alu = new Aluno(alunIns.getIdAlu(),"", "", "", "");
        Instituicao inst = new Instituicao(alunIns.getIdIns(),"", "", "");
        
        alunIns.setAlu(contAlu.buscarAlunoPorId(alu));
        alunIns.setIns(contIns.buscarInstituicaoPorId(inst));

        return alunIns;
    }

    public List<AlunoInstituicao> listarAlunoInstituicao(AlunoInstituicao alunIns) throws SQLException, ClassNotFoundException {

        contAlu = new ControllerAluno();
        contIns = new ControllerInstituicao();

        daoAluIns = new DaoAlunoInstituicao();
        List<AlunoInstituicao> aluInst = daoAluIns.listar(alunIns);

        for (AlunoInstituicao listaAI : aluInst) {
            Aluno alu = new Aluno(listaAI.getIdAlu(),"", "", "", "");
            Instituicao ins = new Instituicao(listaAI.getIdIns(),"", "", "");
            listaAI.setAlu(contAlu.buscarAlunoPorId(alu));
            listaAI.setIns(contIns.buscarInstituicaoPorId(ins));
        }

        return aluInst;
    }
}
