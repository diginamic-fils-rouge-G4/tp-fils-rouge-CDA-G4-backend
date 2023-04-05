package dev.service;

import dev.controller.dto.post.PostDTO;
import dev.controller.dto.post.PostUpdateDTO;
import dev.entite.Utilisateur;
import dev.entite.forum.Post;
import dev.entite.forum.Topic;
import dev.exception.CreateException;
import dev.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Service pour les posts
 * Voir {@link dev.controller.PostCtrl} pour utilisation
 */
@Service
public class PostService {
    /**
     * Voir {@link dev.repository.PostRepository}
     */
    private PostRepository postRepository;
    /**
     * Voir {@link dev.service.UtilisateurService}
     */
    private UtilisateurService utilisateurService;
    /**
     * Voir {@link dev.service.TopicService}
     */
    private TopicService topicService;

    public PostService(PostRepository postRepository, UtilisateurService utilisateurService, TopicService topicService) {
        this.postRepository = postRepository;
        this.utilisateurService = utilisateurService;
        this.topicService = topicService;
    }

    /**
     * Création d'un post
     * @param postDTO
     * @return nouveau Post
     */
    public Post create(@Valid PostDTO postDTO) {
        List<String> errMsg = new ArrayList<>();
        Optional<Topic> topic = topicService.findById(postDTO.getTopic());

        if(topic.isEmpty()) {
            errMsg.add("Le topic " + topicService.findById(postDTO.getTopic()) + " n'existe pas");
        }

        Optional<Utilisateur> utilisateur = utilisateurService.getByMail(postDTO.getUtilisateur());

        if(utilisateur.isEmpty()) {
            errMsg.add("L'utilisateur " + utilisateurService.getByMail(postDTO.getUtilisateur()) + " n'existe pas");
        }

        if(!errMsg.isEmpty()) {
            throw new CreateException(errMsg);
        }

        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setUtilisateur(utilisateur.get());
        post.setTopic(topic.get());
        post.setCreatedDate(LocalDateTime.now());
        post.setUpdatedDate(LocalDateTime.now());
        return postRepository.save(post);
    }

    /**
     * Récupère tout les posts
     * @return liste de tout les posts
     */
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    /**
     * Récupère un post en fonction de son ID
     * @param id
     * @return le post correspondant
     */
    public Optional<Post> findById(Integer id) {
        return postRepository.findById(id);
    }

    /**
     * Supprimer un post
     * @param id
     */
    public void delete(Integer id) {
        Optional<Post> post = findById(id);
        post.ifPresent(value -> postRepository.delete(value));
    }

    public List<Post> findAllByTopicId(int id) {
        return postRepository.findByTopicId(id);
    }

    public Post update(PostUpdateDTO postDTO) {
        Optional<Post> postOpt = findById(postDTO.getId());
        if(postOpt.isPresent()) {
            Post post = postOpt.get();
            post.setContent(postDTO.getContent());
            postRepository.save(post);
            return post;
        }
        return null;
    }
}
