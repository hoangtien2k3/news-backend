package com.hoangtien2k3.newsservice.service.impl;

import com.hoangtien2k3.newsservice.dto.NewsDto;
import com.hoangtien2k3.newsservice.entities.News;
import com.hoangtien2k3.newsservice.helper.NewsMappingHelper;
import com.hoangtien2k3.newsservice.repository.NewsRepository;
import com.hoangtien2k3.newsservice.service.NewsService;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<NewsDto> findAll() {
        return newsRepository.findAll()
                .stream()
                .map(NewsMappingHelper::map)
                .collect(Collectors.toList());
    }

    @Override
    public List<NewsDto> findByCategory(String category) {
        return newsRepository.findByCategory(category).stream()
                .map(NewsMappingHelper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Page<NewsDto> findAll(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Page<News> newsPage = newsRepository.findAll(PageRequest.of(page, size, Sort.by(direction, sortBy)));
        return newsPage.map(NewsMappingHelper::map);
    }

    @Override
    public NewsDto findById(Long newsId) {
        return newsRepository.findById(newsId)
                .map(NewsMappingHelper::map)
                .orElse(null);
    }

    @Override
    public NewsDto save(News news) {
        newsRepository.save(news);
        return NewsMappingHelper.map(news);
    }

    @Override
    public NewsDto update(NewsDto newsDto) {
        return null;
    }

    @Override
    public NewsDto update(Long id, NewsDto newsDto) {
        return null;
    }

    @Override
    public void deleteById(Long newsId) {
        newsRepository.deleteById(newsId);
    }

    @Override
    public Boolean existsByOrderId(Long newsId) {
        return newsRepository.existsById(newsId);
    }

    @Override
    public List<News> fuzzySearch(String keyword) {
        return newsRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<News> searchByTitle(String title) {
        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(News.class).get();
        org.apache.lucene.search.Query query = queryBuilder.keyword().onField("title").matching(title).createQuery();
        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(query, News.class);
        return jpaQuery.getResultList();
    }

}

