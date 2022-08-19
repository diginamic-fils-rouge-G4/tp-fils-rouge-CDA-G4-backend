package dev.controller;

import dev.controller.dto.PostDTO;
import dev.entite.forum.Post;
import dev.service.PostService;
import dev.service.TopicService;
import dev.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("posts")
public class PostCtrl {
    private PostService postService;

    private TopicService topicService;
    private UtilisateurService utilisateurService;

    public PostCtrl(PostService postService, TopicService topicService, UtilisateurService utilisateurService) {
        this.postService = postService;
        this.topicService = topicService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostDTO postDTO) {
        postService.create(postDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Message envoyé");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Post> post = postService.findById(id);
        if(post.isPresent()) {
            postService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
