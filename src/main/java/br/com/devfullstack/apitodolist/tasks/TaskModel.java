package br.com.devfullstack.apitodolist.tasks;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(length = 50)
    private String title;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    private UUID userId;

    @CreationTimestamp
    private LocalDateTime createAd;

    public void setTitle(String title) throws Exception{
        if(title.length() > 50){
            throw new Exception("O campo título deve ter no máximo 50 caractéres");
        }
        this.title = title;
    }
}