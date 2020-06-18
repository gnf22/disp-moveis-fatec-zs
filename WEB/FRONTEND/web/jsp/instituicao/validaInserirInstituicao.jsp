<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.Instituicao"%>
<%@page import="br.com.fatec.controler.ControllerInstituicao" %>

<% 
    String nome = request.getParameter("NOME");
    String ano_fund = request.getParameter("ANO_FUND");
    String endereco = request.getParameter("ENDERECO");
    Instituicao ins = new Instituicao(0, nome, ano_fund, endereco);
    ControllerInstituicao insCont = new ControllerInstituicao();
    
    String success = "true";
    
    try {
        ins = insCont.inserirInstituicao(ins);
    } catch (Exception e) {
        out.print(e);
        success = "false";
    }
    
    String url = "inserirInstituicao.jsp?success="+success;
    response.sendRedirect(url);
   
%>
