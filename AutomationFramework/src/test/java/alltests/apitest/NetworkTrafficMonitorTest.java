package alltests.apitest;


import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;



import java.io.IOException;

public class NetworkTrafficMonitorTest {

    private static final Logger LOG = Logger.getLogger(NetworkTrafficMonitorTest.class.getName());


    @Test
    public void monitorEPAMTraffic() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet req = new HttpGet("https://reportportal.epam.com/");
        HttpClientContext hcc = HttpClientContext.create();
        HttpResponse res = client.execute(req, hcc);
        HttpConnectionMetrics metrics = hcc.getConnection().getMetrics();
        EntityUtils.consumeQuietly(res.getEntity());
        LOG.debug("sent: {}"+metrics.getSentBytesCount());
        LOG.debug("recv: {}"+metrics.getReceivedBytesCount());
        LOG.debug("reqcnt: {}"+metrics.getRequestCount());
        LOG.debug("rescnt: {}"+metrics.getResponseCount());
    }
}
