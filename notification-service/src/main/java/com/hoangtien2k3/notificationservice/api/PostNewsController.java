package com.hoangtien2k3.notificationservice.api;

import com.hoangtien2k3.notificationservice.dto.PostNewsDto;
import com.hoangtien2k3.notificationservice.entity.PostNews;
import com.hoangtien2k3.notificationservice.service.PostNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostNewsController {

    private final PostNewsService postNewsService;

    @Autowired
    public PostNewsController(PostNewsService paymentService) {
        this.postNewsService = paymentService;
    }

    @PostMapping
    public Mono<PostNews> savePayment(@RequestBody PostNewsDto postNewsDto) {
        return postNewsService.savePostNews(postNewsDto);
    }

    @GetMapping("/{postId}")
    public Mono<PostNews> getPayment(@PathVariable Long postId) {
        return postNewsService.getPostNews(postId);
    }

    @GetMapping
    public Mono<List<PostNews>> getAllPayments() {
        return postNewsService.getAllPostNews();
    }

    @GetMapping("/all/{userId}")
    public Mono<List<PostNews>> getAllPostNewsByUserId(@PathVariable Long userId) {
        return postNewsService.getAllPostNewsByUserId(userId);
    }

    @DeleteMapping("/{postId}")
    public Mono<Void> deletePostNews(@PathVariable Long postId) {
        return postNewsService.deletePostNews(postId);
    }

    @DeleteMapping("/all")
    public Mono<Void> deleteAllPostNews() {
        return postNewsService.deleteAllPostNews();
    }

}