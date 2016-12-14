<%--
  Created by IntelliJ IDEA.
  User: jensegebergrasmussen
  Date: 30/11/16
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="model.Invoice" %>
<%@ page import="controller.InvoiceServlet" %>
<%@ page import="model.InvoiceLine" %>
<%@ page import="java.util.List" %>
<%@ page import="data.DBInvoice" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="invoice" scope="request" class="model.Invoice" />
<html lang="en">
  <head>
    <%@ include file="../fragments/headelements.jsp" %>
    <title>Sundebygninger | Velkommen</title>
  </head>

  <body>

    <%@ include file="../fragments/navigation.jsp"%>

    <div class="container">
        <div class="row">
            <div class="col s12 center-align">
                <h2>Faktura detaljer</h2>
            </div>
        </div>
        <div class="divider"></div>
        <div class="row">
            <div class="col s12 l6 offset-l3">
                <br>
                <br>
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
                    <tr class="divider"></tr>
                    <tr>
                        <td>Total pris</td>
                        <td> <% out.print( invoice.getTotalPrice() ); %> </td>
                    </tr>
                    <tr>
                        <td>Betalingsoplysninger</td>
                        <td> <% out.print( invoice.getPaymentDetails() ); %> </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col s12">
                <h4>Faktura linjer</h4>
            </div>
        </div>
        <div class="divider"></div>
        <div class="row">
            <div class="col s12">
                <table class="bordered highlight">
                    <thead>
                        <tr>
                            <th>Produkt nr.</th>
                            <th>Beskrivelse</th>
                            <th>Mængde</th>
                            <th>Pris pr.</th>
                            <th>Enhed</th>
                            <th>Pris</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        List<InvoiceLine> invoiceLineList = DBInvoice.getInvoiceLinesFromInvoice(invoice.getId());
                        for (InvoiceLine invoiceLine : invoiceLineList
                                ) {
                    %>
                    <tr>
                        <td> <% out.print( invoiceLine.getProductNumber() ); %> </td>
                        <td> <% out.print( invoiceLine.getDescription() ); %> </td>
                        <td> <% out.print( invoiceLine.getAmount() ); %> </td>
                        <td> <% out.print( invoiceLine.getPricePerUnit() ); %> </td>
                        <td> <% out.print( invoiceLine.getUnit() ); %> </td>
                        <td> <% out.print( invoiceLine.getPrice() ); %> </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <%@ include file="../fragments/footer.jsp"%>

    <%@ include file="../fragments/scripts.jsp" %>

  </body>
</html>