-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               5.5.47-MariaDB-1~wheezy-log - mariadb.org binary distribution
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for XXX
CREATE DATABASE IF NOT EXISTS `XXX` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `XXX`;

-- Dumping structure for table XXX.LS_Boardlinks
CREATE TABLE IF NOT EXISTS `LS_Boardlinks` (
  `Boardlink_id` int(11) NOT NULL AUTO_INCREMENT,
  `Link_id` int(11) DEFAULT '0',
  `Board_id` int(11) DEFAULT '0',
  `Deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`Boardlink_id`),
  KEY `Link_id` (`Link_id`),
  KEY `Board_id` (`Board_id`),
  CONSTRAINT `FK_LS_Boardlinks_LS_Boards` FOREIGN KEY (`Board_id`) REFERENCES `LS_Boards` (`Board_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_LS_Boardlinks_LS_Links` FOREIGN KEY (`Link_id`) REFERENCES `LS_Links` (`Link_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;

-- Dumping data for table XXX.LS_Boardlinks: ~42 rows (approximately)
/*!40000 ALTER TABLE `LS_Boardlinks` DISABLE KEYS */;
INSERT INTO `LS_Boardlinks` (`Boardlink_id`, `Link_id`, `Board_id`, `Deleted`) VALUES
	(2, 1, 2, 0),
	(4, 1, 4, 0),
	(5, 11, 4, 0),
	(8, 8, 3, 0),
	(10, 7, 3, 0),
	(11, 9, 4, 0),
	(12, 12, 2, 0),
	(13, 15, 3, 0),
	(14, 16, 2, 0),
	(15, 17, 3, 0),
	(25, 27, 4, 0),
	(26, 27, 7, 0),
	(27, 28, 3, 0),
	(28, 29, 3, 0),
	(29, 12, 7, 0),
	(30, 21, 7, 0),
	(31, 21, 4, 0),
	(32, 30, 7, 0),
	(33, 31, 7, 0),
	(34, 31, 8, 0),
	(35, 11, 2, 0),
	(36, 32, 7, 0),
	(37, 32, 2, 1),
	(38, 33, 7, 0),
	(43, 35, 8, 0),
	(44, 35, 9, 0),
	(45, 36, 12, 0),
	(46, 37, 11, 0),
	(47, 38, 11, 0),
	(48, 39, 11, 0),
	(49, 39, 7, 0),
	(51, 40, 12, 0),
	(52, 41, 12, 0),
	(53, 41, 9, 0),
	(54, 42, 13, 0),
	(56, 43, 3, 0),
	(57, 44, 14, 0),
	(58, 45, 15, 0),
	(59, 46, 16, 0),
	(60, 4, 15, 0),
	(61, 47, 17, 0),
	(62, 48, 7, 0);
/*!40000 ALTER TABLE `LS_Boardlinks` ENABLE KEYS */;

-- Dumping structure for table XXX.LS_Boards
CREATE TABLE IF NOT EXISTS `LS_Boards` (
  `Board_id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(150) DEFAULT NULL,
  `Timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`Board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- Dumping data for table XXX.LS_Boards: ~16 rows (approximately)
/*!40000 ALTER TABLE `LS_Boards` DISABLE KEYS */;
INSERT INTO `LS_Boards` (`Board_id`, `Name`, `Timestamp`, `Deleted`) VALUES
	(2, 'Kakku reseptit', '2017-04-08 19:58:09', 0),
	(3, 'Ohjelmointi linkit', '2017-05-01 16:38:57', 0),
	(4, 'Reseptit', '2017-05-06 17:20:23', 0),
	(5, 'Poistettu', '2017-05-11 18:41:00', 1),
	(6, 'ÄÖÅY?"/#"', '2017-05-11 18:41:37', 1),
	(7, 'Testi-Taulu', '2017-05-11 18:41:50', 0),
	(8, 'Kuvat', '2017-05-14 15:22:51', 0),
	(9, 'Poistettava', '2017-05-14 15:24:12', 0),
	(10, 'Auto', '2017-05-14 16:26:36', 1),
	(11, 'Veneet', '2017-05-17 19:43:23', 0),
	(12, 'Purjehdus', '2017-05-17 19:55:53', 0),
	(13, 'Kesäloma', '2017-05-18 18:58:19', 0),
	(14, 'Mancave', '2017-05-19 17:57:01', 0),
	(15, 'Autot', '2017-05-19 20:48:14', 0),
	(16, 'Posliininmaalaus', '2017-05-19 20:51:52', 1),
	(17, 'Hienot vaatteet festareille', '2017-06-16 22:18:52', 1);
/*!40000 ALTER TABLE `LS_Boards` ENABLE KEYS */;

-- Dumping structure for table XXX.LS_Boardusers
CREATE TABLE IF NOT EXISTS `LS_Boardusers` (
  `Board_id` int(11) NOT NULL,
  `User_id` int(11) NOT NULL,
  PRIMARY KEY (`Board_id`,`User_id`),
  KEY `FK_LS_Boardusers_LS_Users` (`User_id`),
  CONSTRAINT `FK_LS_Boardusers_LS_Boards` FOREIGN KEY (`Board_id`) REFERENCES `LS_Boards` (`Board_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `FK_LS_Boardusers_LS_Users` FOREIGN KEY (`User_id`) REFERENCES `LS_Users` (`User_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table XXX.LS_Boardusers: ~0 rows (approximately)
/*!40000 ALTER TABLE `LS_Boardusers` DISABLE KEYS */;
/*!40000 ALTER TABLE `LS_Boardusers` ENABLE KEYS */;

-- Dumping structure for table XXX.LS_Links
CREATE TABLE IF NOT EXISTS `LS_Links` (
  `Link_id` int(11) NOT NULL AUTO_INCREMENT,
  `Link` varchar(500) DEFAULT NULL,
  `Title` varchar(200) DEFAULT NULL,
  `Details` varchar(1000) DEFAULT NULL,
  `TimeStamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`Link_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

-- Dumping data for table XXX.LS_Links: ~48 rows (approximately)
/*!40000 ALTER TABLE `LS_Links` DISABLE KEYS */;
INSERT INTO `LS_Links` (`Link_id`, `Link`, `Title`, `Details`, `TimeStamp`, `Deleted`) VALUES
	(1, 'http://www.maku.fi/blogit/maku-toimituksen-blogi/viime-viikon-suosituin-resepti-nutella-kakku-taas', 'Nutella-juusto kakku', 'Viime viikon suosituin resepti: Nutella-kakku taas20', '2017-04-06 19:39:08', 0),
	(2, 'http://gluteenitonmuumimamma.fi/tag/maailman-paras-juustokakku/', 'Sitruunajuustokakku dulce de lechen kera', 'Gluteiiniton testi2', '2017-04-06 19:39:35', 0),
	(3, 'http://www.autotalli.com/vaihtoauto/34930555/Mini/Cooper/2004/Loimaa?pos=3&page=1', 'Mini Cooper 1.6 3d Aut.Ilmast. 6400,00 €', 'autotalli.com', '2017-04-08 15:15:54', 0),
	(4, 'https://www.nettiauto.com/audi/a6/8759761', 'Audi A6 22 450 ?', 'nettiauto.com', '2017-04-21 22:27:05', 0),
	(5, 'https://www.nettiauto.com/audi/a4/8741109', 'Audi A4 20 850 €', '2.0 TDI Avant Business Alcantara *JUURI HUOLLETTU JA KATSASTETTU! ', '2017-04-21 22:30:35', 0),
	(6, 'https://www.nettiauto.com/volvo/s80/8762537', 'Volvo S80', '', '2017-04-21 22:34:36', 0),
	(7, 'https://codepen.io/imprakash/pen/GgNMXO', 'Pop up CSS', 'Uusi linkki pop up käytetty', '2017-04-23 20:23:28', 0),
	(8, 'http://codepen.io/secondfret/pen/tgBCI', 'LISTA esimerkki KÄYTETTY TYÖSSÄ', 'listaesimerkki jota käytetty 4', '2017-04-23 20:27:29', 0),
	(9, 'http://gluteenitonmuumimamma.fi/tag/maailman-paras-juustokakku/ size=', 'Sitruunajuustokakku dulce de lechen kera size=', 'Gluteiiniton testi', '2017-04-23 21:09:46', 0),
	(10, 'testi', 'testi testi testi muokattu', 'test', '2017-04-27 17:44:40', 1),
	(11, 'https://www.k-ruoka.fi/reseptit/banaaniletut', 'Banaaniletut', 'IHANAA', '2017-05-01 13:31:30', 0),
	(12, 'test', 'kakku testi', 'testilaen tänään kakkureseptillä', '2017-05-07 21:15:34', 0),
	(13, 'sdfsdfsd', 'sfsdfsdf', '', '2017-05-07 21:27:22', 1),
	(14, 'https://www.k-ruoka.fi/reseptit/vegaaninen-juustokakku', 'Vegaaninen juustokakku', 'Tee tätä äitille', '2017-05-10 19:34:49', 0),
	(15, 'https://designbump.com/create-a-flat-website-template-htmlcss-tutorial/', 'CSS tutorial', 'header osio', '2017-05-10 20:48:10', 0),
	(16, 'sfsdf', 'testi kakkuu', 'sfddfssdf', '2017-05-11 17:32:01', 1),
	(17, 'dlsfjsldkjfldsf', 'hyvä css sivu', 'sdfsdfsdkj lue osa', '2017-05-11 17:40:27', 1),
	(18, 'lskjfslkdfjlsdkjfsd', 'testailen kakkua', 'testailen kakkua', '2017-05-11 17:58:10', 0),
	(19, 'ohjelmointi linkki testi 1', 'ohjelmointi linkki testi 1', 'ohjelmointi linkki testi 1', '2017-05-11 17:58:40', 0),
	(20, 'idn haku', 'idn haku', 'idn haku', '2017-05-11 18:01:01', 1),
	(21, 'idtesti', 'idtesti', 'idtesti', '2017-05-11 18:04:03', 1),
	(22, 'linkidtest', 'linkidtest', 'linkidtest', '2017-05-11 18:06:32', 1),
	(23, 'vielä kerran testi id', 'vielä kerran testi id', 'vielä kerran testi id', '2017-05-11 18:07:39', 1),
	(24, 'vielä lisää testiä id', 'vielä lisää testiä id', 'vielä lisää testiä id', '2017-05-11 18:14:47', 1),
	(25, 'mitä', 'mitä', 'mitä', '2017-05-11 18:15:52', 1),
	(26, 'miksi et toimi', 'miksi et toimi', 'miksi et toimi', '2017-05-11 18:16:09', 1),
	(27, 'sfsdf', 'toimi jo', 'sdfsdfs', '2017-05-11 18:17:54', 1),
	(28, 'https://www.w3schools.com/css/css_image_gallery.asp', 'CSS Galleria', 'Hieno galleria', '2017-05-11 19:26:06', 0),
	(29, 'https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_anim_search', 'search box example', '', '2017-05-13 17:49:33', 0),
	(30, 'http://webneel.com/wallpaper/sites/default/files/images/05-2014/1-sunrise.preview.jpg', 'Hieno kuva', 'Hieno kuva auringonlaskusta', '2017-05-14 12:18:34', 0),
	(31, 'https://www.google.fi/imgres?imgurl=http%3A%2F%2F6iee.com%2Fdata%2Fuploads%2F34%2F493452.jpg&imgrefurl=http%3A%2F%2Fwww.keywordsuggests.com%2Focean-view%2F&docid=1kQ3xJfrVJgj8M&tbnid=8XC00A5RCnpAiM%3A&vet=10ahUKEwjHvdPgqe_TAhVBDZoKHZzXACoQMwg3KAMwAw..i&w=1920&h=1080&client=firefox-b-ab&bih=611&biw=1280&q=view&ved=0ahUKEwjHvdPgqe_TAhVBDZoKHZzXACoQMwg3KAMwAw&iact=mrc&uact=8', 'TOINEN HIENO KUVA', '', '2017-05-14 14:57:17', 0),
	(32, 'random', 'random', '', '2017-05-14 17:58:23', 0),
	(33, 'random kuva', 'random kuva', '', '2017-05-15 20:12:47', 0),
	(34, 'uusi kuva', 'uusi kuva', '', '2017-05-15 20:21:36', 0),
	(35, 'pw', 'söpö tipu', '', '2017-05-15 20:55:02', 0),
	(36, 'http://purjehdus.net/wp-content/themes/theme1690/images/bg-img.jpg', 'Hieno maisema keulasta', 'vauhdin huumaa', '2017-05-17 19:56:42', 0),
	(37, 'http://libertas31.nettisivu.org/wp-content/uploads/sites/949/2011/10/s-y-libertas2.jpg', 'vene auringonlasku', '', '2017-05-17 20:15:39', 0),
	(38, 'https://www.google.fi/imgres?imgurl=http%3A%2F%2Fwww.lohjanpurjehtijat.fi%2F%40Bin%2F298231%2FIMG_1140.jpeg&imgrefurl=http%3A%2F%2Fwww.lohjanpurjehtijat.fi%2F&docid=LRQoXROo8hvl-M&tbnid=uYl-wV5SGWeBfM%3A&vet=10ahUKEwixz-yysvfTAhXJkSwKHUeGCFwQMwgwKA0wDQ..i&w=680&h=510&client=firefox-b-ab&bih=611&biw=1280&q=purjehdus&ved=0ahUKEwixz-yysvfTAhXJkSwKHUeGCFwQMwgwKA0wDQ&iact=mrc&uact=8', 'Lochness', '', '2017-05-17 20:23:40', 0),
	(39, 'http://purjehdus.omasivu.fi/', 'Purjehdus harrastus', 'Vene harrastus', '2017-05-17 20:26:41', 0),
	(40, 'http://im.mtv.fi/image/4653044/landscape16_9/1024/576/62e5e89f583d9abe54da84b837ced12c/FR/purjehdus-purjehtia-meri.jpg', 'Purjehdus ihana kuva', 'hieno kuva', '2017-05-18 17:11:18', 0),
	(41, 'http://im.mtv.fi/image/4653044/landscape16_9/1024/576/62e5e89f583d9abe54da84b837ced12c/FR/purjehdus-purjehtia-meri.jpg', 'auringon lasku', 'magee', '2017-05-18 17:48:32', 0),
	(42, 'http://www.gulavillan.fi/', 'Gula Villan', 'Magee mesta, hyvää musaa, kylmää kaljaa! mene! älä mene sateella', '2017-05-18 18:59:11', 0),
	(43, 'https://www.experts-exchange.com/', 'Good link for coding', 'Got from teacher (brade)', '2017-05-18 19:30:16', 0),
	(44, 'https://cdn.homebnc.com/homeimg/2016/01/03-arcade-man-cave-decoration-homebnc.png', 'Baaripöytä', 'sairaan magee', '2017-05-19 17:57:44', 0),
	(45, 'https://www.nettiauto.com/audi/a6', 'Audi A6', 'käy ostaa hyvä auto', '2017-05-19 20:47:47', 0),
	(46, 'http://personal.inet.fi/taide/ritva.kiema/kuvat/seinalaut.jpg', 'Ruusulautanen', 'Katso hyvin maalattu ruusu', '2017-05-19 20:52:29', 1),
	(47, 'https://www.veromoda.com/fi/fi/vm/osta-kategoriottain/mekot/cold-shoulder--mallinen-mekko-10190190.html?cgid=vm-dresses&dwvar_colorPattern=10190190_WhitecapGray_601944', 'Hieno mekko (olkapää)', 'sldkfjksdjf', '2017-06-16 22:20:28', 1),
	(48, 'http://www.haaga-helia.fi/fi/etusivu', 'Haaga-Helia', '', '2018-02-18 12:48:09', 0);
/*!40000 ALTER TABLE `LS_Links` ENABLE KEYS */;

-- Dumping structure for table XXX.LS_Photos
CREATE TABLE IF NOT EXISTS `LS_Photos` (
  `Photo_id` varchar(500) NOT NULL,
  `Link_id` int(11) NOT NULL,
  `Priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`Photo_id`),
  KEY `Link_id_idx` (`Link_id`),
  CONSTRAINT `LS_Photos_Link_id` FOREIGN KEY (`Link_id`) REFERENCES `LS_Links` (`Link_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table XXX.LS_Photos: ~25 rows (approximately)
/*!40000 ALTER TABLE `LS_Photos` DISABLE KEYS */;
INSERT INTO `LS_Photos` (`Photo_id`, `Link_id`, `Priority`) VALUES
	('link_11funny.jpg', 11, 0),
	('link_11koira.jpg', 11, 1),
	('link_30IMG_20150427_165806.jpg', 30, 0),
	('link_30IMG_20150427_165946.jpg', 30, 0),
	('link_31tipu.jpg', 31, 0),
	('link_33IMG_20150427_165842.jpg', 33, 0),
	('link_34koira.jpg', 34, 0),
	('link_35koira.jpg', 35, 0),
	('link_35tipu.jpg', 35, 0),
	('link_36purjehdus.jpg', 36, 0),
	('link_37rocks.jpg', 37, 0),
	('link_37vene.jpg', 37, 0),
	('link_38tipu.jpg', 38, 0),
	('link_39Kuva_090.jpg', 39, 0),
	('link_39rocks.jpg', 39, 0),
	('link_41FB_IMG_1439567807442.jpg', 41, 0),
	('link_41IMG_20150427_165806.jpg', 41, 0),
	('link_41purjehdus.jpg', 41, 0),
	('link_42Kuva_090.jpg', 42, 0),
	('link_44Kuva_090.jpg', 44, 0),
	('link_45funny.jpg', 45, 1),
	('link_45koira.jpg', 45, 0),
	('link_46rocks.jpg', 46, 1),
	('link_46sunrise.jpg', 46, 0),
	('link_48logo.png', 48, 0);
/*!40000 ALTER TABLE `LS_Photos` ENABLE KEYS */;

-- Dumping structure for table XXX.LS_Users
CREATE TABLE IF NOT EXISTS `LS_Users` (
  `User_id` int(11) NOT NULL AUTO_INCREMENT,
  `Firstname` varchar(50) NOT NULL,
  `Lastname` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Username` varchar(50) DEFAULT NULL,
  `Password` varchar(50) NOT NULL,
  `TimeStamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `Deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`User_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table XXX.LS_Users: ~5 rows (approximately)
/*!40000 ALTER TABLE `LS_Users` DISABLE KEYS */;
INSERT INTO `LS_Users` (`User_id`, `Firstname`, `Lastname`, `Email`, `Username`, `Password`, `TimeStamp`, `Deleted`) VALUES
	(3, 'Testi', 'Testinen', 'testi@gmail.com', 'testi', 'salasana', '2017-05-17 21:21:25', 0),
	(4, 'Maija', 'Mehiläinen', 'mehis@gmail.com', 'mehis', 'testisalasana', '2017-05-17 22:43:40', 0),
	(5, 'Matti', 'Nykänen', 'masa@gmail.com', 'masa', 'salasana', '2017-05-17 22:47:58', 0),
	(6, 'Minna', 'Magia', 'minna@gmail.com', 'minna', 'salasana', '2017-05-17 23:18:36', 0),
	(8, 'Firstname', 'Lastname', 'test@test.com', NULL, 'password', '2018-02-18 12:44:05', 0);
/*!40000 ALTER TABLE `LS_Users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
