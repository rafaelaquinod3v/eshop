package sv.com.eshop.infrastructure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class JpaMappingPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LocalContainerEntityManagerFactoryBean factoryBean) {
            // Añades tus archivos sin borrar lo que Spring ya configuró
            factoryBean.setMappingResources(
                "mappings/catalog.orm.xml", 
                "mappings/basket.orm.xml",
                "mappings/buyer.orm.xml",
                "mappings/order.orm.xml"
            );
        }
        return bean;
    } 
}
