<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.controler.ControllerUsuario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    String status = request.getParameter("STATUS");
    String tipo = request.getParameter("TIPO");
    String pbusca = request.getParameter("PBUSCA");

    Usuario usu = new Usuario(id,nome,login,senha,status,tipo);
    ControllerUsuario usuCont = new ControllerUsuario();
    usu = usuCont.alterarUsuario(usu);

    String url = "validaConsultarUsuario.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>