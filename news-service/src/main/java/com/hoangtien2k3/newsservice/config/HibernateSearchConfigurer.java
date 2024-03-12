//package com.hoangtien2k3.newsservice.config;
//
//import org.hibernate.search.jpa.Search;
//import org.hibernate.search.jpa.FullTextEntityManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManagerFactory;
//
//@Configuration
//@EnableTransactionManagement
//public class HibernateSearchConfigurer {
//
//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
//
//    @Autowired
//    private PlatformTransactionManager transactionManager;
//
//    @PostConstruct
//    public void initializeHibernateSearch() {
//        try {
//            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManagerFactory.createEntityManager());
//            fullTextEntityManager.createIndexer().startAndWait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
