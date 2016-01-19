package jebl01.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import jebl01.service.ArticleService;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages(true, ArticleService.class.getPackage().getName());
    }
}
