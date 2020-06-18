<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
     <%@include file="../../inc/materalizeWeb.inc" %>
     <head>
        <title>INSERIR - ALUNO</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
     </head>
     <body>
         <div class="container">
             <h1>INSERIR ALUNO</h1>
             <form name="inserirAluno" action="validaInserirAluno.jsp" method="post">
                 Nome: <input type="text" name="NOME" value=""> <br>
                 Sexo: <input type="text" name="SEXO" value=""> <br>
                 Idade: <input type="number" name="IDADE" value=""> <br>
                 CPF: <input type="text" name="CPF" value=""> <br>
                 <input type="submit" name="Enviar" value="CADASTRAR">
             </form>
         </div>
     </body>
</html>
