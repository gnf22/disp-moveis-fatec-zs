
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="br.com.fatec.bean.Aluno"%>
<%@page import="br.com.fatec.controler.ControllerAluno"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String sexo = request.getParameter("SEXO");
    String idade = request.getParameter("IDADE");
    String cpf = request.getParameter("CPF");
    String pbusca = request.getParameter("PBUSCA");

    Aluno alu = new Aluno(id, nome, sexo, idade, cpf);
    ControllerAluno aluCont = new ControllerAluno();
    alu = aluCont.alterarAluno(alu);

    String url = "validaConsultarAluno.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>