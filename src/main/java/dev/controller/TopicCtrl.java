package dev.controller;

import dev.controller.dto.ErrorDTO;
import dev.controller.dto.TopicDTO;
import dev.controller.dto.TopicModifDTO;
import dev.entite.Utilisateur;
import dev.entite.forum.Rubrique;
import dev.entite.forum.Topic;
import dev.service.TopicService;
import dev.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("topics")
public class TopicCtrl {
    private TopicService topicService;
    private UtilisateurService utilisateurService;

    public TopicCtrl(TopicService topicService, UtilisateurService utilisateurService) {
        this.topicService = topicService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTopics() {
        List<Topic> topics = topicService.findAll();
        if(!topics.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(topics);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("Il n'y a aucun topic d'enregistré");
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TopicDTO topicDTO) {
        Topic topic = topicService.create(topicDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Ajout correctement effectué");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Topic> topic = topicService.findById(id);
        if (topic.isPresent()) {
            topicService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping
    public ResponseEntity<?> patch(@RequestBody TopicModifDTO modifDTO){
        Optional<Topic> topic = topicService.findById(modifDTO.getId());
        Optional<Utilisateur> userTopic = utilisateurService.getByid(modifDTO.getUtilisateur());
        Optional<Utilisateur> currentUser = utilisateurService.getByMail(String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal()));
        //On vérifie que l'user courant est bien la même personne qui a créer le topic
        if(String.valueOf(SecurityContextHolder.getContext().getAuthentication().getAuthorities()).equals("ROLE_USER")) {
            if(userTopic.get().getId().equals(currentUser.get().getId())) {
                if (topic.isPresent()) {
                    Topic topicToUpdate = topic.get();
                    topicToUpdate.setLibelle(modifDTO.getLibelle());
                    topicService.update(modifDTO);
                    return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Modification correctement effectué");
                }
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
            } else {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
            }
        } else {
            return ResponseEntity
                .status(HttpStatus.OK)
                .build();
        }
    }
}
