<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="br.com.fatec.bean.Aluno"%>
<%@page import="br.com.fatec.controler.ControllerAluno" %>

<% 
    String nome = request.getParameter("NOME");
    String sexo = request.getParameter("SEXO");
    String idade = request.getParameter("IDADE");
    String cpf = request.getParameter("CPF");
    Aluno alu = new Aluno(0, nome, sexo, idade, cpf);
    ControllerAluno aluCont = new ControllerAluno();
    
    String success = "true";
    
    try{
        alu = aluCont.inserirAluno(alu);
    }
    catch(Exception e) {
        out.print(e);
        success = "false";
    }
    
    String url = "inserirAluno.jsp?success="+success;
    response.sendRedirect(url);
%>