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
-- Table structure for table `actors`
--

DROP TABLE IF EXISTS `actors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) DEFAULT NULL,
  `LastName` varchar(255) DEFAULT NULL,
  `actorImg` varchar(255) DEFAULT NULL,
  `summary` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actors`
--

LOCK TABLES `actors` WRITE;
/*!40000 ALTER TABLE `actors` DISABLE KEYS */;
INSERT INTO `actors` VALUES (1,'Brad','Pitt','BradPitt.jpg','Brad Pitt was born on December 18, 1963, in Shawnee, Oklahoma, and raised in Springfield, Missouri. \nHe was active in sports, debate, student government, and school musicals during high school. \nHe attended the University of Missouri studying journalism with a focus on advertising but left just before graduating to pursue acting in California. \nBefore becoming successful, he worked various jobs including driving limos, moving appliances, and dressing as a mascot.\nHis early acting career included television roles, with appearances on soap operas and series throughout the 1980s. \nHe gained widespread attention with a small but memorable role in Thelma & Louise in 1991. \nAfter some poorly received films, his career improved with A River Runs Through It, showcasing his depth as an actor. \nHe went on to star in a variety of roles, including performances in Seven, Interview with the Vampire, and 12 Monkeys, the latter earning him a Golden Globe.\n His role in Troy and later Mr. & Mrs. Smith boosted his status as an action star and brought major attention to his personal life.\n He continued taking diverse roles in films like Inglourious Basterds and Moneyball, earning multiple Oscar nominations and starring in Fury in 2014.'),(2,'Mia','Goth','MiaGoth.jpg',NULL),(3,'Mahershala','Ali','MahershalaAli.png',NULL),(4,'Anthony','Hopkins','AnthonyHopkins.jpg',NULL),(5,'Lady','Gaga','LadyGaga.jpg',NULL),(6,'Joey','King','JoeyKing.png','Joey King began acting at a very young age, starting with commercials before quickly moving into television and film roles. She appeared in a variety of shows early in her career and also built a strong presence in voice acting, contributing to several animated films. Her first major film experience sparked her passion for acting, and she later gained widespread attention with her lead role in Ramona and Beezus, which she considers life-changing. Over the years, she has worked with well-known directors and continued to expand her range as an actress. In addition to her acting career, she is involved in charity work and has received critical praise for her performances.'),(7,'Bad','Bunny','BadBunny.jpg','Bad Bunny is a globally influential artist known for blending reggaeton, Latin trap, and experimental sounds while challenging traditional norms in music and fashion. Beyond music, he has expanded into film, appearing in *Bullet Train* alongside Brad Pitt, where he showcased his on-screen charisma and action presence. He has also been involved in Hollywood casting conversations and roles that highlight his crossover appeal, signaling a growing career in the film industry beyond his dominance in music.'),(8,'Brian Tyree','Henry','BrianTyreeHenry.jpg','Brian Tyree Henry is a versatile actor recognized for his work in film, television, and theater, earning nominations for major awards throughout his career. He is best known for his role in Atlanta, where he portrayed a complex character navigating fame and personal challenges. His performance in Causeway earned him significant critical acclaim, including an Academy Award nomination. Henry has also appeared in a wide range of films, from independent dramas to major blockbusters, showcasing his adaptability as an actor. Alongside his screen work, he has a strong background in theater and has received recognition for his performances on stage.'),(9,'Zazie','Beetz','ZazieBeetz.jpg','Zazie Beetz is a talented actress known for her work across film, television, and stage, gaining widespread recognition for her role as Van in the critically acclaimed series *Atlanta*. She has built a strong film career with performances in movies like *Deadpool 2*, *Joker*, and *The Harder They Fall*, demonstrating her versatility across genres from comedy to drama. Her portrayal in *Joker* alongside Joaquin Phoenix brought her further attention for her nuanced and grounded performance.\n\nIn addition to live-action roles, Beetz has contributed to voice acting, including her work in *Invincible*, expanding her presence in different areas of entertainment. She has also been involved in theater and continues to take on diverse and challenging roles.\n');
/*!40000 ALTER TABLE `actors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-24 12:05:49
