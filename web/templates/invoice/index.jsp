<%--
  Created by IntelliJ IDEA.
  User: jensegebergrasmussen
  Date: 30/11/16
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="controller.InvoiceServlet" %>
<%@ page import="model.Invoice " %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <%@include file="../fragments/headelements.jsp" %>
        <title>Sundebygninger | Velkommen</title>
    </head>

    <body>

    <%@ include file="../fragments/navigation.jsp"%>

    <div class="container">
        <div class="row">
            <h1>Fakturaliste</h1>
            <table class="highlight striped centered">
                <thead>
                    <tr>
                        <th>Fakturanummer</th>
                        <th>Kundenavn</th>
                        <th>Dato</th>
                        <th>Sendt</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Invoice> invoices = InvoiceServlet.getAllInvoices();
                        for (Invoice invoice : invoices) {
                    %>
                        <tr>
                            <td>
                                <a href="/invoices/<% out.print(invoice.getId()); %>"> <% out.print( invoice.getInvoiceNumber() ); %> </a>
                            </td>
                            <td>
                                <a href="/invoices/<% out.print(invoice.getId());%>"> <% out.print( invoice.getCustomerFullName() ); %> </a>
                            </td>
                            <td>
                                <a href="/invoices/<% out.print(invoice.getId());%>"> <% out.print( invoice.getDate() ); %> </a>
                            </td>
                            <td>
                                <a href="/invoices/<% out.print(invoice.getId());%>"> <% out.print( invoice.isSent() ? "Sendt" : "Afventer" ); %> </a>
                            </td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>

    <%@ include file="../fragments/footer.jsp"%>

    <%@ include file="../fragments/scripts.jsp" %>

    </body>
</html>
