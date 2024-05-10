package fr.univrouen.cv24v1.repository;

import fr.univrouen.cv24v1.model.cv24;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends JpaRepository<cv24, Long> {

    cv24 findByGenreAndNomAndPrenomAndTel(String genre, String nom, String prenom, String tel);

}

