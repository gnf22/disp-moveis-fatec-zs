<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Aluno"%>
<%@page import="br.com.fatec.controler.ControllerAluno"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Aluno alu = new Aluno(id,"", "", "", "");
    ControllerAluno aluCont = new ControllerAluno();
    alu = aluCont.buscarAlunoPorId(alu);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR ALUNO</h1>
        <form name="alterarAluno" action="validaAlterarAluno.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=alu.getNome()%>"> <br>
            Sexo: <input type="text" name="SEXO" value="<%=alu.getSexo()%>"> <br>
            Idade: <input type="number" name="IDADE" value="<%=alu.getIdade()%>"> <br>
            Cpf: <input type="text" name="CPF" value="<%=alu.getCpf()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=alu.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="CADASTRAR">
        </form>
        <div>
    </body>
</html>