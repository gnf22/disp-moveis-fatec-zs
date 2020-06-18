<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Usuario"%>
<%@page import="br.com.fatec.bean.AlunoInstituicao"%>
<%@page import="br.com.fatec.controler.ControllerAlunoInstituicao"%>

<%
    String obs = request.getParameter("OBS");
    AlunoInstituicao aluIns = new AlunoInstituicao(0,0,0,obs);
    ControllerAlunoInstituicao aluInsCont = new ControllerAlunoInstituicao();
    List<AlunoInstituicao> aluInst = aluInsCont.listarAlunoInstituicao(aluIns);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + aluIns.getObservervacao()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdAluIns">Id</th>
                  <th data-field="idAluno">Id_Aluno</th>
                  <th data-field="NomeAluno">Nome_Aluno</th>
                  <th data-field="IdInstituicao">Id_Instituicao</th>
                  <th data-field="NomeInstituicao">Nome_Instituicao</th>
                  <th data-field="Observacao">Observação</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(aluInst.isEmpty())) { %>    
                <tbody>
                    <% for (AlunoInstituicao listaAlunoInstituicao : aluInst) { %>
                        <tr>
                            <td><%=listaAlunoInstituicao.getIdAluIns()%></td>
                            <td><%=listaAlunoInstituicao.getIdAlu()%></td>
                            <td><%=listaAlunoInstituicao.getAlu().getNome()%></td>
                            <td><%=listaAlunoInstituicao.getIdIns()%></td>
                            <td><%=listaAlunoInstituicao.getIns().getNome()%></td>
                            <td><%=listaAlunoInstituicao.getObservervacao()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirAlunoInstituicao.jsp?<%=url + listaAlunoInstituicao.getIdAluIns()%>">Excluir</a></td>
                                <td><a href="alterarAlunoInstituicao.jsp?<%=url + listaAlunoInstituicao.getIdAluIns()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>