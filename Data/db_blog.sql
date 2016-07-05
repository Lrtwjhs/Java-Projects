-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: db_blog
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL DEFAULT '',
  `content` mediumtext,
  `pubtime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `blogid` int(11) NOT NULL DEFAULT '0',
  `sortid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'Gettysburg','<div>Fourscore and seven years ago, our fathers brought forth upon this continent a new Nation, conceived in Liberty, and dedicated to the proposition that all men are created equal. Now, we are engaged in a great Civil War, testing whether that Nation, or any nation so conceived and so dedicated, can long endure. We are met on a great battlefield of that war. We have come to dedicate a portion of that field as a final resting-place for those who here gave their lives that that Nation might live. It is altogether fitting and proper that we should do this.</div><div><br></div><div>But, in a larger sense, we cannot dedicate, we cannot consecrate, we cannot hallow this ground. The brave men, living and dead, who struggled here, have consecrated it far above our poor power to add or detract. The world will little note nor long remember what we say here, but it can never forget what they did here. It is for us, the living, rather to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. It is rather for us to be here dedicated to the great task remaining before us; that from these honored dead, we take increased devotion to that cause for which they gave the last full measure of devotion; that we here highly resolve that these dead shall not have died in vain, that this Nation, under GOD, shall have a new birth of freedom; and that government of the People by the People and for the People shall not perish from the earth.</div>','2016-07-05 09:00:00',1,1),(2,'Ode to the West Wind','<div>1</div><div><br></div><div>哦，犷野的西风，你秋之实体的气息!</div><div>由于你无形无影的出现，万木萧疏，</div><div>似鬼魅逃避驱魔巫师，蔫黄，魆黑，</div><div><br></div><div>苍白，潮红，疫疠摧残的落叶无数，</div><div>四散飘舞；哦，你又把有翅的种籽</div><div>凌空运送到他们阴暗的越冬床圃；</div><div><br></div><div>仿佛是一具具僵卧在坟墓里的尸体，</div><div>他们将分别蛰伏，冷落而又凄凉，</div><div>直到阳春你蔚蓝的姐妹向梦中的大地</div><div><br></div><div>吹响她嘹亮的号角(如同牧放群羊，</div><div>驱送香甜的花蕾到空气中觅食就饮)</div><div>给高山平原注满生命的色彩和芬芳。</div><div>不羁的精灵，你啊，你到处运行；</div><div>你破坏，你也保存，听，哦，听!</div><div><br></div><div>2</div><div><br></div><div>在你的川流上，在骚动的高空，</div><div>纷乱的乌云，那雨和电的天使，</div><div>正像大地凋零枯败的落叶无穷，</div><div><br></div><div>挣脱天空和海洋交错缠接的柯枝，</div><div>飘流奔泻；在你清虚的波涛表面，</div><div>似梅娜德头上扬起的蓬勃青丝，</div><div><br></div><div>从那茫茫地平线阴暗的边缘</div><div>直到苍穹的绝顶，到处都散布着</div><div>迫近的暴风雨飘摇翻腾的发卷。</div><div><br></div><div>你啊，垂死残年的挽歌，四合的夜幕</div><div>在你聚集的全部水汽威力支撑下，</div><div>将构成他那庞大墓穴的拱形顶部。</div><div><br></div><div>从你那雄浑磅礴的氛围，将迸发</div><div>黑色的雨、火、冰雹；哦，听啊!</div><div><br></div><div>3</div><div><br></div><div>你，哦，是你把蓝色的地中海</div><div>从梦中唤醒，他在一整个夏天</div><div>都酣睡在贝伊湾一座浮石岛外，</div><div><br></div><div>被澄澈的流水喧哗声催送入眠，</div><div>梦见了古代的楼台、塔堡和宫闱，</div><div>在澎湃汹涌的波光里不住地抖颤，</div><div><br></div><div>全都长满了蔚蓝色苔藓和花卉，</div><div>馨香馥郁，如醉的知觉难以描摹。</div><div>哦，为了给你让路，大西洋水</div><div><br></div><div>豁然开裂，而在浩淼波澜深处，</div><div>海底花藻和枝叶无汁的淤泥丛林，</div><div>哦，由于把你的呼啸声辨认出，</div><div><br></div><div>一时都惨然变色，胆怵心惊，</div><div>战栗着自行凋落；听，哦，听!</div><div><br></div><div>4</div><div><br></div><div>我若是一朵轻捷的浮云，能随你同飞，</div><div>我若是一片落叶，能为你所提携，</div><div>我若是一重波浪，能喘息于你的神威，</div><div><br></div><div>分享你雄强的脉搏，自由不羁，</div><div>仅次于，哦，仅次于不可控制的你；</div><div>我若能像在少年时，作为伴侣，</div><div><br></div><div>随你同游天际，因为在那时节，</div><div>似乎超越你天界的神速也不为奇迹；</div><div>我也就不至于像现在这样急切，</div><div><br></div><div>向你苦苦祈求。哦，快把我飏起，</div><div>就像你飏起波浪、浮云、落叶!</div><div>我倾覆于人生的荆棘!我在流血!</div><div><br></div><div>岁月的重负压制着的这一个太像你，</div><div>像你一样，骄傲，不驯，而且敏捷。</div><div><br></div><div>5</div><div><br></div><div>像你以森林演奏，请也以我为琴，</div><div>哪怕我的叶片也像森林的一样凋谢!</div><div>你那非凡和谐的慷慨激越之情，</div><div><br></div><div>定能从森林和我同奏出深沉的秋乐，</div><div>悲怆却又甘洌。但愿你勇猛的精灵</div><div>竟是我的魂魄，我能成为剽悍的你!</div><div><br></div><div>请把我枯萎的思绪播送宇宙，</div><div>就像你驱遣落叶催促新的生命，</div><div>请凭借我这韵文写就的符咒，</div><div><br></div><div>就像从未灭的余烬飏出炉灰和火星，</div><div>把我的话语传遍天地间万户千家，</div><div>通过我的嘴唇，向沉睡未醒的人境，</div><div><br></div><div>让预言的号角奏鸣!哦，风啊，</div><div>冬天如果来了，春天还会远吗?</div>','2016-07-03 18:00:00',1,3),(3,'Hello World','Hello World!','2016-07-01 08:00:00',2009,3),(4,'《错误》','<div>我打江南走过</div><div>那等在季节里的容颜如莲花的开落</div><div>东风不来，三月的柳絮不飞</div><div>你底心如小小的寂寞的城</div><div>恰若青石的街道向晚</div><div>跫音不响，三月的春帷不揭</div><div>你底心是小小的窗扉紧掩</div><div>我达达的马蹄是美丽的错误</div><div>我不是归人，是个过客……</div>','2016-07-03 19:00:00',1,3),(5,'《别》','<div>在春天，</div><div>我把手帕轻挥，</div><div>是让我远去，</div><div>还是马上返回？</div><div>不，什么也不是，</div><div>什么也不因为，</div><div>就象水中的落花，</div><div>就象花上的露水……</div><div>只有影子懂得，</div><div>只有风能体会，</div><div>只有叹息惊起的彩蝶，</div><div>还在心花中纷飞……</div>','2016-07-05 07:00:00',1,1),(6,'《断章》','<div>你站在桥上看风景，</div><div>看风景的人在楼上看你。</div><div>明月装饰了你的窗子，</div><div>你装饰了别人的梦。</div>','2016-07-04 16:21:17',1,1);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) NOT NULL DEFAULT '',
  `subject` varchar(100) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `image` varchar(100) DEFAULT NULL,
  `visitcount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,'admin','123456','中文','abcdef@email.com','image/default.jpg',1),(2,'admin1','admin1','write','nihao@163.com','image/default.jpg',1);
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) NOT NULL DEFAULT '',
  `content` mediumtext,
  `pubtime` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `articleid` int(11) NOT NULL DEFAULT '0',
  `ip` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'不错不错','写的很好呀','2011-01-04 15:30:30',1,'127.0.0.1'),(2,'你好','<FONT color=#ffff00>做的 不错呀！<BR></FONT>','2011-01-04 15:30:30',1,'127.0.0.1'),(3,'你好','往往往往<BR>','2011-01-04 15:30:30',2,'127.0.0.1'),(4,'北方的狼','<BR><FONT color=#ff6633>看了不错哦！</FONT>','2011-01-04 15:30:30',1,'127.0.0.1'),(5,'北方的狼','<BR><FONT color=#ff6633>看了不错哦！</FONT>','2011-01-04 15:30:30',1,'127.0.0.1'),(6,'南无佛','我很好，谢谢<BR>','2011-01-12 14:29:40',5,'127.0.0.1'),(7,'','<br>','2016-07-04 13:31:00',5,'127.0.0.1'),(8,'sfsdf','fsdf','2016-07-04 13:31:09',5,'127.0.0.1'),(9,'dsf','sfsdf','2016-07-04 14:18:06',3,'127.0.0.1');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `links`
--

DROP TABLE IF EXISTS `links`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `links` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL DEFAULT '',
  `url` varchar(100) NOT NULL DEFAULT '',
  `blogid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `links`
--

LOCK TABLES `links` WRITE;
/*!40000 ALTER TABLE `links` DISABLE KEYS */;
INSERT INTO `links` VALUES (2,'Google','https://www.google.com/',1),(3,'东秦在线','http://dqzx.neuq.edu.cn/',1);
/*!40000 ALTER TABLE `links` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sort`
--

DROP TABLE IF EXISTS `sort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL DEFAULT '',
  `blogid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sort`
--

LOCK TABLES `sort` WRITE;
/*!40000 ALTER TABLE `sort` DISABLE KEYS */;
INSERT INTO `sort` VALUES (1,'个人日记',1),(3,'个人博客',1);
/*!40000 ALTER TABLE `sort` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-05 14:55:49
