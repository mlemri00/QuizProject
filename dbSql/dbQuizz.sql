-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Servidor: dbQuiz
-- Tiempo de generación: 26-11-2025 a las 16:59:54
-- Versión del servidor: 8.0.44
-- Versión de PHP: 8.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `quiz`
--
CREATE DATABASE IF NOT EXISTS `quiz` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `quiz`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `game`
--

CREATE TABLE `game` (
                        `id` int NOT NULL,
                        `user_id` int NOT NULL,
                        `game_score` int NOT NULL,
                        `correct_answers` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `game`
--

INSERT INTO `game` (`id`, `user_id`, `game_score`, `correct_answers`) VALUES
                                                                          (10, 1, 4, 0),
                                                                          (11, 1, 10, 0),
                                                                          (12, 1, 40, 0),
                                                                          (13, 1, 21, 0),
                                                                          (14, 1, 20, 0),
                                                                          (15, 1, 1234, 0),
                                                                          (16, 4, 7, 0),
                                                                          (17, 4, 5, 0),
                                                                          (18, 4, 10, 0),
                                                                          (19, 4, 7, 0),
                                                                          (20, 6, 23, 0),
                                                                          (21, 6, 30, 0),
                                                                          (22, 6, 10, 0),
                                                                          (23, 6, 103, 0),
                                                                          (24, 6, 20, 2),
                                                                          (25, 6, 34, 1),
                                                                          (26, 6, 75, 7),
                                                                          (27, 6, 55, 4),
                                                                          (28, 1, 55, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
                         `id` int NOT NULL,
                         `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                         `first_name` varchar(255) DEFAULT NULL,
                         `last_name` varchar(255) DEFAULT NULL,
                         `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `first_name`, `last_name`, `password`) VALUES
                                                                                  (1, 'pedro', 'pedro', 'rubio', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
                                                                                  (2, 'mohanomoja', 'miau', 'chelo', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
                                                                                  (3, 'zxcv', 'zxcv', 'zxcv', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
                                                                                  (4, 'fghj', 'fghj', '1234', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
                                                                                  (5, 'midass', 'midass', 'midass', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
                                                                                  (6, 'zurullete', 'a', 'a', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `game`
--
ALTER TABLE `game`
    ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_game` (`user_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `game`
--
ALTER TABLE `game`
    MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
    MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `game`
--
ALTER TABLE `game`
    ADD CONSTRAINT `fk_user_game` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;