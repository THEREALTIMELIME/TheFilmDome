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
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movie_name` varchar(45) NOT NULL,
  `director` varchar(200) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `studio` varchar(45) DEFAULT NULL,
  `run_time` int DEFAULT NULL,
  `rated` varchar(45) DEFAULT NULL,
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `poster` varchar(45) DEFAULT NULL,
  `trailer` varchar(1000) DEFAULT NULL,
  `trending` tinyint(1) DEFAULT NULL,
  `newest` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES ('Bullet Train','David Leitch','Ladybug is an unlucky assassin who\'s determined to do his job peacefully after one too many gigs has gone off the rails. Fate, however, may have other plans as his latest mission puts him on a collision course with lethal adversaries from around the globe -- all with connected yet conflicting objectives -- on the world\'s fastest train.','Sony',126,'R',1,'Bullet.png','https://www.youtube.com/embed/0IOsk2Vlc4o?si=Xoc5-mJ5hzdtR5EQ',1,0),('Avengers Infinity War','Anthony Russo & Joe Russo','The Avengers and their allies must be willing to sacrifice all in an attempt to defeat the powerful Thanos before his blitz of devastation and ruin puts an end to the universe.','Marvel',149,'PG-13',2,'Infinity.jpg','https://www.youtube.com/embed/QwievZ1Tx-8?si=tZIsXYh3MYwvBaHr',1,0),('Moonlight','Barry Jenkins','A young African-American man grapples with his identity and sexuality while experiencing the everyday struggles of childhood, adolescence, and burgeoning adulthood.','A24',111,'R',3,'Moonlight.jpg','https://www.youtube.com/embed/9NJj12tJzqc?si=eZ9nLpwzx8Ba9tPQ',1,0),('Pearl','Ti West','In 1918, a young woman on the brink of madness pursues stardom in a desperate attempt to escape the drudgery, isolation, and lovelessness of life on her parents\' farm.','A24',103,'R',4,'Pearl.jpg','https://www.youtube.com/embed/L5PW5r3pEOg?si=23Wn0hLc0wETMj8T',1,0),('The Silence of the Lamb','Jonathan Demme','A young F.B.I. cadet must receive the help of an incarcerated and manipulative cannibal killer to help catch another serial killer, a madman who skins his victims.','Orion Pictures',143,'R',5,'Lamb.jpg','https://www.youtube.com/embed/6iB21hsprAQ?si=owAaQCOOzupIcdnX',1,0),('The Lobster','Yorgos Lanthimos','In a dystopian near future, according to the laws of The City, single people are taken to The Hotel, where they are obliged to find a romantic partner in 45 days or they\'re transformed into beasts and sent off into The Woods.','A24',119,'R',6,'Lobster.jpg','https://www.youtube.com/embed/LTNZmOJxuAc?si=M9iktnUveG4YbKQP',1,0),('Everything, Everywhere, All at Once','Daniel Kwan & Daniel Scheinert','A middle-aged Chinese immigrant is swept up into an insane adventure in which she alone can save existence by exploring other universes and connecting with the lives she could have led.','A24',139,'R',7,'Everything.png','https://www.youtube.com/embed/wxN1T1uxQ2g?si=cbXdxORHoB3Ai8Hx',1,0),('Inception','Christopher Nolan','A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.','Warner Bros',148,'PG-13',8,'Inception.jpg','https://www.youtube.com/embed/YoHD9XEInc0?si=4hxCB7KPcg1SvPvS',1,0),('The Green Knight','David Lowery','A fantasy retelling of the medieval story of Sir Gawain and the Green Knight.','A24',130,'R',9,'GreenKnight.jpeg','https://www.youtube.com/embed/sS6ksY8xWCY?si=2eKkXIw62Mi-f1g2',1,0),('The Wild Robot','Chris Sanders','After a shipwreck, an intelligent robot called Roz is stranded on an uninhabited island. To survive the harsh environment, Roz bonds with the island\'s animals and cares for an orphaned baby goose.','DreamWorks',112,'PG',10,'WildRobot.png','https://www.youtube.com/embed/67vbA5ZJdKQ?si=MOAfTaQUjd5jKlNz',1,1),('Smile 2','Parker Finn','About to embark on a world tour, global pop sensation Skye Riley begins experiencing increasingly terrifying and inexplicable events. Overwhelmed by the escalating horrors and the pressures of fame, Skye is forced to face her past.','Paramount Pictures',127,'R',11,'Smile2.png','https://www.youtube.com/embed/0HY6QFlBzUY?si=fx31HtA51_fPkUrb',0,1),('Transformers One','Josh Cooley','The untold origin story of Optimus Prime and Megatron, better known as sworn enemies, but who once were friends bonded like brothers who changed the fate of Cybertron forever.','Paramount Pictures',114,'PG',12,'TransformersOne.png','https://www.youtube.com/embed/0rmJXXKDrsM?si=mNUZMXuCQYY8Somr',0,1),('Beetlejuice Beetlejuice','Tim Burton','After a family tragedy, three generations of the Deetz family return home to Winter River. Still haunted by Beetlejuice, Lydia\'s life is turned upside down when her teenage daughter, Astrid, accidentally opens the portal to the Afterlife.','Warner Bros',105,'PG-13',13,'BeetleJuice2.png','https://www.youtube.com/embed/CoZqL9N6Rx4?si=fXPjFpIhM72_dHmv',0,1),('A Quiet Place: Day One','Michael Sarnoski','A young woman named Sam finds herself trapped in New York City during the early stages of an invasion by alien creatures with ultra-sensitive hearing.','Paramount Pictures',99,'PG-13',14,'DayOne.jpg','https://www.youtube.com/embed/gjx-iHGXk9Q?si=4t45kh8KY3tmQgjc',0,1),('Alien Romulus','Fede Alvarez','While scavenging the deep ends of a derelict space station, a group of young space colonists come face to face with the most terrifying life form in the universe.','20th Century Studios',119,'R',15,'Romulus.jpg','https://www.youtube.com/embed/OzY2r2JXsDM?si=Bs7N9-QH05d4vZZJ',0,1),('Twisters','Lee Isaac Chung','Kate Carter, a retired tornado-chaser and meteorologist, is persuaded to return to Oklahoma to work with a new team and new technologies.','Universal Pictures',122,'PG-13',16,'Twisters.jpg','https://www.youtube.com/embed/wdok0rZdmx4?si=AjUJ461ZJRbTDGWo',0,1),('V/H/S/Beyond','Kate Siegel, Justin Long, Christian Long, Virat Pal, Jordan Downey, Jay Cheel & Justin Martinez','Six bloodcurdling tapes unleash horror in a sci-fi inspired hellscape, pushing the boundaries of fear and suspense.','Shudder',114,'R',17,'VHSBeyond.jpg','https://www.youtube.com/embed/6qwiv_WfBXk?si=bvC7H9yRVnR6uiSf',0,1),('Longlegs','Oz Perkins','In pursuit of a serial killer, an FBI agent uncovers a series of occult clues that she must solve to end his terrifying killing spree.','Neon',101,'R',18,'Longlegs.jpg','https://www.youtube.com/embed/OG7wOTE8NhE?si=-rnb3PXUDMm7iyZc',0,1),('Joker: Folie à Deux','Todd Phillips','Struggling with his dual identity, failed comedian Arthur Fleck meets the love of his life, Harley Quinn, while incarcerated at Arkham State Hospital.','Warner Bros',138,'R',19,'Joker2.jpg','https://www.youtube.com/embed/xy8aJw1vYHo?si=CYC8dC76k9CHujb6',0,1),('Saw','James Wan','Two men awaken to find themselves on the opposite sides of a dead body, each with specific instructions to kill the other or face consequences. These two are the latest victims of the Jigsaw Killer.','Twisted',103,'R',20,'Saw.png','https://www.youtube.com/embed/S-1QgOMQ-ls?si=JcWTeWxz2apdXNRw',1,0),('The Spongebob Squarepants Movie','Stephen Hillenburg','SpongeBob takes leave from Bikini Bottom in order to track down, with Patrick, King Neptune\'s stolen crown.','Nickelodeon',87,'PG',21,'Spongebob.png','https://www.youtube.com/embed/47ceXAEr2Oo?si=EXAMvRmbegyG4e0T',1,0),('The Substance','Coralie Fargeat','A fading celebrity takes a black-market drug: a cell-replicating substance that temporarily creates a younger, better version of herself.','Epinay Studios',141,'R',22,'Substance.png','https://www.youtube.com/embed/LNlrGhBpYjc?si=jhgBd-sA0TWyNxE0',0,1),('Wicked','Jon M. Chu','Elphaba, a misunderstood young woman because of her green skin, and Galinda, a popular girl, become friends at Shiz University in the Land of Oz. After an encounter with the Wonderful Wizard of Oz, their friendship reaches a crossroads.','Sky Studios',160,'PG',23,'Wicked.png','https://www.youtube.com/embed/6COmYeLsz4c?si=-XOFGmhXE_gPg4Ru',0,1),('A Star Is Born','Bradley Cooper','Jackson Maine, a famous country music star on the decline, discovers and falls in love with Ally, a talented but largely unknown singer-songwriter. As Ally\'s career skyrockets, Jackson\'s struggles with addiction and his fading fame lead to a tragic downfall. ','Warner Bros',135,'R',26,'StarIsBorn.png','https://www.youtube.com/embed/nSbzyEJ8X9E?si=jouqPC6FOKld6_WP',1,0),('World War Z','Marc Forster','Life for former United Nations investigator Gerry Lane and his family seems content. Suddenly, the world is plagued by a mysterious infection turning whole human populations into rampaging mindless zombies. After barely escaping the chaos, Lane is persuaded to go on a mission to investigate this disease. What follows is a perilous trek around the world where Lane must brave horrific dangers and long odds to find answers before human civilization falls.','Paramount Pictures',125,'R',27,'WorldWarZ.png','https://www.youtube.com/embed/Md6Dvxdr0AQ?si=tpHrx4329E4D9vW7',1,0),('Killing Them Softly','Andrew Dominik','When rival crook Johnny Amato (Vincent Curatola) hatches a plan to rob a card game run by mob lackey Markie (Ray Liotta), he picks a low-rent thug named Frankie (Scoot McNairy) to do the job. Frankie picks a less-than-ideal partner (Ben Mendelsohn) to help him, but despite their combined incompetence, they manage to make off with the mob\'s money. In retaliation, Markie\'s bosses hire Jackie Cogan (Brad Pitt), a mob enforcer, to eradicate those responsible.','Plan B',197,'R',28,'KillingThemSoftly.png','https://www.youtube.com/embed/VCCBo0yh6YM?si=00ozZX6TLFTqFBDj',1,0);
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-24 12:05:51
