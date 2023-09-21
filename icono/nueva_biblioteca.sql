-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-07-2023 a las 13:58:50
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nueva_biblioteca`
--
CREATE DATABASE IF NOT EXISTS `nueva_biblioteca` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `nueva_biblioteca`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `det_estudiantes`
--

DROP TABLE IF EXISTS `det_estudiantes`;
CREATE TABLE `det_estudiantes` (
  `idEstudiante` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `carrera` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `det_estudiantes`
--

INSERT INTO `det_estudiantes` (`idEstudiante`, `nombre`, `carrera`) VALUES
(1, 'gustavo inciarte', 'Ingenieria de Sistema'),
(2, 'Anabel Berrio Smith', 'Educacion Integral');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `det_libros`
--

DROP TABLE IF EXISTS `det_libros`;
CREATE TABLE `det_libros` (
  `idLibro` int(11) NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `autor` varchar(100) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `det_libros`
--

INSERT INTO `det_libros` (`idLibro`, `titulo`, `autor`, `cantidad`) VALUES
(1, 'Linear Algebra', 'Hoffman-Kunze', 5),
(2, 'Mathematical analysis', 'Rudin', 5),
(3, 'Calculus', 'Tom Apostol', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

DROP TABLE IF EXISTS `prestamos`;
CREATE TABLE `prestamos` (
  `idPrestamo` int(11) NOT NULL,
  `idLibro` int(11) DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `idEstudiante` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `fechaPrestamo` date DEFAULT NULL,
  `fechaVencimiento` date DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`idPrestamo`, `idLibro`, `titulo`, `idEstudiante`, `nombre`, `fechaPrestamo`, `fechaVencimiento`, `estado`) VALUES
(10, 1, 'Linear Algebra', 1, 'gustavo inciarte', '2023-05-12', '2023-07-14', 'Devuelto');

--
-- Disparadores `prestamos`
--
DROP TRIGGER IF EXISTS `actualizar_cantidad_actualizar`;
DELIMITER $$
CREATE TRIGGER `actualizar_cantidad_actualizar` AFTER UPDATE ON `prestamos` FOR EACH ROW BEGIN
    IF NEW.idLibro != OLD.idLibro THEN
        UPDATE det_libros SET cantidad = cantidad + 1 WHERE idLibro = OLD.idLibro;
        UPDATE det_libros SET cantidad = cantidad - 1 WHERE idLibro = NEW.idLibro;
    END IF;
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `actualizar_cantidad_devuelto`;
DELIMITER $$
CREATE TRIGGER `actualizar_cantidad_devuelto` AFTER UPDATE ON `prestamos` FOR EACH ROW BEGIN
    IF NEW.estado = 'Devuelto' THEN
        UPDATE det_libros SET cantidad = cantidad + 1 WHERE idLibro = NEW.idLibro;
    END IF;
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `actualizar_cantidad_eliminar`;
DELIMITER $$
CREATE TRIGGER `actualizar_cantidad_eliminar` AFTER DELETE ON `prestamos` FOR EACH ROW BEGIN
    UPDATE det_libros SET cantidad = cantidad + 1 WHERE idLibro = OLD.idLibro;
END
$$
DELIMITER ;
DROP TRIGGER IF EXISTS `actualizar_cantidad_insertar`;
DELIMITER $$
CREATE TRIGGER `actualizar_cantidad_insertar` AFTER INSERT ON `prestamos` FOR EACH ROW BEGIN
    UPDATE det_libros SET cantidad = cantidad - 1 WHERE idLibro = NEW.idLibro;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `total_estudiantes`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `total_estudiantes`;
CREATE TABLE `total_estudiantes` (
`total` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `total_libros`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `total_libros`;
CREATE TABLE `total_libros` (
`total` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contacto` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `usuario`, `clave`, `email`, `contacto`) VALUES
(1, 'gustavo', '123456', 'gustavoinciarte0409@gmail.com', '04246241443'),
(2, 'anabel', '123456', 'berrioanabel@hotmail.com', '04246918188'),
(3, 'laura', '123', 'laureana-f@hotmail.com', '04121325088'),
(4, 'ana', '123', 'ana@gmail.com', '04241554824');

-- --------------------------------------------------------

--
-- Estructura para la vista `total_estudiantes`
--
DROP TABLE IF EXISTS `total_estudiantes`;

DROP VIEW IF EXISTS `total_estudiantes`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_estudiantes`  AS SELECT count(0) AS `total` FROM `det_estudiantes``det_estudiantes`  ;

-- --------------------------------------------------------

--
-- Estructura para la vista `total_libros`
--
DROP TABLE IF EXISTS `total_libros`;

DROP VIEW IF EXISTS `total_libros`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `total_libros`  AS SELECT sum(`det_libros`.`cantidad`) AS `total` FROM `det_libros``det_libros`  ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `det_estudiantes`
--
ALTER TABLE `det_estudiantes`
  ADD PRIMARY KEY (`idEstudiante`);

--
-- Indices de la tabla `det_libros`
--
ALTER TABLE `det_libros`
  ADD PRIMARY KEY (`idLibro`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`idPrestamo`),
  ADD KEY `idLibro` (`idLibro`),
  ADD KEY `idEstudiante` (`idEstudiante`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `det_estudiantes`
--
ALTER TABLE `det_estudiantes`
  MODIFY `idEstudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `det_libros`
--
ALTER TABLE `det_libros`
  MODIFY `idLibro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `idPrestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`idLibro`) REFERENCES `det_libros` (`idLibro`),
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`idEstudiante`) REFERENCES `det_estudiantes` (`idEstudiante`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
