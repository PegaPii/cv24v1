package fr.univrouen.cv24v1;

import fr.univrouen.cv24v1.model.testDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan( basePackages = {"fr.univrouen.cv24v1.model"} ) // entities package name
public class Cv24v1Application {


	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Cv24v1Application.class, args);
		Cv24v1Application app = context.getBean(Cv24v1Application.class);
		app.persistTestDBs();
	}

	@Transactional
	public void persistTestDBs() {
		System.out.println("caca");
		for(int i = 0; i < 10; i++){
			testDB test = new testDB();
			entityManager.persist(test);
		}
	}

}
