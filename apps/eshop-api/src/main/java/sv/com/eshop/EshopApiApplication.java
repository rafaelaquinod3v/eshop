package sv.com.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// USAR ESTA RUTA SI ES NECESARIO EXCLUIR:
//@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class })
public class EshopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EshopApiApplication.class, args);
	}

}
