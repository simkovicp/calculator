package cz.simkovicp.calculator.configuration;

import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cz.simkovicp.calculator.OperationLog;

@EnableConfigurationProperties(value = { LogProperties.class })
@Configuration
public class AppConfiguration {

    @Bean
    public OperationLog getAdditionLog(EmbeddedCacheManager manager, LogProperties properties) {
        return new OperationLog(manager.getCache(properties.getAdditionCache()));
    }
    
}
