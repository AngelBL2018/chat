/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21-0ubuntu0.17.10.1 : Database - userWebChat
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`userWebChat` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `userWebChat`;

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `from_id` int(11) unsigned NOT NULL,
  `to_id` int(11) unsigned NOT NULL,
  `text` text NOT NULL,
  `times_temp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `from_id` (`from_id`),
  KEY `to_id` (`to_id`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`from_id`) REFERENCES `user` (`id`),
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`to_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

/*Data for the table `message` */

insert  into `message`(`id`,`from_id`,`to_id`,`text`,`times_temp`) values (1,1,2,'barev','2018-02-25 20:02:25'),(2,1,2,'inchxes ara jan','2018-02-25 20:02:49'),(3,1,2,'tneciq lav en','2018-02-25 20:04:43'),(4,2,2,'barev admin jan','2018-02-25 20:05:07'),(5,1,2,'iyaaaaaa\r\n','2018-02-25 20:49:44'),(6,2,2,'','2018-02-25 20:52:02'),(8,2,1,'bareeev axperss','2018-02-25 22:28:39'),(9,2,1,'inch ka chka','2018-02-25 22:57:25'),(10,2,1,'inchx eq','2018-02-25 23:00:25'),(11,2,1,'lav es axper jan\r\n','2018-02-25 23:02:12'),(20,2,1,'inch ka','2018-02-25 23:36:42'),(21,1,2,'inch ka','2018-02-25 23:37:25'),(22,2,1,'iyaa','2018-02-25 23:51:06');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `pic_url` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`surname`,`email`,`password`,`pic_url`) values (1,'admin','admin','admin@mail.com','12','1519574473312_j.jpg'),(2,'ara','ara','ara@mail.com','12','1519574526432_j.jpg'),(3,'lus','lus','lus@mail.com','12','1519581371011_j.jpg'),(4,'poxos','poxos','poxos@mail.com','12','1519581393729_j.jpg');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
