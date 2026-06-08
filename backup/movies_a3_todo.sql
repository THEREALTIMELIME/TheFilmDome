-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: movies
-- ------------------------------------------------------
-- Server version	8.0.37

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `a3_todo`
--

DROP TABLE IF EXISTS `a3_todo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `a3_todo` (
  `todo_item` varchar(255) NOT NULL,
  `todo_item_author` varchar(100) NOT NULL,
  `todo_item_completed_date` date DEFAULT NULL,
  `todo_item_creation_date` date NOT NULL,
  `todo_item_due_date` date DEFAULT NULL,
  `todo_item_person_accountable` varchar(100) DEFAULT NULL,
  `todo_item_start_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `a3_todo`
--

LOCK TABLES `a3_todo` WRITE;
/*!40000 ALTER TABLE `a3_todo` DISABLE KEYS */;
INSERT INTO `a3_todo` VALUES ('Finish homework','Hongbing Pan','2025-10-23','2025-10-22','2025-10-23','Hongbing Pan','2025-10-23'),('Upload Assignment 3','Hongbing Pan',NULL,'2025-10-24','2025-10-25','Hongbing Pan','2025-10-25'),('Ask for course info','Hongbing Pan','2025-10-28','2025-10-27','2025-10-29','Peter Smith','2025-10-27'),('Team meeting','Hongbing Pan',NULL,'2025-10-29',NULL,NULL,NULL),('Study for exam','Alice',NULL,'2025-11-01','2025-11-05','Alice','2025-11-02'),('Buy groceries','Bob','2025-11-03','2025-11-02','2025-11-03','Bob','2025-11-02'),('Clean room','Charlie',NULL,'2025-11-04',NULL,NULL,NULL),('Fix website bug','Dana',NULL,'2025-11-05','2025-11-06','Dana','2025-11-05'),('Read book','Eve','2025-11-07','2025-11-06',NULL,NULL,'2025-11-06'),('Workout','Frank',NULL,'2025-11-07','2025-11-08','Frank','2025-11-07'),('Finish homework','Hongbing Pan','2025-10-23','2025-10-22','2025-10-23','Hongbing Pan','2025-10-23'),('Upload Assignment 3','Hongbing Pan',NULL,'2025-10-24','2025-10-25','Hongbing Pan','2025-10-25'),('Ask for course info','Hongbing Pan','2025-10-28','2025-10-27','2025-10-29','Peter Smith','2025-10-27'),('Team meeting','Hongbing Pan',NULL,'2025-10-29',NULL,NULL,NULL),('Study for exam','Alice',NULL,'2025-11-01','2025-11-05','Alice','2025-11-02'),('Buy groceries','Bob','2025-11-03','2025-11-02','2025-11-03','Bob','2025-11-02'),('Clean room','Charlie',NULL,'2025-11-04',NULL,NULL,NULL),('Fix website bug','Dana',NULL,'2025-11-05','2025-11-06','Dana','2025-11-05'),('Read book','Eve','2025-11-07','2025-11-06',NULL,NULL,'2025-11-06'),('Workout','Frank',NULL,'2025-11-07','2025-11-08','Frank','2025-11-07'),('Finish homework','Hongbing Pan','2025-10-23','2025-10-22','2025-10-23','Hongbing Pan','2025-10-23'),('Upload Assignment 3','Hongbing Pan',NULL,'2025-10-24','2025-10-25','Hongbing Pan','2025-10-25'),('Ask for course info','Hongbing Pan','2025-10-28','2025-10-27','2025-10-29','Peter Smith','2025-10-27'),('Team meeting','Hongbing Pan',NULL,'2025-10-29',NULL,NULL,NULL),('Study for exam','Alice',NULL,'2025-11-01','2025-11-05','Alice','2025-11-02'),('Buy groceries','Bob','2025-11-03','2025-11-02','2025-11-03','Bob','2025-11-02'),('Clean room','Charlie',NULL,'2025-11-04',NULL,NULL,NULL),('Fix website bug','Dana',NULL,'2025-11-05','2025-11-06','Dana','2025-11-05'),('Read book','Eve','2025-11-07','2025-11-06',NULL,NULL,'2025-11-06'),('Workout','Frank',NULL,'2025-11-07','2025-11-08','Frank','2025-11-07'),('Finish homework','Hongbing Pan','2025-10-23','2025-10-22','2025-10-23','Hongbing Pan','2025-10-23'),('Upload Assignment 3','Hongbing Pan',NULL,'2025-10-24','2025-10-25','Hongbing Pan','2025-10-25'),('Ask for course info','Hongbing Pan','2025-10-28','2025-10-27','2025-10-29','Peter Smith','2025-10-27'),('Team meeting','Hongbing Pan',NULL,'2025-10-29',NULL,NULL,NULL),('Study for exam','Alice',NULL,'2025-11-01','2025-11-05','Alice','2025-11-02'),('Buy groceries','Bob','2025-11-03','2025-11-02','2025-11-03','Bob','2025-11-02'),('Clean room','Charlie',NULL,'2025-11-04',NULL,NULL,NULL),('Fix website bug','Dana',NULL,'2025-11-05','2025-11-06','Dana','2025-11-05'),('Read book','Eve','2025-11-07','2025-11-06',NULL,NULL,'2025-11-06'),('Workout','Frank',NULL,'2025-11-07','2025-11-08','Frank','2025-11-07');
/*!40000 ALTER TABLE `a3_todo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-24 12:05:53
