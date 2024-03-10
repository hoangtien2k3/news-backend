package com.hoangtien2k3.notificationservice.repository;

import com.hoangtien2k3.notificationservice.entity.PostNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface PostNewsRepository extends JpaRepository<PostNews, Long> {
    @Query("SELECT p FROM PostNews p WHERE p.userId = ?1")
    List<PostNews> findByUserId(Long userId);
}
