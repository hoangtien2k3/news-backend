package com.hoangtien2k3.newsservice.controller;

import com.hoangtien2k3.newsservice.dto.response.FootballDto;
import com.hoangtien2k3.newsservice.entities.Football;
import com.hoangtien2k3.newsservice.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/football")
public class FootballController {

    private final FootballService footballService;

    @Autowired
    public FootballController(FootballService footballService) {
        this.footballService = footballService;
    }

    @GetMapping
    public List<FootballDto> getAlFootball() {
        return footballService.findAll();
    }

    @GetMapping("/page")
    public Page<FootballDto> getAllFootballPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return footballService.findAll(page, size, sortBy, sortOrder);
    }

    @GetMapping("/{id}")
    public FootballDto getFootballById(@PathVariable Long id) {
        return footballService.findById(id);
    }

    @PostMapping
    public FootballDto createFootball(@RequestBody Football football) {
        return footballService.save(football);
    }

    @PutMapping("/{id}")
    public FootballDto updateFootball(@PathVariable Long id, @RequestBody FootballDto footballDto) {
        return footballService.update(id, footballDto);
    }

    @DeleteMapping("/{id}")
    public void deleteFootball(@PathVariable Long id) {
        footballService.deleteById(id);
    }

}
