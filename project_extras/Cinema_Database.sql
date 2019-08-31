-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cinema
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `tblcategory`
--

DROP TABLE IF EXISTS `tblcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblcategory` (
  `categoryID` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(45) NOT NULL,
  PRIMARY KEY (`categoryID`),
  UNIQUE KEY `categoryID_UNIQUE` (`categoryID`),
  UNIQUE KEY `categoryName_UNIQUE` (`categoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblcategory`
--

LOCK TABLES `tblcategory` WRITE;
/*!40000 ALTER TABLE `tblcategory` DISABLE KEYS */;
INSERT INTO `tblcategory` VALUES (1,'Action'),(10,'Animated'),(2,'Asian'),(8,'Burmese'),(3,'Comedy'),(11,'Documentary'),(6,'Horror'),(7,'Indian'),(4,'Romance'),(9,'Sci-Fi'),(5,'Thriller');
/*!40000 ALTER TABLE `tblcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblmovie`
--

DROP TABLE IF EXISTS `tblmovie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblmovie` (
  `movieID` int(6) NOT NULL AUTO_INCREMENT,
  `movieName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL,
  `categoryID` int(11) NOT NULL,
  `theatreNo` int(11) NOT NULL,
  `movieType` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL DEFAULT '2D',
  `showTimes` text CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL,
  PRIMARY KEY (`movieID`),
  UNIQUE KEY `movieID_UNIQUE` (`movieID`),
  UNIQUE KEY `movieName_UNIQUE` (`movieName`),
  KEY `categoryID_idx` (`categoryID`),
  CONSTRAINT `categoryID` FOREIGN KEY (`categoryID`) REFERENCES `tblcategory` (`categoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblmovie`
--

LOCK TABLES `tblmovie` WRITE;
/*!40000 ALTER TABLE `tblmovie` DISABLE KEYS */;
INSERT INTO `tblmovie` VALUES (1,'Spiderman: Homecoming',1,2,'3D','9:00 am'),(2,'Avengers: Endgame',1,3,'3D','11:00 am'),(3,'Stranger\'s House',8,4,'2D','1:00 pm');
/*!40000 ALTER TABLE `tblmovie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblsales`
--

DROP TABLE IF EXISTS `tblsales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblsales` (
  `theatreNo` int(11) NOT NULL,
  `movieID` int(11) NOT NULL,
  `ticketsSold` int(11) NOT NULL,
  `totalIncome` double NOT NULL,
  PRIMARY KEY (`movieID`),
  KEY `theatreNo` (`theatreNo`),
  CONSTRAINT `tblSales_ibfk_1` FOREIGN KEY (`theatreNo`) REFERENCES `tbltheatre` (`theatreNo`),
  CONSTRAINT `tblSales_ibfk_2` FOREIGN KEY (`movieID`) REFERENCES `tblmovie` (`movieID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblsales`
--

LOCK TABLES `tblsales` WRITE;
/*!40000 ALTER TABLE `tblsales` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblsales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblshow`
--

DROP TABLE IF EXISTS `tblshow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblshow` (
  `showID` int(11) NOT NULL AUTO_INCREMENT,
  `showDate` date NOT NULL,
  `movieID` int(6) NOT NULL,
  `movieName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL,
  `description` text CHARACTER SET ucs2 COLLATE ucs2_general_mysql500_ci NOT NULL,
  PRIMARY KEY (`showID`),
  KEY `movieID` (`movieID`),
  CONSTRAINT `tblShow_ibfk_1` FOREIGN KEY (`movieID`) REFERENCES `tblmovie` (`movieID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblshow`
--

LOCK TABLES `tblshow` WRITE;
/*!40000 ALTER TABLE `tblshow` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblshow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblstaff`
--

DROP TABLE IF EXISTS `tblstaff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblstaff` (
  `staffID` int(11) NOT NULL AUTO_INCREMENT,
  `staffName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL,
  `age` int(11) NOT NULL,
  `birthDate` date NOT NULL,
  `gender` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL,
  `address` text CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL,
  `receptionNo` int(11) NOT NULL,
  `checkInTime` time NOT NULL,
  `checkOutTime` time NOT NULL,
  PRIMARY KEY (`staffID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblstaff`
--

LOCK TABLES `tblstaff` WRITE;
/*!40000 ALTER TABLE `tblstaff` DISABLE KEYS */;
/*!40000 ALTER TABLE `tblstaff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltheatre`
--

DROP TABLE IF EXISTS `tbltheatre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltheatre` (
  `theatreNo` int(11) NOT NULL AUTO_INCREMENT,
  `movieID` int(11) NOT NULL,
  `movieName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL,
  `showTimes` int(11) NOT NULL,
  `availableSeats` int(11) NOT NULL,
  PRIMARY KEY (`theatreNo`),
  KEY `movieID` (`movieID`),
  CONSTRAINT `tblTheatre_ibfk_1` FOREIGN KEY (`movieID`) REFERENCES `tblmovie` (`movieID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltheatre`
--

LOCK TABLES `tbltheatre` WRITE;
/*!40000 ALTER TABLE `tbltheatre` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbltheatre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbltickets`
--

DROP TABLE IF EXISTS `tbltickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbltickets` (
  `ticketID` int(11) NOT NULL AUTO_INCREMENT,
  `movieID` int(6) NOT NULL,
  `movieName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_mysql500_ci NOT NULL,
  `showID` int(11) NOT NULL,
  `showTime` time NOT NULL,
  `theatreNo` int(11) NOT NULL,
  `seatNo` int(11) NOT NULL,
  `totalCost` double NOT NULL,
  `staffID` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`ticketID`),
  KEY `movieID` (`movieID`),
  KEY `staffID` (`staffID`),
  KEY `showID` (`showID`),
  CONSTRAINT `tblTickets_ibfk_1` FOREIGN KEY (`movieID`) REFERENCES `tblmovie` (`movieID`),
  CONSTRAINT `tblTickets_ibfk_2` FOREIGN KEY (`staffID`) REFERENCES `tblstaff` (`staffID`),
  CONSTRAINT `tblTickets_ibfk_3` FOREIGN KEY (`showID`) REFERENCES `tblshow` (`showID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_mysql500_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbltickets`
--

LOCK TABLES `tbltickets` WRITE;
/*!40000 ALTER TABLE `tbltickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbltickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblusers`
--

DROP TABLE IF EXISTS `tblusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblusers` (
  `userID` int(11) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `password` varchar(45) NOT NULL,
  `userType` varchar(45) NOT NULL DEFAULT 'STAFF',
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblusers`
--

LOCK TABLES `tblusers` WRITE;
/*!40000 ALTER TABLE `tblusers` DISABLE KEYS */;
INSERT INTO `tblusers` VALUES (9393,'thiha zaw','sayar gyi','STAFF'),(11221,'harry','superharry','STAFF'),(26093,'naing aung luu','admin','ADMIN'),(34321,'Super someone','supersomeone','STAFF'),(35833,'super latest user','hellonewuser','STAFF'),(38343,'Aung Chan','aungchan123','STAFF'),(39393,'Ko Kyaw Gyi','kokyaw123','STAFF'),(93838,'Special admin','superadmin','STAFF'),(93944,'Nem Khem Dim','teacherisgreat','STAFF');
/*!40000 ALTER TABLE `tblusers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-31 16:33:19
