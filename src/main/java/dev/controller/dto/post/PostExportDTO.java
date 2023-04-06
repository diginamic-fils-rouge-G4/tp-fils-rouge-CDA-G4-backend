package dev.controller.dto.post;

import dev.controller.dto.utilisateur.UtilisateurExportDTO;
import dev.entite.forum.Post;

/**
 * DTO utilisé pour envoyer les données de "Post" qui seront afficher au FRONT
 */
public class PostExportDTO {

    /**
     * Utilisateur qui a envoyé le Post
     */
    private UtilisateurExportDTO utilisateur;

    /**
     * Id du post
     */
    private Integer id;

    /**
     * Contenu du Post
     */
    private String content;

    private String createdDate;
    private String updatedDate;

    // Constructor
    public PostExportDTO() {
    }

    public PostExportDTO(Post post) {
        this.id = post.getId();
        this.utilisateur = new UtilisateurExportDTO(post.getUtilisateur());
        this.content = post.getContent();
    }

    public PostExportDTO(Post post, String createdDate, String updatedDate) {
        this.id = post.getId();
        this.utilisateur = new UtilisateurExportDTO(post.getUtilisateur());
        this.content = post.getContent();
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    // Getter & Setter
    public UtilisateurExportDTO getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurExportDTO utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
}
