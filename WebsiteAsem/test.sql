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

-- Dumping structure for table learning.test
CREATE TABLE IF NOT EXISTS `test` (
  `id_test` int(10) NOT NULL AUTO_INCREMENT,
  `id_user` int(10) DEFAULT NULL,
  `intr1` text,
  `intr2` text,
  `intr3` text,
  `rs1` text,
  `rs2` text,
  `rs3` text,
  `data` date DEFAULT NULL,
  `nota_std` smallint(6) DEFAULT NULL,
  `nota` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id_test`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table learning.test: ~1 rows (approximately)
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
REPLACE INTO `test` (`id_test`, `id_user`, `intr1`, `intr2`, `intr3`, `rs1`, `rs2`, `rs3`, `data`, `nota_std`, `nota`) VALUES
	(1, 5, 'ab1', 'abdcdsa', '', 'adacsdca sad', 'asd asd ', 'asd asd asd ', '2012-10-13', NULL, NULL),
	(2, 5, 'sdfsd', 'sdaf', '', 'sdaf', 'dsaf', 'sadfsadf', '2012-10-13', 10, NULL),
	(3, 5, '', '', '', '', '', '', '2012-10-13', 1, NULL),
	(4, 5, '', '', '', '', '', '', '2012-10-13', 1, NULL);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
/*!40014 SET FOREIGN_KEY_CHECKS=1 */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
