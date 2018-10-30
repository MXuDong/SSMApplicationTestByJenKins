-- MySQL dump 10.14  Distrib 5.5.60-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: tradingmanagerdata
-- ------------------------------------------------------
-- Server version	5.5.60-MariaDB

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
-- Table structure for table `log_info`
--

DROP TABLE IF EXISTS `log_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_info` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `log_type` int(11) NOT NULL,
  `log_what` text NOT NULL,
  PRIMARY KEY (`log_id`),
  UNIQUE KEY `log_info_log_id_uindex` (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_info`
--

LOCK TABLES `log_info` WRITE;
/*!40000 ALTER TABLE `log_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `log_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obill_oupc`
--

DROP TABLE IF EXISTS `obill_oupc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obill_oupc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bill_id` int(11) NOT NULL,
  `operation_user_product_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `obill_oupc_id_uindex` (`id`),
  KEY `obill_oupc_operation_bill_bill_id_fk` (`bill_id`),
  KEY `obill_oupc_operation_user_product_count_operation_id_fk` (`operation_user_product_count`),
  CONSTRAINT `obill_oupc_operation_bill_bill_id_fk` FOREIGN KEY (`bill_id`) REFERENCES `operation_bill` (`bill_id`),
  CONSTRAINT `obill_oupc_operation_user_product_count_operation_id_fk` FOREIGN KEY (`operation_user_product_count`) REFERENCES `operation_user_product_count` (`operation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obill_oupc`
--

LOCK TABLES `obill_oupc` WRITE;
/*!40000 ALTER TABLE `obill_oupc` DISABLE KEYS */;
/*!40000 ALTER TABLE `obill_oupc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operation_bill`
--

DROP TABLE IF EXISTS `operation_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operation_bill` (
  `bill_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `bill_money` int(11) NOT NULL,
  `bill_type` int(11) NOT NULL,
  PRIMARY KEY (`bill_id`),
  UNIQUE KEY `operation_bill_bill_id_uindex` (`bill_id`),
  KEY `operation_bill_user_info_user_id_fk` (`user_id`),
  CONSTRAINT `operation_bill_user_info_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operation_bill`
--

LOCK TABLES `operation_bill` WRITE;
/*!40000 ALTER TABLE `operation_bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `operation_bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operation_user_product_count`
--

DROP TABLE IF EXISTS `operation_user_product_count`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operation_user_product_count` (
  `operation_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `operation_type` int(11) NOT NULL,
  `change_count` int(11) NOT NULL,
  PRIMARY KEY (`operation_id`),
  UNIQUE KEY `operation_user_product_count_operation_id_uindex` (`operation_id`),
  KEY `operation_user_product_count_user_info_user_id_fk` (`user_id`),
  KEY `operation_user_product_count_product_info_product_id_fk` (`product_id`),
  CONSTRAINT `operation_user_product_count_product_info_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`product_id`),
  CONSTRAINT `operation_user_product_count_user_info_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operation_user_product_count`
--

LOCK TABLES `operation_user_product_count` WRITE;
/*!40000 ALTER TABLE `operation_user_product_count` DISABLE KEYS */;
/*!40000 ALTER TABLE `operation_user_product_count` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operation_user_product_price`
--

DROP TABLE IF EXISTS `operation_user_product_price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operation_user_product_price` (
  `operation_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `operation_type` int(11) DEFAULT '0',
  `change_price` double NOT NULL,
  PRIMARY KEY (`operation_id`),
  UNIQUE KEY `operation_user_product_price_operation_id_uindex` (`operation_id`),
  KEY `user_operation_product_user_info_user_id_fk` (`user_id`),
  KEY `operation_user_product_price_product_info_product_id_fk` (`product_id`),
  CONSTRAINT `operation_user_product_price_product_info_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `product_info` (`product_id`),
  CONSTRAINT `user_operation_product_user_info_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operation_user_product_price`
--

LOCK TABLES `operation_user_product_price` WRITE;
/*!40000 ALTER TABLE `operation_user_product_price` DISABLE KEYS */;
/*!40000 ALTER TABLE `operation_user_product_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_info`
--

DROP TABLE IF EXISTS `product_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_info` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` char(30) NOT NULL,
  `product_desc` varchar(50) DEFAULT NULL,
  `product_pic` char(30) DEFAULT NULL,
  `product_count` int(11) DEFAULT '0',
  `product_price` double DEFAULT '0',
  `product_last_change_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `productInfo_productId_uindex` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_info`
--

LOCK TABLES `product_info` WRITE;
/*!40000 ALTER TABLE `product_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_password` char(35) NOT NULL,
  `user_power` int(11) DEFAULT '0',
  `contact_way` char(12) NOT NULL,
  `user_name` char(15) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_info_user_id_uindex` (`user_id`),
  UNIQUE KEY `user_info_user_name_uindex` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
