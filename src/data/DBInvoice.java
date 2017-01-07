package data;

import model.Invoice;
import model.InvoiceLine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jensegebergrasmussen on 30/11/16.
 */
public class DBInvoice {

    public static List<Invoice> getAllInvoices(){
        String sqlStatement = "SELECT * FROM Invoice";
        List<Invoice> invoices = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection("test");
             Statement statement = connection.createStatement() ) {
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                Invoice invoice = new Invoice();
                invoice.setId( resultSet.getLong("id") );
                invoice.setCustomerFullName(resultSet.getString("customerFullName"));
                invoice.setCustomerAddress(resultSet.getString("customerAddress"));
                invoice.setEmployeeName(resultSet.getString("employeeName"));
                invoice.setOfficeName(resultSet.getString("officeName"));
                invoice.setOfficeAdress(resultSet.getString("officeAdress"));
                invoice.setDate(resultSet.getString("date"));
                invoice.setPaymentDetails(resultSet.getString("paymentDetails"));
                invoice.setTotalPrice(resultSet.getInt("totalPrice"));
                invoice.setInvoiceNumber(resultSet.getString("invoiceNumber"));
                invoice.setSent(resultSet.getBoolean("sent"));
                invoices.add(invoice);
            }
        } catch (SQLException | ClassNotFoundException | ConnectionProfileNotFoundException exception) {
            System.out.printf( "\n\nIn DBInvoice, couldn't do: %s\n\n", exception.getMessage() );
            exception.printStackTrace();
        }
        return invoices;
    }

    public static Invoice getOneInvoice(Long id) {
        String sqlStatement = String.format("SELECT * FROM Invoice WHERE id = %s", String.valueOf(id));
        List<Invoice> invoices = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection("test");
             Statement statement = connection.createStatement() ) {
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                Invoice invoice = new Invoice();
                invoice.setId( resultSet.getLong("id") );
                invoice.setCustomerFullName(resultSet.getString("customerFullName"));
                invoice.setCustomerAddress(resultSet.getString("customerAddress"));
                invoice.setEmployeeName(resultSet.getString("employeeName"));
                invoice.setOfficeName(resultSet.getString("officeName"));
                invoice.setOfficeAdress(resultSet.getString("officeAdress"));
                invoice.setDate(resultSet.getString("date"));
                invoice.setPaymentDetails(resultSet.getString("paymentDetails"));
                invoice.setTotalPrice(resultSet.getInt("totalPrice"));
                invoice.setInvoiceNumber(resultSet.getString("invoiceNumber"));
                invoice.setSent(resultSet.getBoolean("sent"));
                invoices.add(invoice);
            }
        } catch (SQLException | ClassNotFoundException | ConnectionProfileNotFoundException exception) {
            System.out.printf( "\n\nIn DBInvoice, couldn't do: %s\n\n", exception.getMessage() );
            exception.printStackTrace();
        }
        return invoices.get(0);
    }

    public static List<InvoiceLine> getInvoiceLinesFromInvoice(Long invoiceId) {
        String sqlStatement = String.format("SELECT * FROM InvoiceLine WHERE invoice_id=%s",String.valueOf(invoiceId) );
        System.out.printf("\n\n%s\n\n",sqlStatement);
        List<InvoiceLine> invoicesLines = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection("test");
             Statement statement = connection.createStatement() ) {
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                InvoiceLine invoiceLine = new InvoiceLine();
                invoiceLine.setId( resultSet.getLong("id") );
                invoiceLine.setAmount(resultSet.getInt("amount"));
                invoiceLine.setDescription(resultSet.getString("description"));
                invoiceLine.setPrice(resultSet.getInt("price"));
                invoiceLine.setPricePerUnit(resultSet.getInt("pricePerUnit"));
                invoiceLine.setProductNumber(resultSet.getInt("productNumber"));
                invoiceLine.setUnit(resultSet.getString("unit"));
                invoicesLines.add(invoiceLine);
            }
        } catch (SQLException | ClassNotFoundException | ConnectionProfileNotFoundException exception) {
            System.out.printf( "\n\nIn DBInvoice, couldn't do: %s\n\n", exception.getMessage() );
            exception.printStackTrace();
        }
        return invoicesLines;
    }
}
