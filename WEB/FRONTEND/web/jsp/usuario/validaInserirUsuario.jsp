<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.controler.ControllerUsuario"%>

<%
    String nome = request.getParameter("NOME");
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    String status = request.getParameter("STATUS");
    String tipo = request.getParameter("TIPO");
    
    String success = "true";
    
    Usuario usu = new Usuario(0,nome,login,senha,status,tipo);
    ControllerUsuario usucont = new ControllerUsuario();
    
    try{
        usu = usucont.inserirUsuario(usu);
    }
    catch(Exception e) {
        out.print(e);
        success = "false";
    }

    String url = "inserirUsuario.jsp?success="+success;
    response.sendRedirect(url);
%>
