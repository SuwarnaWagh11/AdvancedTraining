package alltests.apitest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiDemoTest {
    private static final Logger LOG = Logger.getLogger(ApiDemoTest.class.getName());
    @Test
    public void demoTest2(){
        LOG.info("demoTest2");
        Assert.assertTrue(true);
    }
}
