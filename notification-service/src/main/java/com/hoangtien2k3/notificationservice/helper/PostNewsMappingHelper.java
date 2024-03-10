package com.hoangtien2k3.notificationservice.helper;

import com.hoangtien2k3.notificationservice.dto.PostNewsDto;
import com.hoangtien2k3.notificationservice.entity.PostNews;

public interface PostNewsMappingHelper {
    static PostNewsDto map(PostNews postNews) {
        if (postNews == null) return null;
        return PostNewsDto.builder()
                .title(postNews.getTitle())
                .link(postNews.getLink())
                .img(postNews.getImg())
                .pubDate(postNews.getPubDate())
                .category(postNews.getCategory())
                .build();
    }

    static PostNews map(PostNewsDto postNewsDto) {
        if (postNewsDto == null) return null;
        return PostNews.builder()
                .title(postNewsDto.getTitle())
                .link(postNewsDto.getLink())
                .img(postNewsDto.getImg())
                .pubDate(postNewsDto.getPubDate())
                .category(postNewsDto.getCategory())
                .build();
    }
}
