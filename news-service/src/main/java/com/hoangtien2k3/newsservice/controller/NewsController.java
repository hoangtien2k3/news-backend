package com.hoangtien2k3.newsservice.controller;

import com.hoangtien2k3.newsservice.constant.Constants;
import com.hoangtien2k3.newsservice.dto.response.ApiResponse;
import com.hoangtien2k3.newsservice.dto.response.NewsDto;
import com.hoangtien2k3.newsservice.entities.News;
import com.hoangtien2k3.newsservice.service.NewsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NewsController {

    NewsService newsService;

    @GetMapping("/full")
    public ApiResponse<List<NewsDto>> getAllNews() {
        return ApiResponse.<List<NewsDto>>builder()
                .code(HttpStatus.OK.value())
                .message(Constants.SUCCESS)
                .totalRecords((long) newsService.findAll().size())
                .data(newsService.findAll())
                .build();
    }

    @GetMapping("/page")
    public Page<NewsDto> getAllNews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return newsService.findAll(page, size, sortBy, sortOrder);
    }

    @GetMapping("/category/{category}")
    public ApiResponse<List<NewsDto>> getNewsByCategory(@PathVariable String category) {
        return ApiResponse.<List<NewsDto>>builder()
                .code(HttpStatus.OK.value())
                .message(Constants.SUCCESS)
                .totalRecords((long) newsService.findByCategory(category).size())
                .data(newsService.findByCategory(category))
                .build();
    }

    @GetMapping("/page/{category}")
    public ApiResponse<Page<NewsDto>> getNewsByCategory(
            @PathVariable String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return ApiResponse.<Page<NewsDto>>builder()
                .code(HttpStatus.OK.value())
                .message(Constants.SUCCESS)
                .data(newsService.findByCategory(category, page, size, sortBy, sortOrder))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<NewsDto> getNewsById(@PathVariable("id") Long id) {
        return ApiResponse.<NewsDto>builder()
                .code(HttpStatus.OK.value())
                .message(Constants.SUCCESS)
                .data(newsService.findById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<NewsDto> createNews(@RequestBody News news) {
        return ApiResponse.<NewsDto>builder()
                .code(HttpStatus.OK.value())
                .message(Constants.SUCCESS)
                .data(newsService.save(news))
                .build();
    }

    @PutMapping("/{id}")
    public NewsDto updateNews(@PathVariable("id") Long id, @RequestBody News news) {
        return newsService.update(id, news);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable("id") Long id) {
        newsService.deleteById(id);
    }
}
