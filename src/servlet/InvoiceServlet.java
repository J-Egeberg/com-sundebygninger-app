package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by jensegebergrasmussen on 30/11/16.
 */
@WebServlet( name = "InvoiceList", urlPatterns = { "/invoices/index", "/invoices/details", "/invoices/add" } )
public class InvoiceServlet extends HttpServlet{

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        processGet( request, response );
    }

    protected void processGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println( request.getRequestURI() );
        switch (request.getRequestURI()) {
            case "/invoices/index" :
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/invoice/index.jsp");
                requestDispatcher.forward(request, response);
            case "/invoices/add" :
                getServletContext().getRequestDispatcher("/invoice/form.jsp").forward(request, response);
            case "/invoices/details" :
                getServletContext().getRequestDispatcher("/invoice/details.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        processPost( request, response );
    }

    protected void processPost(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public String getServletInfo() {
        return "En servlet for faktura";
    }

}
