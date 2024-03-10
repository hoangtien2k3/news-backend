package com.hoangtien2k3.notificationservice.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@Builder
public class PostNewsDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String title;
    private String link;
    private String img;
    private String pubDate;
    private Long userId;
}
