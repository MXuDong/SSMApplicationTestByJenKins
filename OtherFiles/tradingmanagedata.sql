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
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_base`
--

LOCK TABLES `t_log_base` WRITE;
/*!40000 ALTER TABLE `t_log_base` DISABLE KEYS */;
INSERT INTO `t_log_base` VALUES (1,'2018-11-28 09:30:10',1,0,'添加产品：鲸鱼'),(2,'2018-11-28 09:30:10',1,1,'产品初次添加入库'),(3,'2018-11-29 13:59:57',1,1,'产品出库'),(4,'2018-11-29 14:15:43',1,1,'产品：鲸鱼出库'),(5,'2018-11-29 14:22:04',1,2,'产品：鲸鱼价格减少'),(6,'2018-11-29 15:05:27',1,0,'添加产品：海豚'),(7,'2018-11-29 15:05:27',1,1,'海豚产品初次添加入库'),(8,'2018-11-29 15:06:39',1,0,'添加产品：海绵宝宝'),(9,'2018-11-29 15:06:39',1,1,'海绵宝宝产品初次添加入库'),(10,'2018-11-29 18:40:24',1,2,'产品：海豚价格减少'),(11,'2018-11-29 18:40:33',1,1,'产品：海豚出库'),(12,'2018-11-30 10:17:12',1,2,'产品：海豚价格提高'),(13,'2018-11-30 13:44:38',1,0,'添加产品：派大星'),(14,'2018-11-30 13:44:38',1,1,'派大星产品初次添加入库'),(15,'2018-11-30 13:48:09',1,1,'产品：派大星入库'),(16,'2018-12-03 19:04:28',1,1,'产品：鲸鱼入库'),(17,'2018-12-03 19:16:52',1,1,'产品：海豚出库'),(18,'2018-12-03 19:16:58',1,1,'产品：海豚出库'),(19,'2018-12-03 19:23:59',1,1,'产品：派大星出库'),(20,'2018-12-03 19:25:32',1,0,'添加产品：测试数据'),(21,'2018-12-03 19:25:32',1,1,'测试数据产品初次添加入库'),(22,'2018-12-03 20:30:48',1,1,'产品：海豚入库'),(23,'2018-12-03 20:31:05',1,2,'产品：海豚价格减少'),(24,'2018-12-03 22:25:33',1,0,'添加产品：冗余测试数据'),(25,'2018-12-03 22:25:33',1,1,'冗余测试数据产品初次添加入库'),(26,'2018-12-03 22:28:45',1,0,'添加产品：测试告急数据'),(27,'2018-12-03 22:28:45',1,1,'测试告急数据产品初次添加入库'),(28,'2018-12-03 22:28:45',1,2,'测试告急数据产品初次添加入库'),(29,'2018-12-03 22:29:43',1,0,'添加产品：测试变动数据'),(30,'2018-12-03 22:29:43',1,1,'测试变动数据产品初次添加入库'),(31,'2018-12-03 22:29:43',1,2,'测试变动数据产品初次添加入库'),(32,'2018-12-03 22:29:52',1,1,'产品：测试变动数据入库'),(33,'2018-12-03 22:30:42',1,2,'产品：冗余测试数据价格提高'),(34,'2018-12-04 11:51:11',1,2,'产品：海绵宝宝价格减少'),(35,'2018-12-04 11:51:22',1,1,'产品：海绵宝宝入库'),(36,'2018-12-04 11:51:57',1,1,'产品：冗余测试数据出库'),(37,'2018-12-04 11:52:04',1,2,'产品：冗余测试数据价格提高'),(38,'2018-12-04 11:52:20',1,1,'产品：测试告急数据入库'),(39,'2018-12-04 11:52:30',1,2,'产品：测试告急数据价格提高'),(40,'2018-12-04 11:52:49',1,1,'产品：测试变动数据出库'),(41,'2018-12-04 11:53:01',1,2,'产品：测试变动数据价格提高'),(42,'2018-12-04 11:53:44',1,1,'产品：海豚出库'),(43,'2018-12-04 11:53:51',1,1,'产品：海豚出库'),(44,'2018-12-04 11:54:02',1,2,'产品：海豚价格提高'),(45,'2018-12-04 11:54:30',1,1,'产品：派大星出库'),(46,'2018-12-04 11:55:08',1,1,'产品：鲸鱼出库'),(47,'2018-12-04 11:55:23',1,2,'产品：鲸鱼价格提高'),(53,'2018-12-04 20:33:04',1,1,'产品：测试数据出库'),(54,'2018-12-04 22:21:35',1,0,'添加产品：赵本山'),(55,'2018-12-04 22:21:35',1,2,'赵本山产品初次添加入库'),(56,'2018-12-04 22:21:35',1,1,'赵本山产品初次添加入库'),(57,'2018-12-04 22:25:14',1,0,'添加产品：批产1'),(58,'2018-12-04 22:25:14',1,2,'批产1产品初次添加入库'),(59,'2018-12-04 22:25:14',1,1,'批产1产品初次添加入库'),(60,'2018-12-04 22:25:14',1,0,'添加产品：批产2'),(61,'2018-12-04 22:25:14',1,2,'批产2产品初次添加入库'),(62,'2018-12-04 22:25:14',1,1,'批产2产品初次添加入库'),(63,'2018-12-04 22:25:14',1,0,'添加产品：批产3'),(64,'2018-12-04 22:25:14',1,2,'批产3产品初次添加入库'),(65,'2018-12-04 22:25:14',1,1,'批产3产品初次添加入库'),(66,'2018-12-04 22:25:14',1,0,'添加产品：批产4'),(67,'2018-12-04 22:25:14',1,2,'批产4产品初次添加入库'),(68,'2018-12-04 22:25:14',1,1,'批产4产品初次添加入库'),(69,'2018-12-04 22:31:34',1,2,'产品：测试数据价格减少'),(77,'2018-12-06 16:11:54',1,0,'添加产品：批产5'),(78,'2018-12-06 16:11:54',1,2,'批产5产品初次添加入库'),(79,'2018-12-06 16:11:54',1,1,'批产5产品初次添加入库'),(80,'2018-12-06 16:11:54',1,0,'添加产品：批产6'),(81,'2018-12-06 16:11:54',1,2,'批产6产品初次添加入库'),(82,'2018-12-06 16:11:54',1,1,'批产6产品初次添加入库'),(83,'2018-12-06 16:11:54',1,0,'添加产品：批产7'),(84,'2018-12-06 16:11:54',1,2,'批产7产品初次添加入库'),(85,'2018-12-06 16:11:54',1,1,'批产7产品初次添加入库'),(86,'2018-12-06 16:11:54',1,0,'添加产品：批产8'),(87,'2018-12-06 16:11:54',1,2,'批产8产品初次添加入库'),(88,'2018-12-06 16:11:54',1,1,'批产8产品初次添加入库'),(89,'2018-12-06 16:15:26',1,1,'产品：测试数据出库'),(90,'2018-12-06 16:16:00',1,2,'产品：测试数据价格减少'),(91,'2018-12-12 09:37:56',1,1,'产品：鲸鱼出库');
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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_change_product_count`
--

