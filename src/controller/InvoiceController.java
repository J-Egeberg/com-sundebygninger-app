package controller;

import dao.DBInvoice;
import model.Invoice;

import java.util.List;

/**
 * Created by jensegebergrasmussen on 30/11/16.
 */
public class InvoiceController {
    public static List<Invoice> getAllInvoices(){
        return DBInvoice.getAllInvoices();
    }
}
