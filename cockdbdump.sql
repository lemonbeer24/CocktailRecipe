-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES (41,'Pornstar Martini','21b688d9-ce25-44d2-b4fd-f4bbc1c7ec4a','{\"Materials\": [{\"unit\": \"ml\", \"volume\": 45, \"MaterialName\": \"앱솔루트 바니리아\"}, {\"unit\": \"ml\", \"volume\": 25, \"MaterialName\": \"패션프루트 퓨레\"}, {\"unit\": \"ml\", \"volume\": 15, \"MaterialName\": \"바닐라 시럽\"}, {\"unit\": \"슬라이스\", \"volume\": 1, \"MaterialName\": \"파인애플\"}, {\"unit\": \"절반\", \"volume\": 1, \"MaterialName\": \"패션 프루트\"}], \"procedures\": [{\"Procedure\": \"보스턴 쉐이커에 앱솔루트 바니리아, 패션프루트 퓨레 및 바닐라 시럽를 넣고 으깬다.\", \"guideImgName\": \"\"}, {\"Procedure\": \"파인애플 및 패션 프루트를 넣는다. 쉐이킹을 한 후 스트레이너를 사용하여 차가운 칵테일 글래스에 따른다.\", \"guideImgName\": \"\"}, {\"Procedure\": \"패션 프루트로 장식한다.\", \"guideImgName\": \"pm2.png\"}]}','test','1234'),(42,'Espresso Martini','822bbe9f-4827-4bb5-a9f9-728c268f7eb6','{\"note\": [\"에스프레소 커피를 미리 준비하고 식히십시오\"], \"Materials\": [{\"unit\": \"ml\", \"volume\": 40, \"MaterialName\": \"앱솔루트 보드카\"}, {\"unit\": \"ml\", \"volume\": 20, \"MaterialName\": \"깔루아\"}, {\"unit\": \"ml\", \"volume\": 20, \"MaterialName\": \"에스프레소\"}, {\"unit\": \"전체\", \"volume\": 3, \"MaterialName\": \"커피콩\"}], \"procedures\": [{\"Procedure\": \"보스턴 쉐이커에 얼음를 채운다. 모든 재료를 넣는다. \", \"guideImgName\": \"\"}, {\"Procedure\": \"쉐이킹을 한 후 스트레이너를 사용하여 차가운 칵테일 글래스에 따른다. 커피 콩으로 장식한다.\", \"guideImgName\": \"em2.png\"}]}','test','1234'),(43,'Amaretto Sour','c44b33e4-d766-41f2-92bf-3e8665811194','{\"Materials\": [{\"unit\": \"ml\", \"volume\": 50, \"MaterialName\": \"아마레또\"}, {\"unit\": \"ml\", \"volume\": 30, \"MaterialName\": \"레몬 주스\"}, {\"unit\": \"ml\", \"volume\": 20, \"MaterialName\": \"슈가시럽\"}, {\"unit\": \"ml\", \"volume\": 10, \"MaterialName\": \"계란 흰자\"}, {\"unit\": \"전체\", \"volume\": 1, \"MaterialName\": \"체리\"}, {\"unit\": \"슬라이스\", \"volume\": 1, \"MaterialName\": \"오렌지\"}], \"procedures\": [{\"Procedure\": \"보스턴 쉐이커에 얼음를 채운다. 모든 재료를 넣는다.쉐이킹을 한 후 스트레이너를 사용하여 락 글래스에 따른다. \", \"guideImgName\": \"\"}, {\"Procedure\": \"체리 및 오렌지로 장식한다.\", \"guideImgName\": \"as2.png\"}]}','test','1234'),(44,'Sex On The Beach','433ee2d3-31ea-4de2-b9f1-a85010b88a33','{\"Materials\": [{\"unit\": \"ml\", \"volume\": 20, \"MaterialName\": \"앱솔루트 보드카\"}, {\"unit\": \"ml\", \"volume\": 100, \"MaterialName\": \"라이트 오렌지 주스\"}, {\"unit\": \"ml\", \"volume\": 100, \"MaterialName\": \"크랜베리 주소\"}, {\"unit\": \"ml\", \"volume\": 20, \"MaterialName\": \"복숭아 슈납스\"}, {\"unit\": \"라임\", \"volume\": 1, \"MaterialName\": \"라임\"}, {\"unit\": \"체리\", \"volume\": 1, \"MaterialName\": \"체리\"}], \"procedures\": [{\"Procedure\": \"하이볼 글래스에 얼음를 채운다. 모든 재료를 넣는다. \", \"guideImgName\": \"\"}, {\"Procedure\": \"라임과 체리로 장식한다\", \"guideImgName\": \"sb2.png\"}]}','test','1234'),(45,'Bloody Mary','9636ee1c-5732-4af2-b224-98628c0ea626','{\"note\": [\"브런치용으로 만드는 경우 블러디 메리를 너무 강하게 만들지 마십시오\"], \"Materials\": [{\"unit\": \"ml\", \"volume\": 45, \"MaterialName\": \"앱솔루트 보드카\"}, {\"unit\": \"ml\", \"volume\": 150, \"MaterialName\": \"토마토 주스\"}, {\"unit\": \"소량\", \"volume\": 4, \"MaterialName\": \"핫 소스\"}, {\"unit\": \"ml\", \"volume\": 10, \"MaterialName\": \"우스터 소스\"}, {\"unit\": \"ml\", \"volume\": 10, \"MaterialName\": \"레몬 주스\"}, {\"unit\": \"자밤\", \"volume\": 1, \"MaterialName\": \"블랙페퍼 가루\"}, {\"unit\": \"자밤\", \"volume\": 1, \"MaterialName\": \"갈릭 솔트\"}, {\"unit\": \"웨지\", \"volume\": 1, \"MaterialName\": \"레몬\"}, {\"unit\": \"개\", \"volume\": 1, \"MaterialName\": \"셀러리\"}], \"procedures\": [{\"Procedure\": \"믹싱 글래스에 모든 재료를 넣고 휘저어준다.\", \"guideImgName\": \"\"}, {\"Procedure\": \"차가운 하이볼 글래스에 따른다. 레몬 및 셀러리로 장식한다.\", \"guideImgName\": \"bm2.png\"}]}','test','1234'),(46,'Firework','c156e928-725b-4274-8a2a-a4940ef59b5f','{\"Materials\": [{\"unit\": \"ml\", \"volume\": 45, \"MaterialName\": \"앱솔루트 보드카\"}, {\"unit\": \"ml\", \"volume\": 60, \"MaterialName\": \"레몬에이드\"}, {\"unit\": \"ml\", \"volume\": 60, \"MaterialName\": \"아이스 티\"}, {\"unit\": \"웨지\", \"volume\": 1, \"MaterialName\": \"라임\"}], \"procedures\": [{\"Procedure\": \"하이볼 글래스에 얼음를 채운다. 모든 재료를 넣는다. \", \"guideImgName\": \"\"}, {\"Procedure\": \"라임으로 장식한다.\", \"guideImgName\": \"fw2.png\"}]}','test','1234');
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

-- Dump completed on 2023-01-20  0:26:02
