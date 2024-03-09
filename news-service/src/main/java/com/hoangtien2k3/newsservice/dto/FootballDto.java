package com.hoangtien2k3.newsservice.dto;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FootballDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "title")
    private String title;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "url")
    private String url;
    @Column(name = "date")
    private String date;

}
