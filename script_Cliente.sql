-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: redsocial
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Vip'),(2,'Premium'),(3,'Super Vip'),(4,'Platinium'),(5,'Super Vip');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `fechaRegistro` datetime DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `idCategoria` int NOT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `fk_cliente_categoria_idx` (`idCategoria`),
  CONSTRAINT `fk_cliente_categoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Luciana Valentina','87474587','2022-04-04 10:59:04',1,3,NULL,NULL,NULL,NULL),(2,'Luciana Valentina','87474587','2022-04-04 10:59:04',1,3,NULL,NULL,NULL,NULL),(3,'Juana Garcia','87474587','2022-04-04 10:59:04',1,3,NULL,NULL,NULL,NULL),(4,'Elba Flores','56565656','2022-04-04 10:59:04',1,2,NULL,NULL,NULL,NULL),(21,'Angelica','41545454','2023-09-04 22:15:43',0,3,NULL,NULL,NULL,NULL),(22,'Ana Perez','99999999','2023-09-04 22:28:13',1,2,NULL,NULL,NULL,NULL),(23,'Luciana Valentina Jacinto','40228588','2023-09-04 22:29:42',1,2,NULL,NULL,NULL,NULL),(24,'Jorge Jacinto Gutarra','40228589','2023-09-04 22:29:42',1,1,NULL,NULL,NULL,NULL),(25,'Juan Quispe','74342286','2026-06-09 00:00:00',1,1,NULL,NULL,NULL,NULL),(26,'Juan Quispe','74342286','2026-06-09 21:41:37',1,5,NULL,NULL,NULL,NULL),(27,'Juan Quispe','40228588','2026-06-09 21:42:03',1,2,NULL,NULL,NULL,NULL),(28,'Luis quispe','40228577','2026-06-10 21:04:23',1,3,NULL,NULL,NULL,NULL),(29,'Luis quispe','40228577','2026-06-10 21:04:37',1,5,NULL,NULL,NULL,NULL),(30,'Luis quispe','40228577','2026-06-10 21:04:51',1,5,NULL,NULL,NULL,NULL),(31,'Luis quispe','40228577','2026-06-10 21:05:00',1,5,NULL,NULL,NULL,NULL),(32,'AAA','74342286','2026-06-10 21:10:10',1,1,NULL,NULL,NULL,NULL),(33,'AAA','74342286','2026-06-10 21:10:11',1,1,NULL,NULL,NULL,NULL),(34,'AAA','74342286','2026-06-10 21:10:12',1,1,NULL,NULL,NULL,NULL),(35,'AAA','74342286','2026-06-10 21:10:13',1,1,NULL,NULL,NULL,NULL),(36,'Luisa Flores','12345678','2026-06-10 21:12:18',1,4,NULL,NULL,NULL,NULL),(37,'Jorge Jacinto','12345679','2026-06-10 21:17:39',1,3,NULL,NULL,NULL,NULL),(38,'Juan','23232323','2026-06-17 19:18:16',1,1,NULL,NULL,NULL,NULL),(39,'Elbita','84591526','2026-06-10 21:17:39',1,2,NULL,NULL,NULL,NULL),(40,'Elbita b','33232323','2026-06-17 19:51:22',1,4,NULL,NULL,NULL,NULL),(41,'kiara','55669545','2026-10-07 00:00:00',1,1,'goik','458545477','hoik@gmail.com','lima'),(42,'klll','88775484','2026-10-07 00:00:00',1,3,'soids','987654321','prueba@gmail.com','Lima');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-10-07  2:14:12
