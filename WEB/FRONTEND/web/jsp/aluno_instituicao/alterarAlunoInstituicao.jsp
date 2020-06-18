<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.AlunoInstituicao"%>
<%@page import="br.com.fatec.controler.ControllerAlunoInstituicao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fatec.bean.Aluno"%>
<%@page import="br.com.fatec.controler.ControllerAluno"%>
<%@page import="br.com.fatec.bean.Instituicao"%>
<%@page import="br.com.fatec.controler.ControllerInstituicao"%>

<%
    ControllerAluno aluCont = new ControllerAluno();
    List<Aluno> alun = aluCont.listarTodos();

    ControllerInstituicao insCont = new ControllerInstituicao();
    List<Instituicao> inst = insCont.listarTodos();

    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    AlunoInstituicao aluIns = new AlunoInstituicao(id,0,0,"");
    ControllerAlunoInstituicao aluInsCont = new ControllerAlunoInstituicao();
    aluIns = aluInsCont.buscarAlunoInstituicaoPorId(aluIns);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - ALUNO INSTITUIÇÃO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - ALUNO INSTITUIÇÃO</h1>
        <form name="alterarAlunoInstituicao" action="validaAlterarAlunoInstituicao.jsp" method="post">
            <table>
                <tr>
                    <td>Aluno:</td>
                        <td>
                            <select NAME="ID_ALUNO" class="browser-default">
                                <% for (Aluno alu : alun) { %>
                                    <% if( alu.getId() == aluIns.getIdAlu()) { %>
                                        <option selected value="<%=alu.getId()%>"><%=alu.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=alu.getId()%>"><%=alu.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                </tr>
                <tr>
                        <td>Instituicao:</td>
                        <td>
                            <select NAME ="ID_INSTITUICAO" class="browser-default">
                                <% for (Instituicao ins : inst) { %>
                                    <% if( ins.getId()== aluIns.getIdIns()) { %>
                                        <option selected value="<%=ins.getId()%>"><%=ins.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=ins.getId()%>"><%=ins.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="<%=aluIns.getObservervacao()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=aluIns.getIdAluIns()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="CADASTRAR">
        </form>
        <div>
    </body>
</html>