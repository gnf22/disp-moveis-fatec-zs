<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - INSTITUIÇÃO</title>
    <body>
        <div class="container">
            <h1>CONSULTAR INSTITUIÇÃO</h1>
            <form name="consultarInstituicao" action="validaConsultarInstituicao.jsp" method="post">
                Nome: <input type="text" name="NOME" value=""> <br>
                <input type="submit" name="Enviar" value="BUSCAR"> <br>
            </form>
        </div>
    </body>
</html>
