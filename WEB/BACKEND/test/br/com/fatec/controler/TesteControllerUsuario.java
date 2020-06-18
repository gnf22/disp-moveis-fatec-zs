package br.com.fatec.controler;

import br.com.fatec.bean.Usuario;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteControllerUsuario {
    
    public TesteControllerUsuario() {
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
    public void testeLogin() throws SQLException, ClassNotFoundException {
          Usuario usu = new Usuario(0,"","BITTENCOURT","ABFABF010101","","");
          ControllerUsuario usucont = new ControllerUsuario();
          usu = usucont.validarUsuario(usu);
          assertEquals("ADM", usu.getTipo());
    }

    @Test
    public void testebuscaUsuario() throws SQLException, ClassNotFoundException {
          Usuario usu = new Usuario(13,"","","","","");
          ControllerUsuario usucont = new ControllerUsuario();
          usu = usucont.buscarUsuario(usu);
          assertEquals("123", usu.getSenha());
    }
}
