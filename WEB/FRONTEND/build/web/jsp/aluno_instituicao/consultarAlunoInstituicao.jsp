<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - ALUNO - INSTITUICAO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR ALUNO - INSTITUICAO</h1>
       <form name="consultarAlunoInstituicao" action="validaConsultarAlunoInstituicao.jsp" method="post">
           Observação: <input type="text" name ="OBS" value=""> <br>
           <input type="submit" name ="Enviar" value="BUSCAR"> <br>
       </form>
       </div>
    </body>
</html>
