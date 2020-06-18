package br.com.fatec.db;

import br.com.fatec.util.ConexaoDB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import br.com.fatec.bean.Usuario;
import java.sql.Statement;

public class DaoUsuario {

    private final Connection c;
    
    public DaoUsuario() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    
    public Usuario buscar(Usuario usu) throws SQLException{
        String sql = "select * from usuarios WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);

            stmt.setInt(1,usu.getId());

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {

                usu.setId(rs.getInt(1));
                usu.setNome(rs.getString(2));
                usu.setLogin(rs.getString(3));
                usu.setSenha(rs.getString(4));
                usu.setStatus(rs.getString(5));
                usu.setTipo(rs.getString(6));

            }
        return usu;
    }
    
    public Usuario alterar(Usuario usu) throws SQLException{
        String sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ?, status = ?, tipo = ? WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setString(1,usu.getNome());
        stmt.setString(2,usu.getLogin());
        stmt.setString(3,usu.getSenha());
        stmt.setString(4,usu.getStatus());
        stmt.setString(5,usu.getTipo());
        stmt.setInt(6,usu.getId());

        stmt.execute();
        stmt.close();
        return usu;
    }

    public Usuario excluir(Usuario usu) throws SQLException{
        String sql = "delete from usuarios WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1,usu.getId());

        stmt.execute();
        stmt.close();
        c.close();
        return usu;
    }
    
    public Usuario validarLogin(Usuario usu) throws SQLException{

        String sql = "select * from usuarios WHERE login = ? AND senha = ?";

        PreparedStatement stmt = this.c.prepareStatement(sql);

        stmt.setString(1,usu.getLogin());
        stmt.setString(2,usu.getSenha());

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {      
            usu.setId(rs.getInt(1));
            usu.setNome(rs.getString(2));
            usu.setLogin(rs.getString(3));
            usu.setSenha(rs.getString(4));
            usu.setStatus(rs.getString(5));
            usu.setTipo(rs.getString(6));
        }
        
        stmt.close();
        return usu;
    }
    
    public List<Usuario> listar(Usuario usuEnt) throws SQLException{

        List<Usuario> usus = new ArrayList<>();
        
        String sql = "select * from usuarios where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);

        stmt.setString(1,"%" + usuEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Usuario usu = new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)
            );
            usus.add(usu);
        }
        
        rs.close();
        stmt.close();
        return usus;
    }
    
    public List<Usuario> listarTodos() throws SQLException{

        List<Usuario> usus = new ArrayList<Usuario>();
        
        String sql = "select * from usuarios";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Usuario usu = new Usuario(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6)
            );
            usus.add(usu);
        }
        
        rs.close();
        stmt.close();
        return usus;
        
    }
    
    public Usuario inserir(Usuario usu) throws SQLException{
        String sql = "insert into usuarios" + " (nome, login, senha, status, tipo)" + " values (?,?,?,?,?)";
    
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1,usu.getNome());
        stmt.setString(2,usu.getLogin());
        stmt.setString(3,usu.getSenha());
        stmt.setString(4,usu.getStatus());
        stmt.setString(5,usu.getTipo());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        
        if (rs.next()) {
            int id = rs.getInt(1);
            usu.setId(id);
        }
        
        stmt.close();
        return usu;
    }
}
