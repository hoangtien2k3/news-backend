package com.hoangtien2k3.notificationservice.entity;

import lombok.*;
import javax.persistence.*;

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
    private Long postId;

    private String title;
    private String link;
    private String img;
    private String pubDate;
    private String category;
}

