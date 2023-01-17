-- MySQL dump 10.13  Distrib 5.7.14, for Win32 (AMD64)
--
-- Host: localhost    Database: cocktailrecipe_db
-- ------------------------------------------------------
-- Server version	5.7.14-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipes` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `drinkName` varchar(30) COLLATE utf8_bin NOT NULL,
  `drinkImgsDirUUID` varchar(40) COLLATE utf8_bin DEFAULT NULL,
  `Json_RecipeDetail` json DEFAULT NULL,
  `userid` varchar(20) COLLATE utf8_bin NOT NULL,
  `userpw` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (1,'jackcoke','asdf','{\"note\": [\"언더락\", \"추천하는 글라스 : 스템\"], \"Materials\": [{\"volume\": 987, \"MaterialName\": \"ck\"}, {\"volume\": 234, \"MaterialName\": \"b\"}, {\"volume\": 100, \"MaterialName\": \"cock\"}], \"procedures\": [{\"Procedure\": \"먼저 얼음을 넣고 위스키를 넣는다\", \"guideImgName\": \"ontherock.jpg\"}, {\"Procedure\": \"콜라를 넣고 레몬 또는 레몬 즙을 넣어 마무리 한다.\"}]}','',''),(2,'Pornstar Martini','zxcv',NULL,'',''),(3,'Espresso Martini',NULL,NULL,'',''),(4,'Amaretto Sour',NULL,NULL,'',''),(5,'Sex On The Beach',NULL,NULL,'',''),(6,'Bloody Mary',NULL,NULL,'',''),(11,'잭콕','de707fe8-7b98-4547-913d-b3cc0f01d9af','{\"note\": [\"온더락\", \"레몬 즙 추가시 좋음\"], \"Materials\": [{\"volume\": 100, \"MaterialName\": \"콜라\"}, {\"volume\": 20, \"MaterialName\": \"위스키\"}], \"procedures\": [{\"Procedure\": \"온더락 한 잔에 위스키를 넣는다.\"}, {\"Procedure\": \"콜라를 넣고 레몬즙 으로 마무리 한다.\", \"guideImgName\": \"20140510_003010.jpg\"}]}','',''),(12,'asdf','55296bea-7785-41ac-a3bf-542958063a63','{\"note\": [\"asdf\"], \"Materials\": [{\"volume\": 124, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"avwarv\", \"guideImgName\": \"이클립스1.png\"}, {\"Procedure\": \"wagabs\", \"guideImgName\": \"이클립스2.png\"}, {\"Procedure\": \"dfbseb\", \"guideImgName\": \"이클립스3.png\"}]}','',''),(13,'asdg','526f1664-d525-40b9-a8b2-4b2b77135ea0','{\"note\": [\"afb\"], \"Materials\": [{\"volume\": 124, \"MaterialName\": \"asfga\"}], \"procedures\": [{\"Procedure\": \"aweg\", \"guideImgName\": \"이클립스1.png\"}, {\"Procedure\": \"asgv\", \"guideImgName\": \"이클립스2.png\"}]}','',''),(14,'asdf','9d604e98-a21b-48a4-ab71-ccad953d29ca','{\"note\": [\"fawsdv\", \"wfaf\"], \"Materials\": [{\"volume\": 1234, \"MaterialName\": \"awgawf\"}, {\"volume\": 324, \"MaterialName\": \"aergeber\"}], \"procedures\": [{\"Procedure\": \"agfsv\", \"guideImgName\": \"이클립스1.png\"}, {\"Procedure\": \"vav\", \"guideImgName\": \"이클립스2.png\"}, {\"Procedure\": \"fbs\", \"guideImgName\": \"이클립스3.png\"}]}','',''),(15,'칼루아 밀크','98587cb4-ba9c-4f00-bc2c-4a870f6d224f','{\"note\": [\"ㅁㄴㅇㄹ\"], \"Materials\": [{\"volume\": 100, \"MaterialName\": \"1\"}, {\"volume\": 200, \"MaterialName\": \"2\"}], \"procedures\": [{\"Procedure\": \"12345687\"}, {\"Procedure\": \"346684685\", \"guideImgName\": \"20140510_003010.jpg\"}]}','',''),(16,'zxcbdf','a1b410c4-bdc9-4bc2-a31a-604eaabeac36','{\"note\": [\"awf\"], \"Materials\": [{\"volume\": 1234, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"eg\"}]}','',''),(17,'zxcbdf','9d0b7f0a-c850-4660-b56f-dbf57a555dc0','{\"note\": [\"awf\"], \"Materials\": [{\"volume\": 1234, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"eg\"}]}','',''),(18,'asdf','53d3706e-6dff-465b-bd35-622f228ad7a6','{\"note\": [], \"Materials\": [{\"volume\": 2134, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"asdvwagawf\"}]}','',''),(19,'asdf','2732b95b-40c1-4e9b-a870-05532ad7add7','{\"note\": [\"asdg\"], \"Materials\": [{\"volume\": 1234, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"asdg\"}]}','',''),(20,'zxcv','11d0f549-a8cc-4744-9aa4-d9c998d5593e','{\"note\": [\"ag\"], \"Materials\": [{\"volume\": 235, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"eqrgegr\", \"guideImgName\": \"img1.daumcdn.jpg\"}]}','',''),(21,'zx cv','bf6e5b24-e618-42ad-a1ce-3ec10da83262','{\"note\": [\"ag\"], \"Materials\": [{\"volume\": 235, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"eqrgegr\", \"guideImgName\": \"img1.daumcdn.jpg\"}]}','',''),(22,'잭 콕','cfe9c8a9-5cab-478f-94cf-8a22acf36a1e','{\"note\": [\"ㅁㄴㅇㅎ\"], \"Materials\": [{\"volume\": 2345, \"MaterialName\": \"ㅁㄹㄴ\"}], \"procedures\": [{\"Procedure\": \"ㄴㅇㅍㅁㅈ\", \"guideImgName\": \"c2f5e4d2f6179ad202c57097ec478b6a1.jpg\"}]}','',''),(23,'esttcock','9cf7d5c2-0c9e-47c6-bb41-7af7ad4f38b4','{\"note\": [], \"Materials\": [{\"volume\": 1234, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"asdgwar\", \"guideImgName\": \"test.html\"}]}','',''),(24,'cocktest234','770fb82f-ecec-4439-835a-7aa9b76f75c3','{\"note\": [], \"Materials\": [{\"volume\": 234, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"qergrg\", \"guideImgName\": \"img1.daumcdn.jpg\"}]}','',''),(25,'Newtest','be49fddf-11ee-4264-8279-d6c23bd7435b','{\"note\": [\"asdf\", \"zxcv\"], \"Materials\": [{\"volume\": 100, \"MaterialName\": \"m1\"}, {\"volume\": 100, \"MaterialName\": \"m2\"}], \"procedures\": [{\"Procedure\": \"m1\"}, {\"Procedure\": \"m2\"}, {\"Procedure\": \"m3\"}]}','',''),(26,'newtest2','7e7c810e-3ce7-44ec-a983-a8d74cb7f2af','{\"note\": [\"asdf\"], \"Materials\": [{\"volume\": 3465, \"MaterialName\": \"1243\"}, {\"volume\": 1234, \"MaterialName\": \"235\"}], \"procedures\": [{\"Procedure\": \"m1\"}, {\"Procedure\": \"m2\"}, {\"Procedure\": \"m3\"}]}','',''),(27,'newtest3','2128df91-8add-4c49-a09e-fac1c2321f8b','{\"note\": [\"ernr\"], \"Materials\": [{\"volume\": 1345, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"m1\"}, {\"Procedure\": \"m2\"}, {\"Procedure\": \"m3\"}]}','',''),(28,'newtest4','c0e6b7ec-21f9-439f-9a29-9b50e3a3c71f','{\"note\": [\"gwegr\"], \"Materials\": [{\"volume\": 12345, \"MaterialName\": \"asfd\"}], \"procedures\": [{\"Procedure\": \"m1\", \"guideImgName\": \"이클립스1.png\"}, {\"Procedure\": \"m4\", \"guideImgName\": \"이클립스2.png\"}]}','',''),(29,'test5','4653777f-2b1a-4129-96d5-d3ab04449583','{\"note\": [\"특이사항\"], \"Materials\": [{\"volume\": 1234, \"MaterialName\": \"ㅂㅈㄷㄱ\"}], \"procedures\": [{\"Procedure\": \"m1\", \"guideImgName\": \"\"}, {\"Procedure\": \"m2\", \"guideImgName\": \"\"}]}','',''),(30,'test6','554e9800-1dfe-415c-a668-8c230321e370','{\"note\": [\"qwer\"], \"Materials\": [{\"volume\": 1234, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"m1\", \"guideImgName\": \"\"}, {\"Procedure\": \"m2\", \"guideImgName\": \"이클립스1.png\"}]}','',''),(31,'test7','6372f0ed-39f8-4096-97d2-f9a5cc2ff5b8','{\"note\": [\"asdf\"], \"Materials\": [{\"volume\": 123, \"MaterialName\": \"asdf\"}], \"procedures\": [{\"Procedure\": \"m1\", \"guideImgName\": \"이클립스3.png\"}]}','',''),(32,'test9','62c2057c-6a1b-47e8-a611-e82b12f36fab','{\"note\": [\"특이1\"], \"Materials\": [{\"volume\": 1234, \"MaterialName\": \"재료1\"}], \"procedures\": [{\"Procedure\": \"m1\", \"guideImgName\": \"img1.daumcdn.jpg\"}, {\"Procedure\": \"m2\", \"guideImgName\": \"\"}]}','test','1234'),(34,'Holiday Mule','738e7423-ead2-4f3c-aaa7-8508d67b9edc','{\"note\": [\"온더락\"], \"Materials\": [{\"volume\": 1, \"MaterialName\": \"얼음\"}, {\"volume\": 40, \"MaterialName\": \"보드카\"}, {\"volume\": 40, \"MaterialName\": \"사이다\"}, {\"volume\": 40, \"MaterialName\": \"진저비어\"}, {\"volume\": 1, \"MaterialName\": \"계피스틱\"}], \"procedures\": [{\"Procedure\": \"하이볼 글래스에 온더 락후 모든 재료를 넣는다.\", \"guideImgName\": \"하이볼 글래스.png\"}, {\"Procedure\": \"계피스틱으로 마무리 한다.\", \"guideImgName\": \"cockguide.png\"}]}','qwer','1234');
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-29 23:57:19
