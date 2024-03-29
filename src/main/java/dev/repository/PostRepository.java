package dev.repository;

import dev.entite.forum.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface pour les méthodes en lien avec la table post
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByTopicId(int id);
}
