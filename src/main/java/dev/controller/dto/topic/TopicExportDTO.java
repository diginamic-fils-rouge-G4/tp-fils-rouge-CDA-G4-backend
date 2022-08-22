package dev.controller.dto.topic;

import dev.controller.dto.post.PostExportDTO;
import dev.controller.dto.utilisateur.UtilisateurExportDTO;

import javax.validation.constraints.NotBlank;

// Objet reçu par le front
public class TopicExportDTO {
    @NotBlank
    public Integer id;
    @NotBlank
    public String libelle;
    @NotBlank
    public UtilisateurExportDTO utilisateur;
    @NotBlank
    public PostExportDTO post;

    public TopicExportDTO() {
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

    public PostExportDTO getPost() {
        return post;
    }

    public void setPost(PostExportDTO post) {
        this.post = post;
    }
}
