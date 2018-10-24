package TestEnvironment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestLog4j {

    @Test
    public void testLog4jProperties(){
        Logger logger = LogManager.getLogger();
        logger.error("Hello Log4J");
    }
}
