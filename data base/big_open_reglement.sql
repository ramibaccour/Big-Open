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
-- Table structure for table `reglement`
--

DROP TABLE IF EXISTS `reglement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reglement` (
  `id` int NOT NULL,
  `id_retenu_source` int DEFAULT NULL,
  `montant` double DEFAULT NULL,
  `rib` varchar(45) DEFAULT NULL,
  `date_encaissement` date DEFAULT NULL,
  `date_echeance` varchar(45) DEFAULT NULL,
  `debit_credit` varchar(45) DEFAULT NULL,
  `observation` varchar(45) DEFAULT NULL,
  `rib_compte_source` varchar(45) DEFAULT NULL,
  `numero_traite` varchar(45) DEFAULT NULL,
  `id_banque` int DEFAULT NULL,
  `id_document` int DEFAULT NULL,
  `id_document_avoir` int DEFAULT NULL,
  `type_reglement` varchar(45) DEFAULT NULL,
  `id_caisse` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `retenu_source_reglement_idx` (`id_retenu_source`),
  KEY `banque_reglement_idx` (`id_banque`),
  KEY `document_reglement_idx` (`id_document`),
  KEY `document_avoir_reglement_idx` (`id_document_avoir`),
  KEY `caisse_regl_idx` (`id_caisse`),
  CONSTRAINT `banque_reglement` FOREIGN KEY (`id_banque`) REFERENCES `banque` (`id`),
  CONSTRAINT `caisse_regl` FOREIGN KEY (`id_caisse`) REFERENCES `caisse` (`id`),
  CONSTRAINT `document_avoir_reglement` FOREIGN KEY (`id_document_avoir`) REFERENCES `document` (`id`),
  CONSTRAINT `document_reglement` FOREIGN KEY (`id_document`) REFERENCES `document` (`id`),
  CONSTRAINT `retenu_source_reglement` FOREIGN KEY (`id_retenu_source`) REFERENCES `retenu_source` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reglement`
--

LOCK TABLES `reglement` WRITE;
/*!40000 ALTER TABLE `reglement` DISABLE KEYS */;
/*!40000 ALTER TABLE `reglement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-05  8:15:25
