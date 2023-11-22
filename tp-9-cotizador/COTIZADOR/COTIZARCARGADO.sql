CREATE DATABASE  IF NOT EXISTS `cotizador` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cotizador`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cotizador
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `cotizacion`
--

DROP TABLE IF EXISTS `cotizacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cotizacion` (
  `idCotizacion` int unsigned NOT NULL AUTO_INCREMENT,
  `idVehiculo` int NOT NULL,
  `cantidadDias` int unsigned NOT NULL,
  `precioCotizacion` float NOT NULL,
  `fecha_Creacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idCotizacion`,`idVehiculo`),
  KEY `fk_Cotizacion_Vehiculo_idx` (`idVehiculo`),
  CONSTRAINT `fk_Cotizacion_Vehiculo` FOREIGN KEY (`idVehiculo`) REFERENCES `vehiculo` (`idVehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cotizacion`
--

LOCK TABLES `cotizacion` WRITE;
/*!40000 ALTER TABLE `cotizacion` DISABLE KEYS */;
INSERT INTO `cotizacion` VALUES (2,5,10,20000,'2023-11-15 00:00:00'),(3,5,10,26000,'2023-11-15 00:00:00'),(4,5,12,28000,'2023-11-15 09:33:48'),(5,5,30,0,'2023-11-15 09:36:02'),(6,5,30,0,'2023-11-15 09:36:04'),(7,5,30,0,'2023-11-15 09:36:10'),(8,5,30,0,'2023-11-15 09:36:13'),(9,5,15,32000,'2023-11-15 09:38:34'),(10,5,5,11000,'2023-11-15 10:42:46'),(11,18,10,24300,'2023-11-15 11:45:54'),(12,7,1,0,'2023-11-15 11:54:25'),(13,18,10,24300,'2023-11-15 11:59:38'),(14,10,11,24800,'2023-11-15 11:59:50'),(15,7,11,0,'2023-11-15 12:00:05'),(16,7,10,30800,'2023-11-15 12:05:26'),(17,5,1,2600,'2023-11-15 12:18:28'),(18,16,1,2600,'2023-11-15 12:18:33'),(19,20,10,30800,'2023-11-15 12:22:04'),(20,11,30,63500,'2023-11-15 12:52:46'),(21,12,10,21500,'2023-11-15 12:55:34'),(22,15,10,22800,'2023-11-15 12:55:50'),(23,6,10,30800,'2023-11-15 12:58:15');
/*!40000 ALTER TABLE `cotizacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_vehiculo`
--

DROP TABLE IF EXISTS `tipo_vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_vehiculo` (
  `idtipo_vehiculo` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_vehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_vehiculo`
--

LOCK TABLES `tipo_vehiculo` WRITE;
/*!40000 ALTER TABLE `tipo_vehiculo` DISABLE KEYS */;
INSERT INTO `tipo_vehiculo` VALUES (1,'AUTO'),(2,'MINIBUS'),(3,'FURGONETA'),(4,'CAMION');
/*!40000 ALTER TABLE `tipo_vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `idVehiculo` int NOT NULL AUTO_INCREMENT,
  `idtipo_vehiculo` int NOT NULL,
  `Marca` varchar(45) DEFAULT NULL,
  `Modelo` varchar(45) DEFAULT NULL,
  `AnioFabricacion` int DEFAULT NULL,
  `Patente` varchar(10) DEFAULT NULL,
  `Color` varchar(45) DEFAULT NULL,
  `TipoTransmision` varchar(45) DEFAULT NULL,
  `CantPlazas` int DEFAULT NULL,
  `CapacidadBaul` int DEFAULT NULL,
  `PMA` float DEFAULT NULL,
  PRIMARY KEY (`idVehiculo`),
  UNIQUE KEY `idVehiculo_UNIQUE` (`idVehiculo`),
  KEY `fk_vehiculo_tipoVehiculo_idx` (`idtipo_vehiculo`),
  CONSTRAINT `fk_vehiculo_tipo` FOREIGN KEY (`idtipo_vehiculo`) REFERENCES `tipo_vehiculo` (`idtipo_vehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (5,1,'Renault','Clio mio',2013,'MPZ 651','Bordo','Manual',5,255,0),(6,4,'Scania','Escania',2023,'FE235AB','Negro','Manual',1,0,50),(7,4,'Scania','Escania',2023,'FE235AB','Negro','Manual',1,0,50),(8,4,'Scania','Escania',2023,'FE235AB','Negro','Manual',1,0,50),(9,2,'Iveco','Daily',2022,'DF124HJ','Blanca','Automatico',18,1000,0),(10,3,'Ford','Esford',2020,'AB123CD','Blanca','Manual',1,1000,3.5),(11,1,'Wolksvagen','Vento',2012,'LVM 123','Negro','Manual',5,500,0),(12,1,'Fiat','147',1994,'QAX 163','Rojo','Manual',5,300,0),(13,4,'Ford','Cargo',2016,'AC147DF','Blanco','Manual',1,500,15),(14,1,'Chevrolet','Agile',2015,'POQ 698','Gris','Manual',5,500,0),(15,3,'Iveco','Nodaily',2015,'PIU 456','Blanca','Manual',1,5000,2),(16,1,'Toyota','Etios',2018,'AB156ND','Azul','Automatico',5,600,0),(17,1,'Renault','12',1996,'QAA465','Verde','Manual',5,400,0),(18,2,'Toyota','Nose',2023,'FR100AB','Azul','Automatico',20,600,0),(19,4,'Ford','1200',2016,'AB369BN','Blanco','Manual',1,690,12),(20,4,'Volvo','Volvo max',2023,'FF456FF','Amarillo','Automatico',1,1,1);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-15 14:09:57
