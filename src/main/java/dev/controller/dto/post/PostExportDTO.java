package dev.controller.dto.post;

import dev.controller.dto.topic.TopicExportDTO;
import dev.controller.dto.utilisateur.UtilisateurExportDTO;
import dev.entite.forum.Post;

import java.time.LocalDateTime;
import java.util.Date;

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

    private Date created_date;
    private Date updated_date;

    // Constructor
    public PostExportDTO() {
    }

    public PostExportDTO(Post post) {
        this.id = post.getId();
        this.utilisateur = new UtilisateurExportDTO(post.getUtilisateur());
        this.content = post.getContent();
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

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }
}
