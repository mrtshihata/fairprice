-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 07, 2018 at 07:03 PM
-- Server version: 5.6.35
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pricefairdrcongo`
--

-- --------------------------------------------------------

--
-- Table structure for table `accepted_Cost_flux`
--

CREATE TABLE `accepted_Cost_flux` (
  `id` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `city` int(11) NOT NULL,
  `street` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `climat`
--

CREATE TABLE `climat` (
  `id` int(11) NOT NULL,
  `pluie` int(11) NOT NULL,
  `chaleur` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `distance_rate`
--

CREATE TABLE `distance_rate` (
  `id` int(11) NOT NULL,
  `distance` int(11) NOT NULL,
  `time_estimate` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `climat_id` int(11) NOT NULL,
  `from_address_id` int(11) NOT NULL,
  `monaies_id` int(11) NOT NULL,
  `prices_id` int(11) NOT NULL,
  `rarete_id` int(11) NOT NULL,
  `temps_id` int(11) NOT NULL,
  `tension_politiques_id` int(11) NOT NULL,
  `to_address_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `From_Address`
--

CREATE TABLE `From_Address` (
  `pays` text CHARACTER SET utf32 NOT NULL,
  `id` int(11) NOT NULL,
  `province` text NOT NULL,
  `commune` text NOT NULL,
  `quartier` text NOT NULL,
  `territoire` text NOT NULL,
  `rue` text NOT NULL,
  `numero_domicile` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Fuel_Consumption`
--

CREATE TABLE `Fuel_Consumption` (
  `id` int(11) NOT NULL,
  `road` varchar(300) NOT NULL,
  `trafic` varchar(300) NOT NULL,
  `driving_stype` varchar(300) NOT NULL,
  `speed` varchar(300) NOT NULL,
  `loadings` varchar(300) NOT NULL,
  `conditioning` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `monaie`
--

CREATE TABLE `monaie` (
  `id` int(11) NOT NULL,
  `pays` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `monaies`
--

CREATE TABLE `monaies` (
  `id` int(11) NOT NULL,
  `nom_de_monaie` int(11) NOT NULL,
  `taux_journalier` int(11) NOT NULL,
  `taux_mensuel` int(11) NOT NULL,
  `taux_de_base` int(11) NOT NULL,
  `valeur_public` int(11) NOT NULL,
  `taux_avenir` int(11) NOT NULL,
  `taux_de_semaine` int(11) NOT NULL,
  `pix_id` int(11) NOT NULL,
  `temps_id` int(11) NOT NULL,
  `address_id` int(11) NOT NULL,
  `tension_politique_id` int(11) NOT NULL,
  `rarete_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `prices`
--

CREATE TABLE `prices` (
  `id` int(11) NOT NULL,
  `essence` int(11) NOT NULL,
  `mazoute` int(11) NOT NULL,
  `petrole` int(11) NOT NULL,
  `payage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rarete`
--

CREATE TABLE `rarete` (
  `id` int(11) NOT NULL,
  `frequent` varchar(300) NOT NULL,
  `rare` varchar(300) NOT NULL,
  `tres_rare` varchar(300) NOT NULL,
  `extremement_rare` varchar(300) NOT NULL,
  `facile` varchar(300) NOT NULL,
  `tres_facile` varchar(300) NOT NULL,
  `extremement_facile` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `temps`
--

CREATE TABLE `temps` (
  `id` int(11) NOT NULL,
  `matin` varchar(300) NOT NULL,
  `midi` varchar(300) NOT NULL,
  `soir` varchar(300) NOT NULL,
  `nuit` varchar(300) NOT NULL,
  `grande_nuit` varchar(300) NOT NULL,
  `aurore` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tension_politiques`
--

CREATE TABLE `tension_politiques` (
  `id` int(11) NOT NULL,
  `faible` varchar(300) NOT NULL,
  `petite` varchar(300) NOT NULL,
  `normal` varchar(300) NOT NULL,
  `moyenne` varchar(300) NOT NULL,
  `assez_grande` varchar(300) NOT NULL,
  `grande` varchar(300) NOT NULL,
  `tres_grande` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `To_Address`
--

CREATE TABLE `To_Address` (
  `pays` text CHARACTER SET utf32 NOT NULL,
  `id` int(11) NOT NULL,
  `province` text NOT NULL,
  `commune` text NOT NULL,
  `quartier` text NOT NULL,
  `territoire` text NOT NULL,
  `rue` text NOT NULL,
  `numero_domicile` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accepted_Cost_flux`
--
ALTER TABLE `accepted_Cost_flux`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `climat`
--
ALTER TABLE `climat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `distance_rate`
--
ALTER TABLE `distance_rate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `climat_id` (`climat_id`),
  ADD KEY `from_address_id` (`from_address_id`),
  ADD KEY `monaies_id` (`monaies_id`),
  ADD KEY `prices_id` (`prices_id`),
  ADD KEY `rarete_id` (`rarete_id`),
  ADD KEY `temps_id` (`temps_id`),
  ADD KEY `tension_politiques_id` (`tension_politiques_id`),
  ADD KEY `to_address_id` (`to_address_id`);

--
-- Indexes for table `From_Address`
--
ALTER TABLE `From_Address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Fuel_Consumption`
--
ALTER TABLE `Fuel_Consumption`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `monaie`
--
ALTER TABLE `monaie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `monaies`
--
ALTER TABLE `monaies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `priceid` (`pix_id`),
  ADD KEY `temp_id` (`temps_id`),
  ADD KEY `addressed` (`address_id`),
  ADD KEY `tension_politique` (`tension_politique_id`),
  ADD KEY `rarete_id` (`rarete_id`);

--
-- Indexes for table `prices`
--
ALTER TABLE `prices`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rarete`
--
ALTER TABLE `rarete`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `temps`
--
ALTER TABLE `temps`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tension_politiques`
--
ALTER TABLE `tension_politiques`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `To_Address`
--
ALTER TABLE `To_Address`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accepted_Cost_flux`
--
ALTER TABLE `accepted_Cost_flux`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `climat`
--
ALTER TABLE `climat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `distance_rate`
--
ALTER TABLE `distance_rate`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `From_Address`
--
ALTER TABLE `From_Address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Fuel_Consumption`
--
ALTER TABLE `Fuel_Consumption`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `monaie`
--
ALTER TABLE `monaie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `monaies`
--
ALTER TABLE `monaies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `prices`
--
ALTER TABLE `prices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `rarete`
--
ALTER TABLE `rarete`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `temps`
--
ALTER TABLE `temps`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `To_Address`
--
ALTER TABLE `To_Address`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `monaies`
--
ALTER TABLE `monaies`
  ADD CONSTRAINT `monaies_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `Address` (`id`),
  ADD CONSTRAINT `monaies_ibfk_2` FOREIGN KEY (`pix_id`) REFERENCES `prices` (`id`),
  ADD CONSTRAINT `monaies_ibfk_3` FOREIGN KEY (`temps_id`) REFERENCES `temps` (`id`),
  ADD CONSTRAINT `monaies_ibfk_4` FOREIGN KEY (`rarete_id`) REFERENCES `rarete` (`id`),
  ADD CONSTRAINT `monaies_ibfk_5` FOREIGN KEY (`tension_politique_id`) REFERENCES `tension_politiques` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
