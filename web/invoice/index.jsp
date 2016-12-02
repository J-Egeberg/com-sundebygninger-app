<%@ page import="controller.InvoiceController" %>
<%@ page import="model.Invoice " %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: jensegebergrasmussen
  Date: 30/11/16
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Alle fakturaer</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <h1>Fakturaliste</h1>
        <table class="tableSubHeadingColor">
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
                    List<Invoice> invoices = InvoiceController.getAllInvoices();
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
                                    <a href="/invoices/<% out.print(invoice.getId());%>"> <% out.print( invoice.getCustomerFullName() ); %> </a>
                                </td>
                                <td>
                                    <a href="/invoices/<%out.print(invoice.getId());%>"> <% out.print( invoice.isSent() ? "Sendt" : "Afventer" ); %> </a>
                                </td>
                            </tr>
                        <%
                    }
                %>
            </tbody>
        </table>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    </body>
</html>
