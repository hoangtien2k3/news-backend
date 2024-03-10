package com.hoangtien2k3.notificationservice.service;

import com.hoangtien2k3.notificationservice.dto.PostNewsDto;
import com.hoangtien2k3.notificationservice.entity.PostNews;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PostNewsService {
    Mono<PostNews> savePostNews(PostNewsDto paymentDto);
    Mono<PostNews> getPostNews(Long paymentId);
    Mono<List<PostNews>> getAllPostNews();
    Mono<List<PostNews>> getAllPostNewsByUserId(Long userId);
    Mono<Void> deletePostNews(Long paymentId);
    Mono<Void> deleteAllPostNews();
}
