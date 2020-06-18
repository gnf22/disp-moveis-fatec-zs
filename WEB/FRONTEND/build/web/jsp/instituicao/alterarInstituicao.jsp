<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Instituicao"%>
<%@page import="br.com.fatec.controler.ControllerInstituicao"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Instituicao ins = new Instituicao(id,"", "", "");
    ControllerInstituicao insCont = new ControllerInstituicao();
    ins = insCont.buscarInstituicaoPorId(ins);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - INSTITUIÇÃO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR INSTITUIÇÃO</h1>
        <form name="alterarInstituicao" action="validaAlterarInstituicao.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=ins.getNome()%>"> <br>
            Ano de Fundação: <input type="text" name="ANO_FUND" value="<%=ins.getAno_fund()%>"> <br>
            Endereço: <input type="text" name="ENDERECO" value="<%=ins.getEndereco()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=ins.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="CADASTRAR">
        </form>
        <div>
    </body>
</html>