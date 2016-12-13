package controller;

import data.DBInvoice;
import model.Invoice;

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
        switch (request.getRequestURI()) {
            case "/invoices/index" :
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/templates/invoice/index.jsp");
                requestDispatcher.forward(request, response);
            case "/invoices/add" :
                RequestDispatcher requestDispatcher1 = getServletContext().getRequestDispatcher("/templates/invoice/form.jsp");
                requestDispatcher1.forward(request, response);
            case "/invoices/1" :
                RequestDispatcher requestDispatcher2 = getServletContext().getRequestDispatcher("/templates/invoice/details.jsp");
                requestDispatcher2.forward(request, response);
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
        return "En servlet for faktura";
    }

    public static List<Invoice> getAllInvoices(){
        return DBInvoice.getAllInvoices();
    }

    public static Invoice getOneInvoice() {
        return DBInvoice.getOneInvoice(1L);
    }


}
