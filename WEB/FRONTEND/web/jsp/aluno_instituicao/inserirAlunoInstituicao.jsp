<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fatec.bean.Aluno"%>
<%@page import="br.com.fatec.bean.Instituicao"%>

<%@page import="br.com.fatec.controler.ControllerAluno"%>
<%@page import="br.com.fatec.controler.ControllerInstituicao"%>

<% 
    ControllerAluno aluCont = new ControllerAluno();
    List <Aluno> alun = aluCont.listarTodos();
    
    ControllerInstituicao insCont = new ControllerInstituicao();
    List<Instituicao> inst = insCont.listarTodos();
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - ALUNO INSTITUIÇÃO</title>
    <body>
        <div class="container">
            <h1>INSERIR - ALUNO INSTITUIÇÃO</h1>
            <form name="inserirAlunoInstitucaio" action="validaInserirAlunoInstituicao.jsp" method="post">
                <table>
                    <tr>
                        <td>Aluno</td>
                        <td>
                            <select name="ID_ALUNO" class="browser-default">
                                <% for (Aluno alu : alun) { %> 
                                <option value="<%=alu.getId()%>"><%=alu.getNome()%></option>
                                <% }%>
                            </select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Instituição</td>
                        <td>
                            <select name="ID_INSTITUICAO" class="browser-default">
                                <% for (Instituicao ins : inst) { %> 
                                <option value="<%=ins.getId()%>"><%=ins.getNome()%></option>
                                <% }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="CADASTRAR">  <br>
                </table>
            </form>
        </div>
    </body>
</html>