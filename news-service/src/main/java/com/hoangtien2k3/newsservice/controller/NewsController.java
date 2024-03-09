package com.hoangtien2k3.newsservice.controller;

import com.hoangtien2k3.newsservice.dto.NewsDto;
import com.hoangtien2k3.newsservice.entities.News;
import com.hoangtien2k3.newsservice.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<NewsDto> getAllNews() {
        return newsService.findAll();
    }

    @GetMapping("/category/{category}")
    public List<NewsDto> getNewsByCategory(@PathVariable String category) {
        return newsService.findByCategory(category);
    }

    @GetMapping("/page")
    public Page<NewsDto> getAllNewsPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return newsService.findAll(page, size, sortBy, sortOrder);
    }

    @GetMapping("/{id}")
    public NewsDto getNewsById(@PathVariable Long id) {
        return newsService.findById(id);
    }

    @PostMapping
    public NewsDto createNews(@RequestBody News news) {
        return newsService.save(news);
    }

    @PutMapping("/{id}")
    public NewsDto updateNews(@PathVariable Long id, @RequestBody NewsDto newsDto) {
        return newsService.update(id, newsDto);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteById(id);
    }

}
