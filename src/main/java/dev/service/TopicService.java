package dev.service;

import dev.controller.dto.topic.TopicDTO;
import dev.controller.dto.topic.TopicModifDTO;
import dev.entite.Utilisateur;
import dev.entite.forum.Rubrique;
import dev.entite.forum.Topic;
import dev.exception.CreateException;
import dev.repository.TopicRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Service pour les topics
 * Voir {@link dev.controller.TopicCtrl} pour utilisation
 */
@Service
public class TopicService {
    /**
     * Voir {@link dev.repository.TopicRepository}
     */
    private TopicRepository topicRepository;
    /**
     * Voir {@link dev.service.RubriqueService}
     */
    private RubriqueService rubriqueService;
    /**
     * Voir {@link dev.service.UtilisateurService}
     */
    private UtilisateurService utilisateurService;

    public TopicService(TopicRepository topicRepository, RubriqueService rubriqueService, UtilisateurService utilisateurService) {
        this.topicRepository = topicRepository;
        this.rubriqueService = rubriqueService;
        this.utilisateurService = utilisateurService;
    }

    /**
     * Création d'un topic
     * @param topicDTO
     * @return nouveau topic
     */
    public Topic create(@Valid TopicDTO topicDTO) {
        List<String> errMsg = new ArrayList<>();
        Optional<Rubrique> rubrique = rubriqueService.getByid(topicDTO.getRubrique());

        if(rubrique.isEmpty()) {
            errMsg.add("La rubrique " + topicDTO.getRubrique() + " n'existe pas");
        }

        Optional<Utilisateur> utilisateur = utilisateurService.getByMail(topicDTO.getUtilisateur());

        if(utilisateur.isEmpty()) {
            errMsg.add("L'utilisateur " + topicDTO.getUtilisateur() + " n'existe pas");
        }

        if(!errMsg.isEmpty()) {
            throw new CreateException(errMsg);
        }

        Topic topic = new Topic();
        topic.setLibelle(topicDTO.getLibelle());
        topic.setRubrique(rubrique.get());
        topic.setUtilisateur(utilisateur.get());
        return topicRepository.save(topic);
    }

    /**
     * Récupère tout les topics
     * @return liste des topics
     */
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
    /**
     * Récupère un topic en fonction de son ID
     * @param id
     * @return le topic correspondant
     */
    public Optional<Topic> findById(int id){
        return topicRepository.findById(id);
    }
    /**
     * Supprime un topic
     * @param id
     */
    public void delete(int id){
        findById(id).ifPresent(topic ->topicRepository.delete(topic));
    }
    /**
     * Modifie un topic
     * @param topicModifDTO
     * @return le topic modifier
     */
    public Topic update(TopicModifDTO topicModifDTO){
        Optional<Topic> optionalTopic = findById(topicModifDTO.getId());
        Optional<Rubrique> optionalRubrique = rubriqueService.getByid(topicModifDTO.getRubrique());

        if (optionalTopic.isPresent() && optionalRubrique.isPresent()){
            Topic topic = optionalTopic.get();
            topic.setRubrique(optionalRubrique.get());
            topic.setLibelle(topicModifDTO.getLibelle());
            topicRepository.save(topic);
            return topic;
        }
        return null;
    }

    public List<Topic> findByRubriqueId(int id) {
        return topicRepository.findAllByRubriqueId(id);
    }
}
