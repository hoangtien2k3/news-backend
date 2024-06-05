-- MySQL dump 10.13  Distrib 8.2.0, for macos13 (x86_64)
--
-- Host: localhost    Database: notificationservice
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `postnews`
--

DROP TABLE IF EXISTS `postnews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postnews` (
  `post_id` bigint NOT NULL AUTO_INCREMENT,
  `img` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `pub_date` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=MyISAM AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postnews`
--

LOCK TABLES `postnews` WRITE;
/*!40000 ALTER TABLE `postnews` DISABLE KEYS */;
INSERT INTO `postnews` VALUES (148,'https://i1-vnexpress.vnecdn.net/2024/03/06/afp-20240303-34km3ky-v1-highre-4162-5995-1709693602.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=O0mzXV8nDVUKr7fC0KmdRA','https://vnexpress.net/ong-trump-khung-hoang-gaza-se-khong-xay-ra-neu-toi-lam-tong-thong-4718916.html','06 Mar 2024 15:24:50 +0700','Ông Trump: Khủng hoảng Gaza sẽ không xảy ra nếu tôi làm tổng thống',3),(147,'https://i1-sohoa.vnecdn.net/2024/03/06/musk-meta-2600-1709661444.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=6VdGQBN83ROj3LE4h4GFfw','https://vnexpress.net/elon-musk-che-gieu-meta-sau-su-co-sap-facebook-4718851.html','Wed, 06 Mar 2024 01:10:17 +0700','Elon Musk chế giễu Meta sau sự cố sập Facebook',3),(143,'https://i1-vnexpress.vnecdn.net/2024/03/05/bo-truong-thang-1871-170965365-7191-8931-1709655295.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=WR6GddepVipQNOYDWY4wVw','https://vnexpress.net/bo-truong-giao-thong-van-tai-xay-cao-toc-phai-co-tram-dung-nghi-4718836.html','Wed, 06 Mar 2024 00:00:00 +0700','Bộ trưởng Giao thông Vận tải: \'Xây cao tốc phải có trạm dừng nghỉ\'',3),(146,'https://i1-kinhdoanh.vnecdn.net/2024/03/05/elonmuskbillgateswarrenbuff-17-9483-9043-1709632449.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=IW3JM7CYppcmTJLN-XvU0w','https://vnexpress.net/cac-ty-phu-nghi-gi-ve-bitcoin-4718756.html','Wed, 06 Mar 2024 00:37:26 +0700','Các tỷ phú nghĩ gì về Bitcoin?',3),(145,'https://i1-sohoa.vnecdn.net/2024/03/06/musk-meta-2600-1709661444.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=6VdGQBN83ROj3LE4h4GFfw','https://vnexpress.net/elon-musk-che-gieu-meta-sau-su-co-sap-facebook-4718851.html','Wed, 06 Mar 2024 01:10:17 +0700','Elon Musk chế giễu Meta sau sự cố sập Facebook',3),(144,'https://i1-sohoa.vnecdn.net/2024/03/05/IMG7378-1709654748-9739-1709654772.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=DvYPKsoyV3vT5yhekhCS1g','https://vnexpress.net/facebook-va-messenger-gap-su-co-tren-tat-ca-nen-tang-4718833.html','Tue, 05 Mar 2024 22:36:40 +0700','Facebook và Messenger gặp sự cố trên tất cả nền tảng',3);
/*!40000 ALTER TABLE `postnews` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-05 22:48:49
