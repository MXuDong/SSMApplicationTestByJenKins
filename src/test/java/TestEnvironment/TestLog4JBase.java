package TestEnvironment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class TestLog4JBase {

    private Logger log = LogManager.getLogger(TestLog4JBase.class);

    @Test
    public void tsetLog(){
        log.info("Test Complete");
    }
}
