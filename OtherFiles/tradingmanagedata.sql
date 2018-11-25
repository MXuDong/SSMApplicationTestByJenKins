-- MySQL dump 10.13  Distrib 5.5.56, for Win64 (AMD64)
--
-- Host: localhost    Database: tradingmanagerdata
-- ------------------------------------------------------
-- Server version	5.5.56

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_log_base`
--

DROP TABLE IF EXISTS `t_log_base`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_log_base` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_time` datetime DEFAULT NULL,
  `log_about_user` int(11) DEFAULT NULL,
  `log_type` int(11) DEFAULT '0',
  `log_what` char(30) DEFAULT NULL,
  PRIMARY KEY (`log_id`),
  UNIQUE KEY `t_log_base_log_id_uindex` (`log_id`),
  KEY `t_log_base_t_user_infos_user_id_fk` (`log_about_user`),
  CONSTRAINT `t_log_base_t_user_infos_user_id_fk` FOREIGN KEY (`log_about_user`) REFERENCES `t_user_infos` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_base`
--

LOCK TABLES `t_log_base` WRITE;
/*!40000 ALTER TABLE `t_log_base` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_log_base` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_log_change_product_count`
--

DROP TABLE IF EXISTS `t_log_change_product_count`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_log_change_product_count` (
  `lcpc_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_old_count` int(11) NOT NULL,
  `product_old_price` double NOT NULL,
  `product_new_count` int(11) NOT NULL,
  PRIMARY KEY (`lcpc_id`),
  UNIQUE KEY `t_log_change_product_count_lcpc_id_uindex` (`lcpc_id`),
  KEY `t_log_change_product_count_t_log_base_log_id_fk` (`log_id`),
  KEY `t_log_change_product_count_t_product_product_id_fk` (`product_id`),
  CONSTRAINT `t_log_change_product_count_t_product_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`product_id`),
  CONSTRAINT `t_log_change_product_count_t_log_base_log_id_fk` FOREIGN KEY (`log_id`) REFERENCES `t_log_base` (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_change_product_count`
--

LOCK TABLES `t_log_change_product_count` WRITE;
/*!40000 ALTER TABLE `t_log_change_product_count` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_log_change_product_count` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_log_change_product_price`
--

DROP TABLE IF EXISTS `t_log_change_product_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_log_change_product_price` (
  `lcpp_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_old_count` int(11) NOT NULL,
  `product_old_price` int(11) NOT NULL,
  `product_new_price` int(11) NOT NULL,
  PRIMARY KEY (`lcpp_id`),
  UNIQUE KEY `t_log_change_product_price_lcpp_id_uindex` (`lcpp_id`),
  KEY `t_log_change_product_price_t_log_base_log_id_fk` (`log_id`),
  KEY `t_log_change_product_price_t_product_product_id_fk` (`product_id`),
  CONSTRAINT `t_log_change_product_price_t_log_base_log_id_fk` FOREIGN KEY (`log_id`) REFERENCES `t_log_base` (`log_id`),
  CONSTRAINT `t_log_change_product_price_t_product_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_change_product_price`
--

LOCK TABLES `t_log_change_product_price` WRITE;
/*!40000 ALTER TABLE `t_log_change_product_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_log_change_product_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_log_operation_obill`
--

DROP TABLE IF EXISTS `t_log_operation_obill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_log_operation_obill` (
  `loo_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_id` int(11) DEFAULT NULL,
  `t_lcpc_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`loo_id`),
  UNIQUE KEY `t_log_operation_obill_loo_id_uindex` (`loo_id`),
  KEY `t_log_operation_obill_t_log_base_log_id_fk` (`log_id`),
  KEY `t_log_operation_obill_t_log_change_product_count_lcpc_id_fk` (`t_lcpc_id`),
  CONSTRAINT `t_log_operation_obill_t_log_base_log_id_fk` FOREIGN KEY (`log_id`) REFERENCES `t_log_base` (`log_id`),
  CONSTRAINT `t_log_operation_obill_t_log_change_product_count_lcpc_id_fk` FOREIGN KEY (`t_lcpc_id`) REFERENCES `t_log_change_product_count` (`lcpc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_operation_obill`
--

LOCK TABLES `t_log_operation_obill` WRITE;
/*!40000 ALTER TABLE `t_log_operation_obill` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_log_operation_obill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_log_operation_obill_res`
--

DROP TABLE IF EXISTS `t_log_operation_obill_res`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_log_operation_obill_res` (
  `lobr_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_obill_id` int(11) DEFAULT NULL,
  `t_product_id` int(11) DEFAULT NULL,
  `t_loo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`lobr_id`),
  UNIQUE KEY `t_log_operation_obill_res_lobr_id_uindex` (`lobr_id`),
  KEY `t_log_operation_obill_res_t_log_operation_obill_loo_id_fk` (`t_loo_id`),
  KEY `t_log_operation_obill_res_t_obill_info_obill_fk` (`t_obill_id`),
  KEY `t_log_operation_obill_res_t_product_product_id_fk` (`t_product_id`),
  CONSTRAINT `t_log_operation_obill_res_t_log_operation_obill_loo_id_fk` FOREIGN KEY (`t_loo_id`) REFERENCES `t_log_operation_obill` (`loo_id`),
  CONSTRAINT `t_log_operation_obill_res_t_obill_info_obill_fk` FOREIGN KEY (`t_obill_id`) REFERENCES `t_obill_info` (`obill`),
  CONSTRAINT `t_log_operation_obill_res_t_product_product_id_fk` FOREIGN KEY (`t_product_id`) REFERENCES `t_product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_operation_obill_res`
--

LOCK TABLES `t_log_operation_obill_res` WRITE;
/*!40000 ALTER TABLE `t_log_operation_obill_res` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_log_operation_obill_res` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_obill_info`
--

DROP TABLE IF EXISTS `t_obill_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_obill_info` (
  `obill` int(11) NOT NULL AUTO_INCREMENT,
  `obill_time` datetime NOT NULL,
  `obill_money` double NOT NULL,
  PRIMARY KEY (`obill`),
  UNIQUE KEY `t_obill_info_obill_uindex` (`obill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_obill_info`
--

LOCK TABLES `t_obill_info` WRITE;
/*!40000 ALTER TABLE `t_obill_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_obill_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` char(20) NOT NULL,
  `product_desc` text,
  `product_pic` int(11) DEFAULT '0',
  `product_price` double NOT NULL,
  `product_count` int(11) NOT NULL,
  `product_max_count` int(11) DEFAULT '0',
  `product_min_count` int(11) DEFAULT '0',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user_infos`
--

DROP TABLE IF EXISTS `t_user_infos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user_infos` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` char(20) NOT NULL,
  `user_password` char(20) NOT NULL,
  `user_power` int(11) DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `t_user_infos_user_id_uindex` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_infos`
--

LOCK TABLES `t_user_infos` WRITE;
/*!40000 ALTER TABLE `t_user_infos` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_infos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-25 17:10:21
