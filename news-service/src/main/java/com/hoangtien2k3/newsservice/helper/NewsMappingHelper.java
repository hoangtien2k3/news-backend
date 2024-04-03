package com.hoangtien2k3.newsservice.helper;

import com.hoangtien2k3.newsservice.dto.response.NewsDto;
import com.hoangtien2k3.newsservice.entities.Category;
import com.hoangtien2k3.newsservice.entities.News;

public interface NewsMappingHelper {
    static NewsDto map(News news) {
        if (news == null)
            return null;
        return NewsDto.builder()
                .title(news.getTitle())
                .link(news.getLink())
                .img(news.getImg())
                .pubDate(news.getPubDate())
                .category(news.getCategory())
                .build();
    }

    static News map(final NewsDto newsDto) {
        if (newsDto == null)
            return null;
        return News.builder()
                .title(newsDto.getTitle())
                .link(newsDto.getLink())
                .img(newsDto.getImg())
                .pubDate(newsDto.getPubDate())
                .category(newsDto.getCategory())
                .build();
    }
}
