package com.hoangtien2k3.newsservice.config;

import org.hibernate.search.jpa.Search;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.annotation.PostConstruct;

@Configuration
@EnableTransactionManagement
public class HibernateSearchConfiguration {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init() {
        try {
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManagerFactory.createEntityManager());
            fullTextEntityManager.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            System.out.println("Error occurred while initializing Hibernate Search: " + e.getMessage());
        }
    }
}
