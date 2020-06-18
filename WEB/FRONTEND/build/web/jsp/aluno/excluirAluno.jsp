<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Aluno"%>
<%@page import="br.com.fatec.controler.ControllerAluno"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Aluno alu = new Aluno(id, "", "", "","");
    ControllerAluno aluCont = new ControllerAluno();
    alu = aluCont.excluirAluno(alu);
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validaConsultarAluno.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>