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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `email` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `birthDate` date DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `user_id_UNIQUE` (`id`),
  UNIQUE KEY `phonenumber_UNIQUE` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('frfrf@gmail.casas','sdasdsdsd3e2','$2a$10$DAf6d82VompDew1Er8AdXuqUDmJP2HsziHlHZaieoRT4cT7zr2/ZS',96,'erffaerfera','erfrefererer',NULL,'1112221100'),('ssdsd@gmasil.com','3erwfe333we4','$2a$10$R5nL2DbfJiOjKVIHfzah6OTXXDtO3cHHLgjgKIn5lbDqZ5AHExiUa',97,'Bas','dasD',NULL,'9990003911'),('ewfwewffew@gma43il.com','121212211212','$2a$10$9Nk0fSc7uT31uX.WSI2QkOin.v12qypx6Yp7dJWfmWRhEerE0ZMEy',98,'dsfceww','ewwefwewe',NULL,'8933011122'),('FREWRFWEF@fdafdf','ervgrgaeargeargeargarfgarvge','$2a$10$fbHIsWnLQDWaJwRv1HW.suJ4PuwB75yZAZzQIvykavoEIVPbT3/pe',99,'erfgfssargef','regrgeergsaearg',NULL,'0101221199'),('eaweweaaewff@awefew','wqqwdqwddfqwqwedf','$2a$10$jx/.ZZSYgmj5rAlk1J367.wElOsXpDmDhKSwJfTbAV3qF6gzGiN3C',100,'aerfvgaergfaefgwrv','aewfgaefgwaewfg',NULL,'4244222686'),('edcfefwdcefwefw@erfwfwerwefr','ewfwef424e42ew','$2a$10$R7/qw2yGbRNNByJShlP9POYT08RMdIEIMVk9Wj1NSraB1JM61F02u',101,'sdFDFSCDF','fEEfwefw',NULL,'3332223335'),('ererre@dfgdfgdf','ewfwefefwwef','$2a$10$ZsQv9cL2yxfDC.qCUtxE5OTIPSFbrp/3bSwOXfkaURA4hl7O3PGhG',102,'ergeerer','ererer',NULL,'4445552211'),('frfrf@dsfsdf','434334fge','$2a$10$IHXEbBm0L3LMvFeKV0pZN.F4msGZjL419vmo1VBlUPb1vBjwL61nC',103,'ff44er','weewwewe3',NULL,'0001110000'),('edrtgertgstg@ererftg','eferghfrefgerg','$2a$10$NppARiDTbny8hYVeuZxO5.639QghvcVA0yB6wdqGvX0da4vp/so6.',104,'sefgdedfgsedfgsefdg','reftgderdtg45',NULL,'5554447777'),('Babsoa@example.com','GoofyCow32','$2a$10$3tIGtrzj5gr5Y5d.krB3cOa/e.JpmkPLv47cURCNj6ZHxEzyajini',105,'Poly','Mama',NULL,'9993332225'),('buddy@buddy.com','buddy','$2a$10$3jlq.s9wh.uaUBr3LTUDOuNgEQSKpyfkqW23uU/usVBlGyqJ9OX.y',106,'buddy','buddy',NULL,'0003330000'),('Siick@example.com','BaBa','$2a$10$D0XhRhuZEH3KfYZTm17P.uQ2FDOAi26xzvT2t6vTiBwSDc4oENOCi',107,'Ba','Be',NULL,'0003314931'),('Gsdagisd@example.com','GroGreo','$2a$10$HvYs/k1GFDHXADIhA2JrquMVVLWH.gf9zWERRTJC3GTpuxOdjIVbW',108,'Gro','Gro',NULL,'4880003000'),('FarmJoe222@gmail.com','FarmJoe222','$2a$10$Y9joRtVbedR4Q3MWy66xmuIcfs/Zo9Om3i56MtO7aeCcjiyXlT3Py',109,'Farmer','Joe',NULL,'0004449999'),('Bob@gmail.com','Bob','$2a$10$NzA5l.GcmjZhguoGMEwOe.TZ1qSjDQsneiXRq4mQyWgdmb3IiFTam',110,'Bob','Bob',NULL,'4077442510'),('kenyich12@gmail.com','P@ssword4','$2a$10$D8c.KmD6G/jU311bcgwcPujrCDR4QBQ4o.zQWERqwcspKwR7gPHsy',111,'Jim','Cosmo',NULL,'4077442515'),('kenyich12@gmail1.com','jchangkenyi','$2a$10$VomxkZBRT16P9oTY/1IBLuZj3vq1QNc9d7BG/0EGOqPqa9u4XrwA.',112,'Jaime','Chang',NULL,'4077442514'),('Sam@gmail.com','SamSam','$2a$10$oxU5mZEwcLEtCOTC2dwVT.ToRpsJndIh7NsX/hnBeL2phRoSDZ.uK',113,'Sam','Sam',NULL,'4440004444'),('kenyich12@example.com','jchangkenyi1','$2a$10$/b5xtBK5gyfMTeyJg5GFmOg2mcMCMHhSkhGCEzcZ6tPlskb6WPpbu',118,'Jaime','Chang',NULL,'4077442516'),('Carl@example.com','Carl','$2a$10$UlI/uWL3kyMFycbw3av1du89g0EjouSBBfz3Jr.BJKvamCuWIniTC',119,'Carl','Carl',NULL,'9899799696');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-24 12:05:45
