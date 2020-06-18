<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - INSTITUIÇÃO</title>
    <body>
        <div class="container">
            <h1>INSERIR INSTITUIÇÃO</h1>
            <form name="inserirInstituicao" action="validaInserirInstituicao.jsp" method="post">
                Nome: <input type="text" name="NOME" value=""> <br>
                Ano de Fundação: <input type="number" name="ANO_FUND" value=""<br>
                Endereço: <input type="text" name="ENDERECO" value="">
                <input type="submit" name="Enviar" value="CADASTRAR">
            </form>
        </div>
    </body>
</html>
