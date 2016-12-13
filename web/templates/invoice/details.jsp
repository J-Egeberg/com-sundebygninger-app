<%--
  Created by IntelliJ IDEA.
  User: jensegebergrasmussen
  Date: 30/11/16
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Invoice" %>
<%@ page import="controller.InvoiceServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <%@ include file="../fragments/headelements.jsp" %>
    <title>Sundebygninger | Velkommen</title>
  </head>

  <body>

    <%@ include file="../fragments/navigation.jsp"%>

    <div class="container">
        <div class="row">
            <%
                Invoice invoice;
                invoice = InvoiceServlet.getOneInvoice();
            %>
            <div class="col s12 l6 offset-l3">
                <table class="bordered highlight">
                    <tbody>
                    <tr>
                        <td>Kunde Adresse</td>
                        <td> <% out.print( invoice.getCustomerAddress() ); %> </td>
                    </tr>
                    <tr>
                        <td>Kunde Fulde navn</td>
                        <td> <% out.print( invoice.getCustomerFullName() ); %> </td>
                    </tr>
                    <tr>
                        <td>Dato</td>
                        <td> <% out.print( invoice.getDate() ); %> </td>
                    </tr>
                    <tr>
                        <td>Medarbejder navn</td>
                        <td> <% out.print( invoice.getEmployeeName() ); %> </td>
                    </tr>
                    <tr>
                        <td>Faktura nummer</td>
                        <td> <% out.print( invoice.getInvoiceNumber() ); %> </td>
                    </tr>
                    <tr>
                        <td>Leverandør navn</td>
                        <td> <% out.print( invoice.getOfficeName() ); %> </td>
                    </tr>
                    <tr>
                        <td>Leverandør adresse</td>
                        <td> <% out.print( invoice.getOfficeAdress() ); %> </td>
                    </tr>
                    <tr>
                        <td>Total pris</td>
                        <td> <% out.print( invoice.getOfficeAdress() ); %> </td>
                    </tr>
                    <tr>
                        <td>Betalingsoplysninger</td>
                        <td> <% out.print( invoice.getPaymentDetails() ); %> </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <%@ include file="../fragments/footer.jsp"%>

    <%@ include file="../fragments/scripts.jsp" %>

  </body>
</html>