-- MySQL dump 10.9
--
-- Host: localhost    Database: blogver1
-- ------------------------------------------------------
-- Server version	4.1.14-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(20) NOT NULL default '',
  `content` mediumtext,
  `pubtime` datetime NOT NULL default '0000-00-00 00:00:00',
  `blogid` int(11) NOT NULL default '0',
  `sortid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `article`
--


/*!40000 ALTER TABLE `article` DISABLE KEYS */;
LOCK TABLES `article` WRITE;
INSERT INTO `article` VALUES (1,'今天我做好了一件事情','今天我做好了一件事情，一件很酷的事情。','2011-01-03 00:00:00',1,1),(2,'你在他乡还好吗？','你还好吗?问候你一句。','2011-01-03 00:00:00',1,3),(3,'你好，时间','你好世界我的时间。','2011-01-03 00:00:00',2009,3),(4,'我很好','我很好','2011-01-03 00:00:00',1,1),(5,'中国，你好','中国，你好','2011-01-03 00:00:00',1,1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) NOT NULL default '',
  `password` varchar(20) NOT NULL default '',
  `subject` varchar(100) NOT NULL default '',
  `email` varchar(50) NOT NULL default '',
  `image` varchar(100) default NULL,
  `visitcount` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `blog`
--


/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
LOCK TABLES `blog` WRITE;
INSERT INTO `blog` VALUES (1,'admin','123456','中文','abcdef@email.com','image/default.jpg',1),(2,'admin1','admin1','write','nihao@163.com','image/default.jpg',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL auto_increment,
  `uname` varchar(20) NOT NULL default '',
  `content` mediumtext,
  `pubtime` datetime NOT NULL default '0000-00-00 00:00:00',
  `articleid` int(11) NOT NULL default '0',
  `ip` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `feedback`
--


/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
LOCK TABLES `feedback` WRITE;
INSERT INTO `feedback` VALUES (1,'不错不错','写的很好呀','2011-01-04 15:30:30',1,'127.0.0.1'),(2,'你好','<FONT color=#ffff00>做的 不错呀！<BR></FONT>','2011-01-04 15:30:30',1,'127.0.0.1'),(3,'你好','往往往往<BR>','2011-01-04 15:30:30',2,'127.0.0.1'),(4,'北方的狼','<BR><FONT color=#ff6633>看了不错哦！</FONT>','2011-01-04 15:30:30',1,'127.0.0.1'),(5,'北方的狼','<BR><FONT color=#ff6633>看了不错哦！</FONT>','2011-01-04 15:30:30',1,'127.0.0.1'),(6,'南无佛','我很好，谢谢<BR>','2011-01-12 14:29:40',5,'127.0.0.1');
UNLOCK TABLES;
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;

--
-- Table structure for table `links`
--

DROP TABLE IF EXISTS `links`;
CREATE TABLE `links` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(40) NOT NULL default '',
  `url` varchar(100) NOT NULL default '',
  `blogid` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `links`
--


/*!40000 ALTER TABLE `links` DISABLE KEYS */;
LOCK TABLES `links` WRITE;
INSERT INTO `links` VALUES (1,'网址导航','http://www.hao123.com',1),(3,'百度','www.baidu.com',1),(4,'google','www.google.com',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `links` ENABLE KEYS */;

--
-- Table structure for table `sort`
--

DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(40) NOT NULL default '',
  `blogid` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

--
-- Dumping data for table `sort`
--


/*!40000 ALTER TABLE `sort` DISABLE KEYS */;
LOCK TABLES `sort` WRITE;
INSERT INTO `sort` VALUES (1,'个人日记',1),(3,'个人博客',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `sort` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

