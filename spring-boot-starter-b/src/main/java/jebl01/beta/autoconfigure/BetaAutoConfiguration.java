package jebl01.beta.autoconfigure;

import com.codahale.metrics.MetricRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.MetricsDropwizardAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;

/**
 * Created by jesblo on 16-01-18.
 */
@Configuration
@AutoConfigureAfter(MetricsDropwizardAutoConfiguration.class)
@ConditionalOnBean(MetricRegistry.class)
@EnableConfigurationProperties(BetaProperties.class)
@ConditionalOnProperty(prefix = "beta", value = {"host", "port"})
public class BetaAutoConfiguration {
    @Autowired
    private MetricRegistry metricRegistry;
    @Autowired
    private BetaProperties properties;

    @PostConstruct
    public void wireStuff() throws URISyntaxException {
        System.err.println("*********************************************");
        System.err.println("post construct: " + getClass().getSimpleName());
        System.err.println("got properties: ");
        System.err.println("  host: " + properties.getHost());
        System.err.println("  port: " + properties.getPort());
        System.err.println("*********************************************");
    }
}
