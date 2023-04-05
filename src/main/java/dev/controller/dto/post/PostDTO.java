package dev.controller.dto.post;

import javax.validation.constraints.NotBlank;

/**
 *  DTO utilisé pour la création de "Post"
 */
public class PostDTO {
    /**
     * Contenu du Post
     */
    @NotBlank
    private String content;
    /**
     * Utilisateur qui a posté le Post
     */
    @NotBlank
    private String utilisateur;
    /**
     * Topic dans lequel se trouve le post
     */
    @NotBlank
    private Integer topic;

    // Constructor
    public PostDTO() {
    }

    // Getter & Setter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Integer getTopic() {
        return topic;
    }

    public void setTopic(Integer topic) {
        this.topic = topic;
    }
}
