package starters.jebl01.alpha.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by jesblo on 16-01-18.
 */
@ConfigurationProperties("alpha")
public class AlphaProperties {
    private String host = "localhost";
    private int port = 1234;

    public String getHost() {
        return host;
    }

    public void setHost(final String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(final int port) {
        this.port = port;
    }
}
