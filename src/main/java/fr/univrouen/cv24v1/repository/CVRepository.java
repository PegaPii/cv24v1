package fr.univrouen.cv24v1.repository;

import fr.univrouen.cv24.model.CV;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CVRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(CV cv) {
        entityManager.persist(cv);
    }

    @Transactional
    public CV findById(Long id) {
        return entityManager.find(CV.class, id);
    }

    @Transactional
    public void update(CV cv) {
        entityManager.merge(cv);
    }

    @Transactional
    public void delete(CV cv) {
        entityManager.remove(entityManager.contains(cv) ? cv : entityManager.merge(cv));
    }
}

