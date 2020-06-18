<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.AlunoInstituicao"%>
<%@page import="br.com.fatec.controler.ControllerAlunoInstituicao"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    AlunoInstituicao aluIns = new AlunoInstituicao(id,0,0,"");
    ControllerAlunoInstituicao aluInsCont = new ControllerAlunoInstituicao();
    aluIns = aluInsCont.excluirAlunoInstituicao(aluIns);
    
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validaConsultarAlunoInstituicao.jsp?OBS=" + pbusca;
    response.sendRedirect(url);

%>

