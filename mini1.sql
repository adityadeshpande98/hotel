-- MySQL dump 10.13  Distrib 5.1.72, for Win64 (unknown)
--
-- Host: 127.0.0.1    Database: miniproject
-- ------------------------------------------------------
-- Server version	5.1.72-community

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
-- Table structure for table `admin_login`
--

DROP TABLE IF EXISTS `admin_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_login` (
  `admin_id` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_login`
--

LOCK TABLES `admin_login` WRITE;
/*!40000 ALTER TABLE `admin_login` DISABLE KEYS */;
INSERT INTO `admin_login` VALUES ('aditya','aditya123');
/*!40000 ALTER TABLE `admin_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_login_history`
--

DROP TABLE IF EXISTS `admin_login_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_login_history` (
  `admin_id` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `dateandtime` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_login_history`
--

LOCK TABLES `admin_login_history` WRITE;
/*!40000 ALTER TABLE `admin_login_history` DISABLE KEYS */;
INSERT INTO `admin_login_history` VALUES ('aditya','aditya123','2018/10/03 15:20:55'),('aditya','aditya123','2018/10/06 10:23:44'),('aditya','aditya123','2018/10/06 10:25:09'),('aditya','aditya123','2018/10/06 10:26:22'),('aditya','aditya123','2018/10/09 23:55:26'),('aditya','aditya123','2018/10/09 23:56:09'),('aditya','aditya123','2018/10/10 11:09:59'),('aditya','aditya123','2018/10/12 15:21:36'),('aditya','aditya123','2018/10/15 08:02:31'),('aditya','aditya123','2018/10/16 14:13:06'),('aditya','aditya123','2018/10/16 22:08:55'),('aditya','aditya123','2018/10/22 09:46:33'),('aditya','aditya123','2018/10/22 09:51:51');
/*!40000 ALTER TABLE `admin_login_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `bid` int(10) NOT NULL AUTO_INCREMENT,
  `tid` int(20) DEFAULT NULL,
  `rno` int(11) DEFAULT NULL,
  `cid` int(20) DEFAULT NULL,
  `rent` int(20) DEFAULT NULL,
  `refresh` int(10) DEFAULT NULL,
  `cab` int(10) DEFAULT NULL,
  `dam` int(10) DEFAULT NULL,
  `tot_bill` int(10) DEFAULT NULL,
  PRIMARY KEY (`bid`),
  KEY `rno` (`rno`),
  KEY `cid` (`cid`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`rno`) REFERENCES `room` (`rno`),
  CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (17,18,55,4,5000,0,0,0,5000),(18,19,55,4,5000,0,0,1200,6200),(19,20,55,60,5000,0,100,1200,6300),(20,21,55,9,5000,0,0,0,5000),(21,22,26,61,2500,0,0,0,2500),(22,23,60,62,5000,500,100,1200,6800),(23,24,56,63,5000,500,50,1000,6550),(24,25,57,64,5000,57,150,1000,6207),(25,26,55,65,5000,0,0,0,5000),(26,27,60,66,5000,0,100,150,5250),(27,28,60,66,5000,0,0,0,5000),(28,29,45,66,3800,0,0,0,3800);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkin`
--

DROP TABLE IF EXISTS `checkin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `checkin` (
  `tid` int(20) NOT NULL AUTO_INCREMENT,
  `indate` date DEFAULT NULL,
  `intime` time DEFAULT NULL,
  `accom` int(10) DEFAULT NULL,
  `duration` int(5) DEFAULT NULL,
  `cid` int(20) DEFAULT NULL,
  `rno` int(10) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `cid` (`cid`),
  KEY `rno` (`rno`),
  CONSTRAINT `checkin_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `customer` (`cid`),
  CONSTRAINT `checkin_ibfk_2` FOREIGN KEY (`rno`) REFERENCES `room` (`rno`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkin`
--

LOCK TABLES `checkin` WRITE;
/*!40000 ALTER TABLE `checkin` DISABLE KEYS */;
/*!40000 ALTER TABLE `checkin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkout`
--

DROP TABLE IF EXISTS `checkout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `checkout` (
  `cname` varchar(20) DEFAULT NULL,
  `rtype` varchar(20) DEFAULT NULL,
  `rrent` int(10) DEFAULT NULL,
  `duration` int(10) DEFAULT NULL,
  `indate` date DEFAULT NULL,
  `outdate` date DEFAULT NULL,
  `rno` int(11) DEFAULT NULL,
  `tot_rent` int(10) DEFAULT NULL,
  KEY `rno` (`rno`),
  CONSTRAINT `checkout_ibfk_1` FOREIGN KEY (`rno`) REFERENCES `room` (`rno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkout`
--

LOCK TABLES `checkout` WRITE;
/*!40000 ALTER TABLE `checkout` DISABLE KEYS */;
INSERT INTO `checkout` VALUES ('gyug','Villa',5000,0,'2018-10-21','2018-10-21',55,5000),('fek','Villa',5000,0,'2018-10-21','2018-10-21',55,6200),('Rahul','Villa',5000,0,'2018-10-21','2018-10-21',55,6300),('tanmay','Villa',5000,0,'2018-10-21','2018-10-21',55,5000),('Lily','Delux',2500,0,'2018-10-21','2018-10-21',26,2500),('Radhika Phadke','Villa',5000,0,'2018-10-22','2018-10-22',60,6800),('Saloni','Villa',5000,0,'2018-10-22','2018-10-22',56,6550),('Manasi','Villa',5000,0,'2018-10-22','2018-10-22',57,6207),('Kabir','Villa',5000,0,'2018-10-22','2018-10-22',55,5000),('Isha','Villa',5000,0,'2018-10-22','2018-10-22',60,5250),('Isha','Villa',5000,0,'2018-10-22','2018-10-22',60,5000),('Isha','Cottage',3800,0,'2018-10-22','2018-10-22',45,3800);
/*!40000 ALTER TABLE `checkout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `cid` int(20) NOT NULL,
  `cname` varchar(30) DEFAULT NULL,
  `id` varchar(20) DEFAULT NULL,
  `idno` int(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Aditya','Pan Card',52552),(2,'ketki','Lisence',85241),(3,'tanmay','Pan Card',6352525),(4,'sameer','Pan Card',5525205),(6,'adya','Pan Card',85252),(7,'sameer','Adhaar',85952),(9,'tanmay','Pan Card',554445),(10,'Tanmay Bhawsar','Adhaar',745213698),(15,'Lily','Adhaar',852864),(16,'Lily','Pan Card',4847896),(18,'Sallo','Adhaar',45555),(20,'Sam','Adhaar',2687962),(30,'Swanand','Adhaar',4654897),(31,'Arjun','Pan Card',1524789),(32,'lola','Pan Card',485486),(34,'Adi','Lisence',2335),(35,'Nisha','Lisence',46884894),(60,'Rahul','Pan Card',546854),(61,'Lily','Pan Card',57547),(62,'Radhika Phadke','Adhaar',1565465),(63,'Saloni','Lisence',78624788),(64,'Manasi','Lisence',87912),(65,'Kabir','Lisence',654684),(66,'Isha','Adhaar',7896);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `user_id` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('aditya','aditya123'),('tanmay','tanmay123'),('ketki','ketki123'),('sameer','sam123'),('sameer','abcd');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_history`
--

DROP TABLE IF EXISTS `login_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_history` (
  `user_id` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `dateandtime` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_history`
--

LOCK TABLES `login_history` WRITE;
/*!40000 ALTER TABLE `login_history` DISABLE KEYS */;
INSERT INTO `login_history` VALUES ('aditya','aditya123','2018/09/26 23:36:09'),('aditya','aditya123','2018/09/26 23:38:29'),('aditya','aditya123','2018/09/26 23:38:50'),('aditya','aditya123','2018/09/26 23:49:38'),('aditya','aditya123','2018/09/27 09:40:49'),('aditya','aditya123','2018/09/27 09:41:05'),('aditya','aditya123','2018/09/30 11:30:17'),('aditya','aditya123','2018/09/30 12:13:14'),('aditya','aditya123','2018/09/30 12:15:02'),('aditya','aditya123','2018/09/30 12:51:06'),('aditya','aditya123','2018/09/30 12:54:32'),('aditya','aditya123','2018/09/30 13:04:17'),('aditya','aditya123','2018/09/30 13:09:22'),('aditya','aditya123','2018/09/30 13:14:20'),('aditya','aditya123','2018/09/30 13:16:54'),('aditya','aditya123','2018/09/30 13:24:31'),('aditya','aditya123','2018/09/30 13:26:57'),('aditya','aditya123','2018/09/30 13:29:38'),('aditya','aditya123','2018/09/30 13:34:45'),('aditya','aditya123','2018/09/30 13:39:01'),('aditya','aditya123','2018/09/30 13:40:57'),('aditya','aditya123','2018/09/30 13:42:37'),('aditya','aditya123','2018/09/30 13:45:39'),('aditya','aditya123','2018/09/30 13:46:25'),('aditya','aditya123','2018/09/30 14:26:14'),('aditya','aditya123','2018/10/02 17:10:26'),('tanmay','tanmay123','2018/10/03 13:30:27'),('aditya','aditya123','2018/10/03 15:12:55'),('aditya','aditya123','2018/10/03 15:18:37'),('aditya','aditya123','2018/10/03 15:20:17'),('aditya','aditya123','2018/10/03 15:24:24'),('aditya','aditya123','2018/10/05 09:50:35'),('aditya','aditya123','2018/10/06 00:45:43'),('aditya','aditya123','2018/10/06 01:10:27'),('aditya','aditya123','2018/10/06 07:36:21'),('aditya','aditya123','2018/10/06 10:12:31'),('aditya','aditya123','2018/10/06 10:24:22'),('aditya','aditya123','2018/10/06 10:28:57'),('aditya','aditya123','2018/10/06 10:29:39'),('aditya','aditya123','2018/10/09 19:19:57'),('ketki','ketki123','2018/10/09 23:57:05'),('aditya','aditya123','2018/10/10 00:04:48'),('sameer','sam123','2018/10/10 11:10:55'),('aditya','aditya123','2018/10/12 14:25:57'),('aditya','aditya123','2018/10/12 14:38:28'),('aditya','aditya123','2018/10/12 15:22:28'),('ketki','ketki123','2018/10/15 08:00:08'),('aditya','aditya123','2018/10/16 14:13:31'),('aditya','aditya123','2018/10/16 22:09:54'),('aditya','aditya123','2018/10/16 22:18:51'),('aditya','aditya123','2018/10/16 22:24:58'),('aditya','aditya123','2018/10/16 22:50:24'),('aditya','aditya123','2018/10/16 22:56:51'),('aditya','aditya123','2018/10/16 23:18:21'),('aditya','aditya123','2018/10/16 23:23:22'),('aditya','aditya123','2018/10/16 23:25:27'),('aditya','aditya123','2018/10/16 23:28:58'),('aditya','aditya123','2018/10/16 23:56:17'),('aditya','aditya123','2018/10/17 00:03:00'),('aditya','aditya123','2018/10/17 06:06:24'),('aditya','aditya123','2018/10/17 07:29:38'),('aditya','aditya123','2018/10/17 07:48:22'),('aditya','aditya123','2018/10/19 07:28:27'),('aditya','aditya123','2018/10/20 11:34:50'),('ketki','ketki123','2018/10/20 11:58:17'),('ketki','ketki123','2018/10/20 12:02:06'),('ketki','ketki123','2018/10/20 12:36:11'),('ketki','ketki123','2018/10/20 12:43:25'),('ketki','ketki123','2018/10/20 12:55:29'),('ketki','ketki123','2018/10/20 13:10:26'),('ketki','ketki123','2018/10/20 13:13:56'),('ketki','ketki123','2018/10/20 15:43:31'),('ketki','ketki123','2018/10/20 15:56:24'),('ketki','ketki123','2018/10/20 16:10:19'),('ketki','ketki123','2018/10/20 16:29:21'),('ketki','ketki123','2018/10/20 16:37:24'),('ketki','ketki123','2018/10/20 16:40:23'),('ketki','ketki123','2018/10/20 16:46:16'),('ketki','ketki123','2018/10/20 22:22:36'),('ketki','ketki123','2018/10/20 22:52:33'),('ketki','ketki123','2018/10/21 15:21:22'),('ketki','ketki123','2018/10/21 15:24:19'),('ketki','ketki123','2018/10/21 15:25:57'),('ketki','ketki123','2018/10/21 15:29:43'),('ketki','ketki123','2018/10/21 20:12:09'),('ketki','ketki123','2018/10/21 20:17:13'),('ketki','ketki123','2018/10/21 20:24:40'),('ketki','ketki123','2018/10/21 20:29:13'),('ketki','ketki123','2018/10/21 20:33:34'),('ketki','ketki123','2018/10/21 22:29:58'),('ketki','ketki123','2018/10/21 22:42:28'),('ketki','ketki123','2018/10/21 22:45:34'),('ketki','ketki123','2018/10/21 22:55:22'),('ketki','ketki123','2018/10/21 22:57:14'),('ketki','ketki123','2018/10/21 23:18:48'),('ketki','ketki123','2018/10/21 23:46:57'),('ketki','ketki123','2018/10/21 23:58:23'),('ketki','ketki123','2018/10/22 00:22:01'),('ketki','ketki123','2018/10/22 08:34:03'),('ketki','ketki123','2018/10/22 08:57:51'),('ketki','ketki123','2018/10/22 09:09:08'),('ketki','ketki123','2018/10/22 09:31:46'),('ketki','ketki123','2018/10/22 09:35:21'),('ketki','ketki123','2018/10/22 09:42:12'),('ketki','ketki123','2018/10/22 09:44:49');
/*!40000 ALTER TABLE `login_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `rno` int(10) NOT NULL,
  `rtype` varchar(30) DEFAULT NULL,
  `rsize` int(5) DEFAULT NULL,
  `avail` varchar(10) DEFAULT NULL,
  `rent` int(10) DEFAULT NULL,
  PRIMARY KEY (`rno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'Double',2,'y',1000),(2,'Double',2,'y',1000),(3,'Double',2,'y',1000),(4,'Double',2,'y',1000),(5,'Double',2,'y',1000),(6,'Double',2,'y',1000),(7,'Double',2,'y',1000),(8,'Double',2,'y',1000),(9,'Double',2,'y',1000),(10,'Double',2,'y',1000),(11,'Double',2,'y',1000),(12,'Double',2,'y',1000),(13,'Double',2,'y',1000),(14,'Double',2,'y',1000),(15,'Double',2,'y',1000),(16,'Double',2,'y',1000),(17,'Double',2,'y',1000),(18,'Double',2,'y',1000),(19,'Double',2,'y',1000),(20,'Double',2,'y',1000),(21,'Delux',2,'y',2500),(22,'Delux',2,'y',2500),(23,'Delux',2,'y',2500),(24,'Delux',2,'y',2500),(25,'Delux',2,'y',2500),(26,'Delux',2,'y',2500),(27,'Delux',2,'y',2500),(28,'Delux',2,'y',2500),(29,'Delux',2,'y',2500),(30,'Delux',2,'y',2500),(31,'Delux',2,'y',2500),(32,'Delux',2,'y',2500),(33,'Delux',2,'y',2500),(34,'Delux',2,'y',2500),(35,'Delux',2,'y',2500),(36,'Delux',2,'y',2500),(37,'Delux',2,'y',2500),(38,'Delux',2,'y',2500),(39,'Delux',2,'y',2500),(40,'Delux',2,'y',2500),(41,'Cottage',2,'y',3800),(42,'Cottage',2,'y',3800),(43,'Cottage',2,'y',3800),(44,'Cottage',2,'y',3800),(45,'Cottage',2,'y',3800),(46,'Cottage',2,'y',3800),(47,'Cottage',2,'y',3800),(48,'Cottage',2,'y',3800),(49,'Cottage',2,'y',3800),(50,'Cottage',2,'y',3800),(51,'Villa',4,'y',5000),(52,'Villa',4,'y',5000),(53,'Villa',4,'y',5000),(54,'Villa',4,'y',5000),(55,'Villa',4,'y',5000),(56,'Villa',4,'y',5000),(57,'Villa',4,'y',5000),(58,'Villa',4,'y',5000),(59,'Villa',4,'y',5000),(60,'Villa',4,'y',5000);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `sid` int(10) NOT NULL AUTO_INCREMENT,
  `rno` int(10) DEFAULT NULL,
  `refresh` int(10) DEFAULT NULL,
  `cab` int(10) DEFAULT NULL,
  `damage` int(10) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `rno` (`rno`),
  CONSTRAINT `services_ibfk_1` FOREIGN KEY (`rno`) REFERENCES `room` (`rno`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-22  9:55:20
