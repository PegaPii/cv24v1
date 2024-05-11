package fr.univrouen.cv24v1;

import fr.univrouen.cv24v1.model.testDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableJpaRepositories("fr.univrouen.cv24v1.*")
@ComponentScan("fr.univrouen.cv24v1.*")
@EntityScan("fr.univrouen.cv24v1.*") // entities package name
public class Cv24v1Application {


	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Cv24v1Application.class, args);
		Cv24v1Application app = context.getBean(Cv24v1Application.class);
	}

}
