package dev.controller.dto.topic;

import javax.validation.constraints.NotBlank;

public class TopicUpdateDTO {
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

    public TopicUpdateDTO() {
    }

    public TopicUpdateDTO(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
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
}
