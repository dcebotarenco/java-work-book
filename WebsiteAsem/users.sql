-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.23 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL version:             7.0.0.4140
-- Date/time:                    2012-10-13 17:57:51
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

-- Dumping structure for table learning.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nume` varchar(50) DEFAULT NULL,
  `prenume` varchar(50) DEFAULT NULL,
  `grupa` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tara` varchar(50) DEFAULT NULL,
  `datareg` date DEFAULT NULL,
  `dataBirt` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table learning.users: ~2 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
REPLACE INTO `users` (`id`, `login`, `password`, `nume`, `prenume`, `grupa`, `email`, `tara`, `datareg`, `dataBirt`) VALUES
	(5, 'phoenix', '1234567', '23131', '5412132', 'INF - 101', '132156142', 'Bahrain', '2012-10-06', '11-10-1997'),
	(10, 'dannnnn', '123456', 'Dan]', 'Cebotarenco', 'INFa - 111', 'st_mihai213@yahoo.com', 'American Samoa', '2012-10-11', '4-4-2001');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
