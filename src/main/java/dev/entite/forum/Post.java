package dev.entite.forum;

import dev.entite.BaseEntite;
import dev.entite.Utilisateur;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Classe pour la définition des posts <br/>
 * Se référer à {@link dev.entite.BaseEntite} pour les identifiants générés
 */
@Entity
public class Post extends BaseEntite {

    /**
     * Le contenu du post
     * Lob permet de changer le String "content" de simple "varchar" en "longtext",
     * columnDefinition permet de le changer en "text" <br/>
     */
    @Lob
    @Column(columnDefinition = "TEXT", length = 2048)
    private String content;
    /**
     * Relation many to one avec les utilisateurs <br/>
     * Id dans table post = utilisateur_id<br/>
     * Voir {@link dev.entite.Utilisateur}
     */
    @ManyToOne
    private Utilisateur utilisateur;
    /**
     * Relation many to one avec les topics<br/>
     * Id dans table post = topic_id <br/>
     * Voir {@link dev.entite.forum.Topic}
     */
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Topic topic;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    // Constructeur
    public Post() {
    }

    public Post(String content, Utilisateur utilisateur, Topic topic, LocalDateTime created_date, LocalDateTime updated_date) {
        this.content = content;
        this.utilisateur = utilisateur;
        this.topic = topic;
        this.createdDate = created_date;
        this.updatedDate = updated_date;
    }

    // Getter & Setter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime created_date) {
        this.createdDate = created_date;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updated_date) {
        this.updatedDate = updated_date;
    }
}
