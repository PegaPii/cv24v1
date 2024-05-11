package fr.univrouen.cv24v1.repository;

import fr.univrouen.cv24v1.model.Identite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface identiteRepository extends JpaRepository<Identite, Long> {
    Identite findByGenreAndNomAndPrenomAndTel(String genre, String nom, String prenom, String tel);
}