LOCK TABLES `t_log_change_product_count` WRITE;
/*!40000 ALTER TABLE `t_log_change_product_count` DISABLE KEYS */;
INSERT INTO `t_log_change_product_count` VALUES (1,2,1,0,5.6,100),(2,3,1,100,5.6,70),(3,4,1,70,5.6,56),(4,7,2,0,71.6,500),(5,9,3,0,75,10),(6,11,2,500,10000,100),(7,14,4,0,100.5,50),(8,15,4,50,100.5,1000),(9,16,1,56,56,1200),(10,17,2,100,100,50),(11,18,2,50,100,26),(12,19,4,1000,100.5,103),(13,21,5,0,100,10000),(14,22,2,26,100,73),(15,25,6,0,0,1000),(16,27,7,0,0,100),(17,30,8,0,0,100),(18,32,8,100,100,600),(19,35,3,10,75.5,65),(20,36,6,1000,50,900),(21,38,7,100,100,136),(22,40,8,600,100,100),(23,42,2,73,5000,50),(24,43,2,50,5000,30),(25,45,4,103,100.5,78),(26,46,1,1200,56,1150),(27,53,5,10000,100,5000),(28,56,9,0,56.6,78),(29,59,10,0,100,125),(30,62,11,0,100,125),(31,65,12,0,100,125),(32,68,13,0,100,125),(33,79,14,0,100,125),(34,82,15,0,100,125),(35,85,16,0,100,125),(36,88,17,0,100,125),(37,89,5,5000,101,3000),(38,91,1,1150,50.36,950);
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_log_change_product_price`
--

LOCK TABLES `t_log_change_product_price` WRITE;
/*!40000 ALTER TABLE `t_log_change_product_price` DISABLE KEYS */;
INSERT INTO `t_log_change_product_price` VALUES (1,5,1,56,5.6,56),(2,10,2,500,71.6,10000),(3,12,2,100,10000,100),(4,23,2,73,100,5000),(5,28,7,100,0,100),(6,31,8,100,0,100),(7,33,6,1000,100,50),(8,34,3,10,75,75.5),(9,37,6,900,50,49),(10,39,7,136,100,75),(11,41,8,100,100,78.6),(12,44,2,30,5000,4936.54),(13,47,1,1150,56,50.36),(14,55,9,0,0,56.6),(15,58,10,0,0,100),(16,61,11,0,0,100),(17,64,12,0,0,100),(18,67,13,0,0,100),(19,69,5,5000,100,101),(20,78,14,0,0,100),(21,81,15,0,0,100),(22,84,16,0,0,100),(23,87,17,0,0,100),(24,90,5,3000,101,110);
/*!40000 ALTER TABLE `t_log_change_product_price` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_obill_info`
--

LOCK TABLES `t_obill_info` WRITE;
/*!40000 ALTER TABLE `t_obill_info` DISABLE KEYS */;
INSERT INTO `t_obill_info` VALUES (12,'2018-12-06 16:03:33',3554566.1);
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (1,'鲸鱼','暂无',1,50.36,950,1000,10),(2,'海豚','海豚而已啦',0,4936.54,30,100,10),(3,'海绵宝宝','派大星呢',0,75.5,65,100,20),(4,'派大星','海绵宝宝我在这里',1,100.5,78,200,100),(5,'测试数据','测试系统成像是否成功',1,110,3000,20000,5000),(6,'冗余测试数据','测试冗余状态',0,49,900,800,200),(7,'测试告急数据','测试告急数据',0,75,136,800,200),(8,'测试变动数据','测试数据经常变动',0,78.6,100,800,200),(9,'赵本山','无',0,56.6,78,800,98),(10,'批产1','测试批量上传',0,100,125,200,50),(11,'批产2','测试批量上传',0,100,125,200,50),(12,'批产3','测试批量上传',0,100,125,200,50),(13,'批产4','测试批量上传',0,100,125,200,50),(14,'批产5','测试批量上传',0,100,125,200,50),(15,'批产6','测试批量上传',0,100,125,200,50),(16,'批产7','测试批量上传',0,100,125,200,50),(17,'批产8','测试批量上传',0,100,125,200,50);
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

-- Dump completed on 2018-12-24 20:20:53
