package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {
    public static final Logger logger = LogManager.getLogger(MyLogger.class);

    public static void main(String[] args) {
        logger.info("This is info message!");
        logger.trace("This is trace message!");
        logger.debug("This is debug message!");
        logger.error("This is error message!");
        logger.fatal("This is fatal message!");
    }
}