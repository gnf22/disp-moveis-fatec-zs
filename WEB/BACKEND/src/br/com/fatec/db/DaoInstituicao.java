package br.com.fatec.db;

import br.com.fatec.util.ConexaoDB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import br.com.fatec.bean.Instituicao;
import java.sql.Statement;

public class DaoInstituicao {

    private final Connection c;
    
    public DaoInstituicao() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    
    public Instituicao buscar(Instituicao ins) throws SQLException{
        String sql = "select * from instituicao WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);

            stmt.setInt(1,ins.getId());

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {         
                ins.setId(rs.getInt(1));
                ins.setNome(rs.getString(2));
                ins.setAno_fund(rs.getString(3));
                ins.setEndereco(rs.getString(4));
            }
            
        stmt.close();
        c.close();
        return ins;
    }
    
    public Instituicao alterar(Instituicao ins) throws SQLException{
        String sql = "UPDATE instituicao SET nome = ?, ano_fund = ?, endereco = ? WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setString(1,ins.getNome());
        stmt.setString(2,ins.getAno_fund());
        stmt.setString(3,ins.getEndereco());
        stmt.setInt(4,ins.getId());

        stmt.execute();
        stmt.close();
        return ins;
    }

    public Instituicao excluir(Instituicao ins) throws SQLException{
        String sql = "delete from instituicao WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1,ins.getId());

        stmt.execute();
        stmt.close();
        c.close();
        return ins;
    }
    
        public Instituicao inserir(Instituicao ins) throws SQLException{
        String sql = "insert into instituicao" + " (nome, ano_fund, endereco)" + " values (?,?,?)";
    
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setString(1,ins.getNome());
        stmt.setString(2,ins.getAno_fund());
        stmt.setString(3,ins.getEndereco());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        
        if (rs.next()) {
            int id = rs.getInt(1);
            ins.setId(id);
        }
        
        stmt.close();
        c.close();
        return ins;
    }
    
    
    public List<Instituicao> listar(Instituicao insEnt) throws SQLException{

        List<Instituicao> inss = new ArrayList<>();
        
        String sql = "select * from instituicao where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);

        stmt.setString(1,"%" + insEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Instituicao ins = new Instituicao(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            );
        inss.add(ins);
        }
        
        rs.close();
        stmt.close();
        return inss;
        
    }
    
    public List<Instituicao> listarTodos() throws SQLException {
    
        List<Instituicao> inst = new ArrayList<>();
        String sql = "select * from instituicao";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            Instituicao ins = new Instituicao(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));      
            inst.add(ins);
        }
    
        rs.close();
        stmt.close();
        return inst;
    }
}
