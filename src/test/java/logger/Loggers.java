package logger;

import org.openqa.selenium.logging.Logs;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loggers {
    static Logger logger = Logger.getLogger(Logs.class.getName());
    static Handler consoleHandler = new java.util.logging.ConsoleHandler();

    public static void addHandler() {
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warning(message);
    }

    public static void severe(String message) {
        logger.severe(message);
    }

    public static void config(String message) {
        logger.config(message);
    }

    public static void fine(String message) {
        logger.fine(message);
    }

    public static void finest(String message) {
        logger.finest(message);
    }
}
