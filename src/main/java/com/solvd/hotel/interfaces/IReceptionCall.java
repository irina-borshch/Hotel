package com.solvd.hotel.interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IReceptionCall {
    //final static Logger logger = Logger.getLogger(String.valueOf(IReceptionCall.class))
    static final Logger logger = LogManager.getLogger(IReceptionCall.class);

    default void callToReception() {
        logger.info("You can call to reception using this number: 0800 700 66 55");
    }
}
