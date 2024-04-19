/*
SQLyog Community v11.52 (32 bit)
MySQL - 5.5.30 : Database - crop-knn
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crop-knn` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `crop-knn`;

/*Table structure for table `dataset` */

DROP TABLE IF EXISTS `dataset`;

CREATE TABLE `dataset` (
  `sno` int(11) DEFAULT NULL,
  `SoilName` varchar(500) DEFAULT NULL,
  `soilMoisture` varchar(500) DEFAULT NULL,
  `Temp` varchar(500) DEFAULT NULL,
  `Humidity` varchar(500) DEFAULT NULL,
  `PH` varchar(500) DEFAULT NULL,
  `CropType` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `dataset` */

insert  into `dataset`(`sno`,`SoilName`,`soilMoisture`,`Temp`,`Humidity`,`PH`,`CropType`) values (1,'Red','1','13','2','21','Rice'),(2,'Black','23','45','23','34','Wheat'),(3,'RedBlack','12','12','12','45','Corn'),(4,'Green','24','34','34','23','Sweet Corn'),(5,'Red','23','14','12','21','Corn');

/*Table structure for table `svalues` */

DROP TABLE IF EXISTS `svalues`;

CREATE TABLE `svalues` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `SoilName` varchar(500) DEFAULT NULL,
  `soilMoisture` varchar(500) DEFAULT NULL,
  `Temp` varchar(500) DEFAULT NULL,
  `Humidity` varchar(500) DEFAULT NULL,
  `PH` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `svalues` */

insert  into `svalues`(`sno`,`SoilName`,`soilMoisture`,`Temp`,`Humidity`,`PH`) values (1,'11','11','11','11','11'),(2,'33','68','12','2','3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
