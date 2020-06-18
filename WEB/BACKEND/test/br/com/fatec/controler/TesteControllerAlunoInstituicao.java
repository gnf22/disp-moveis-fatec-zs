package br.com.fatec.controler;

import br.com.fatec.bean.AlunoInstituicao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteControllerAlunoInstituicao {
    
    public TesteControllerAlunoInstituicao() {
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
          AlunoInstituicao aluInst = new AlunoInstituicao(1,1,1,"E");
          ControllerAlunoInstituicao contAluIns = new ControllerAlunoInstituicao();
          aluInst = contAluIns.inserirAlunoInstituicao(aluInst);
          
          assertEquals(8, aluInst.getIdAluIns());
    }

    @Test
    public void buscar() throws SQLException, ClassNotFoundException {
          AlunoInstituicao aluInst = new AlunoInstituicao(6,1,1,"");
          ControllerAlunoInstituicao contAluIns = new ControllerAlunoInstituicao();
          aluInst = contAluIns.buscarAlunoInstituicaoPorId(aluInst);
          
          System.out.println("IMPRESSAO TESTE DE BUSCA " + aluInst.toString());
          
          assertEquals(6, aluInst.getIdAluIns());
    }

    @Test
    public void listar() throws SQLException, ClassNotFoundException {
          AlunoInstituicao aluInst = new AlunoInstituicao(6,1,1,"E");
          ControllerAlunoInstituicao contAluIns = new ControllerAlunoInstituicao();
          List<AlunoInstituicao> listaAI = new ArrayList();
          
          
          listaAI = contAluIns.listarAlunoInstituicao(aluInst);
          System.out.println("IMPRESSAO DE TESTE DE LISTA " + listaAI.get(0).toString()) ;

          assertEquals(5, listaAI.get(0).getIdAluIns());
    }
}
