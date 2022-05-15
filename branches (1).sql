-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 07:08 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electro_grid`
--

-- --------------------------------------------------------

--
-- Table structure for table `branches`
--

CREATE TABLE `branches` (
  `branchID` varchar(10) NOT NULL,
  `branchName` varchar(30) NOT NULL,
  `branchAddress` varchar(50) NOT NULL,
  `branchContact` int(11) NOT NULL,
  `branchEmail` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `branches`
--

INSERT INTO `branches` (`branchID`, `branchName`, `branchAddress`, `branchContact`, `branchEmail`) VALUES
('C100', 'Colombo7', 'No 05, Colombo7', 112334507, 'colombo7ceb@gmail.com'),
('C105', 'Colombo', 'No 3, Tea avenue, Colombo 3', 112756789, 'colomceb3@gmail.com'),
('C108', 'Colombo', 'No 3, Tea avenue, Colombo 3', 112756789, 'colomceb3@gmail.com'),
('G170', 'Gampaha', 'No 9, Veyangoda road, Gampaha', 336765974, 'gampahaceb@gmail.com'),
('K160', 'Bentara', 'No 5, Galle road, Bentara', 112756744, 'bentaraceb@gmail.com'),
('T110', 'Trincomalee', 'No 111, Trincomalee', 356775674, 'trinco5ceb@gmail.com'),
('V040', '', 'No 8, Jaffna road, Vavniya', 242221891, 'vavniyaceb@gmaiil.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branches`
--
ALTER TABLE `branches`
  ADD PRIMARY KEY (`branchID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
