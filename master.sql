-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 30, 2021 at 06:08 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `master`
--
CREATE DATABASE IF NOT EXISTS `master` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `master`;

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
CREATE TABLE IF NOT EXISTS `korisnik` (
  `Username` varchar(32) NOT NULL,
  `Ime` varchar(32) CHARACTER SET cp1251 DEFAULT NULL,
  `Prezime` varchar(32) CHARACTER SET cp1251 DEFAULT NULL,
  `E-mail` varchar(32) NOT NULL,
  `Password` varchar(40) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`Username`, `Ime`, `Prezime`, `E-mail`, `Password`) VALUES
('vs150429d', 'Сандра', 'Велимировић', 'vs150429d@student.etf.bg.ac.rs', 'f6.7#fDeaC68'),
('lp150463d', 'Петар', 'Лозо', 'lp150463d@student.etf.bg.ac.rs', 'r1f7/6HjiC68'),
('va150098d','Ана','Ванзо','va150098d@student.etf.bg.ac.rs','anaVanzo123'),
('mj150345d','Јелена','Миловановић','mj150345d@student.etf.bg.ac.rs','mj1234'),
('zaki', 'Захарије', 'Радивојевић', 'zaki@etf.bg.ac.rs', 'zaki1234'),
('certic', 'Јелена', 'Ћертић', 'certic@etf.bg.ac.rs', 'certic123'),
('kstankovic', 'Ковиљка', 'Станковић', 'kstankovic@etf.bg.ac.rs', 'kstankovic123'),
('sosic', 'Дарко', 'Шошић', 'sosic@etf.bg.ac.rs', 'sosic123'),
('nenad', 'Ненад', 'Јовичић', 'nenad@etf.bg.ac.rs', 'nenad1234'),
('dragan84m', 'Драган', 'Михић', 'dragan84m@etf.bg.ac.rs', 'dragan84m123'),
('zoran.cica', 'Зоран', 'Чича', 'zoran.cica@etf.rs', 'zoki76cica'),
('mnikolic', 'Марија', 'Стевановић', 'mnikolic@etf.bg.ac.rs', 'mstevanovic87'),
('varsovski', 'Владимир', 'Арсоски', 'varsovski@etf.bg.ac.rs', 'vars123ovski'),
('tatjana.lutovac', 'Татјана', 'Лутовац', 'tatjana.lutovac@etf.rs', 'tatjana.lutovac123'),
('ptadic', 'Предраг', 'Тадић', 'ptadic@etf.bg.ac.rs', 'ptadicPR'),
('bojic', 'Драган', 'Бојић', 'bojic@etf.bg.ac.rs', 'bojicdragan.123'),
('stud_sluzba', 'Драгана', 'Треневски Виденов', 'stud_sluzba@etf.bg.ac.rs', 'stud_sluzba_123'),
('milanka', 'Миланка', 'Ђорђевић', 'milanka@etf.bg.ac.rs', 'milanka5467'),
('suncica', 'Сунчица', 'Анђелковић', 'suncica@etf.bg.ac.rs', 'suncica190'),
('desanka', 'Десанка', 'Степић', 'desanka@etf.bg.ac.rs', 'desankaStepic123'),
('dmilena', 'Милена', 'Дамјановић', 'dmilena@etf.bg.ac.rs', 'dmilena89'),
('marinad', 'Марина', 'Мумин', 'marinad@etf.bg.ac.rs', 'marinamumin123'),
('jelenav', 'Јелена', 'Вилотић', 'jelenav@etf.bg.ac.rs', 'jelenaV23'),
('mbojovic', 'Мирослав', 'Бојовић', 'mbojovic@etf.bg.ac.rs', 'mboja98034'),
('cmilos','Милош','Цветановић','cmilos@etf.bg.ac.rs','cMilos123'),
('stojsasa','Саша','Стојановић','stojsasa@etf.bg.ac.rs','stojsasa456'),
('pavle.vuletic','Павле','Вулетић','pavle.vuletic@etf.bg.ac.rs','vule89pavle'),
('zarko','Жарко','Станисављевић','zarko@etf.bg.ac.rs','zare1235'),
('tartalja','Игор','Тартаља','tartalja@etf.bg.ac.rs','t98123_1#Fge'),
('pedjao','Предраг','Обрадовић','pedjao@etf.bg.ac.rs','p$23dgsdFke23'),
('ziza','Кристијан','Жижа','ziza@etf.bg.ac.rs','ziza-san123'),
('nbosko','Бошко','Николић','nbosko@etf.bg.ac.rs','nBoza123'),
('drazen.draskovic','Дражен','Драшковић','drazen.draskovic@etf.bg.ac.rs','drazen.drasko!2345'),
('mvt','Мило','Томашевић','mvt@etf.bg.ac.rs','m#tLK3235'),
('jeca','Јелица','Протић','jeca@etf.bg.ac.rs','protic03@jelica'),
('dmilicev','Драган','Милићев','dmilicev@etf.bg.ac.rs','dmilicev1234#fgs'),
('marko.misic','Марко','Мишић','marko.misic@etf.bg.ac.rs','marko.misic2345'),
('slavko.gajin','Славко','Гајин','slavko.gajin@etf.bg.ac.rs','slavko1234'),
('anaga777','Ана','Гавровска','anaga777@etf.bg.ac.rs','gavrAna1234'),
('hadzic.filip','Филип','Хаџић','hadzic.filip@etf.bg.ac.rs','hdzFilip'),
('prodekanzanastavu', 'Предраг', 'Иваниш', 'prodekanzanastavu@etf.bg.ac.rs', 'prodekan1234'),
('dekanat','Мило','Томашевић','dekanat@etf.bg.ac.rs','dekanat1234'),
('prodekanzanauku','Златан','Стојковић','prodekanzanauku@etf.bg.ac.rs','prodekan1234');

