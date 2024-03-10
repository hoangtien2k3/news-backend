package com.hoangtien2k3.notificationservice.repository;

import com.hoangtien2k3.notificationservice.entity.PostNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostNewsRepository extends JpaRepository<PostNews, Long> {

}
