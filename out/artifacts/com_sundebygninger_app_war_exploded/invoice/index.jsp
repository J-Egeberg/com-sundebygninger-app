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
        <title>Title</title>
    </head>
    <body>
    <h1>Fakturaliste</h1>
        <table>
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
                                <td> <% out.print( invoice.getInvoiceNumber() ); %> </td>
                                <td> <% out.print( invoice.getCustomerFullName() ); %> </td>
                                <td> <% out.print( invoice.getDate() );%> </td>
                                <td> <% out.print( invoice.isSent() ? "Sendt" : "Afventer" ); %> </td>
                            </tr>
                        <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
