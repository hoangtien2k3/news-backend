package com.hoangtien2k3.newsservice.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Indexed;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "news")
@Indexed
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Builder
public final class News implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    Long id;

    @Column(name = "title")
    String title;
    @Column(name = "link")
    String link;
    @Column(name = "img")
    String img;
    @Column(name = "pubDate")
    String pubDate;
    @Column(name = "category")
    String category;
}

