package sv.com.eshop.infrastructure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitPostProcessor;

@Configuration(proxyBeanMethods = false)
public class JpaConfig {

    @Bean
    public PersistenceUnitPostProcessor infrastructureMappingPostProcessor() {
        return (pui) -> {
            // Estos archivos se buscarán dentro del JAR de infraestructura
            pui.addMappingFileName("mappings/catalog.orm.xml");
            pui.addMappingFileName("mappings/basket.orm.xml");
        };
    }
}
