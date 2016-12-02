package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    protected void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("tex");
    }

    @Override
    public String getServletInfo() {
        return "En servlet for faktura";
    }
}
