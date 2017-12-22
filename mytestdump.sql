-- MySQL dump 10.13  Distrib 5.5.58, for Win64 (AMD64)
--
-- Host: localhost    Database: student_progress
-- ------------------------------------------------------
-- Server version	5.5.58-log

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id_account` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id_account`),
  UNIQUE KEY `id_account_UNIQUE` (`id_account`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'firstID','123654'),(2,'secondID','123546'),(3,'admin','123');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_role`
--

DROP TABLE IF EXISTS `account_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_role` (
  `id_account_role` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_account` bigint(20) NOT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id_account_role`),
  KEY `fk1_idx` (`id_account`),
  KEY `fk2_idx` (`id_role`),
  CONSTRAINT `fk1` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk2` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_role`
--

LOCK TABLES `account_role` WRITE;
/*!40000 ALTER TABLE `account_role` DISABLE KEYS */;
INSERT INTO `account_role` VALUES (1,1,1),(2,1,2),(3,2,2),(4,3,1),(5,3,2);
/*!40000 ALTER TABLE `account_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `discipline` (
  `id_discipline` bigint(20) NOT NULL AUTO_INCREMENT,
  `discipline` longtext NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_discipline`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discipline`
--

LOCK TABLES `discipline` WRITE;
/*!40000 ALTER TABLE `discipline` DISABLE KEYS */;
INSERT INTO `discipline` VALUES (1,'Высшая Математика',1),(2,'История Науки и Техника',1),(3,'понт',1),(4,'Информатика',1),(5,'Теория Алгоритмизации',1),(6,'Системный Анализ',1),(7,'Управление Проэктами',1),(8,'Основы Дискретной Математики',1),(9,'jkjkjkjk',0),(10,'jkjkjkjk',0),(11,'kkk',1),(12,'kopko',1),(13,'Ð¿Ð¿',0),(14,'ÑÑÑÐºÐ°ÐºÑ',0),(15,'Ð²Ð¿Ð°Ð²Ð¿',0),(16,'Ð¿Ð°ÑÐ°Ñ',0),(17,'ÐµÐµÐµ',0),(18,'try',1),(19,'Ð°Ð¿Ð¿Ð¿Ð¿Ðº',0),(20,'jkjkjkkj',1),(21,'English Grammar',1),(22,'Rharmacia',1);
/*!40000 ALTER TABLE `discipline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mark`
--

DROP TABLE IF EXISTS `mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mark` (
  `id_mark` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_student` bigint(20) NOT NULL,
  `id_term_discipline` bigint(20) NOT NULL,
  `mark` int(11) NOT NULL,
  PRIMARY KEY (`id_mark`),
  KEY `fk5_idx` (`id_student`),
  KEY `fk6_idx` (`id_term_discipline`),
  CONSTRAINT `fk5` FOREIGN KEY (`id_student`) REFERENCES `student` (`id_student`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk6` FOREIGN KEY (`id_term_discipline`) REFERENCES `term_disciplin` (`id_term_discipline`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mark`
--

LOCK TABLES `mark` WRITE;
/*!40000 ALTER TABLE `mark` DISABLE KEYS */;
INSERT INTO `mark` VALUES (1,1,4,5),(2,1,13,4),(3,1,14,5),(4,1,15,4),(5,1,6,3),(6,1,7,4),(7,1,8,3);
/*!40000 ALTER TABLE `mark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Администратор'),(2,'Студент'),(3,'Учитель');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id_student` bigint(20) NOT NULL AUTO_INCREMENT,
  `surname` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `groupe` varchar(45) NOT NULL,
  `entry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_student`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Петрович','Петр','КТ-21','2017-12-15 16:20:17',1),(2,'Сидор','Сидр','КТ-21','2017-11-01 15:47:57',0),(3,'Иванов','Иван','КТ-21','2017-03-31 21:00:00',1),(4,'Макаревич','Андрей','КТ-21','2015-09-01 16:47:24',1),(5,'Васильев','Василий','КТ-21','2016-03-31 21:00:00',1),(6,'Михайлов','Александр','КТ-21','2017-11-24 08:06:57',0),(7,'Андреев','Андрей','КТ-21','2017-11-01 15:54:55',0),(8,'Котляр','Алексей','КТ-21','2017-01-10 22:00:00',1),(9,'Козлов','Максим','КТ-21','2017-11-01 15:54:55',0),(10,'Михайлов','Александр','КТ-21','2017-12-12 18:11:41',0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `term`
--

DROP TABLE IF EXISTS `term`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `term` (
  `id_term` bigint(20) NOT NULL AUTO_INCREMENT,
  `terms_name` varchar(45) NOT NULL,
  `duration` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_term`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `term`
--

LOCK TABLES `term` WRITE;
/*!40000 ALTER TABLE `term` DISABLE KEYS */;
INSERT INTO `term` VALUES (1,'Семестр 1',24,1),(2,'Семестр 2',18,1),(3,'Семестр 3',15,1),(21,'',0,1),(22,'Семестр 4',12,1),(28,'ghjgfhf',7,1),(30,'yghjgjgj',89,1),(31,'Семестр 20',14,1),(32,'Семестр 6',13,1),(33,'Семестр 4',21,1),(34,'Семестр 77',55,1),(35,'Семестр 8',12,1),(36,'Семестр 9',26,1),(37,'Семестр 9',45,1),(38,'Семестр 9',45,1),(39,'Семестр 9',23,1),(40,'Семестр 9',12,1),(41,'Семестр 9',12,1),(42,'Семестр 9',12,1),(43,'Семестр 9',12,1),(44,'10',10,1),(45,'10',10,1),(46,'11',11,1),(47,'Семестр 12',12,1),(48,'Семестр 13',13,1),(49,'Семестр 14',14,1),(50,'Семестр 16',16,1),(51,'Семестр 17',17,1),(52,'Семестр 9',12,1),(53,'Семестр 4',12,1),(54,'Семестр 4',99,1),(55,'ololo',99,1),(56,'ololo',99,1),(57,'ololol',99,1),(58,'Семестр 35',35,1),(59,'ghgfhtgfhfghgfh',99,1),(60,'Семестр 16',13,1),(61,'Семестр 44',22,1),(62,'Семестр 55',11,1),(63,'well',10,1),(64,'Александр2',4,1),(65,'Семестр 5',0,1),(66,'Семестр 4',56,1),(67,'Семестр 30',16,1),(68,'err',12,1),(69,'Семестр 4',123,1),(70,'Семестр 12',23,1),(71,'Семестр 5',5,1),(72,'vn',23,1),(73,'gfjghjghjghj',778,1),(74,'gfgfg',7,1),(75,'newwww',2,0),(76,'ghghgfhgfhf',6868,1),(77,'arf',423,0),(78,'new',12,1),(79,'new1',11,1);
/*!40000 ALTER TABLE `term` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `term_disciplin`
--

DROP TABLE IF EXISTS `term_disciplin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `term_disciplin` (
  `id_term_discipline` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_term` bigint(20) NOT NULL,
  `id_discipline` bigint(20) NOT NULL,
  PRIMARY KEY (`id_term_discipline`),
  KEY `fk3_idx` (`id_term`),
  KEY `fk4_idx` (`id_discipline`),
  CONSTRAINT `fk3` FOREIGN KEY (`id_term`) REFERENCES `term` (`id_term`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk4` FOREIGN KEY (`id_discipline`) REFERENCES `discipline` (`id_discipline`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `term_disciplin`
--

LOCK TABLES `term_disciplin` WRITE;
/*!40000 ALTER TABLE `term_disciplin` DISABLE KEYS */;
INSERT INTO `term_disciplin` VALUES (7,2,4),(8,2,5),(9,3,1),(11,3,5),(13,1,6),(14,1,7),(47,35,6),(52,40,6),(58,52,21),(64,58,2),(66,60,2),(67,61,6),(68,62,21),(70,64,2),(71,65,1),(72,66,1),(73,67,6),(74,68,1),(75,69,1),(76,70,1),(77,71,2),(78,72,1),(79,73,1),(80,74,1),(81,75,1),(82,77,4),(84,78,1),(88,79,2),(89,79,4),(91,60,8),(92,60,21),(93,2,21),(94,2,22),(95,34,2),(97,79,21),(98,79,22),(99,35,21),(101,40,3),(102,40,12),(103,34,9),(104,34,10),(105,34,11),(106,34,12),(107,34,18),(108,34,20),(111,1,9),(113,1,1),(114,1,2),(120,1,21),(121,1,22),(124,1,18),(126,2,12);
/*!40000 ALTER TABLE `term_disciplin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-22 17:37:50
