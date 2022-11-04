-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: mysqlDawes:3306
-- Tiempo de generación: 04-11-2022 a las 20:42:30
-- Versión del servidor: 5.7.22
-- Versión de PHP: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `comestiblesCorrea`
CREATE DATABASE comestiblesCorrea;

-- Creación de usuario 
CREATE USER 'correa'@'%' IDENTIFIED BY 'nadia';
GRANT ALL PRIVILEGES ON comestiblesCorrea.* to 'correa'@'%';
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CATEGORIES`
--

CREATE TABLE `CATEGORIES` (
  `cat_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `CATEGORIES`
--

INSERT INTO `CATEGORIES` (`cat_id`, `name`, `description`) VALUES
(1, 'frutas', 'frutas varias'),
(2, 'verduras', 'verduras varias'),
(3, 'conservas', 'productos en conserva varios'),
(4, 'bebidas', 'bebidas varias'),
(5, 'cereales', 'cereales varios'),
(6, 'lacteos', 'lacteos varios'),
(7, 'pescados', 'pescados varios'),
(8, 'comida preparada', 'productos precocinados'),
(9, 'postres', 'postres varios'),
(10, 'salsas', 'salsas varios'),
(11, 'frutos secos', 'frutos secos varios'),
(12, 'carnes', 'carnes varias'),
(13, 'aceites', 'aceites varios');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ELEMENTS`
--

CREATE TABLE `ELEMENTS` (
  `ele_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ELEMENTS`
--

INSERT INTO `ELEMENTS` (`ele_id`, `name`, `description`, `price`, `category`) VALUES
(1, 'Asparagus - White, Canned', 'platea dictumst', 3.09, 1),
(2, 'Food Colouring - Blue', 'nisl duis bibendum', 2.6, 10),
(3, 'Soup - Campbells, Chix Gumbo', 'ultrices erat tortor sollicitudin mi', 3.6, 8),
(4, 'Cheese - La Sauvagine', 'vitae nisi nam', 6.75, 6),
(5, 'Nut - Walnut, Chopped', 'potenti cras', 8.31, 11),
(6, 'Mahi Mahi', 'morbi ut odio', 9.48, 7),
(7, 'Longos - Burritos', 'integer pede', 7.95, 8),
(8, 'Flour - All Purpose', 'varius nulla facilisi', 1.76, 5),
(9, 'Coconut - Shredded, Unsweet', 'ut dolor', 3.89, 11),
(10, 'Cheese - Pont Couvert', 'tortor sollicitudin mi', 9.73, 6),
(11, 'Longos - Grilled Veg Sandwiches', 'sem mauris', 7.33, 8),
(12, 'Quail - Whole, Bone - In', 'ultrices enim', 7.57, 12),
(13, 'Lid - 3oz Med Rec', 'dui luctus rutrum nulla tellus', 5.22, 3),
(14, 'Wine - Carmenere Casillero Del', 'nibh ligula', 8.42, 4),
(15, 'Evaporated Milk - Skim', 'vulputate justo in', 1.57, 6),
(16, 'Tart Shells - Sweet, 3', 'vel ipsum praesent blandit lacinia', 2.47, 9),
(17, 'Crab - Claws, Snow 16 - 24', 'in blandit ultrices enim lorem', 9.07, 7),
(18, 'Pheasants - Whole', 'orci mauris', 4.1, 5),
(19, 'Squash - Guords', 'tempus vel pede', 4.91, 2),
(20, 'Cheese - Montery Jack', 'rhoncus aliquam lacus morbi', 4.4, 6),
(21, 'Sloe Gin - Mcguinness', 'volutpat erat quisque', 4.57, 4),
(22, 'Wine - Blue Nun Qualitatswein', 'lorem quisque ut', 4.05, 4),
(23, 'Teriyaki Sauce', 'potenti in eleifend', 6.54, 10),
(24, 'Cheese - Shred Cheddar / Mozza', 'lobortis vel dapibus', 2.8, 6),
(25, 'Evaporated Milk - Whole', 'elit proin risus', 1.26, 6),
(26, 'Strawberry yogurt', 'quis justo', 1.46, 6),
(27, 'Lamb - Leg, Diced', 'in hac habitasse platea', 8.88, 12),
(28, 'Spic And Span All Purpose', 'risus dapibus augue vel accumsan', 9.92, 5),
(29, 'Veal - Osso Bucco', 'ultrices vel augue', 11.18, 12),
(30, 'Lemonade - Natural, 591 Ml', 'in magna bibendum', 2.31, 4),
(31, 'Beer - Blue', 'imperdiet nullam orci pede venenatis', 4.89, 4),
(32, 'Barley - Pearl', 'nibh in hac', 2.41, 4),
(33, 'Pastry - Lemon Danish - Mini', 'ultrices vel', 3.05, 9),
(34, 'Pork - Ground', 'luctus et ultrices', 6.05, 12),
(35, 'Spring Roll', 'imperdiet et', 5.89, 8),
(36, 'Pork - Smoked Kassler', 'nec nisi vulputate', 9.61, 12),
(37, 'Squid Ink', 'nunc rhoncus dui vel sem', 4, 7),
(38, 'Horseradish - Prepared', 'nulla ut', 4.24, 8),
(39, 'Lambcasing', 'cubilia curae mauris viverra', 5.32, 12),
(40, 'Mushroom - Chanterelle, Dry', 'imperdiet nullam orci pede', 2.85, 2),
(41, 'Marjoram - Fresh', 'cras in purus eu', 1.72, 2),
(42, 'Samosa - Veg', 'ante vestibulum ante ipsum', 2.08, 8),
(43, 'Icecream - Dstk Cml And Fdg', 'vivamus metus', 1.95, 10),
(44, 'Chinese Foods - Cantonese', 'integer aliquet massa', 9.76, 8),
(45, 'Lamb - Shoulder', 'nullam sit amet', 7.65, 12),
(46, 'Parsley - Fresh', 'integer non velit donec diam', 1.9, 2),
(47, 'Thyme - Lemon, Fresh', 'condimentum curabitur', 1.75, 2),
(48, 'Oil - Shortening - All - Purpose', 'bibendum felis sed interdum venenatis', 9.16, 13),
(49, 'Cheese - Oka', 'porta volutpat quam pede', 4.52, 6),
(50, 'Creamy Butter', 'mauris morbi', 2.76, 6),
(51, 'Tarts Assorted', 'odio curabitur convallis', 7.51, 9),
(52, 'Cheese - Brie, Triple Creme', 'justo pellentesque viverra pede', 3.89, 6),
(53, 'Beef - Eye Of Round', 'volutpat eleifend donec ut dolor', 15.09, 12),
(54, 'Wine - Alsace Riesling Reserve', 'tortor risus', 3.3, 4),
(55, 'Compound - Strawberry', 'quis orci eget', 3.89, 3),
(56, 'Sorrel - Fresh', 'enim in tempor turpis', 1.36, 2),
(57, 'Cheese - Cheddar With Claret', 'vivamus tortor', 2.18, 6),
(58, 'Ice Tea', 'quis turpis sed ante', 1.52, 4),
(59, 'Apricots Fresh', 'accumsan felis ut at', 5.81, 1),
(60, 'Papaya', 'morbi non lectus', 6.25, 1),
(61, 'Potatoes - Idaho 80 Count', 'vehicula condimentum curabitur in', 1.63, 2),
(62, 'Squid - U 5', 'gravida nisi at nibh', 4.08, 7),
(63, 'Chinese Foods - Thick Noodles', 'cubilia curae donec pharetra magna', 8.72, 8),
(64, 'Hagen Daza - Dk Choocolate', 'id massa id nisl', 6.34, 9),
(65, 'Sprite, Diet - 355ml', 'quisque arcu libero rutrum ac', 1.19, 4),
(66, 'Pepsi', 'tincidunt ante', 1.03, 4),
(67, 'Mayonnaise', 'felis sed lacus morbi', 1.95, 10),
(68, 'Butter - Salted, Micro', 'mauris viverra diam vitae', 1.68, 6),
(69, 'Pepper - Red', 'at turpis', 3.61, 2),
(70, 'Tuna - Salad Premix', 'eget elit sodales', 3.81, 3),
(71, 'Asparagus - White, Fresh', 'at vulputate vitae nisl aenean', 4.41, 2),
(72, 'Sauerkraut', 'id massa id nisl', 2.3, 3),
(73, 'Appetizer - Veg Assortment', 'tortor sollicitudin', 7.97, 8),
(74, 'Coffee - Espresso', 'non mattis pulvinar nulla', 1.77, 4),
(75, 'Clams - Littleneck, Whole', 'cras non velit', 7.56, 7),
(76, 'Chicken - Ground', 'consectetuer adipiscing elit proin risus', 5.77, 12),
(77, 'Lettuce - Treviso', 'quisque porta volutpat', 1.39, 2),
(78, 'Raisin - Golden', 'bibendum morbi non', 2.32, 11),
(79, 'Sourcream', 'in ante', 2.2, 10),
(80, 'Pepper - Cubanelle', 'rhoncus aliquet', 1.67, 2),
(81, 'Muffin Mix - Banana Nut', 'vel enim sit amet nunc', 3.73, 9),
(82, 'Cookies - Englishbay Wht', 'at lorem integer tincidunt', 1.24, 9),
(83, 'Bread - Bistro White', 'justo in blandit', 1.53, 5),
(84, 'Pork - Sausage, Medium', 'phasellus sit amet', 6.69, 12),
(85, 'Bread - Pita', 'posuere nonummy integer', 1.82, 5),
(86, 'Sunflower Oil', 'nunc viverra dapibus', 7.88, 13),
(87, 'Wine - Malbec Trapiche Reserve', 'faucibus orci luctus', 4.43, 4),
(88, 'Asparagus - Green, Fresh', 'metus arcu', 7.6, 2),
(89, 'Tomato Puree', 'quisque arcu libero rutrum', 4.72, 3),
(90, 'Wine - Casillero Deldiablo', 'adipiscing elit', 3.12, 4),
(91, 'Beef - Rib Eye Aaa', 'et ultrices posuere cubilia', 18.29, 12),
(92, 'Creamers - 10%', 'amet sapien dignissim vestibulum', 2.69, 6),
(93, 'Garden Salad', 'a libero nam', 2.22, 8),
(94, 'Tart Shells - Sweet, 4', 'lacus at', 6.45, 9),
(95, 'Trout - Rainbow, Frozen', 'aliquam lacus morbi quis', 5.46, 4),
(96, 'Milk - 2% 250 Ml', 'viverra eget congue', 1.62, 4),
(97, 'Tortillas - Flour, 10', 'consequat nulla nisl nunc', 2.12, 5),
(98, 'Rambutan', 'nec nisi volutpat eleifend', 7.22, 8),
(99, 'Pecan Raisin - Tarts', 'aliquet maecenas leo odio', 4.2, 9),
(100, 'Pear - Packum', 'felis eu sapien cursus vestibulum', 3.45, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `SALES`
--

CREATE TABLE `SALES` (
  `ele_id` int(11) NOT NULL,
  `us_id` int(11) NOT NULL,
  `salesDate` datetime NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `SALES`
--

INSERT INTO `SALES` (`ele_id`, `us_id`, `salesDate`, `quantity`, `price`) VALUES
(1, 3, '2022-04-10 12:45:56', 3, 3.09),
(5, 2, '2022-04-10 12:47:20', 1, 8.31),
(14, 2, '2022-04-10 12:47:20', 1, 8.42);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `USERS`
--

CREATE TABLE `USERS` (
  `us_id` int(11) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `USERS`
--

INSERT INTO `USERS` (`us_id`, `userName`, `password`, `name`, `lastname`, `dob`, `sex`, `admin`) VALUES
(1, 'Nash', 'a9b69ae1a4c3491d2dbf5eae94f5c041', 'Nadia', 'Correa', '1984-09-29', 'M', 0),
(2, 'Pcaro', '487b5d4113bb0b62a558679bd761594f', 'Pedro', 'Caro', '1982-09-03', 'H', 0),
(3, 'Charlottie', '0719c04224aa7d436156124c06f5c304', 'Charlotte', 'Caro', '2011-02-08', 'M', 0),
(4, 'NCorrea', '2a78ea6363a06081e3874cad1d926240', 'Nadia', 'Morales', '1984-09-29', 'M', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `CATEGORIES`
--
ALTER TABLE `CATEGORIES`
  ADD PRIMARY KEY (`cat_id`);

--
-- Indices de la tabla `ELEMENTS`
--
ALTER TABLE `ELEMENTS`
  ADD PRIMARY KEY (`ele_id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `fk_elemenys` (`category`);

