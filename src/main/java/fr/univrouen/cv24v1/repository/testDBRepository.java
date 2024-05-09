package fr.univrouen.cv24v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import fr.univrouen.cv24v1.model.testDB;

@EnableJpaRepositories("repository")
@Repository
public interface testDBRepository extends JpaRepository<testDB, Long> {
  List<testDB> findByCaca(String caca);

}
