package log4j;
import org.apache.logging.log4j.*;

public class log4jTest {

    private static Logger log4jTest = LogManager.getLogger(log4jTest.class.getName());
    public static void main(String[] args) {

        System.out.println("Hello world");
        log4jTest.info("Information Message");
        log4jTest.error("Connection failed");
        log4jTest.warn("Warning message");
        log4jTest.debug("This is debug");
    }
}


//final Logger logger = LogManager.getLogger(...);
//logger.error("ErrorMessage: {}", error.getMessage());