--
-- Indices de la tabla `SALES`
--
ALTER TABLE `SALES`
  ADD PRIMARY KEY (`ele_id`,`us_id`,`salesDate`),
  ADD KEY `fk2_sales` (`us_id`);

--
-- Indices de la tabla `USERS`
--
ALTER TABLE `USERS`
  ADD PRIMARY KEY (`us_id`),
  ADD UNIQUE KEY `userName` (`userName`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `CATEGORIES`
--
ALTER TABLE `CATEGORIES`
  MODIFY `cat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `ELEMENTS`
--
ALTER TABLE `ELEMENTS`
  MODIFY `ele_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- AUTO_INCREMENT de la tabla `USERS`
--
ALTER TABLE `USERS`
  MODIFY `us_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ELEMENTS`
--
ALTER TABLE `ELEMENTS`
  ADD CONSTRAINT `fk_elemenys` FOREIGN KEY (`category`) REFERENCES `CATEGORIES` (`cat_id`);

--
-- Filtros para la tabla `SALES`
--
ALTER TABLE `SALES`
  ADD CONSTRAINT `fk1_sales` FOREIGN KEY (`ele_id`) REFERENCES `ELEMENTS` (`ele_id`),
  ADD CONSTRAINT `fk2_sales` FOREIGN KEY (`us_id`) REFERENCES `USERS` (`us_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
