-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2023 at 11:54 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `itp4511_db2c`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `name` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `phone` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`name`, `password`, `email`, `phone`) VALUES
('dog', '123', 'dog@123.com', '1234'),
('Mak', '123', 'mark@gmail.com', '999'),
('Pang', '123', 'mhp@gmail.com', '123');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookingId` int(11) NOT NULL,
  `venueId` int(1) NOT NULL,
  `date` varchar(25) NOT NULL,
  `startTime` varchar(25) NOT NULL,
  `memberEmail` varchar(40) DEFAULT NULL,
  `available` tinyint(1) NOT NULL,
  `isApproved` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bookingId`, `venueId`, `date`, `startTime`, `memberEmail`, `available`, `isApproved`) VALUES
(1, 1, '2023-05-25', '10:00 - 11:00', 'mhp@gmail.com', 0, 1),
(2, 1, '2023-05-25', '11:00 - 12:00', 'mhp@gmail.com', 0, 0),
(8, 1, '2023-05-25', '12:00 - 13:00', 'mhp@gmail.com', 0, 0),
(9, 1, '2023-05-25', '13:00 - 14:00', '', 1, 0),
(10, 1, '2023-05-25', '14:00 - 15:00', '', 1, 0),
(11, 1, '2023-05-25', '15:00 - 16:00', '', 1, 0),
(12, 1, '2023-05-25', '16:00 - 17:00', '', 1, 0),
(13, 1, '2023-05-25', '17:00 - 18:00', '', 1, 0),
(14, 1, '2023-05-25', '18:00 - 19:00', '', 1, 0),
(15, 1, '2023-05-25', '19:00 - 20:00', '', 1, 0),
(16, 1, '2023-05-25', '20:00 - 21:00', '', 1, 0),
(17, 1, '2023-05-25', '21:00 - 22:00', '', 1, 0),
(18, 2, '2023-05-25', '10:00 - 11:00', NULL, 1, 0),
(19, 2, '2023-05-25', '11:00 - 12:00', NULL, 1, 0),
(20, 2, '2023-05-25', '12:00 - 13:00', NULL, 1, 0),
(21, 2, '2023-05-25', '13:00 - 14:00', NULL, 1, 0),
(22, 2, '2023-05-25', '14:00 - 15:00', NULL, 1, 0),
(23, 2, '2023-05-25', '15:00 - 16:00', NULL, 1, 0),
(24, 2, '2023-05-25', '16:00 - 17:00', NULL, 1, 0),
(25, 2, '2023-05-25', '17:00 - 18:00', NULL, 1, 0),
(26, 2, '2023-05-25', '18:00 - 19:00', NULL, 1, 0),
(27, 2, '2023-05-25', '19:00 - 20:00', NULL, 1, 0),
(28, 2, '2023-05-25', '20:00 - 21:00', NULL, 1, 0),
(29, 2, '2023-05-25', '21:00 - 22:00', NULL, 1, 0),
(30, 3, '2023-05-25', '10:00 - 11:00', NULL, 1, 0),
(31, 3, '2023-05-25', '11:00 - 12:00', NULL, 1, 0),
(32, 3, '2023-05-25', '12:00 - 13:00', NULL, 1, 0),
(33, 3, '2023-05-25', '13:00 - 14:00', NULL, 1, 0),
(34, 3, '2023-05-25', '14:00 - 15:00', NULL, 1, 0),
(35, 3, '2023-05-25', '15:00 - 16:00', NULL, 1, 0),
(36, 3, '2023-05-25', '16:00 - 17:00', NULL, 1, 0),
(37, 3, '2023-05-25', '17:00 - 18:00', NULL, 1, 0),
(38, 3, '2023-05-25', '18:00 - 19:00', NULL, 1, 0),
(39, 3, '2023-05-25', '19:00 - 20:00', NULL, 1, 0),
(40, 3, '2023-05-25', '20:00 - 21:00', NULL, 1, 0),
(41, 3, '2023-05-25', '21:00 - 22:00', NULL, 1, 0),
(42, 4, '2023-05-25', '10:00 - 11:00', NULL, 1, 0),
(43, 4, '2023-05-25', '11:00 - 12:00', NULL, 1, 0),
(44, 4, '2023-05-25', '12:00 - 13:00', NULL, 1, 0),
(45, 4, '2023-05-25', '13:00 - 14:00', NULL, 1, 0),
(46, 4, '2023-05-25', '14:00 - 15:00', NULL, 1, 0),
(47, 4, '2023-05-25', '15:00 - 16:00', NULL, 1, 0),
(48, 4, '2023-05-25', '16:00 - 17:00', NULL, 1, 0),
(49, 4, '2023-05-25', '17:00 - 18:00', NULL, 1, 0),
(50, 4, '2023-05-25', '18:00 - 19:00', NULL, 1, 0),
(51, 4, '2023-05-25', '19:00 - 20:00', NULL, 1, 0),
(52, 4, '2023-05-25', '20:00 - 21:00', NULL, 1, 0),
(53, 4, '2023-05-25', '21:00 - 22:00', NULL, 1, 0),
(54, 5, '2023-05-25', '10:00 - 11:00', NULL, 1, 0),
(55, 5, '2023-05-25', '11:00 - 12:00', NULL, 1, 0),
(56, 5, '2023-05-25', '12:00 - 13:00', NULL, 1, 0),
(57, 5, '2023-05-25', '13:00 - 14:00', NULL, 1, 0),
(58, 5, '2023-05-25', '14:00 - 15:00', NULL, 1, 0),
(59, 5, '2023-05-25', '15:00 - 16:00', NULL, 1, 0),
(60, 5, '2023-05-25', '16:00 - 17:00', NULL, 1, 0),
(61, 5, '2023-05-25', '17:00 - 18:00', NULL, 1, 0),
(62, 5, '2023-05-25', '18:00 - 19:00', NULL, 1, 0),
(63, 5, '2023-05-25', '19:00 - 20:00', NULL, 1, 0),
(64, 5, '2023-05-25', '20:00 - 21:00', NULL, 1, 0),
(65, 5, '2023-05-25', '21:00 - 22:00', NULL, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `guest`
--

CREATE TABLE `guest` (
  `bookingId` int(11) NOT NULL,
  `memberEmail` varchar(40) NOT NULL,
  `guestName` varchar(40) NOT NULL,
  `guestEmail` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guest`
--

INSERT INTO `guest` (`bookingId`, `memberEmail`, `guestName`, `guestEmail`) VALUES
(1, 'mhp@gmail.com', 'dung', 'dun@gmail.com'),
(1, 'mhp@gmail.com', 'ma', 'ma@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffid` int(25) NOT NULL,
  `name` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `type` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffid`, `name`, `password`, `type`) VALUES
(1, 'Dung', '123', 'manager'),
(2, 'Pang', '123', 'manager'),
(4, 'ccc', '123', 'staff'),
(5, 'aaa', '123', 'staff'),
(8, '6', '123', 'manager'),
(9, 'pppp', '123', 'manager');

-- --------------------------------------------------------

--
-- Table structure for table `venue`
--

CREATE TABLE `venue` (
  `venueId` int(1) NOT NULL,
  `name` varchar(25) NOT NULL,
  `address` varchar(40) NOT NULL,
  `pic` varchar(40) NOT NULL,
  `phone` varchar(8) NOT NULL,
  `email` varchar(40) NOT NULL,
  `hourlyPrice` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `venue`
--

INSERT INTO `venue` (`venueId`, `name`, `address`, `pic`, `phone`, `email`, `hourlyPrice`) VALUES
(1, 'Sha Tin Meeting Room', '21 Yuen Wo Road, Sha Tin', 'Will Kwok', '26061234', 'will_kwok@hello.vtc.hk', 505),
(2, 'Tsing Yi Conference Room', '38 Tsing Yi  Road, Tsing Yi', 'Kenneth Chan', '35621234', 'kenneth_chan@hello.vtc.hk', 700),
(3, 'Lee Wai Lee Classroom', '47 Lee Wai Lee Road', 'Alan Po', '21561123', 'alan_po@hello.vtc.hk', 150),
(4, 'Tuen Mun', '1 Tuen Kung Suck Chat Road', 'Sky Wong', '88881111', 'sky_wong@hello.vtc.hk', 400),
(5, 'Chai Wan Dining Room', '21 Chai Wan Kwok Street', 'Dennis Poon', '33221231', 'dennis_poon@hello.vtc.hk', 1000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `staffid` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
