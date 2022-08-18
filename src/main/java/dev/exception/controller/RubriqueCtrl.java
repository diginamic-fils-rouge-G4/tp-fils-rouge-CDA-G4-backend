package dev.exception.controller;

import dev.exception.controller.dto.RubriqueDTO;
import dev.entite.forum.Rubrique;
import dev.service.RubriqueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("rubrique")
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class RubriqueCtrl {
    private RubriqueService rubriqueService;
    private static final Logger LOGGER = LoggerFactory.getLogger(RubriqueCtrl.class);

    public RubriqueCtrl(RubriqueService rubriqueService) {
        this.rubriqueService = rubriqueService;
    }

    @GetMapping
    public List<Rubrique> getAllRubrique() {
        Object test = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        LOGGER.info("" + test);
        return rubriqueService.findAll();
    }

    @PostMapping
    public Rubrique create(@RequestBody RubriqueDTO rubriqueDTO) {
        return rubriqueService.create(rubriqueDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteRubrique(@PathVariable Integer id) {
        Optional<Rubrique> rubrique = rubriqueService.getByid(id);
        if (rubrique.isPresent()) {
            Rubrique currentRubrique = rubrique.get();
            rubriqueService.deleteRubrique(currentRubrique);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

//    @PatchMapping
//    public ResponseEntity<Rubrique> updateRubrique(@RequestBody RubriqueLibelleDTO rubriqueLibelleDTO) {
//        Optional<Rubrique> rubrique = rubriqueService.getByid(rubriqueLibelleDTO.getId());
//        if (rubrique.isPresent()) {
//            Rubrique currentRubrique = rubrique.get();
//            currentRubrique.setLibelle(rubriqueLibelleDTO.getLibelle());
//            return ResponseEntity.ok(rubriqueService.)
//        }
//    }
}