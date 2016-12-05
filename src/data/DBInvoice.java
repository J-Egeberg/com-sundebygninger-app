package data;

import model.Invoice;

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
        String sqlStatement = "SELECT * FROM invoice";
        List<Invoice> invoices = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection("test-js-mac");
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
                invoice.setSent(resultSet.getBoolean("isSent"));
                invoices.add(invoice);
            }

        } catch (SQLException | ClassNotFoundException exception) {
            System.out.printf( "\n\nIn DBInvoice, couldn't do: %s\n\n", exception.getMessage() );
            exception.printStackTrace();
        }

        return invoices;
    }

}
