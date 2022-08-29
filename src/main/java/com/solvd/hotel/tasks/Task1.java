package com.solvd.hotel.tasks;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.charset.StandardCharsets;


public class Task1 {
    private static final Logger logger = LogManager.getLogger(Task1.class);

    public static void main(String[] args) {
        count();
    }
    public static void count() {
        try {
            //Task1 stringTask = new Task1();
            File HotelDescription = new File("src/main/resources/HotelDescription.txt");
            String text = FileUtils.readFileToString(HotelDescription, Charsets.toCharset(StandardCharsets.UTF_8));
            logger.info("Amount of counted words - " + StringUtils.countMatches(text, "hotels"));
        } catch (Exception exception) {
            logger.error(exception);
        }
    }
}
