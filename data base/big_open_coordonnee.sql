-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: big_open
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `coordonnee`
--

DROP TABLE IF EXISTS `coordonnee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coordonnee` (
  `id` int NOT NULL,
  `adresse_ln1` varchar(45) DEFAULT NULL,
  `adresse_ln2` varchar(45) DEFAULT NULL,
  `adresse_ln3` varchar(45) DEFAULT NULL,
  `code_postal` varchar(45) DEFAULT NULL,
  `ville_lng1` varchar(45) DEFAULT NULL,
  `ville_lng2` varchar(45) DEFAULT NULL,
  `ville_lng3` varchar(45) DEFAULT NULL,
  `region_lng1` varchar(45) DEFAULT NULL,
  `region_lng2` varchar(45) DEFAULT NULL,
  `region_lng3` varchar(45) DEFAULT NULL,
  `pays_lng1` varchar(45) DEFAULT NULL,
  `pays_lng3` varchar(45) DEFAULT NULL,
  `pays_lng2` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `faxe` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `site_web` varchar(45) DEFAULT NULL,
  `id_objet` int DEFAULT NULL,
  `type_objet` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ffs_idx` (`id_objet`),
  CONSTRAINT `ffs` FOREIGN KEY (`id_objet`) REFERENCES `collaborateur` (`id`),
  CONSTRAINT `ygf` FOREIGN KEY (`id_objet`) REFERENCES `societe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordonnee`
--

LOCK TABLES `coordonnee` WRITE;
/*!40000 ALTER TABLE `coordonnee` DISABLE KEYS */;
/*!40000 ALTER TABLE `coordonnee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-27  7:38:12
