<%--
  Created by IntelliJ IDEA.
  User: jensegebergrasmussen
  Date: 01/12/16
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <%@ include file="templates/fragments/headelements.jsp" %>
        <title>Sundebygninger | Velkommen</title>
    </head>

    <body>

    <%@ include file="templates/fragments/navigation.jsp"%>

    <div class="section no-pad-bot" id="index-banner">
        <div class="container">
            <br>
            <br>
            <h1 class="header center grey-text">Sundebygninger</h1>
            <div class="row center">
                <h5 class="header col s12 light">Velkommen til faktura sektionen</h5>
            </div>
            <div class="row center">
                <a href="http://sundebygninger.com:8080" id="download-button" class="btn-large waves-effect waves-light blue">Sundebygninger Platformen</a>
                <p class="grey-text">Denne sektion demonstrerer vores version af kundens platform efterspurgt.</p>
            </div>
            <br>
            <br>
        </div>
    </div>


    <div class="container">
        <div class="section">
            <div class="row">
                <div class="col s12 m4 offset-m4">
                    <div class="icon-block">
                        <h2 class="center blue-text"><i class="material-icons">flash_on</i></h2>
                        <h5 class="center grey-text">Alle fakturaer</h5>
                        <div class="center">
                            <a class="waves-light waves-effect blue btn-large" href="/jsp/invoices/index">Alle faktura</a>
                        </div>
                    </div>
                    <div class="center">
                        <p class="grey-text">Denne sektion af platformen er af demonstrative formål til et skoleprojekt på CPHBusiness.</p>
                        <p class="grey-text">Denne sektion påviser det lærte inden for JSP, HttpServlet, SQL, MVC, Tomcat, MySQL og Linux</p>
                        <p class="grey-text">Vi er gruppe nr. 2</p>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
    </div>

    <%@ include file="templates/fragments/footer.jsp"%>

    <%@ include file="templates/fragments/scripts.jsp" %>

    </body>
</html>
