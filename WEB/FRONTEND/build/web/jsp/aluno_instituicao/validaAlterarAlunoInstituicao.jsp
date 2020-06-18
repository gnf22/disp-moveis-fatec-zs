<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.AlunoInstituicao"%>
<%@page import="br.com.fatec.controler.ControllerAlunoInstituicao"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idAluno = Integer.parseInt(request.getParameter("ID_ALUNO"));
    int idInstituicao = Integer.parseInt(request.getParameter("ID_INSTITUICAO"));
    String obs = request.getParameter("OBS");
    String pbusca = request.getParameter("PBUSCA");
    AlunoInstituicao aluIns = new AlunoInstituicao(id,idAluno,idInstituicao,obs);
    ControllerAlunoInstituicao aluInsCont = new ControllerAlunoInstituicao();
    aluIns = aluInsCont.alterarAlunoInstituicao(aluIns);

    String url = "validaConsultarAlunoInstituicao.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    