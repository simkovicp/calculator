package cz.simkovicp.calculator.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "log")
public class LogProperties {

    /**
     * The name of the access log cache container
     */
    private String additionCache;

    /**
     * @return the additionCache
     */
    public String getAdditionCache() {
        return additionCache;
    }

    /**
     * @param additionCache
     *            the additionCache to set
     */
    public void setAdditionCache(String additionCache) {
        this.additionCache = additionCache;
    }

}
