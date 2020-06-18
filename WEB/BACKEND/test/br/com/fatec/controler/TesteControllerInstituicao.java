package br.com.fatec.controler;

import br.com.fatec.bean.Instituicao;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteControllerInstituicao {
    
    public TesteControllerInstituicao() {
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
          Instituicao ins = new Instituicao(1, "Fatec", "B", "C");
          ControllerInstituicao contIns = new ControllerInstituicao();
          ins = contIns.inserirInstituicao(ins);
          
          assertEquals("Fatec", ins.getNome());
    }
    
    @Test
    public void excluir() throws SQLException, ClassNotFoundException {
          Instituicao ins = new Instituicao(3,"", "", "");
          ControllerInstituicao contIns = new ControllerInstituicao();
          ins = contIns.excluirInstituicao(ins);
          
          assertEquals(3, ins.getId());
    }
    
    @Test
    public void buscar() throws SQLException, ClassNotFoundException {
          Instituicao ins = new Instituicao(1,"", "", "");
          ControllerInstituicao contIns = new ControllerInstituicao();
          ins = contIns.buscarInstituicaoPorId(ins);
          assertEquals(1, ins.getId());
    }
    
    @Test
    public void alterar() throws SQLException, ClassNotFoundException {
          Instituicao ins = new Instituicao(3,"Impacta test", "", "");
          ControllerInstituicao contIns = new ControllerInstituicao();
          ins = contIns.alterarInstituicao(ins);
          
          assertEquals(3, ins.getId());
    }
}
