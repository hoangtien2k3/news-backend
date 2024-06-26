package com.hoangtien2k3.newsservice.service;

import com.hoangtien2k3.newsservice.dto.response.FootballDto;
import com.hoangtien2k3.newsservice.entities.Football;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FootballService {
    List<FootballDto> findAll();
    Page<FootballDto> findAll(int page, int size, String sortBy, String sortOrder);
    FootballDto findById(Long footballId);
    FootballDto save(final Football football);
    FootballDto update(final FootballDto footballDto);
    FootballDto update(final Long orderId, final Football football);
    void deleteById(final Long footballId);
}
