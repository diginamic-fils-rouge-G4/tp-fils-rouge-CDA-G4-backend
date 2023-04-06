package dev.service;

import dev.controller.UtilisateurCtrl;
import dev.controller.dto.utilisateur.UtilisateurInscriptionDTO;
import dev.entite.Utilisateur;
import dev.repository.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
/**
 * Service pour les topics
 * Voir {@link dev.controller.UtilisateurCtrl} pour utilisation
 */
@Service
public class UtilisateurService {
    private PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurCtrl.class);

    /**
     * Voir {@link dev.repository.UtilisateurRepository}
     */
    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(PasswordEncoder passwordEncoder, UtilisateurRepository utilisateurRepository) {
        this.passwordEncoder = passwordEncoder;
        this.utilisateurRepository = utilisateurRepository;
    }

    /**
     * Création d'un utilisateur
     * @param utilisateurInscriptionDTO
     */
    public HttpStatus creeUtilisateur(UtilisateurInscriptionDTO utilisateurInscriptionDTO){

        if ( Optional.empty().equals(getByMail(utilisateurInscriptionDTO.getMail()))){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(utilisateurInscriptionDTO.getNom());

        utilisateur.setMail(utilisateurInscriptionDTO.getMail());
        utilisateur.setPrenom(utilisateurInscriptionDTO.getPrenom());
        utilisateur.setRole("ROLE_USER");
        utilisateur.setPassword(passwordEncoder.encode(utilisateurInscriptionDTO.getPassword()));
        saveUtilisateur(utilisateur);
        return HttpStatus.OK;

        }else return HttpStatus.FORBIDDEN;
    }
    /**
     * Récupère un utilisateur en fonction de son ID
     * @param id
     * @return l'utilisateur correspondant
     */
    public Optional<Utilisateur> getByid(Integer id){return utilisateurRepository.findById(id);}
    /**
     * Récupère un utilisateur en fonction de son email
     * @param mail
     * @return l'utilisateur correspondant
     */
    public Optional<Utilisateur> getByMail(String mail){
        return utilisateurRepository.findByMail(mail);}
    /**
     * Création d'un utilisateur
     * @param utilisateur
     * @return le nouvel utilisateur
     */
    public Utilisateur saveUtilisateur(Utilisateur utilisateur){
        return utilisateurRepository.save(utilisateur);
    }

//    admin methods
    /**
     * Recupère tous les utilisateurs
     * @return liste des utilisateurs
     */
    public List<Utilisateur> getAll(){
        return utilisateurRepository.findAll();
    }

    /**
     * Récupère tous les utilisateurs avec une pagination
     * @param page
     * @param size
     * @return liste des utilisateurs
     */
    public Page<Utilisateur> getAll(int page, int size){
        return utilisateurRepository.findAll(PageRequest.of(page,size));
    }

    /**
     * Supprimer un utilisateur
     * @param utilisateur
     */
    public void deleteUtilisateur(Utilisateur utilisateur){
        utilisateurRepository.delete(utilisateur);
    }
}