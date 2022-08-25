package com.solvd.hotel.invoice;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.apache.commons.io.FileUtils.getFile;

public class InvoiceDetails {
    private final static Logger logger = LogManager.getLogger(InvoiceDetails.class);

    public static void invoiceDetails() {

        try {
            File paymentDetails = getFile("src/main/resources/payment.txt");
            String invoice = FileUtils.readFileToString(paymentDetails, Charsets.toCharset(StandardCharsets.UTF_8));
            logger.info("The information about invoice: " + "\n" + invoice);
        } catch (Exception exception) {
            logger.error(exception);
        }
    }
}