-- --------------------------------------------------------

--
-- Table structure for table `masterrad`
--

DROP TABLE IF EXISTS `masterrad`;
CREATE TABLE IF NOT EXISTS `masterrad` (
  `IdRad` int(11) NOT NULL AUTO_INCREMENT,
  `NazivS` varchar(100) CHARACTER SET cp1251 NOT NULL,
  `NazivE` varchar(100) NOT NULL,
  `Predmet` varchar(1000),
  `Sadrzaj` varchar(1000),
  PRIMARY KEY (`IdRad`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `mentor`
--

DROP TABLE IF EXISTS `mentor`;
CREATE TABLE IF NOT EXISTS `mentor` (
  `Username` varchar(32) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mentor`
--

INSERT INTO `mentor` (`Username`) VALUES
('zaki'),
('certic'),
('kstankovic'),
('sosic'),
('nenad'),
('dragan84m'),
('zoran.cica'),
('mnikolic'),
('varsovski'),
('tatjana.lutovac'),
('ptadic'),
('bojic'),
('mbojovic'),
('cmilos'),
('stojsasa'),
('pavle.vuletic'),
('tartalja'),
('nbosko'),
('mvt'),
('jeca'),
('dmilicev'),
('marko.misic'),
('anaga777'),
('zarko');

-- --------------------------------------------------------

--
-- Table structure for table `modul`
--

DROP TABLE IF EXISTS `modul`;
CREATE TABLE IF NOT EXISTS `modul` (
  `IdModul` int(11) NOT NULL,
  `Naziv` varchar(50) CHARACTER SET cp1251 NOT NULL,
  PRIMARY KEY (`IdModul`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `modul`
--

INSERT INTO `modul` (`IdModul`, `Naziv`) VALUES
(1, 'Аудио и видео технологије'),
(2, 'Биомедицински и еколошки инжењеринг'),
(3, 'Електроенергетски системи'),
(4, 'Електроника и дигитални системи'),
(5, 'Енергетска ефикасност'),
(6, 'Информационо комуникационе технологије'),
(7, 'Микроталасна техника'),
(8, 'Наноелектроника и фотоника'),
(9, 'Општеобразовни предмети'),
(10, 'Примењена математика'),
(11, 'Рачунарска техника и информатика'),
(12, 'Сигнали и системи'),
(13, 'Софтверско инжењерство');

-- --------------------------------------------------------

--
-- Table structure for table `pozicija`
--

DROP TABLE IF EXISTS `pozicija`;
CREATE TABLE IF NOT EXISTS `pozicija` (
  `IdPoz` int(11) NOT NULL,
  `Pozicija` varchar(32) NOT NULL,
  PRIMARY KEY (`IdPoz`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pozicija`
--

INSERT INTO `pozicija` (`IdPoz`, `Pozicija`) VALUES
(1, 'dekan'),
(2, 'prodekan'),
(3, 'predsednik K2 komisije');

-- --------------------------------------------------------

--
-- Table structure for table `predaje`
--

DROP TABLE IF EXISTS `predaje`;
CREATE TABLE IF NOT EXISTS `predaje` (
  `IdPredaje` int(11) NOT NULL AUTO_INCREMENT,
  `IdMentor` varchar(32) NOT NULL,
  `IdStudent` varchar(32) NOT NULL,
  `IdPredmet` int(11) NOT NULL,
  PRIMARY KEY (`IdPredaje`),
  KEY `predaje_fk_1` (`IdMentor`),
  KEY `predaje_fk_2` (`IdStudent`),
  KEY `predaje_fk_3` (`IdPredmet`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


INSERT INTO `predaje` (`IdPredaje`, `IdMentor`, `IdStudent`, `IdPredmet`) VALUES
(1,'zarko','vs150429d',36),
(2,'bojic','vs150429d',35),
(3,'tartalja','vs150429d',42),
(4,'nbosko','vs150429d',37),
(5,'anaga777','vs150429d',44),
(6,'zarko','lp150463d',36),
(7,'bojic','lp150463d',35),
(8,'zaki','lp150463d',69),
(9,'nbosko','lp150463d',37),
(10,'anaga777','lp150463d',44),
(11,'zaki','va150098d', 68),
(12,'bojic','va150098d', 60),
(13,'bojic','va150098d', 57),
(14,'cmilos','va150098d', 61),
(15,'nbosko','va150098d', 67);

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

DROP TABLE IF EXISTS `predmet`;
CREATE TABLE IF NOT EXISTS `predmet` (
  `IdPredmet` int(11) NOT NULL AUTO_INCREMENT,
  `IdModul` int(11) NOT NULL,
  `Naziv` varchar(100) CHARACTER SET cp1251 NOT NULL,
  `ESBP` int(11) NOT NULL DEFAULT '6',
  `Sifra` varchar(10) CHARACTER SET cp1251 NOT NULL,
  PRIMARY KEY (`IdPredmet`),
  KEY `predmet_fk_1` (`IdModul`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `predmet`
--

INSERT INTO `predmet` (`IdPredmet`, `IdModul`, `Naziv`, `ESBP`, `Sifra`) VALUES
(1, 1, 'Снимање и обрада звука', 6, '13М031СОЗ'),
(2, 1, 'Акустични дизајн просторија и звучна заштита', 6, '19М031АДП'),
(3, 1, 'Статистичка теорија телекомуникација', 6, '13М031СТТ'),
(4, 1, 'Персонализоване апликације', 6, '19М031ПА'),
(5, 1, 'Форензика видео сигнала', 6, '13М031ФВС'),
(6, 1, 'Анализа и синтеза музичких сигнала', 6, '13M031АСМ'),
(7, 1, 'Оптоелектронски телекомуникациони подсистеми', 6, '19M061ОТП'),
(8, 1, 'Интерактивни видео сервиси', 6, '19M034ВС'),
(9, 1, 'Савремени системи за обраду слике', 6, '19М033СОС'),
(10, 1, 'Архитектура IoT мрежа', 6, '13М034ИoТ'),
(11, 1, 'Итеративни алгоритми за динамичку оптимизацију', 6, '19М034АДО'),
(12, 1, 'Савремене технологије у аудио системима', 6, '19M031СТА'),
(13, 1, 'Комуникација човек-рачунар', 6, '13М031КЧР'),
(14, 1, 'Обрада аудио сигнала', 6, '13М031ОАС'),
(15, 1, 'Мултимедијални системи', 6, '19M031ММС'),
(16, 1, 'Информационо комуникационе технологије у телемедицини', 6, '19M031ИКТ'),
(17, 1, 'Системи са више брзина', 6, '13М031СВБ'),
(18, 1, 'Јавне мобилне мреже', 6, '13М034ЈМС'),
(19, 1, 'Напредно програмирање комуникационог хардвера', 6, '13М034ПКХ'),
(20, 1, 'Позиционирање у мобилним мрежама', 6, '13М034ППР'),
(21, 1, 'Симулација телекомуникационих мрежа', 6, '13М034МИСТ'),
(22, 1, 'Архитектура савременог интернета', 6, '19М034АИ'),
(23, 1, 'Алати за интернет програмирање', 6, '19М034ИП'),
(24, 1, 'Развој сервиса за мобилне мреже', 6, '13М034РМС'),
(25, 11, 'Системи отпорни на отказе', 6, '13М111СОН'),
(26, 11, 'Рачунарство у био-медицини', 6, '13М111РБМ'),
(27, 11, 'Програмирање уграђених система', 6, '13М111ПУС'),
(28, 11, 'Заштита рачунарских система и мрежа', 6, '13М111ЗРМ'),
(29, 11, 'Моделовање и пројектовање софтвера', 6, '13M114ПС'),
(30, 11, 'Интелигентни сервиси и системи', 6, '13М114ИС'),
(31, 11, 'Одабрана поглавља из рачунарских мрежа', 6, '13М114РМ2'),
(32, 11, 'Социолошки и професионални аспекти рачунарства', 6, '13М111СИП'),
(33, 11, 'Програмирање у реалном времену', 6, '13М111ПРВ'),
(34, 11, 'Пројектовање рачунарских мрежа', 6, '13М111ПРМ'),
(35, 11, 'Програмски преводиоци 2', 6, '13М111ПП2'),
(36, 11, 'Геномска информатика', 6, '13М111ГИ'),
(37, 11, 'Проналажење скривеног знања', 6, '13М111ПСЗ'),
(38, 11, 'Примењено паралално програмирање', 6, '13М114МУПС'),
(39, 11, 'Алати за програмирање база података', 6, '13М114САБ'),
(40, 11, 'Пројектовање информационих система 1', 6, '13М114ИС1'),
(41, 11, 'Паралелизам у архитектури рачунара и програмским преводиоцима', 6, '13М114ПАР'),
(42, 11, 'Интерактивна рачунарска графика', 6, '13М114РГ'),
(43, 11, 'Напредне архитектуре и организације рачунара', 6, '13М113АОР2'),
(44, 11, 'Мултимедијални системи', 6, '19M031ММС'),
(45, 13, 'Програмирање корисничких интерфејса', 6, '13М111ПКИ'),
(46, 13, 'Теорија алгоритама', 6, '13М111ТА'),
(47, 13, 'Управљање електронским садржајима', 6, '13М111УЕС'),
(48, 13, 'Софтверско инжењерство великих база података',6,'13М111СИБП'),
(49, 13, 'Рачунарска графика 2', 6, '13М111РГ2'),
(50, 13, 'Анализа социјалних мрежа', 6, '13М111АСМ'),
(51, 13, 'Оперативни системи 2', 6, '13E113ОС2'),
(52, 13, 'Рачунарски VLSI системи', 6, '13E114ВЛСИ'),
(53, 13, 'Пројектовање софтвера', 6, '13E114ПС'),
(54, 13, 'Рачунарске мреже 2', 6, '13E114РМ2'),
(55, 13, 'Интелигентни системи', 6, '13E114ИС'),
(56, 13, 'Социолошки и професионални аспекти рачунарства', 6, '13М111СИП'),
(57, 13, 'Еволуција софтвера', 6, '13М111ЕС'),
(58, 13, 'Програмирање у реалном времену', 6, '13М111ПРВ'),
(59, 13, 'Mултимедијални системи', 6, '13E034ММС'),
(60, 13, 'Програмски преводиоци 2', 6, '13М111ПП2'),
(61, 13, 'Информациони системи 2', 6, '13М111ИС2'),
(62, 13, 'Функционално програмирање', 6, '13М111ФП'),
(63, 13, 'Обрада природних језика', 6, '13M111ОПЈ'),
(64, 13, 'Развој безбедног софтвера', 6, '13М111РБС'),
(65, 13, 'Базе података 2', 6, '13E114БП2'),
(66, 13, 'Рачунарска графика', 6, '13E114РГ'),
(67, 13, 'Програмирање Интернет апликација', 6, '13E113ПИА'),
(68, 13, 'Паралелни рачунарски системи', 6, '13Е114ПАР'),
(69, 11, 'Паралелни рачунарски системи', 6, '13Е114ПАР');

-- --------------------------------------------------------

--
-- Table structure for table `prijava`
--

DROP TABLE IF EXISTS `prijava`;
CREATE TABLE IF NOT EXISTS `prijava` (
  `IdPrijava` int(11) NOT NULL AUTO_INCREMENT,
  `IdStudent` varchar(32) NOT NULL,
  `IdMentor` varchar(32) NOT NULL,
  `IdMentorZ` varchar(32),
  `IdRukovodilac` varchar(32) NOT NULL,
  `IdRad` int(11) NOT NULL,
  `IdPredmet` int(11),
  `RukIliProf` int(11) NOT NULL,
  `Biografija` varchar(2000) CHARACTER SET cp1251,
  `IdRukRada` varchar(32) DEFAULT NULL,
  `IdKom1` varchar(32) DEFAULT NULL,
  `IdKom2` varchar(32) DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  `Prihvata` int(11),
  `Sugestija` varchar(2000) CHARACTER SET cp1251,
  `DatumS` date DEFAULT NULL,
  `PredsednikKomisije` varchar(50) CHARACTER SET cp1251,
  `ImaGreske` int(11) NOT NULL,
  `Prijavljena` int(11) NOT NULL,
  PRIMARY KEY (`IdPrijava`),
  KEY `prijava_fk_1` (`IdStudent`),
  KEY `prijava_fk_2` (`IdMentor`),
  KEY `prijava_fk_3` (`IdRad`),
  KEY `prijava_fk_4` (`IdPredmet`),
  KEY `prijava_fk_5` (`IdMentorZ`),
  KEY `prijava_fk_6` (`IdRukovodilac`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `komentari_st_ment`
--

DROP TABLE IF EXISTS `komentari_st_ment`;
CREATE TABLE IF NOT EXISTS `komentari_st_ment` (
  `IdKomentar` int(11) NOT NULL AUTO_INCREMENT,
  `IdPrijava` int(11) NOT NULL,
  `IdStudent` varchar(32) NOT NULL,
  `IdMentor` varchar(32) NOT NULL,
  `Komentar` varchar(100) CHARACTER SET cp1251,
  PRIMARY KEY (`IdKomentar`),
  KEY `komentari_st_ment_fk_1` (`IdPrijava`),
  KEY `komentari_st_ment_fk_2` (`IdStudent`),
  KEY `komentari_st_ment_fk_3` (`IdMentor`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rukovodilac_modula`
--

DROP TABLE IF EXISTS `rukovodilac_modula`;
CREATE TABLE IF NOT EXISTS `rukovodilac_modula` (
  `Username` varchar(32) NOT NULL,
  `UsernameZ` varchar(32) DEFAULT NULL,
  `IdModul` int(11) NOT NULL,
  `Sprecen` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Username`),
  KEY `rukovodilac_modula_fk_2` (`UsernameZ`),
  KEY `rukovodilac_modula_fk_3` (`IdModul`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rukovodilac_modula`
--

INSERT INTO `rukovodilac_modula` (`Username`, `UsernameZ`, `IdModul`, `Sprecen`) VALUES
('zaki', NULL, 11, 0),
('certic', NULL, 1, 0),
('kstankovic', NULL, 2, 0),
('sosic', NULL, 3, 0),
('nenad', NULL, 4, 0),
('dragan84m', NULL, 5, 0),
('zoran.cica', NULL, 6, 0),
('mnikolic', NULL, 7, 0),
('varsovski', NULL, 8, 0),
('tatjana.lutovac', NULL, 10, 0),
('ptadic', NULL, 12, 0),
('bojic', NULL, 13, 0);


-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `Username` varchar(32) NOT NULL,
  `IdModul` int(11) NOT NULL,
  PRIMARY KEY (`Username`),
  KEY `student_fk_2` (`IdModul`),
  KEY `student_fk_1` (`Username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Username`, `IdModul`) VALUES
('vs150429d', 11),
('lp150463d', 11),
('va150098d', 13),
('mj150345d', 1);

-- --------------------------------------------------------

--
-- Table structure for table `studentska_sluzba`
--

DROP TABLE IF EXISTS `studentska_sluzba`;
CREATE TABLE IF NOT EXISTS `studentska_sluzba` (
  `Username` varchar(32) NOT NULL,
  `Telefon1` varchar(32) NOT NULL,
  `Telefon2` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`Username`),
  KEY `studentska_sluzba_fk_1` (`Username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `studentska_sluzba`
--

INSERT INTO `studentska_sluzba` (`Username`, `Telefon1`, `Telefon2`) VALUES
('stud_sluzba', '(011) 3226-760', '(011) 3218-421'),
('milanka', '(011) 3218-492', NULL),
('suncica', '(011) 3218-417', NULL),
('desanka', '(011) 3218-419', NULL),
('dmilena', '(011) 3218-420', NULL),
('marinad', '(011) 3218-424', NULL),
('jelenav', '(011) 3218-418', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `uprava`
--

DROP TABLE IF EXISTS `uprava`;
CREATE TABLE IF NOT EXISTS `uprava` (
  `Username` varchar(32) NOT NULL,
  `IdPoz` int(11) NOT NULL,
  PRIMARY KEY (`Username`),
  KEY `uprava_fk_1` (`Username`),
  KEY `uprava_fk_2` (`IdPoz`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `uprava`
--

INSERT INTO `uprava` (`Username`, `IdPoz`) VALUES 
('dekanat', 1),
('prodekanzanastavu', 2),
('prodekanzanauku', 2);
-- --------------------------------------------------------

--
-- Table structure for table `sastanak`
--

DROP TABLE IF EXISTS `sastanak`;
CREATE TABLE IF NOT EXISTS `sastanak` (
  `IdSastanak` int(11) NOT NULL AUTO_INCREMENT,
  `IdSluzba` varchar(32) NOT NULL,
  `IdUprava1` varchar(32) NOT NULL,
  `IdUprava2` varchar(32) NOT NULL,
  `IdPrijava` int(11) NOT NULL,
  `Datum` date not null,
  `Odrzan` int(11) not null,
  PRIMARY KEY (`IdSastanak`),
  KEY `sastanak_fk_1` (`IdSluzba`),
  KEY `sastanak_fk_2` (`IdUprava1`),
  KEY `sastanak_fk_3` (`IdUprava2`),
  KEY `sastanak_fk_4` (`IdPrijava`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------



--
-- Table structure for table `zamenik`
--

DROP TABLE IF EXISTS `zamenik`;
CREATE TABLE IF NOT EXISTS `zamenik` (
  `Username` varchar(32) NOT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


INSERT INTO `zamenik` (`Username`) VALUES 
('stojsasa'),
('marko.misic');

-- --------------------------------------------------------

--
-- Table structure for table `mentToRuk`
--

DROP TABLE IF EXISTS `mentToRuk`;
CREATE TABLE IF NOT EXISTS `mentToRuk` (
  `IdMentToRuk` int(11) NOT NULL AUTO_INCREMENT,
  `IdPrijava` int(11) NOT NULL,
  `IdMentor` varchar(32) NOT NULL,
  `IdRuk` varchar(32) NOT NULL,
  `Status` int(11),
  PRIMARY KEY (`IdMentToRuk`),
  KEY `mentToRuk_fk_1` (`IdPrijava`),
  KEY `mentToRuk_fk_2` (`IdMentor`),
  KEY `mentToRuk_fk_3` (`IdRuk`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- --------------------------------------------------------
--
-- Table structure for table `mentToZam`
--

DROP TABLE IF EXISTS `mentToZam`;
CREATE TABLE IF NOT EXISTS `mentToZam` (
  `IdMentToZam` int(11) NOT NULL AUTO_INCREMENT,
  `IdPrijava` int(11) NOT NULL,
  `IdMentor` varchar(32) NOT NULL,
  `IdZam` varchar(32) NOT NULL,
  `Status` int(11),
  PRIMARY KEY (`IdMentToZam`),
  KEY `mentToZam_fk_1` (`IdPrijava`),
  KEY `mentToZam_fk_2` (`IdMentor`),
  KEY `mentToZam_fk_3` (`IdZam`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- --------------------------------------------------------
--
-- Table structure for table komentari_ment_ruk`
--

DROP TABLE IF EXISTS `komentari_ment_ruk`;
CREATE TABLE IF NOT EXISTS `komentari_ment_ruk` (
  `IdKom` int(11) NOT NULL AUTO_INCREMENT,
  `IdMentToRuk` int(11) NOT NULL,
  `Komentar` varchar(100) CHARACTER SET cp1251,
  PRIMARY KEY (`IdKom`),
  KEY `komentari_ment_ruk_fk_1` (`IdMentToRuk`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- --------------------------------------------------------
--
-- Table structure for table komentari_ment_zam`
--

DROP TABLE IF EXISTS `komentari_ment_zam`;
CREATE TABLE IF NOT EXISTS `komentari_ment_zam` (
  `IdKom` int(11) NOT NULL AUTO_INCREMENT,
  `IdMentToZam` int(11) NOT NULL,
  `Komentar` varchar(100) CHARACTER SET cp1251,
  PRIMARY KEY (`IdKom`),
  KEY `komentari_ment_zam_fk_1` (`IdMentToZam`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- --------------------------------------------------------

--
-- Table structure for table `rukToSluzba`
--

DROP TABLE IF EXISTS `rukToSluzba`;
CREATE TABLE IF NOT EXISTS `rukToSluzba` (
  `IdRukToSluzba` int(11) NOT NULL AUTO_INCREMENT,
  `IdMentToRuk` int(11) NOT NULL,
  `IdRuk` varchar(32) NOT NULL,
  `IdSluzba` varchar(32) NOT NULL,
  `Status` int(11),
  PRIMARY KEY (`IdRukToSluzba`),
  KEY `rukToSluzba_fk_1` (`IdMentToRuk`),
  KEY `rukToSluzba_fk_2` (`IdRuk`),
  KEY `rukToSluzba_fk_3` (`IdSluzba`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `zamToSluzba`
--

DROP TABLE IF EXISTS `zamToSluzba`;
CREATE TABLE IF NOT EXISTS `zamToSluzba` (
  `IdZamToSluzba` int(11) NOT NULL AUTO_INCREMENT,
  `IdMentToZam` int(11) NOT NULL,
  `IdZam` varchar(32) NOT NULL,
  `IdSluzba` varchar(32) NOT NULL,
  `Status` int(11),
  PRIMARY KEY (`IdZamToSluzba`),
  KEY `zamToSluzba_fk_1` (`IdMentToZam`),
  KEY `zamToSluzba_fk_2` (`IdZam`),
  KEY `zamToSluzba_fk_3` (`IdSluzba`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- --------------------------------------------------------
--
-- Table structure for table komentari_sluzba_mentor`
--

DROP TABLE IF EXISTS `komentari_sluzba_mentor`;
CREATE TABLE IF NOT EXISTS `komentari_sluzba_mentor` (
  `IdKom` int(11) NOT NULL AUTO_INCREMENT,
  `IdRukToSluzba` int(11),
  `IdZamToSluzba` int(11),
  `IdMentor` varchar(32) NOT NULL,
  `Komentar` varchar(100) CHARACTER SET cp1251,
  PRIMARY KEY (`IdKom`),
  KEY `komentari_sluzba_mentor_fk_1` (`IdRukToSluzba`),
  KEY `komentari_sluzba_mentor_fk_2` (`IdMentor`),
  KEY `komentari_sluzba_mentor_fk_3` (`IdZamToSluzba`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- --------------------------------------------------------
--
-- Table structure for table komentari_sluzba_zamenik`
--

DROP TABLE IF EXISTS `komentari_sluzba_zamenik`;
CREATE TABLE IF NOT EXISTS `komentari_sluzba_zamenik` (
  `IdKom` int(11) NOT NULL AUTO_INCREMENT,
  `IdZamToSluzba` int(11) NOT NULL,
  `IdMentor` varchar(32) NOT NULL,
  `Komentar` varchar(100) CHARACTER SET cp1251,
  PRIMARY KEY (`IdKom`),
  KEY `komentari_sluzba_zamenik_fk_1` (`IdZamToSluzba`),
  KEY `komentari_sluzba_zamenik_fk_2` (`IdMentor`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
--
-- Table structure for table komentari_sluzba_student`
--

DROP TABLE IF EXISTS `komentari_sluzba_student`;
CREATE TABLE IF NOT EXISTS `komentari_sluzba_student` (
  `IdKom` int(11) NOT NULL AUTO_INCREMENT,
  `IdRukToSluzba` int(11) NOT NULL,
  `IdStudent` varchar(32) NOT NULL,
  `Komentar` varchar(100) CHARACTER SET cp1251,
  PRIMARY KEY (`IdKom`),
  KEY `komentari_sluzba_student_fk_1` (`IdRukToSluzba`),
  KEY `komentari_sluzba_student_fk_2` (`IdStudent`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------
--
-- Table structure for table komentari_sluzba_studentZ`
--

DROP TABLE IF EXISTS `komentari_sluzba_studentZ`;
CREATE TABLE IF NOT EXISTS `komentari_sluzba_studentZ` (
  `IdKom` int(11) NOT NULL AUTO_INCREMENT,
  `IdZamToSluzba` int(11) NOT NULL,
  `IdStudent` varchar(32) NOT NULL,
  `Komentar` varchar(100) CHARACTER SET cp1251,
  PRIMARY KEY (`IdKom`),
  KEY `komentari_sluzba_studentZ_fk_1` (`IdZamToSluzba`),
  KEY `komentari_sluzba_studentZ_fk_2` (`IdStudent`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- --------------------------------------------------------
--
-- Table structure for table verzija_prijave`
--

DROP TABLE IF EXISTS `verzija_prijave`;
CREATE TABLE IF NOT EXISTS `verzija_prijave` (
  `IdVer` int(11) NOT NULL AUTO_INCREMENT,
  `IdPrijava` int(11) NOT NULL,
  `DatumVer` date NOT NULL,
  `VremeVer` time(0) NOT NULL,
  `IdStudent` varchar(32) NOT NULL,
  `IdMentor` varchar(32) NOT NULL,
  `IdMentorZ` varchar(32),
  `IdRukovodilac` varchar(32) NOT NULL,
  `IdRad` int(11) NOT NULL,
  `NazivS` varchar(100) CHARACTER SET cp1251 NOT NULL,
  `NazivE` varchar(100) NOT NULL,
  `Predmet` varchar(1000),
  `Sadrzaj` varchar(1000),
  `IdPredmet` int(11),
  `RukIliProf` int(11) NOT NULL,
  `Biografija` varchar(2000) CHARACTER SET cp1251,
  `IdRukRada` varchar(32) DEFAULT NULL,
  `IdKom1` varchar(32) DEFAULT NULL,
  `IdKom2` varchar(32) DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  `Prihvata` int(11),
  `Sugestija` varchar(2000) CHARACTER SET cp1251,
  `DatumS` date DEFAULT NULL,
  `PredsednikKomisije` varchar(50) CHARACTER SET cp1251,
  PRIMARY KEY (`IdVer`),
  KEY `verzija_prijave_fk_1` (`IdPrijava`),
  KEY `verzija_prijave_fk_2` (`IdMentor`),
  KEY `verzija_prijave_fk_3` (`IdStudent`),
  KEY `verzija_prijave_fk_4` (`IdRad`),
  KEY `verzija_prijave_fk_5` (`IdPredmet`),
  KEY `verzija_prijave_fk_6` (`IdMentorZ`),
  KEY `verzija_prijave_fk_7` (`IdRukovodilac`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- --------------------------------------------------------

--
-- Constraints for table `verzija_prijave`
--
ALTER TABLE `verzija_prijave`
  ADD CONSTRAINT `verzija_prijave_fk_1` FOREIGN KEY (`IdPrijava`) REFERENCES `prijava` (`IdPrijava`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `verzija_prijave_fk_2` FOREIGN KEY (`IdMentor`) REFERENCES `mentor` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `verzija_prijave_fk_3` FOREIGN KEY (`IdStudent`) REFERENCES `student` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `verzija_prijave_fk_4` FOREIGN KEY (`IdRad`) REFERENCES `masterrad` (`IdRad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `verzija_prijave_fk_5` FOREIGN KEY (`IdPredmet`) REFERENCES `predmet` (`IdPredmet`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `verzija_prijave_fk_6` FOREIGN KEY (`IdMentorZ`) REFERENCES `zamenik` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `verzija_prijave_fk_7` FOREIGN KEY (`IdRukovodilac`) REFERENCES `rukovodilac_modula` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE; 


--
-- Constraints for table `sastanak`
--
ALTER TABLE `sastanak`
  ADD CONSTRAINT `sastanak_fk_1` FOREIGN KEY (`IdSluzba`) REFERENCES `studentska_sluzba` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sastanak_fk_2` FOREIGN KEY (`IdUprava1`) REFERENCES `uprava` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sastanak_fk_3` FOREIGN KEY (`IdUprava2`) REFERENCES `uprava` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sastanak_fk_4` FOREIGN KEY (`IdPrijava`) REFERENCES `prijava` (`IdPrijava`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `mentToRuk`
--
ALTER TABLE `mentToRuk`
  ADD CONSTRAINT `mentToRuk_fk_1` FOREIGN KEY (`IdPrijava`) REFERENCES `prijava` (`IdPrijava`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mentToRuk_fk_2` FOREIGN KEY (`IdMentor`) REFERENCES `mentor` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mentToRuk_fk_3` FOREIGN KEY (`IdRuk`) REFERENCES `rukovodilac_modula` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `mentToZam`
--
ALTER TABLE `mentToZam`
  ADD CONSTRAINT `mentToZam_fk_1` FOREIGN KEY (`IdPrijava`) REFERENCES `prijava` (`IdPrijava`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mentToZam_fk_2` FOREIGN KEY (`IdMentor`) REFERENCES `mentor` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `mentToZam_fk_3` FOREIGN KEY (`IdZam`) REFERENCES `zamenik` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `komentari_ment_ruk`
--
ALTER TABLE `komentari_ment_ruk`
  ADD CONSTRAINT `komentari_ment_ruk_fk_1` FOREIGN KEY (`IdMentToRuk`) REFERENCES `mentToRuk` (`IdMentToRuk`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `komentari_ment_zam`
--
ALTER TABLE `komentari_ment_zam`
  ADD CONSTRAINT `komentari_ment_zam_fk_1` FOREIGN KEY (`IdMentToZam`) REFERENCES `mentToZam` (`IdMentToZam`) ON DELETE CASCADE ON UPDATE CASCADE;


-- Constraints for table `komentari_sluzba_mentor`
--
ALTER TABLE `komentari_sluzba_mentor`
  ADD CONSTRAINT `komentari_sluzba_mentor_fk_1` FOREIGN KEY (`IdRukToSluzba`) REFERENCES `rukToSluzba` (`IdRukToSluzba`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `komentari_sluzba_mentor_fk_2` FOREIGN KEY (`IdMentor`) REFERENCES `mentor` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `komentari_sluzba_mentor_fk_3` FOREIGN KEY (`IdZamToSluzba`) REFERENCES `zamToSluzba` (`IdZamToSluzba`) ON DELETE CASCADE ON UPDATE CASCADE;


-- Constraints for table `komentari_sluzba_zamenik`
--
ALTER TABLE `komentari_sluzba_zamenik`
  ADD CONSTRAINT `komentari_sluzba_zamenik_fk_1` FOREIGN KEY (`IdZamToSluzba`) REFERENCES `zamToSluzba` (`IdZamToSluzba`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `komentari_sluzba_zamenik_fk_2` FOREIGN KEY (`IdMentor`) REFERENCES `mentor` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;


-- Constraints for table `komentari_sluzba_student`
--
ALTER TABLE `komentari_sluzba_student`
  ADD CONSTRAINT `komentari_sluzba_student_fk_1` FOREIGN KEY (`IdRukToSluzba`) REFERENCES `rukToSluzba` (`IdRukToSluzba`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `komentari_sluzba_student_fk_2` FOREIGN KEY (`IdStudent`) REFERENCES `student` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;

-- Constraints for table `komentari_sluzba_studentZ`
--
ALTER TABLE `komentari_sluzba_studentZ`
  ADD CONSTRAINT `komentari_sluzba_studentZ_fk_1` FOREIGN KEY (`IdZamToSluzba`) REFERENCES `zamToSluzba` (`IdZamToSluzba`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `komentari_sluzba_studentZ_fk_2` FOREIGN KEY (`IdStudent`) REFERENCES `student` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Constraints for table `rukToSluzba`
--
ALTER TABLE `rukToSluzba`
  ADD CONSTRAINT `rukToSluzba_fk_1` FOREIGN KEY (`IdMentToRuk`) REFERENCES `mentToRuk` (`IdMentToRuk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rukToSluzba_fk_2` FOREIGN KEY (`IdRuk`) REFERENCES `rukovodilac_modula` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rukToSluzba_fk_3` FOREIGN KEY (`IdSluzba`) REFERENCES `studentska_sluzba` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;


--
-- Constraints for table `zamToSluzba`
--
ALTER TABLE `zamToSluzba`
  ADD CONSTRAINT `zamToSluzba_fk_1` FOREIGN KEY (`IdMentToZam`) REFERENCES `mentToZam` (`IdMentToZam`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `zamToSluzba_fk_2` FOREIGN KEY (`IdZam`) REFERENCES `zamenik` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `zamToSluzba_fk_3` FOREIGN KEY (`IdSluzba`) REFERENCES `studentska_sluzba` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `predaje`
--
ALTER TABLE `predaje`
  ADD CONSTRAINT `predaje_fk_1` FOREIGN KEY (`IdMentor`) REFERENCES `mentor` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `predaje_fk_2` FOREIGN KEY (`IdStudent`) REFERENCES `student` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `predaje_fk_3` FOREIGN KEY (`IdPredmet`) REFERENCES `predmet` (`IdPredmet`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `predmet`
--
ALTER TABLE `predmet`
  ADD CONSTRAINT `predmet_fk_1` FOREIGN KEY (`IdModul`) REFERENCES `modul` (`IdModul`) ON DELETE CASCADE ON UPDATE CASCADE;
  
--
-- Constraints for table `prijava`
--  
ALTER TABLE `prijava`
  ADD CONSTRAINT `prijava_fk_2` FOREIGN KEY (`IdMentor`) REFERENCES `mentor` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prijava_fk_1` FOREIGN KEY (`IdStudent`) REFERENCES `student` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prijava_fk_3` FOREIGN KEY (`IdRad`) REFERENCES `masterrad` (`IdRad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prijava_fk_4` FOREIGN KEY (`IdPredmet`) REFERENCES `predmet` (`IdPredmet`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prijava_fk_5` FOREIGN KEY (`IdMentorZ`) REFERENCES `zamenik` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prijava_fk_6` FOREIGN KEY (`IdRukovodilac`) REFERENCES `rukovodilac_modula` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;
  
 
--
-- Constraints for table `rukovodilac_modula`
--   
 
ALTER TABLE `rukovodilac_modula`
  ADD CONSTRAINT `rukovodilac_modula_fk_1` FOREIGN KEY (`Username`) REFERENCES `korisnik` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rukovodilac_modula_fk_2` FOREIGN KEY (`UsernameZ`) REFERENCES `zamenik` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rukovodilac_modula_fk_3` FOREIGN KEY (`IdModul`) REFERENCES `modul` (`IdModul`) ON DELETE CASCADE ON UPDATE CASCADE; 
  
 
--
-- Constraints for table `student`
--    
  
ALTER TABLE `student`
  ADD CONSTRAINT `student_fk_1` FOREIGN KEY (`Username`) REFERENCES `korisnik` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `student_fk_2` FOREIGN KEY (`IdModul`) REFERENCES `modul` (`IdModul`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `komentari_st_ment`
--    
  
ALTER TABLE `komentari_st_ment`
  ADD CONSTRAINT `komentari_st_ment_fk_1` FOREIGN KEY (`IdPrijava`) REFERENCES `prijava` (`IdPrijava`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `komentari_st_ment_fk_2` FOREIGN KEY (`IdStudent`) REFERENCES `student` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `komentari_st_ment_fk_3` FOREIGN KEY (`IdMentor`) REFERENCES `mentor` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `studentska_sluzba`
--    

ALTER TABLE `studentska_sluzba`
  ADD CONSTRAINT `studentska_sluzba_fk_1` FOREIGN KEY (`Username`) REFERENCES `korisnik` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `uprava`
--    
ALTER TABLE `uprava`
  ADD CONSTRAINT `uprava_fk_1` FOREIGN KEY (`Username`) REFERENCES `korisnik` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE,
    ADD CONSTRAINT `uprava_fk_2` FOREIGN KEY (`IdPoz`) REFERENCES `pozicija` (`IdPoz`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `zamenik`
--    

ALTER TABLE `zamenik`
  ADD CONSTRAINT `zamenik_fk_1` FOREIGN KEY (`Username`) REFERENCES `korisnik` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;
  
--
-- Constraints for table `mentor`
--
ALTER TABLE `mentor`
  ADD CONSTRAINT `mentor_fk_1` FOREIGN KEY (`Username`) REFERENCES `korisnik` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;
    
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
