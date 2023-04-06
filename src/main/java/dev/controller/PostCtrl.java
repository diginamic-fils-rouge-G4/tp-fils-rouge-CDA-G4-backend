package dev.controller;

import dev.controller.dto.post.PostDTO;
import dev.controller.dto.post.PostExportDTO;
import dev.controller.dto.post.PostUpdateDTO;
import dev.entite.forum.Post;
import dev.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *  Controlleur utilisé pour la gestion des Posts <br/>
 *  Utilise le service : {@link dev.service.PostService}
 */
@CrossOrigin
@RestController
@RequestMapping("posts")
public class PostCtrl {
    private PostService postService;

    public PostCtrl(PostService postService) {
        this.postService = postService;
    }

    /**
     * Récupère la totalité des posts
     * @return une liste de tout les posts
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllPosts(@PathVariable int id) {
        List<PostExportDTO> posts = postService.findAllByTopicId(id).stream().map( post -> {
            PostExportDTO postExportDTO = new PostExportDTO(post);
            postExportDTO.setCreatedDate(post.getCreatedDate().toString());
            postExportDTO.setUpdatedDate(post.getUpdatedDate().toString());
            return postExportDTO;
        }).toList();
        if(posts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .build();
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(posts);
        }
    }

    /**
     * Créé un post
     * @param postDTO
     * @return body = "Message envoyé"
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PostDTO postDTO) {
        postService.create(postDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * Supprime un post à partir de son id
     * @param id
     * @return http status 200
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Optional<Post> post = postService.findById(id);
        if(post.isPresent()) {
            postService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PatchMapping
    public ResponseEntity<?> updatePost(@RequestBody PostUpdateDTO postDTO) {
        Post post = postService.update(postDTO);
        if(post != null) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
