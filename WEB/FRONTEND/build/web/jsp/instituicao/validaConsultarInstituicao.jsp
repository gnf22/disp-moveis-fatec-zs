<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.bean.Instituicao"%>
<%@page import="br.com.fatec.controler.ControllerInstituicao"%>

<%
    String nome = request.getParameter("NOME");
    Instituicao  ins = new Instituicao(0,nome,"","");
    ControllerInstituicao insCont = new ControllerInstituicao();
    List<Instituicao> inst = insCont.listarInstituicao(ins);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + ins.getNome() +"&ID=" ;
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
                  <th data-field="Ano de Fundação">Ano de Fundação</th>
                  <th data-field="Endereço">Endereço</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(inst.isEmpty())) { %>    
                <tbody>
                    <% for (Instituicao listaInstituicao : inst) { %>
                        <tr>
                            <td><%=listaInstituicao.getId()%></td>
                            <td><%=listaInstituicao.getNome()%></td>
                            <td><%=listaInstituicao.getAno_fund()%></td>
                            <td><%=listaInstituicao.getEndereco()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirInstituicao.jsp?<%=url + listaInstituicao.getId()%>">Excluir</a></td>
                                <td><a href="alterarInstituicao.jsp?<%=url + listaInstituicao.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>