package com.hoangtien2k3.newsservice.entities;

import lombok.*;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "news")
@Indexed
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

    @Field(termVector = TermVector.YES)
    @Column(name = "title")
    private String title;
    @Field(termVector = TermVector.YES)
    @Column(name = "link")
    private String link;
    @Field(termVector = TermVector.YES)
    @Column(name = "img")
    private String img;
    @Field(termVector = TermVector.YES)
    @Column(name = "pubDate")
    private String pubDate;
    @Field(termVector = TermVector.YES)
    @Column(name = "category")
    private String category;
}
