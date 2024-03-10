package com.hoangtien2k3.notificationservice.service.impl;

import com.hoangtien2k3.notificationservice.dto.PostNewsDto;
import com.hoangtien2k3.notificationservice.entity.PostNews;
import com.hoangtien2k3.notificationservice.helper.PostNewsMappingHelper;
import com.hoangtien2k3.notificationservice.repository.PostNewsRepository;
import com.hoangtien2k3.notificationservice.service.PostNewsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class PostNewsServiceImpl implements PostNewsService {

    private final PostNewsRepository postNewsRepository;

    @Autowired
    public PostNewsServiceImpl(PostNewsRepository paymentRepository) {
        this.postNewsRepository = paymentRepository;
    }

    @Override
    public Mono<PostNews> savePayment(PostNewsDto postNewsDto) {
        return Mono.fromSupplier(() -> postNewsRepository.save(PostNewsMappingHelper.map(postNewsDto)))
                .onErrorResume(throwable -> {
                    log.error("Error saving payment: {}", throwable.getMessage());
                    return Mono.error(throwable);
                });
    }

    @Override
    public Mono<PostNews> getPayment(Long paymentId) {
        return Mono.fromSupplier(() -> postNewsRepository.findById(paymentId)
                        .orElse(null));
    }

    @Override
    public Mono<List<PostNews>> getAllPayments() {
        return Mono.fromSupplier(postNewsRepository::findAll)
                .onErrorResume(throwable -> {
                    log.error("Error fetching user info: {}", throwable.getMessage());
                    return Mono.empty();
                });
    }

    @Override
    public Mono<Void> deletePayment(Long paymentId) {
        log.info("Void, service; delete payment by id");
        return Mono.fromRunnable(() -> postNewsRepository.deleteById(paymentId));
    }
}
