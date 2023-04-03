package dev.controller.dto.utilisateur;

import org.springframework.stereotype.Component;

/**
 * DTO d'utilisateur utilisé pour l'inscription d'un utilisateur
 */
public class UtilisateurInscriptionDTO {
    /**
     * Nom de l'utilisateur
     */
    String  nom;
    /**
     * Prenom de l'utilisateur
     */
    String  prenom;
    /**
     * Ville de l'utilisateur
     */
    String  ville;
    /**
     * Code postal de l'utilisateur
     */
    String  codePostal;
    /**
     * Email de l'utilisateur
     */
    String  mail;
    /**
     * Mot de passe de l'utilisateur
     */
    String  password;
    /**
     * Role de l'utilisateur
     */
    String role;

    // Constructor
    public UtilisateurInscriptionDTO() {

    }

    // Getter & Setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getEmail() {
        return mail;
    }

    public void setEmail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UtilisateurDTO {" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", ville='" + ville + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", email='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
