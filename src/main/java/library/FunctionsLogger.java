package library;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.properties.PropertiesConfigurationBuilder;

import java.util.Properties;

/**
 * @author Aïssa OULAD DAOUD
 */
public class FunctionsLogger {
    protected FunctionsManageFile functionsManageFile = new FunctionsManageFile();
    public Properties log4jProperties = functionsManageFile.readPropertiesFile("log4j2.properties");
    public static Logger logger = LogManager.getLogger(FunctionsLogger.class.getName());
    static String lastError;

    public FunctionsLogger(String logFilePath){
        //log4jProperties.setProperty("log4j.appender.fileAppender.File", logFilePath);
        //PropertyConfigurator.configure(log4jProperties);

        log4jProperties.setProperty("appender.a_rolling.fileName", logFilePath + "_TestAuto.log");
        log4jProperties.setProperty("appender.a_rolling.filePattern", logFilePath + "_TestAuto_%d{yyyy-MM-dd}.log");
        LoggerContext context = (LoggerContext)LogManager.getContext(false);
        Configuration config = new PropertiesConfigurationBuilder().setConfigurationSource(ConfigurationSource.NULL_SOURCE).setRootProperties(log4jProperties) .setLoggerContext(context) .build();
        context.setConfiguration(config);
        Configurator.initialize(config);
    }

    /**
     * Logging of the exception
     * @param e exception
     */
    public static void exceptionLog(Throwable e){
        logError(e.getMessage());
    }

    /**
     * Logging of the exception and the error message
     * @param e exception
     * @param errorMessage error message
     */
    public static void exceptionLog(Throwable e, String errorMessage){
        logError(errorMessage);
        logError(e.getMessage());
    }

    /**
     * Logging of the trace message
     * @param traceMessage trace message
     */
    public static void logTrace(String traceMessage){
        logger.trace(traceMessage);
    }

    /**
     * Logging of the error message
     * @param errorMessage error message
     */
    public static void logError(String errorMessage){
        setLastError(errorMessage);
        logger.error(errorMessage);
    }

    /**
     * Logging of the error message if condition is true
     * @param errorMessage error message
     * @param condition condition
     */
    public static void logError(String errorMessage, boolean condition){
        if(condition) logError(errorMessage);
    }

    /**
     * Logging of the info message
     * @param infoMessage info message
     */
    public static void logInfo(String infoMessage){
        logger.info(infoMessage);
    }

    /**
     * Logging of the info message if condition is true
     * @param infoMessage info message
     * @param condition condition
     */
    public static void logInfo(String infoMessage, boolean condition){
        if(condition) logger.info(infoMessage);
    }

    /**
     * Logging of the :
     * info message if condition is true
     * error message if condition is false
     * @param infoMessage info message
     * @param errorMessage error message
     * @param condition condition
     */
    public static void log(String infoMessage, String errorMessage, boolean condition){
        if(condition) logInfo(infoMessage);
        else  logError(errorMessage);
    }

    /**
     * Get last error logged
     * @return last error logged
     */
    public static String getLastError() {
        return lastError;
    }

    /**
     * Set last error logged
     * @param lastError last error
     */
    public static void setLastError(String lastError) {
        FunctionsLogger.lastError = lastError;
    }
}
