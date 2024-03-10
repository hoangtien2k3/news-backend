package com.hoangtien2k3.notificationservice.service;

import com.hoangtien2k3.notificationservice.dto.PostNewsDto;
import com.hoangtien2k3.notificationservice.entity.PostNews;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PostNewsService {
    Mono<PostNews> savePayment(PostNewsDto paymentDto);
    Mono<PostNews> getPayment(Long paymentId);
    Mono<List<PostNews>> getAllPayments();
    Mono<Void> deletePayment(Long paymentId);
}
