package br.com.fatec.controler;

import br.com.fatec.bean.Usuario;
import br.com.fatec.db.DaoUsuario;
import java.sql.SQLException;
import java.util.List;

public class ControllerUsuario {
    
    public Usuario validarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.validarLogin(usu);
        return usu;
    }
    
    public Usuario inserirUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.inserir(usu);
        return usu;
    }

    public Usuario excluirUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.excluir(usu);
        return usu;
    }

    public Usuario buscarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.buscar(usu);
        return usu;
    }

    public Usuario alterarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        DaoUsuario usuDao = new DaoUsuario();
        usu = usuDao.alterar(usu);
        return usu;
    }
    
    public List<Usuario> listarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        List<Usuario>  usus ;
        DaoUsuario usuDao = new DaoUsuario();
        usus = usuDao.listar(usu);
        return usus;
    }

    public List<Usuario> listarTodosUsuario() throws SQLException, ClassNotFoundException {
        List<Usuario>  usus ;
        DaoUsuario usuDao = new DaoUsuario();
        usus = usuDao.listarTodos();
        return usus;
    }   
}
