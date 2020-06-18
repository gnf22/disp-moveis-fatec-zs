package br.com.fatec.controler;

import br.com.fatec.bean.Aluno;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteControllerAluno {
    
    public TesteControllerAluno() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void inserir() throws SQLException, ClassNotFoundException {
          Aluno alu = new Aluno(1, "Gustavo", "Masculino", "20", "111.222.333-44");
          ControllerAluno contAlu = new ControllerAluno();
          alu = contAlu.inserirAluno(alu);
          
          assertEquals("Gustavo", alu.getNome());
    }
    
    @Test
    public void excluir() throws SQLException, ClassNotFoundException {
          Aluno alu = new Aluno(1,"", "", "", "");
          ControllerAluno contAlu = new ControllerAluno();
          alu = contAlu.excluirAluno(alu);
          
          assertEquals(1, alu.getId());
    }
    
    @Test
    public void buscar() throws SQLException, ClassNotFoundException {
          Aluno alu = new Aluno(1,"", "", "", "");
          ControllerAluno contAlu = new ControllerAluno();
          alu = contAlu.buscarAlunoPorId(alu);
          
          assertEquals(1, alu.getId());
    }
    
    @Test
    public void alterar() throws SQLException, ClassNotFoundException {
          Aluno alu = new Aluno(2,"Gustavo", "Masculino", "20", "222.333.444-55");
          ControllerAluno contAlu = new ControllerAluno();
          alu = contAlu.alterarAluno(alu);
          
          assertEquals(2, alu.getId());
    }
}
