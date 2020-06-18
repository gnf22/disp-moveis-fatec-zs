package br.com.fatec.controler;

import br.com.fatec.bean.Aluno;
import br.com.fatec.db.DaoAluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerAluno {
    
    public static DaoAluno daoAlu;

    public Aluno buscarAlunoPorId (Aluno alu) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAluno();
        return daoAlu.buscar(alu);
    }

    public Aluno inserirAluno (Aluno alu) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAluno();
        return daoAlu.inserir(alu);
    }

    public Aluno alterarAluno (Aluno alu) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAluno();
        return daoAlu.alterar(alu);
    }

    public Aluno excluirAluno (Aluno alu) throws SQLException, ClassNotFoundException {
        daoAlu = new DaoAluno();
        return daoAlu.excluir(alu);
    }

    public List<Aluno> listarAluno (Aluno alu) throws SQLException, ClassNotFoundException {
        List<Aluno> listAlu = new ArrayList();
        daoAlu = new DaoAluno();
        listAlu = daoAlu.listar(alu);
        return listAlu;
    }
    
    public List<Aluno> listarTodos () throws SQLException, ClassNotFoundException {
        List<Aluno> lisAlu = new ArrayList<>();
        daoAlu = new DaoAluno();
        lisAlu = daoAlu.listarTodos();
        return lisAlu;
    }
}
