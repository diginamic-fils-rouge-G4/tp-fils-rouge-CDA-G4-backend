package dev.controller;

import dev.controller.dto.post.PostExportDTO;
import dev.controller.dto.rubrique.RubriqueExportDTO;
import dev.controller.dto.topic.TopicDTO;
import dev.controller.dto.topic.TopicExportDTO;
import dev.controller.dto.topic.TopicModifDTO;
import dev.controller.dto.utilisateur.UtilisateurExportDTO;
import dev.entite.forum.Post;
import dev.entite.forum.Topic;
import dev.service.TopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Controller utilisé pour la gestion des Topics <br/>
 * Utilise le service : {@link dev.service.TopicService}
 */
@CrossOrigin
@RestController
@RequestMapping("topics")
public class TopicCtrl {
    private TopicService topicService;

    public TopicCtrl(TopicService topicService) {
        this.topicService = topicService;
    }

    /**
     * Récupères la totalité des topics
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllTopics(@PathVariable int id) {
        List<Topic> topics = topicService.findByRubriqueId(id);
        TopicExportDTO topicExportDTO;
        List<TopicExportDTO> topicExportDTOList = new ArrayList<>();
        for (Topic topic : topics) {
            List<PostExportDTO> posts = new ArrayList<>();
            PostExportDTO post;
            for (Post topicPost : topic.getPosts()) {
                post = new PostExportDTO();
                post.setContent(topicPost.getContent());
                UtilisateurExportDTO utilisateurExportDTO = new UtilisateurExportDTO();
                utilisateurExportDTO.setId(topicPost.getUtilisateur().getId());
                utilisateurExportDTO.setPrenom(topicPost.getUtilisateur().getPrenom());
                utilisateurExportDTO.setNom(topicPost.getUtilisateur().getNom());
                post.setUtilisateur(utilisateurExportDTO);
                posts.add(post);
            }
            topicExportDTO = new TopicExportDTO();
            topicExportDTO.setId(topic.getId());
            topicExportDTO.setLibelle(topic.getLibelle());
            UtilisateurExportDTO utilisateur = new UtilisateurExportDTO();
            utilisateur.setId(topic.getUtilisateur().getId());
            utilisateur.setNom(topic.getUtilisateur().getNom());
            utilisateur.setPrenom(topic.getUtilisateur().getPrenom());
            utilisateur.setMail(topic.getUtilisateur().getMail());
            topicExportDTO.setUtilisateur(utilisateur);
            if(!posts.isEmpty()) {
                topicExportDTO.setPost(posts);
            }
            topicExportDTOList.add(topicExportDTO);
        }
        if(!topics.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(topicExportDTOList);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("Il n'y a aucun topic d'enregistré");
        }
    }

    /**
     * Créé un topic
     * @param topicDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody TopicDTO topicDTO) {
        Topic topic = topicService.create(topicDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id) {
        Optional<Topic> topicOpt = topicService.findById(id);
        if(topicOpt.isPresent()) {
            TopicExportDTO topic = new TopicExportDTO(topicOpt.get());
            topic.setId(topicOpt.get().getId());
            RubriqueExportDTO rubriqueExportDTO = new RubriqueExportDTO(topicOpt.get().getRubrique());
            topic.setRubrique(rubriqueExportDTO);
            UtilisateurExportDTO utilisateurExportDTO = new UtilisateurExportDTO(topicOpt.get().getUtilisateur());
            topic.setUtilisateur(utilisateurExportDTO);
            topic.setLibelle(topicOpt.get().getLibelle());
            List<PostExportDTO> postExportDTOS = new ArrayList<>();
            for (Post post : topicOpt.get().getPosts()) {
                postExportDTOS.add(new PostExportDTO(post));
            }
            topic.setPost(postExportDTOS);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(topic);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        }
    }

    /**
     * Supprime un
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Topic> topic = topicService.findById(id);
        if (topic.isPresent()) {
            topicService.delete(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    @PatchMapping
    public TopicExportDTO patch(@RequestBody TopicModifDTO modifDTO){
        return new TopicExportDTO(topicService.update(modifDTO));
    }

}
