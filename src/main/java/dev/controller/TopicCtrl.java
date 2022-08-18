package dev.controller;

import dev.controller.dto.TopicDTO;
import dev.controller.dto.TopicModifDTO;
import dev.entite.forum.Topic;
import dev.service.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("topic")
public class TopicCtrl {
    private TopicService topicService;

    public TopicCtrl(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.findAll();
    }

    @PostMapping
    public Topic create(@RequestBody TopicDTO topicDTO) {
        return topicService.create(topicDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id ){
        topicService.delete(id);
    }
    @PatchMapping
    public Topic patch(@RequestBody TopicModifDTO modifDTO){
        return topicService.update(modifDTO);
    }

}
