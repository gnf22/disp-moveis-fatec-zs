<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.controler.ControllerUsuario" %>

<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    Usuario usu = new Usuario(0,"",login,senha,"","");
    ControllerUsuario usucont = new ControllerUsuario();
    usu = usucont.validarUsuario(usu);
    session.setAttribute("UsuarioLogado",usu);
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>SISTEMA</title>
    <body>
        <% if (!usu.getStatus().equals("")) { %>
            <!-- Dropdown1 Trigger -->
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Manter Controle de Usuário</a>       
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Manter Controle de Aluno</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Manter Controle de Instituição</a>
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown4'>Manter Controle de Aluno_Instituição</a> 

            <% if (usu.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/inserirUsuario.jsp"> Inserir Usuário </a></li>
                    <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuário </a></li>
                </ul>
                
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../aluno/inserirAluno.jsp"> Inserir Aluno </a></li>
                    <li><a href="../aluno/consultarAluno.jsp"> Consultar Aluno </a></li>
                </ul>
                
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../instituicao/inserirInstituicao.jsp"> Inserir Instituição </a></li>
                    <li><a href="../instituicao/consultarInstituicao.jsp"> Consultar Instituição </a></li>
                </ul>
                
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../aluno_instituicao/inserirAlunoInstituicao.jsp"> Inserir Aluno_Instituição </a></li>
                    <li><a href="../aluno_instituicao/consultarAlunoInstituicao.jsp"> Consultar Aluno_Instituição </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/consultarUsuario.jsp"> Consultar Usuário </a></li>
                </ul>
                
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../aluno/consultarAluno.jsp"> Consultar Aluno </a></li>
                </ul>
                
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../instituicao/consultarInstituicao.jsp"> Consultar Instituição </a></li>
                </ul>
                
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../aluno_instituicao/consultarAlunoInstituicao.jsp"> Consultar Aluno Instituição </a></li>
                </ul>
            <% } %>

            
        <% } else { %>
                <h1>USUÁRIO INVÁLIDO</h1>
        <% } %>
    </body>
</html>
