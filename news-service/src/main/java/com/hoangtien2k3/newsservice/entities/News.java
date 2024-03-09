package com.hoangtien2k3.newsservice.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "news")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public final class News implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "link")
    private String link;
    @Column(name = "img")
    private String img;
    @Column(name = "pubDate")
    private String pubDate;

    @Column(name = "category")
    private String category;

}
