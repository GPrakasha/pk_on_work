-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: iihtproject
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `css`
--

LOCK TABLES `css` WRITE;
/*!40000 ALTER TABLE `css` DISABLE KEYS */;
INSERT INTO `css` VALUES (1,'# refers to id or class?','id'),(2,'different sytle sheets to imp in html','link , style attribute in html');
/*!40000 ALTER TABLE `css` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `java`
--

LOCK TABLES `java` WRITE;
/*!40000 ALTER TABLE `java` DISABLE KEYS */;
INSERT INTO `java` VALUES (1,'is Java completly object oriented?','no'),(2,'Will u get an error (Yes /NO)class hello{Static public void main(String []args){System.out.println(\"hello world\");}}','no'),(3,'Predict the output of following Java Programs.class Test { protected int x, y;protected int x, y;class Main {  public static void main(String args[]) { Test t = new Test(); System.out.println(t.x + \" \" + t.y);}}','0 0');
/*!40000 ALTER TABLE `java` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `python`
--

LOCK TABLES `python` WRITE;
/*!40000 ALTER TABLE `python` DISABLE KEYS */;
INSERT INTO `python` VALUES (1,'will python need ; to end statement','no');
/*!40000 ALTER TABLE `python` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'is java an oop based?','yes','java'),(2,'is C a top-down approach','yes','c'),(3,'Is java completly oops ?','no','java'),(4,'Can we use java to develop games?','yeah','java'),(5,'asdasd','asd','java'),(12,'first question in php','something','php'),(13,'sda','sda','C');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `topics`
--

LOCK TABLES `topics` WRITE;
/*!40000 ALTER TABLE `topics` DISABLE KEYS */;
INSERT INTO `topics` VALUES (10,'css'),(11,'Java'),(12,'python');
/*!40000 ALTER TABLE `topics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'prakasha','pk@mail.com','asdasd','789456123'),(2,'asd','asd@mail.com','+password+','+ phno+'),(3,'asd','asd@mail.com','asd','123456789'),(4,'asd','asd@mail.com','123123','123546789'),(5,'tejas','tejas@gmail.com','monkey','420840'),(6,'tejas','tejas@gmail.com','monkey','420840'),(7,'panda','codendsleep','pandacode','789456123'),(8,'tejas','tejas','tejas','789456123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-22  4:54:07
