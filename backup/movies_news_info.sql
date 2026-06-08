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
-- Table structure for table `news_info`
--

DROP TABLE IF EXISTS `news_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `news_info` (
  `title` varchar(255) DEFAULT NULL,
  `poster` varchar(255) DEFAULT NULL,
  `description` varchar(999) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_info`
--

LOCK TABLES `news_info` WRITE;
/*!40000 ALTER TABLE `news_info` DISABLE KEYS */;
INSERT INTO `news_info` VALUES ('Lilo and Stich remake goes VIRAL after audience discourse over ending reaches social media','Lilo&Stitch.png','In the original 2002 animated version, Nani fights to keep Lilo and Stitch together, leading to a heartwarming conclusion where Stitch is officially adopted and becomes part of the \'ohana—no one gets left behind. \r In the remake, Nani decides to leave Hawaii to study marine biology at the University of California. As a result, Lilo ends up in the care of their neighbor, Tūtū, and David. The sisters part ways physically but connected through a magical portal.','2025-05-23',1),('Spaceballs RETURNS in a brand-new sequel! Here is everything we know about the upcoming Star Wars parody film.','Spaceballs2.png','Amazon MGM Studios announced in June 2025 that Spaceballs 2 is officially in development, targeting a theatrical release in 2027','2025-06-12',2),('Marvel\'s \"Thunderbolts\" becomes trending again, as sales dramatically increases in Japan.','Thunderbolts.png','In its first three days, Thunderbolts grossed approximately ¥459 million (about $3.2 million USD) in Japan, drawing in 271,000 tickets sold. That performance helped Japan rank among the top 10 international markets for the film’s opening, right alongside Australia, Korea, Germany, and others.','2025-06-17',3),('\"Wicked: For Good\" has released their first trailer','WickedForGood.png','Broadway’s beloved tale returns for its epic conclusion as Wicked: For Good hits theaters November 21, 2025. Cynthia Erivo’s Elphaba goes underground, Ariana Grande’s Glinda ascends to power, and the arrival of Dorothy throws Oz into chaos. Expect betrayal, rebellion, redemption—and two brand-new songs.\n\nGet ready for a darker, bolder journey through the land of Oz. The witches aren’t done yet.','2025-06-04',8);
/*!40000 ALTER TABLE `news_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-24 12:05:47
