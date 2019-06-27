-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 26, 2019 at 10:33 PM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `lms`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
	`id` int(10) NOT NULL,
	`callno` varchar(100) NOT NULL,
	`name` varchar(100) NOT NULL,
	`author` varchar(100) NOT NULL,
	`publisher` varchar(100) NOT NULL,
	`quantity` int(10) NOT NULL,
	`issued` int(10) DEFAULT NULL,
	`added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`status` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `callno`, `name`, `author`, `publisher`, `quantity`, `issued`, `added_date`, `status`) VALUES
(1, '3', 'C In Depth', 'Shrivastav', 'BPB', 2, 2, '2019-06-20 20:19:13', NULL),
(2, '2', 'DBMS', 'Korth', 'Pearson', 3, 0, '2019-06-20 20:19:09', NULL),
(3, '1', 'Let\'s see', 'Yashwant Kanetkar', 'BPB', 10, 0, '2019-06-20 20:19:04', NULL),
(4, '4', 'book4', 'book4', 'book4', 5, NULL, '2019-06-26 05:02:57', NULL),
(5, '5', 'book5', 'book5', 'book5', 5, NULL, '2019-06-26 05:03:15', NULL),
(6, '6', 'book7', 'book7', 'book7', 6, NULL, '2019-06-26 05:03:30', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `borrow`
--

CREATE TABLE `borrow` (
	`idborrow` int(11) NOT NULL,
	`callno` varchar(45) DEFAULT NULL,
	`iduser` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `borrow`
--

INSERT INTO `borrow` (`idborrow`, `callno`, `iduser`) VALUES
(1, '3', '1');

-- --------------------------------------------------------

--
-- Table structure for table `carts`
--

CREATE TABLE `carts` (
	`idcarts` int(11) NOT NULL,
	`collno` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`idcarts`, `collno`) VALUES
(1, '1'),
(2, '2'),
(3, '4');

-- --------------------------------------------------------

--
-- Table structure for table `issuebooks`
--

CREATE TABLE `issuebooks` (
	`id` int(11) NOT NULL,
	`bookcallno` varchar(50) NOT NULL,
	`studentid` int(11) NOT NULL,
	`studentname` varchar(50) NOT NULL,
	`studentcontact` varchar(20) NOT NULL,
	`issueddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issuebooks`
--

INSERT INTO `issuebooks` (`id`, `bookcallno`, `studentid`, `studentname`, `studentcontact`, `issueddate`) VALUES
(4, 'A@4', 23, 'kk', '932992932', '2016-07-19 18:43:16'),
(6, 'A@4', 335, 'Sumedh', '95676565756', '2016-07-19 18:44:34'),
(7, 'A@4', 87, 'abhishek', '9329882382', '2016-07-19 18:46:12');

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
	`id` int(5) NOT NULL,
	`name` varchar(100) NOT NULL,
	`password` varchar(100) NOT NULL,
	`email` varchar(100) NOT NULL,
	`address` varchar(200) NOT NULL,
	`city` varchar(100) NOT NULL,
	`contact` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `librarian`
--

INSERT INTO `librarian` (`id`, `name`, `password`, `email`, `address`, `city`, `contact`) VALUES
(1, 'Prabhakar', 'ppp', 'prabhakar@gmail.com', 'javatpoint', 'noida', '9998328238'),
(4, 'sumedh', 'sumesh', 'sumesh@gmail.com', 'Kuch Bhi', 'noida', '93823932823'),
(7, '1', '1', '1', '1', '1', '1');

-- --------------------------------------------------------

--
-- Table structure for table `reserve`
--

CREATE TABLE `reserve` (
	`idrerserve` int(11) NOT NULL,
	`callno` varchar(45) DEFAULT NULL,
	`iduser` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reserve`
--

INSERT INTO `reserve` (`idrerserve`, `callno`, `iduser`) VALUES
(1, '2', '1'),
(2, '2', NULL),
(3, '5', NULL),
(5, '6', NULL),
(7, '5', NULL),
(8, '2', NULL),
(12, '5', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
	`iduser` int(11) NOT NULL,
	`username` varchar(45) DEFAULT NULL,
	`sex` varchar(45) DEFAULT NULL,
	`password` varchar(45) DEFAULT NULL,
	`email` varchar(45) DEFAULT NULL,
	`dateofbirth` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `username`, `sex`, `password`, `email`, `dateofbirth`) VALUES
(1, 'thong', 'M', 'mengthong123', 'mengthongoenggl@gmail.com', '02-01-1998');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
	ADD PRIMARY KEY (`id`),
	ADD UNIQUE KEY `callno` (`callno`),
	ADD UNIQUE KEY `callno_2` (`callno`);

--
-- Indexes for table `borrow`
--
ALTER TABLE `borrow`
	ADD PRIMARY KEY (`idborrow`);

--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
	ADD PRIMARY KEY (`idcarts`);

--
-- Indexes for table `issuebooks`
--
ALTER TABLE `issuebooks`
	ADD PRIMARY KEY (`id`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
	ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reserve`
--
ALTER TABLE `reserve`
	ADD PRIMARY KEY (`idrerserve`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
	ADD PRIMARY KEY (`iduser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
	MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `issuebooks`
--
ALTER TABLE `issuebooks`
	MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `librarian`
--
ALTER TABLE `librarian`
	MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `reserve`
--
ALTER TABLE `reserve`
	MODIFY `idrerserve` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
