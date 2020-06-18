
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="br.com.fatec.bean.Instituicao"%>
<%@page import="br.com.fatec.controler.ControllerInstituicao"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String ano_fund = request.getParameter("ANO_FUND");
    String endereco = request.getParameter("ENDERECO");
    String pbusca = request.getParameter("PBUSCA");

    Instituicao ins = new Instituicao(id, nome, ano_fund, endereco);
    ControllerInstituicao insCont = new ControllerInstituicao();
    ins = insCont.alterarInstituicao(ins);

    String url = "validaConsultarInstituicao.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>