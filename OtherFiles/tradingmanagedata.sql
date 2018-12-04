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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_base`
--

LOCK TABLES `t_log_base` WRITE;
/*!40000 ALTER TABLE `t_log_base` DISABLE KEYS */;
INSERT INTO `t_log_base` VALUES (1,'2018-11-28 09:30:10',1,0,'添加产品：鲸鱼'),(2,'2018-11-28 09:30:10',1,1,'产品初次添加入库'),(3,'2018-11-29 13:59:57',1,1,'产品出库'),(4,'2018-11-29 14:15:43',1,1,'产品：鲸鱼出库'),(5,'2018-11-29 14:22:04',1,2,'产品：鲸鱼价格减少'),(6,'2018-11-29 15:05:27',1,0,'添加产品：海豚'),(7,'2018-11-29 15:05:27',1,1,'海豚产品初次添加入库'),(8,'2018-11-29 15:06:39',1,0,'添加产品：海绵宝宝'),(9,'2018-11-29 15:06:39',1,1,'海绵宝宝产品初次添加入库'),(10,'2018-11-29 18:40:24',1,2,'产品：海豚价格减少'),(11,'2018-11-29 18:40:33',1,1,'产品：海豚出库'),(12,'2018-11-30 10:17:12',1,2,'产品：海豚价格提高'),(13,'2018-11-30 13:44:38',1,0,'添加产品：派大星'),(14,'2018-11-30 13:44:38',1,1,'派大星产品初次添加入库'),(15,'2018-11-30 13:48:09',1,1,'产品：派大星入库'),(16,'2018-12-03 19:04:28',1,1,'产品：鲸鱼入库'),(17,'2018-12-03 19:16:52',1,1,'产品：海豚出库'),(18,'2018-12-03 19:16:58',1,1,'产品：海豚出库'),(19,'2018-12-03 19:23:59',1,1,'产品：派大星出库'),(20,'2018-12-03 19:25:32',1,0,'添加产品：测试数据'),(21,'2018-12-03 19:25:32',1,1,'测试数据产品初次添加入库'),(22,'2018-12-03 20:30:48',1,1,'产品：海豚入库'),(23,'2018-12-03 20:31:05',1,2,'产品：海豚价格减少'),(24,'2018-12-03 22:25:33',1,0,'添加产品：冗余测试数据'),(25,'2018-12-03 22:25:33',1,1,'冗余测试数据产品初次添加入库'),(26,'2018-12-03 22:28:45',1,0,'添加产品：测试告急数据'),(27,'2018-12-03 22:28:45',1,1,'测试告急数据产品初次添加入库'),(28,'2018-12-03 22:28:45',1,2,'测试告急数据产品初次添加入库'),(29,'2018-12-03 22:29:43',1,0,'添加产品：测试变动数据'),(30,'2018-12-03 22:29:43',1,1,'测试变动数据产品初次添加入库'),(31,'2018-12-03 22:29:43',1,2,'测试变动数据产品初次添加入库'),(32,'2018-12-03 22:29:52',1,1,'产品：测试变动数据入库'),(33,'2018-12-03 22:30:42',1,2,'产品：冗余测试数据价格提高');
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
  CONSTRAINT `t_log_change_product_count_t_log_base_log_id_fk` FOREIGN KEY (`log_id`) REFERENCES `t_log_base` (`log_id`),
  CONSTRAINT `t_log_change_product_count_t_product_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_change_product_count`
--

LOCK TABLES `t_log_change_product_count` WRITE;
/*!40000 ALTER TABLE `t_log_change_product_count` DISABLE KEYS */;
INSERT INTO `t_log_change_product_count` VALUES (1,2,1,0,5.6,100),(2,3,1,100,5.6,70),(3,4,1,70,5.6,56),(4,7,2,0,71.6,500),(5,9,3,0,75,10),(6,11,2,500,10000,100),(7,14,4,0,100.5,50),(8,15,4,50,100.5,1000),(9,16,1,56,56,1200),(10,17,2,100,100,50),(11,18,2,50,100,26),(12,19,4,1000,100.5,103),(13,21,5,0,100,10000),(14,22,2,26,100,73),(15,25,6,0,0,1000),(16,27,7,0,0,100),(17,30,8,0,0,100),(18,32,8,100,100,600);
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
  `product_old_price` double NOT NULL,
  `product_new_price` double NOT NULL,
  PRIMARY KEY (`lcpp_id`),
  UNIQUE KEY `t_log_change_product_price_lcpp_id_uindex` (`lcpp_id`),
  KEY `t_log_change_product_price_t_log_base_log_id_fk` (`log_id`),
  KEY `t_log_change_product_price_t_product_product_id_fk` (`product_id`),
  CONSTRAINT `t_log_change_product_price_t_log_base_log_id_fk` FOREIGN KEY (`log_id`) REFERENCES `t_log_base` (`log_id`),
  CONSTRAINT `t_log_change_product_price_t_product_product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_change_product_price`
--

LOCK TABLES `t_log_change_product_price` WRITE;
/*!40000 ALTER TABLE `t_log_change_product_price` DISABLE KEYS */;
INSERT INTO `t_log_change_product_price` VALUES (1,5,1,56,5.6,56),(2,10,2,500,71.6,10000),(3,12,2,100,10000,100),(4,23,2,73,100,5000),(5,28,7,100,0,100),(6,31,8,100,0,100),(7,33,6,1000,100,50);
/*!40000 ALTER TABLE `t_log_change_product_price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_log_obill_operation`
--

DROP TABLE IF EXISTS `t_log_obill_operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_log_obill_operation` (
  `loo_id` int(11) NOT NULL AUTO_INCREMENT,
  `obill_id` int(11) DEFAULT NULL,
  `log_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`loo_id`),
  UNIQUE KEY `t_log_obill_operation_loo_id_uindex` (`loo_id`),
  KEY `t_log_obill_operation_t_log_base_log_id_fk` (`log_id`),
  KEY `t_log_obill_operation_t_obill_info_obill_fk` (`obill_id`),
  CONSTRAINT `t_log_obill_operation_t_log_base_log_id_fk` FOREIGN KEY (`log_id`) REFERENCES `t_log_base` (`log_id`),
  CONSTRAINT `t_log_obill_operation_t_obill_info_obill_fk` FOREIGN KEY (`obill_id`) REFERENCES `t_obill_info` (`obill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_obill_operation`
--

LOCK TABLES `t_log_obill_operation` WRITE;
/*!40000 ALTER TABLE `t_log_obill_operation` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_log_obill_operation` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (1,'鲸鱼','暂无',1,56,1200,1000,10),(2,'海豚','海豚而已啦',0,5000,73,100,10),(3,'海绵宝宝','派大星呢',0,75,10,100,20),(4,'派大星','海绵宝宝我在这里',1,100.5,103,200,100),(5,'测试数据','测试系统成像是否成功',0,100,10000,20000,5000),(6,'冗余测试数据','测试冗余状态',0,50,1000,800,200),(7,'测试告急数据','测试告急数据',0,100,100,800,200),(8,'测试变动数据','测试数据经常变动',0,100,600,800,200);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user_infos`
--

LOCK TABLES `t_user_infos` WRITE;
/*!40000 ALTER TABLE `t_user_infos` DISABLE KEYS */;
INSERT INTO `t_user_infos` VALUES (1,'Admin@qq.com','a123456',1);
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

-- Dump completed on 2018-12-04 11:49:05
