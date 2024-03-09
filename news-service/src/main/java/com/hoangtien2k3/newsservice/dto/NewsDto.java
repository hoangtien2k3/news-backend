package com.hoangtien2k3.newsservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewsDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "title")
    private String title;
    @Column(name = "link")
    private String link;
    @Column(name = "img")
    private String img;
    @Column(name = "pubDate")
    private String pubDate;

    @JsonIgnore
    @Column(name = "category")
    private String category;

}
