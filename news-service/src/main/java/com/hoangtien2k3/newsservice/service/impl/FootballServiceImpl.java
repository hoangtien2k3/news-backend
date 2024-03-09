package com.hoangtien2k3.newsservice.service.impl;

import com.hoangtien2k3.newsservice.dto.FootballDto;
import com.hoangtien2k3.newsservice.entities.Football;
import com.hoangtien2k3.newsservice.helper.FootballMappingHelper;
import com.hoangtien2k3.newsservice.repository.FootballRepository;
import com.hoangtien2k3.newsservice.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FootballServiceImpl implements FootballService {

    private final FootballRepository footballRepository;

    @Autowired
    public FootballServiceImpl(FootballRepository footballRepository) {
        this.footballRepository = footballRepository;
    }

    @Override
    public List<FootballDto> findAll() {
        return footballRepository.findAll()
                .stream()
                .map(FootballMappingHelper::map)
                .collect(Collectors.toList());
    }

    @Override
    public Page<FootballDto> findAll(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Page<Football> newsPage = footballRepository.findAll(PageRequest.of(page, size, Sort.by(direction, sortBy)));
        return newsPage.map(FootballMappingHelper::map);
    }

    @Override
    public FootballDto findById(Long footballId) {
        return footballRepository.findById(footballId)
                .map(FootballMappingHelper::map)
                .orElse(null);
    }

    @Override
    public FootballDto save(Football football) {
        footballRepository.save(football);
        return FootballMappingHelper.map(football);
    }

    @Override
    public FootballDto update(FootballDto footballDto) {
        return null;
    }

    @Override
    public FootballDto update(Long orderId, FootballDto footballDto) {
        return null;
    }

    @Override
    public void deleteById(Long footballId) {
        footballRepository.deleteById(footballId);
    }

}
