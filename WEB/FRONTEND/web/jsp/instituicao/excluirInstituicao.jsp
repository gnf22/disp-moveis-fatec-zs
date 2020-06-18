<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Instituicao"%>
<%@page import="br.com.fatec.controler.ControllerInstituicao"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Instituicao ins = new Instituicao(id, "", "", "");
    ControllerInstituicao insCont = new ControllerInstituicao();
    ins = insCont.excluirInstituicao(ins);
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validaConsultarInstituicao.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>