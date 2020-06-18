package br.com.fatec.db;

import br.com.fatec.util.ConexaoDB;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import br.com.fatec.bean.Aluno;
import java.sql.Statement;

public class DaoAluno {

    private final Connection c;
    
    public DaoAluno() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    
    public Aluno buscar(Aluno alu) throws SQLException{
        String sql = "select * from aluno WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setInt(1,alu.getId());
        ResultSet rs = stmt.executeQuery();
            
        while (rs.next()) {
            alu.setId(rs.getInt(1));
            alu.setNome(rs.getString(2));
            alu.setSexo(rs.getString(3));
            alu.setIdade(rs.getString(4));
            alu.setCpf(rs.getString(5));
        }
            
        stmt.close();
        c.close();
        return alu;
    }
    
    public Aluno alterar(Aluno alu) throws SQLException{
        String sql = "UPDATE aluno SET nome = ?, sexo = ?, idade = ?, cpf = ? WHERE id = ?";
        
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setString(1,alu.getNome());
        stmt.setString(2,alu.getSexo());
        stmt.setString(3,alu.getIdade());
        stmt.setString(4,alu.getCpf());
        stmt.setInt(5,alu.getId());

        stmt.execute();
        stmt.close();
        return alu;
    }

    public Aluno excluir(Aluno alu) throws SQLException{
        String sql = "delete from aluno WHERE id = ?";
        
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setInt(1,alu.getId());
        
        stmt.execute();
        stmt.close();
        c.close();
        return alu;
    }
    
        public Aluno inserir(Aluno alu) throws SQLException{
            String sql = "insert into aluno" + " (nome, sexo, idade, cpf)" + " values (?,?,?,?)";

            PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1,alu.getNome());
            stmt.setString(2,alu.getSexo());
            stmt.setString(3,alu.getIdade());
            stmt.setString(4,alu.getCpf());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next()) {
                int id = rs.getInt(1);
                alu.setId(id);
            }

            stmt.close();
            c.close();
            return alu;
    }
    
    
    public List<Aluno> listar(Aluno aluEnt) throws SQLException{

        List<Aluno> alus = new ArrayList<>();
        
        String sql = "select * from aluno where nome like ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);

        stmt.setString(1,"%" + aluEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Aluno alu = new Aluno(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            alus.add(alu);
        }
        
        rs.close();
        stmt.close();
        return alus;
    }
    
    public List<Aluno> listarTodos() throws SQLException {
        List<Aluno> alun = new ArrayList<>();

        String sql = "select * from aluno";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            Aluno alu = new Aluno(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            alun.add(alu);
        }

        rs.close();
        stmt.close();
        return alun;
    }
}
