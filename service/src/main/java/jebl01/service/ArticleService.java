package jebl01.service;

import com.codahale.metrics.MetricRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Collections;
import java.util.Map;

@Component
@Path("/")
public class ArticleService {

    private final MetricRegistry metricRegistry;

    @Autowired
    public ArticleService(MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
    }

    @GET
    @Path("{name}")
    @Produces("application/json")
    public Map<String, String> hello(@PathParam("name") String name) {
        metricRegistry.counter("requests").inc();
        return Collections.singletonMap("name", name);
    }
}
