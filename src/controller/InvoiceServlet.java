package controller;

import data.DBInvoice;
import model.Invoice;
import model.InvoiceLine;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jensegebergrasmussen on 30/11/16.
 */
@WebServlet( name = "InvoiceList", urlPatterns = { "/invoices/*" } )
public class InvoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        processGet( request, response );
    }

    protected void processGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String requestURI = request.getRequestURI();
        String idString = requestURI.substring(requestURI.lastIndexOf('/') + 1);
        RequestDispatcher requestDispatcher;
        if (requestURI.equals("/jsp/invoices/index")) {
            requestDispatcher = getServletContext().getRequestDispatcher("/templates/invoice/index.jsp");
            requestDispatcher.forward(request, response);
        }
        if (requestURI.equals("/jsp/invoices/add")) {
            requestDispatcher = getServletContext().getRequestDispatcher("/templates/invoice/form.jsp");
            requestDispatcher.forward(request, response);
        }
        if (requestURI.contains("/jsp/invoices/") && idString.matches("[0-9]+")) {
            Invoice invoice = getOneInvoice(Long.parseLong(idString));
            List<InvoiceLine> invoiceLines = getInvoiceLinesFromInvoice(Long.parseLong(idString));
            invoice.setInvoiceLines(invoiceLines);
            request.setAttribute("invoice", invoice);
            requestDispatcher = getServletContext().getRequestDispatcher("/templates/invoice/details.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        processPost( request, response );
    }

    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text");
    }

    @Override
    public String getServletInfo() {
        return "En servlet for faktura og dens tilbehør";
    }

    public static List<Invoice> getAllInvoices(){
        return DBInvoice.getAllInvoices();
    }

    public static Invoice getOneInvoice(Long id) {
        return DBInvoice.getOneInvoice(id);
    }

    public static List<InvoiceLine> getInvoiceLinesFromInvoice(Long id) {
        return DBInvoice.getInvoiceLinesFromInvoice(id);
    }
}
