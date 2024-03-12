package com.hoangtien2k3.newsservice.service;

import com.hoangtien2k3.newsservice.dto.NewsDto;
import com.hoangtien2k3.newsservice.entities.News;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsService {
    List<NewsDto> findAll();
    List<NewsDto> findByCategory(String category);
    Page<NewsDto> findAll(int page, int size, String sortBy, String sortOrder);
    NewsDto findById(Long newsId);
    NewsDto save(final News news);
    NewsDto update(final NewsDto newsDto);
    NewsDto update(final Long orderId, final NewsDto newsDto);
    void deleteById(final Long newsId);
    Boolean existsByOrderId(Long newsId);

    List<News> fuzzySearch(String keyword);
    List<News> searchByTitle(String title);
}
