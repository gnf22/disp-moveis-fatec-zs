package br.com.fatec.db;

import br.com.fatec.bean.AlunoInstituicao;
import br.com.fatec.util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoAlunoInstituicao {
    
    private final Connection c;
    
    public DaoAlunoInstituicao() throws SQLException, ClassNotFoundException{
        this.c = new ConexaoDB().getConnection();
    }
    
    public AlunoInstituicao alterar(AlunoInstituicao aluIns) throws SQLException{
        String sql = "UPDATE aluno_instituicao SET idAlu = ?, idIns = ?, observacao = ? WHERE id = ?";
       
        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1,aluIns.getIdAlu());
        stmt.setInt(2,aluIns.getIdIns());
        stmt.setString(3,aluIns.getObservervacao());
        stmt.setInt(4,aluIns.getIdAluIns());


        stmt.execute();
        stmt.close();
        return aluIns;
    }

    public AlunoInstituicao excluir(AlunoInstituicao aluIns) throws SQLException{
        String sql = "delete from aluno_instituicao WHERE id = ?";

        PreparedStatement stmt = c.prepareStatement(sql);

        stmt.setInt(1,aluIns.getIdAluIns());

        stmt.execute();
        stmt.close();
        c.close();
        return aluIns;
    }


    public AlunoInstituicao inserir(AlunoInstituicao aluIns) throws SQLException{

        String sql = "insert into aluno_instituicao" + " (idAlu, idIns, observacao)" + " values (?,?,?)";

        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1,aluIns.getIdAlu());
        stmt.setInt(2,aluIns.getIdIns());
        stmt.setString(3,aluIns.getObservervacao());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        
        if (rs.next()) {
            int id = rs.getInt(1);
            aluIns.setIdAluIns(id);
        }
        
        stmt.close();
        c.close();
        return aluIns;

    }
    
    public AlunoInstituicao buscar(AlunoInstituicao aluIns) throws SQLException{
        String sql = "select * from aluno_instituicao WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);

            stmt.setInt(1,aluIns.getIdAluIns());

            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {

                aluIns.setIdAluIns(rs.getInt(1));
                aluIns.setIdAlu(rs.getInt(2));
                aluIns.setIdIns(rs.getInt(3));
                aluIns.setObservervacao(rs.getString(4));
            }
            
        return aluIns;
    }
    
    public List<AlunoInstituicao> listar(AlunoInstituicao aluIns) throws SQLException{

        List<AlunoInstituicao> aluInsti = new ArrayList<>();
        
        String sql = "select * from aluno_instituicao where observacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);

        stmt.setString(1,"%" + aluIns.getObservervacao()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            AlunoInstituicao aluninstit = new AlunoInstituicao(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4)
            );

            aluInsti.add(aluninstit);
        }
        
        rs.close();
        stmt.close();
        return aluInsti;
    }
    
}