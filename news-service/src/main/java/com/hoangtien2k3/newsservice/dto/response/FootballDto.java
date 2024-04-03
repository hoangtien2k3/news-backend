package com.hoangtien2k3.newsservice.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class FootballDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    String title;
    String thumbnail;
    String url;
    String date;
}
