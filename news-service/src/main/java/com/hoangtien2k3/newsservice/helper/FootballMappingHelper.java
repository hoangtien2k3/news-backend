package com.hoangtien2k3.newsservice.helper;

import com.hoangtien2k3.newsservice.dto.response.FootballDto;
import com.hoangtien2k3.newsservice.entities.Football;

public interface FootballMappingHelper {
    static FootballDto map(Football football) {
        if (football == null)
            return null;
        return FootballDto.builder()
                .title(football.getTitle())
                .thumbnail(football.getThumbnail())
                .url(football.getUrl())
                .date(football.getDate())
                .build();
    }

    static Football map(final FootballDto footballDto) {
        if (footballDto == null)
            return null;
        return Football.builder()
                .title(footballDto.getTitle())
                .thumbnail(footballDto.getThumbnail())
                .url(footballDto.getUrl())
                .date(footballDto.getDate())
                .build();
    }
}
