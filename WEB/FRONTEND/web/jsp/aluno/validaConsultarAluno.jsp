<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.bean.Aluno"%>
<%@page import="br.com.fatec.controler.ControllerAluno"%>

<%
    String nome = request.getParameter("NOME");
    Aluno  alu = new Aluno(0,nome,"","","");
    ControllerAluno aluCont = new ControllerAluno();
    List<Aluno> alun = aluCont.listarAluno(alu);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + alu.getNome() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA ALUNOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Sexo">Sexo</th>
                  <th data-field="Idade">Idade</th>
                  <th data-field="CPF">CPF</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(alun.isEmpty())) { %>    
                <tbody>
                    <% for (Aluno listaAluno : alun) { %>
                        <tr>
                            <td><%=listaAluno.getId()%></td>
                            <td><%=listaAluno.getNome()%></td>
                            <td><%=listaAluno.getSexo()%></td>
                            <td><%=listaAluno.getIdade()%></td>
                            <td><%=listaAluno.getCpf()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirAluno.jsp?<%=url + listaAluno.getId()%>">Excluir</a></td>
                                <td><a href="alterarAluno.jsp?<%=url + listaAluno.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>