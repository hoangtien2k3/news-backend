package com.hoangtien2k3.newsservice.repository;

import com.hoangtien2k3.newsservice.entities.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    @Query("SELECT n FROM News n WHERE n.category = ?1")
    List<News> findByCategory(String category);

    List<News> findByTitleContainingIgnoreCase(String keyword);
}
