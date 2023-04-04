package dev.controller.dto.post;

import java.time.LocalDateTime;

public class PostUpdateDTO {
    private Integer id;
    private Integer topic;
    private String content;
    private LocalDateTime created_date;
    private LocalDateTime updated_date;

    public PostUpdateDTO(Integer id, Integer topic, String content, LocalDateTime created_date, LocalDateTime updated_date) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopic() {
        return topic;
    }

    public void setTopic(Integer topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(LocalDateTime updated_date) {
        this.updated_date = updated_date;
    }
}
