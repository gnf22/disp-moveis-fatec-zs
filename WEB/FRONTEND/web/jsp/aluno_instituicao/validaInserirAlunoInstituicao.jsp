<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.fatec.bean.AlunoInstituicao"%>
<%@page import="br.com.fatec.controler.ControllerAlunoInstituicao"%>

<%
    int idAluno = Integer.parseInt(request.getParameter("ID_ALUNO"));
    int idInstituicao = Integer.parseInt(request.getParameter("ID_INSTITUICAO"));
    String obs = request.getParameter("OBS");
    String success = "true";
    
    AlunoInstituicao aluIns = new AlunoInstituicao(0,idAluno,idInstituicao,obs);
    ControllerAlunoInstituicao aluInsCont = new ControllerAlunoInstituicao();
    
    try{
    aluIns = aluInsCont.inserirAlunoInstituicao(aluIns);
    } catch (Exception e) {
        out.print(e);
        success="false";
    }

    String url = "inserirAlunoInstituicao.jsp?success="+success;
    response.sendRedirect(url);

%>