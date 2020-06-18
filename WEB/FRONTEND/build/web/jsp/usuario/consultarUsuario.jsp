<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - USUÁRIO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR USUÁRIO</h1>
       <form name="consultarUsuario" action="validaConsultarUsuario.jsp" method="post">
           Nome: <input type="text" name ="NOME" value=""> <br>
           <input type="submit" name ="Enviar" value="BUSCAR"> <br>
       </form>
       </div>
    </body>
</html>
