package dev.controller.dto.topic;

import dev.controller.dto.post.PostExportDTO;
import dev.controller.dto.rubrique.RubriqueExportDTO;
import dev.controller.dto.utilisateur.UtilisateurExportDTO;
import dev.entite.forum.Topic;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 *  DTO utilisé pour afficher les données de "Topic" au FRONT
 */
public class TopicExportDTO {
    /**
     * Id du topic
     */
    @NotBlank
    private Integer id;
    /**
     * Libelle du Topic
     */
    @NotBlank
    private String libelle;
    /**
     * Utilisateur qui à créé le Topic
     */
    @NotBlank
    private UtilisateurExportDTO utilisateur;
    /**
     * Les Posts présents dans le topic
     */
    @NotBlank
    private List<PostExportDTO> post;

    @NotBlank
    private RubriqueExportDTO rubrique;

    public TopicExportDTO() {
    }

    public TopicExportDTO(Integer id, String libelle, UtilisateurExportDTO utilisateur, List<PostExportDTO> post) {
        this.id = id;
        this.libelle = libelle;
        this.utilisateur = utilisateur;
        this.post = post;
    }

    public TopicExportDTO(Integer id, String libelle, RubriqueExportDTO rubrique) {
        this.id = id;
        this.libelle = libelle;
        this.rubrique = rubrique;
    }

    public TopicExportDTO(Integer id, String libelle, UtilisateurExportDTO utilisateur, List<PostExportDTO> post, RubriqueExportDTO rubrique) {
        this.id = id;
        this.libelle = libelle;
        this.utilisateur = utilisateur;
        this.post = post;
        this.rubrique = rubrique;
    }

    public TopicExportDTO(Topic update) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public UtilisateurExportDTO getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurExportDTO utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<PostExportDTO> getPost() {
        return post;
    }

    public void setPost(List<PostExportDTO> post) {
        this.post = post;
    }

    public RubriqueExportDTO getRubrique() {
        return rubrique;
    }

    public void setRubrique(RubriqueExportDTO rubrique) {
        this.rubrique = rubrique;
    }
}
