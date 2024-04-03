package com.hoangtien2k3.notificationservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "postnews")
public class PostNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long postId;

    private String title;
    private String link;
    private String img;
    private String pubDate;
    @JsonIgnore
    private Long userId;
}

