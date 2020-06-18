package br.com.fatec.controler;

import br.com.fatec.bean.Instituicao;
import br.com.fatec.db.DaoInstituicao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerInstituicao {
    
    public static DaoInstituicao daoIns;

    public Instituicao buscarInstituicaoPorId (Instituicao ins) throws SQLException, ClassNotFoundException {
        daoIns = new DaoInstituicao();
        return daoIns.buscar(ins);
    }

    public Instituicao inserirInstituicao (Instituicao ins) throws SQLException, ClassNotFoundException {
        daoIns = new DaoInstituicao();
        return daoIns.inserir(ins);
    }

    public Instituicao alterarInstituicao (Instituicao ins) throws SQLException, ClassNotFoundException {
        daoIns = new DaoInstituicao();
        return daoIns.alterar(ins);
    }

    public Instituicao excluirInstituicao (Instituicao ins) throws SQLException, ClassNotFoundException {
        daoIns = new DaoInstituicao();
        return daoIns.excluir(ins);
    }

    public List<Instituicao> listarInstituicao (Instituicao ins) throws SQLException, ClassNotFoundException {
        List<Instituicao> listIns = new ArrayList();
        daoIns = new DaoInstituicao();
        listIns = daoIns.listar(ins);
        return listIns;
    }
    
    public List<Instituicao> listarTodos () throws SQLException, ClassNotFoundException {
        List<Instituicao> lisAlu = new ArrayList();
        daoIns = new DaoInstituicao();
        lisAlu = daoIns.listarTodos();
        return lisAlu;
    }
}
