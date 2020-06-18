<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LOGIN - SISTEMA</title>
    <body>
        <div class="container">
            <div class="content">
                <div id="login">
                    <form name="FORMLOGIN" action="menu.jsp" method="post">
                        <h1>LOGIN</h1>
                        <p>
                            <label for="nome_login">Nome</label>
                            <input id="nome_login" type="text" name="LOGIN">
                        </p>
                        <p>
                            <label for="senha_login">Senha</label>
                            <input id="senha_login" type="password" name="SENHA">
                        </p>
                        <p>
                            <input type="submit" name="ENVIAR" value="Entrar">
                        </p> 
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
