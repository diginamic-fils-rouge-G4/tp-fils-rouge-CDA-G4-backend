package dev.controller.dto;

import javax.validation.constraints.NotBlank;

public class PostDTO {
    @NotBlank
    private String content;

    @NotBlank
    private Integer utilisateur;
    @NotBlank
    private Integer topic;

    public PostDTO() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Integer utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Integer getTopic() {
        return topic;
    }

    public void setTopic(Integer topic) {
        this.topic = topic;
    }


}
