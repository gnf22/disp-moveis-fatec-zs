<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - ALUNO</title>
    <body>
        <div class="container">
            <h1>CONSULTAR ALUNO</h1>
            <form name="consultarAluno" action="validaConsultarAluno.jsp" method="post">
                Nome: <input type="text" name="NOME" value=""> <br>
                <input type="submit" name="Enviar" value="BUSCAR"> <br>
            </form>
        </div>
    </body>
</html>
