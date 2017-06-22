-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Jeu 22 Juin 2017 à 09:18
-- Version du serveur :  5.7.18-0ubuntu0.16.04.1
-- Version de PHP :  7.0.18-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `boulderdash`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `getMapByID` (IN `param1` INT(11))  NO SQL
SELECT * FROM maps WHERE `Id` = `param1`$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `maps`
--

CREATE TABLE `maps` (
  `Id` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `map` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `maps`
--

INSERT INTO `maps` (`Id`, `width`, `height`, `map`) VALUES
(1, 8, 8, '########\n#......#\n#.   ..#\n#. M ..#\n#.    .#\n#.   ..#\n#..V...#\n########\n'),
(2, 10, 8, '##########\n#...O....#\n#...  ...#\n#.O...O..#\n#...... .#\n#.. .....#\n#.....V..#\n##########\n'),
(3, 23, 15, '#######################\n#.. .   M      M     .#\n#.. .                .#\n#.. .                .#\n#.. .                .#\n#.. .                .#\n#.. .   M      M     .#\n#.. .   M      M     .#\n#.. .   M      M     .#\n#.. .   M      M     .#\n#.. .   M      M     .#\n#.. .   M      M     .#\n#.. .   M      M     .#\n#.. .   M      M    V.#\n#######################\n'),
(4, 8, 8, '########\n#...O..#\n#...O..#\n#...O..#\n#.... .#\n#......#\n#..V...#\n########\n'),
(5, 8, 8, '########\n#...V..#\n#...O..#\n#...O..#\n#.... .#\n#......#\n#..V...#\n########\n'),
(6, 26, 24, '##########################\n#......O...OO......O...OO#\n#..O..V...O......O.......#\n#.......O. ...O...O.....V#\n#.O.........O............#\n###################..OO..#\n# ....O.O........V#O..O.O#\n#O............O.O.#. ..O.#\n#.O.......OO......#......#\n#...O.............#....V.#\n#..####.......O.O........#\n# ...V#.....O......O.O..O#\n# O...#..O...... ........#\n#.... #.................V#\n#.....####################\n#..O.....................#\n#.......O... OO........O.#\n#....................O.O.#\n#...O.O..O .. ...O.O.....#\n#V............... ...O.O.#\n#..........OO............#\n#.. ....... ...V......O..#\n#.........O..O.....O..O..#\n##########################\n'),
(7, 26, 24, '##########################\n#..#...O...OO......OOO.OO#\n#.O#..V...O......O.......#\n#..#....OO ...O...O.....V#\n#.O#.O#..V..O............#\n#..#.##############..OO..#\n# .#..#..........V#O..O.O#\n#O.#..#VO.....O.O.#. ..O.#\n#. #..#...OO......#......#\n#O.#O.# ..M.......#....V.#\n#.V##.#.......O.O........#\n# .#.V#.....O......O.O..O#\n# O#..#..O...M.. ........#\n#..#.O#.................V#\n#..#..#...##############.#\n#..#..#..........#.......#\n#O.#.O#.O... OO..#.....O.#\n#..#..#.........O#...O.OV#\n#..#O.#..O .. ...O.O.....#\n#VO#..#........OO# ..O.O.#\n#..#..#....OO..OO#.......#\n#.. ..#.... ...V.#....O..#\n#O....#...O..O..V#.O..O..#\n##########################\n'),
(8, 4, 24, '####\n#..#\n#.O#\n#..#\n#.O#\n#..#\n# .#\n#O.#\n#.O#\n#O.#\n#.V#\n# .#\n# O#\n#..#\n#..#\n#..#\n#O.#\n#O.#\n#..#\n#VO#\n#..#\n#.M#\n#O.#\n####\n');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
