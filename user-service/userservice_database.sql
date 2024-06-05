-- MySQL dump 10.13  Distrib 8.2.0, for macos13 (x86_64)
--
-- Host: localhost    Database: userservice
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
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,'ADMIN'),(2,'USER'),(3,'USER'),(4,'USER'),(5,'USER'),(6,'USER'),(7,'USER'),(8,'USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin@gmail.com','ADMIN','$2a$10$fRAzLhuuALvArraKycAiXOExPJKrzlkS.fTdh87KK6I.CT2mnE9Ca','2024-03-31 14:30:30.294116','2024-03-31 14:30:30.294150','admin'),(2,'hoangtien2k3qx1@gmail.com','Hoang Anh Tien','$2a$10$HQ3vIj1cwFJd6ySMVrtPHO37slq/CGQ142bxe/4OD0hDB2mKl7slO','2024-03-31 14:35:39.916540','2024-03-31 14:35:39.916571','hoangtien2k3qx1'),(3,'hoangtien2k3qx1@gmail.com','Hoang Anh Tien','$2a$10$6Z/TTL52gi.fxDeiLjP1kegHkCLTnS9hC84Sz.CqOCask6dPSMkYq','2024-04-01 17:49:19.451215','2024-04-01 17:49:19.451274','hoangtien2k3'),(4,'hoangtien2k3qx1@gmail.com','Hoang Anh Tien','$2a$10$dcbEkcQKmW4hyxpcWcTKf.TyNrnIon77CiZ1mWD.amUyTf/2VHAsS','2024-04-02 13:24:08.757169','2024-04-02 13:24:08.757191','tiendaica'),(5,'hoanganhtien@gmail.com','Hoang Anh Tien','$2a$10$pMacnxE0318TwTv8bFClheDZrT55.nLgq8ZqM.hb6MXmU32nkRZT6','2024-04-03 18:23:45.992125','2024-04-03 18:23:45.992147','hoanganhtien'),(6,'hoangtientest1@gmail.com','hoangtientest1','$2a$10$UO5qr9ZLaHcvXKcmedZDO.vI4BxXWz.JbBrQHBnNQuXkYqistSTZW','2024-04-17 16:46:41.347958','2024-04-17 16:46:41.348009','hoangtientest1'),(7,'nguyenhoanganh@gmail.com','Nguyễn Hoàng Anh','$2a$10$t48lM9x7/a.2TdMTGo9pY.UdVITl0xdO4o9Tqsn7ZvG0NDVlj..e2','2024-04-18 23:44:45.935864','2024-04-18 23:44:45.935932','nguyenhoanganh'),(8,'tien1245@gmail.com','Hoàngg anh tiến','$2a$10$Cda38ADG5mdwxj20rk9sJONC.tQ/HCb3jhT0M/6iTuV7mgt1D0VNy','2024-04-19 02:54:58.099295','2024-04-19 02:54:58.099321','tien1245');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-05 22:47:06
