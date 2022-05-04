-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 23, 2022 at 05:04 AM
-- Server version: 10.5.12-MariaDB
-- PHP Version: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id18420043_sharepixel`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `story_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `profile_image` text COLLATE utf8_unicode_ci NOT NULL,
  `comment_text` text COLLATE utf8_unicode_ci NOT NULL,
  `time` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `story_id`, `user_id`, `username`, `profile_image`, `comment_text`, `time`) VALUES
(16, 13, 12, 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', 'Beautiful ✨', 'Sat Mar 12 17:00:43 GMT+05:30 2022'),
(17, 21, 11, 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', 'cute ❤', 'Sat Mar 12 23:01:45 GMT+05:30 2022'),
(18, 21, 11, 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', ':) ', 'Sun Mar 13 10:48:40 GMT+05:30 2022'),
(19, 22, 11, 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', 'hi', 'Sun Mar 13 10:50:21 GMT+05:30 2022'),
(20, 22, 11, 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', 'cool', 'Sun Mar 13 16:16:02 GMT+05:30 2022'),
(21, 24, 12, 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', 'Carry on :) ', 'Sun Mar 13 16:18:39 GMT+05:30 2022'),
(22, 28, 12, 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', 'nice', 'Mon Mar 14 11:19:18 GMT+05:30 2022'),
(23, 29, 11, 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', 'beautiful✨✨✨', 'Mon Mar 14 12:29:08 GMT+05:30 2022'),
(24, 13, 13, 'suzan', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 12:02:30.908.jpg', 'nice :) ', 'Mon Mar 14 12:41:56 GMT+05:30 2022'),
(25, 35, 12, 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', 'cool', 'Fri Apr 01 16:08:55 GMT+05:30 2022'),
(26, 37, 18, 'albert_newton', 'https://sharepixel.000webhostapp.com/users_images/2022-04-03 18:19:48.275.jpg', 'awesome!', 'Sun Apr 03 18:20:22 GMT+05:30 2022'),
(27, 38, 17, 'issac_einstein', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 11:59:23.787.jpg', 'Jai Shree Ram!!', 'Sun Apr 03 18:21:36 GMT+05:30 2022'),
(28, 39, 11, 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', 'Enjoy ヾ(＾-＾)ノ', 'Mon Apr 04 08:23:18 GMT+05:30 2022'),
(29, 34, 13, 'suzan', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 12:02:30.908.jpg', 'nice', 'Mon Apr 11 18:47:40 GMT+05:30 2022'),
(30, 20, 12, 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', 'nice', 'Mon Apr 11 20:44:22 GMT+05:30 2022'),
(31, 40, 12, 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', 'Enjoy (〃＾▽＾〃)', 'Mon Apr 11 21:59:57 GMT+05:30 2022'),
(32, 40, 11, 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', 'Cooollll', 'Mon Apr 11 22:00:40 GMT+05:30 2022'),
(33, 42, 12, 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', 'Woahh', 'Sat Apr 16 12:04:43 GMT+05:30 2022'),
(34, 35, 13, 'suzan', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 12:02:30.908.jpg', 'great', 'Sat Apr 16 12:05:10 GMT+05:30 2022'),
(35, 44, 11, 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', 'not good pic', 'Sat Apr 16 20:23:56 GMT+05:30 2022'),
(36, 45, 12, 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', 'Beautiful✨', 'Sat Apr 16 23:52:27 GMT+05:30 2022'),
(37, 45, 13, 'suzan', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 12:02:30.908.jpg', 'wow *(^o^)/*', 'Sat Apr 16 23:53:41 GMT+05:30 2022'),
(38, 45, 23, 'charlie9', 'https://sharepixel.000webhostapp.com/users_images/2022-04-22 01:57:29.733.jpg', 'wow', 'Sun Apr 17 08:16:54 GMT+05:30 2022'),
(39, 45, 25, 'james', 'https://sharepixel.000webhostapp.com/users_images/2022-04-17 08:41:56.722.jpg', 'wowe', 'Sun Apr 17 08:35:23 GMT+05:30 2022');

-- --------------------------------------------------------

--
-- Table structure for table `following`
--

CREATE TABLE `following` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `other_user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `following`
--

INSERT INTO `following` (`id`, `user_id`, `other_user_id`) VALUES
(13, 12, 11),
(14, 11, 12),
(15, 11, 13),
(17, 13, 11),
(18, 14, 11),
(19, 15, 14),
(20, 11, 16),
(21, 18, 17),
(22, 17, 18),
(23, 12, 18),
(24, 12, 13),
(25, 19, 12),
(26, 19, 16),
(27, 19, 15),
(28, 19, 15),
(29, 19, 11),
(30, 19, 13),
(31, 19, 15),
(32, 13, 14),
(33, 20, 11),
(34, 21, 11),
(35, 22, 11),
(36, 23, 11),
(37, 23, 13),
(38, 24, 11),
(39, 25, 11),
(40, 25, 13);

-- --------------------------------------------------------

--
-- Table structure for table `images`
--

CREATE TABLE `images` (
  `id` int(11) NOT NULL,
  `image_name` text COLLATE utf8_unicode_ci NOT NULL,
  `image_url` text COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `images`
--

INSERT INTO `images` (`id`, `image_name`, `image_url`, `user_id`) VALUES
(23, '#flower #beauty #nature', 'https://sharepixel.000webhostapp.com/story_images/2022-03-12 16:59:17.375.jpg', 11),
(30, '#food', 'https://sharepixel.000webhostapp.com/story_images/2022-03-12 22:54:49.251.jpg', 11),
(31, '#cute #doggo', 'https://sharepixel.000webhostapp.com/story_images/2022-03-12 22:59:36.586.jpg', 12),
(32, '#work', 'https://sharepixel.000webhostapp.com/story_images/2022-03-12 23:47:53.062.jpg', 12),
(33, 'My garden ', 'https://sharepixel.000webhostapp.com/story_images/2022-03-13 10:51:50.164.jpg', 11),
(34, '#working on major project', 'https://sharepixel.000webhostapp.com/story_images/2022-03-13 16:16:58.308.jpg', 11),
(35, '#muskmelon #texture', 'https://sharepixel.000webhostapp.com/story_images/2022-03-13 16:32:29.328.jpg', 12),
(36, '#how insta started', 'https://sharepixel.000webhostapp.com/story_images/2022-03-13 17:39:19.526.jpg', 13),
(38, 'back to terna ', 'https://sharepixel.000webhostapp.com/story_images/2022-03-14 11:18:06.324.jpg', 11),
(39, '#scenery ', 'https://sharepixel.000webhostapp.com/story_images/2022-03-14 12:27:18.559.jpg', 13),
(40, 'test ', 'https://sharepixel.000webhostapp.com/story_images/2022-03-14 12:32:09.519.jpg', 12),
(41, '#bts #army', 'https://sharepixel.000webhostapp.com/story_images/2022-03-14 12:48:21.078.jpg', 14),
(42, 'prac', 'https://sharepixel.000webhostapp.com/story_images/2022-03-14 12:55:27.153.jpg', 15),
(43, '#nature', 'https://sharepixel.000webhostapp.com/story_images/2022-03-15 22:11:51.413.jpg', 12),
(44, '#pattern', 'https://sharepixel.000webhostapp.com/story_images/2022-03-24 19:41:53.846.jpg', 11),
(45, 'back to college', 'https://sharepixel.000webhostapp.com/story_images/2022-03-31 11:37:10.301.jpg', 11),
(46, 'Volleyball', 'https://sharepixel.000webhostapp.com/story_images/2022-03-31 12:33:13.915.jpg', 12),
(47, 'sky ', 'https://sharepixel.000webhostapp.com/story_images/2022-04-03 18:09:57.773.jpg', 17),
(48, 'Jai Shree Ram!', 'https://sharepixel.000webhostapp.com/story_images/2022-04-03 18:19:20.905.jpg', 18),
(49, '#fest ٩( ᐛ )و', 'https://sharepixel.000webhostapp.com/story_images/2022-04-04 08:19:04.924.jpg', 13),
(50, '#Fest', 'https://sharepixel.000webhostapp.com/story_images/2022-04-04 21:54:53.556.jpg', 13),
(51, 'Quote', 'https://sharepixel.000webhostapp.com/story_images/2022-04-11 18:49:10.372.jpg', 13),
(52, '#Dhol ', 'https://sharepixel.000webhostapp.com/story_images/2022-04-11 22:03:54.793.jpg', 13),
(53, '#Cultural Fest', 'https://sharepixel.000webhostapp.com/story_images/2022-04-11 22:38:09.543.jpg', 13),
(54, '#cat', 'https://sharepixel.000webhostapp.com/story_images/2022-04-12 13:30:11.113.jpg', 13),
(55, '#painting ', 'https://sharepixel.000webhostapp.com/story_images/2022-04-16 21:16:44.616.jpg', 11),
(56, '#nature', 'https://sharepixel.000webhostapp.com/story_images/2022-04-17 08:39:11.99.jpg', 25),
(57, '#pic', 'https://sharepixel.000webhostapp.com/story_images/2022-04-17 08:40:15.523.jpg', 25),
(58, '#crush', 'https://sharepixel.000webhostapp.com/story_images/2022-04-17 18:16:16.113.jpg', 12),
(59, 'xyZ', 'https://sharepixel.000webhostapp.com/story_images/2022-04-21 12:28:14.765.jpg', 19),
(60, 'xyZ', 'https://sharepixel.000webhostapp.com/story_images/2022-04-21 12:28:14.765.jpg', 19),
(61, 'coding', 'https://sharepixel.000webhostapp.com/story_images/2022-04-22 01:56:34.438.jpg', 23);

-- --------------------------------------------------------

--
-- Table structure for table `likes`
--

CREATE TABLE `likes` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `story_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `likes`
--

INSERT INTO `likes` (`id`, `user_id`, `story_id`) VALUES
(21, 12, 13),
(22, 11, 21),
(23, 11, 22),
(24, 12, 23),
(25, 12, 24),
(26, 12, 28),
(27, 11, 26),
(30, 13, 13),
(31, 13, 23),
(32, 13, 28),
(33, 14, 28),
(34, 14, 24),
(35, 14, 23),
(36, 15, 31),
(38, 18, 37),
(39, 17, 38),
(40, 11, 39),
(41, 12, 38),
(42, 13, 34),
(43, 11, 40),
(44, 12, 40),
(45, 19, 44),
(46, 19, 43),
(47, 19, 42),
(48, 19, 40),
(49, 19, 39),
(50, 12, 45),
(51, 13, 45),
(52, 20, 45),
(53, 21, 45),
(54, 23, 45),
(55, 24, 45),
(56, 25, 45),
(57, 11, 42);

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `story_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`id`, `user_id`, `story_id`) VALUES
(2, 12, 13),
(18, 11, 41),
(19, 12, 41),
(20, 11, 43),
(21, 11, 44),
(22, 12, 44),
(23, 12, 35),
(24, 25, 44),
(25, 11, 48);

-- --------------------------------------------------------

--
-- Table structure for table `stories`
--

CREATE TABLE `stories` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `num_of_likes` int(11) NOT NULL DEFAULT 0,
  `image_url` text COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `time` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `profile_image` text COLLATE utf8_unicode_ci NOT NULL,
  `image_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `num_of_reports` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `stories`
--

INSERT INTO `stories` (`id`, `user_id`, `num_of_likes`, `image_url`, `title`, `time`, `username`, `profile_image`, `image_name`, `num_of_reports`) VALUES
(20, 11, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-03-12 22:54:49.251.jpg', '#food', 'Sat Mar 12 22:54:49 GMT+05:30 2022', 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', '2022-03-12 22:54:49.251', 0),
(21, 12, 1, 'https://sharepixel.000webhostapp.com/story_images/2022-03-12 22:59:36.586.jpg', '#cute #doggo', 'Sat Mar 12 22:59:36 GMT+05:30 2022', 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', '2022-03-12 22:59:36.586', 0),
(22, 12, 1, 'https://sharepixel.000webhostapp.com/story_images/2022-03-12 23:47:53.062.jpg', '#work', 'Sat Mar 12 23:47:53 GMT+05:30 2022', 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', '2022-03-12 23:47:53.062', 0),
(23, 11, 3, 'https://sharepixel.000webhostapp.com/story_images/2022-03-13 10:51:50.164.jpg', 'My garden ', 'Sun Mar 13 10:51:50 GMT+05:30 2022', 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', '2022-03-13 10:51:50.164', 0),
(24, 11, 2, 'https://sharepixel.000webhostapp.com/story_images/2022-03-13 16:16:58.308.jpg', '#working on major project', 'Sun Mar 13 16:16:58 GMT+05:30 2022', 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', '2022-03-13 16:16:58.308', 0),
(25, 12, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-03-13 16:32:29.328.jpg', '#muskmelon #texture', 'Sun Mar 13 16:32:29 GMT+05:30 2022', 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', '2022-03-13 16:32:29.328', 0),
(26, 13, 1, 'https://sharepixel.000webhostapp.com/story_images/2022-03-13 17:39:19.526.jpg', '#how insta started', 'Sun Mar 13 17:39:19 GMT+05:30 2022', 'suzan', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 12:02:30.908.jpg', '2022-03-13 17:39:19.526', 0),
(28, 11, 3, 'https://sharepixel.000webhostapp.com/story_images/2022-03-14 11:18:06.324.jpg', 'back to terna ', 'Mon Mar 14 11:18:06 GMT+05:30 2022', 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', '2022-03-14 11:18:06.324', 0),
(29, 13, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-03-14 12:27:18.559.jpg', '#scenery ', 'Mon Mar 14 12:27:18 GMT+05:30 2022', 'suzan', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 12:02:30.908.jpg', '2022-03-14 12:27:18.559', 0),
(30, 12, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-03-14 12:32:09.519.jpg', 'test ', 'Mon Mar 14 12:32:09 GMT+05:30 2022', 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', '2022-03-14 12:32:09.519', 0),
(31, 14, 1, 'https://sharepixel.000webhostapp.com/story_images/2022-03-14 12:48:21.078.jpg', '#bts #army', 'Mon Mar 14 12:48:21 GMT+05:30 2022', 'annnuu136', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', '2022-03-14 12:48:21.078', 0),
(32, 15, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-03-14 12:55:27.153.jpg', 'prac', 'Mon Mar 14 12:55:27 GMT+05:30 2022', 'priya123', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', '2022-03-14 12:55:27.153', 0),
(33, 12, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-03-15 22:11:51.413.jpg', '#nature', 'Tue Mar 15 22:11:51 GMT+05:30 2022', 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', '2022-03-15 22:11:51.413', 0),
(34, 11, 1, 'https://sharepixel.000webhostapp.com/story_images/2022-03-24 19:41:53.846.jpg', '#pattern', 'Thu Mar 24 19:41:53 GMT+05:30 2022', 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', '2022-03-24 19:41:53.846', 0),
(35, 11, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-03-31 11:37:10.301.jpg', 'back to college', 'Thu Mar 31 11:37:10 GMT+05:30 2022', 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', '2022-03-31 11:37:10.301', 1),
(36, 12, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-03-31 12:33:13.915.jpg', 'Volleyball', 'Thu Mar 31 12:33:13 GMT+05:30 2022', 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', '2022-03-31 12:33:13.915', 0),
(37, 17, 1, 'https://sharepixel.000webhostapp.com/story_images/2022-04-03 18:09:57.773.jpg', 'sky ', 'Sun Apr 03 18:09:57 GMT+05:30 2022', 'issac_einstein', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 11:59:23.787.jpg', '2022-04-03 18:09:57.773', 0),
(38, 18, 2, 'https://sharepixel.000webhostapp.com/story_images/2022-04-03 18:19:20.905.jpg', 'Jai Shree Ram!', 'Sun Apr 03 18:19:20 GMT+05:30 2022', 'albert_newton', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', '2022-04-03 18:19:20.905', 0),
(39, 13, 2, 'https://sharepixel.000webhostapp.com/story_images/2022-04-04 08:19:04.924.jpg', '#fest ٩( ᐛ )و', 'Mon Apr 04 08:19:04 GMT+05:30 2022', 'suzan', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 12:02:30.908.jpg', '2022-04-04 08:19:04.924', 0),
(40, 13, 3, 'https://sharepixel.000webhostapp.com/story_images/2022-04-04 21:54:53.556.jpg', '#Fest', 'Mon Apr 04 21:54:53 GMT+05:30 2022', 'suzan', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 12:02:30.908.jpg', '2022-04-04 21:54:53.556', 0),
(42, 13, 2, 'https://sharepixel.000webhostapp.com/story_images/2022-04-11 22:03:54.793.jpg', '#Dhol ', 'Mon Apr 11 22:03:54 GMT+05:30 2022', 'suzan', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 12:02:30.908.jpg', '2022-04-11 22:03:54.793', 0),
(45, 11, 7, 'https://sharepixel.000webhostapp.com/story_images/2022-04-16 21:16:44.616.jpg', '#painting ', 'Sat Apr 16 21:16:44 GMT+05:30 2022', 'selena_doe', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', '2022-04-16 21:16:44.616', 0),
(46, 25, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-04-17 08:39:11.99.jpg', '#nature', 'Sun Apr 17 08:39:11 GMT+05:30 2022', 'james', 'https://sharepixel.000webhostapp.com/users_images/2022-04-17 08:41:56.722.jpg', '2022-04-17 08:39:11.99', 0),
(47, 25, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-04-17 08:40:15.523.jpg', '#pic', 'Sun Apr 17 08:40:15 GMT+05:30 2022', 'james', 'https://sharepixel.000webhostapp.com/users_images/2022-04-17 08:41:56.722.jpg', '2022-04-17 08:40:15.523', 0),
(48, 12, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-04-17 18:16:16.113.jpg', '#crush', 'Sun Apr 17 18:16:16 GMT+05:30 2022', 'john_wilson', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', '2022-04-17 18:16:16.113', 1),
(49, 19, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-04-21 12:28:14.765.jpg', 'xyZ', 'Thu Apr 21 12:28:14 GMT+05:30 2022', 'vaishnavimanchanda', 'https://sharepixel.000webhostapp.com/users_images/2022-04-21 13:15:53.021.jpg', '2022-04-21 12:28:14.765', 0),
(50, 19, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-04-21 12:28:14.765.jpg', 'xyZ', 'Thu Apr 21 12:28:14 GMT+05:30 2022', 'vaishnavimanchanda', 'https://sharepixel.000webhostapp.com/users_images/2022-04-21 13:15:53.021.jpg', '2022-04-21 12:28:14.765', 0),
(51, 23, 0, 'https://sharepixel.000webhostapp.com/story_images/2022-04-22 01:56:34.438.jpg', 'coding', 'Fri Apr 22 01:56:34 GMT+05:30 2022', 'charlie9', 'https://sharepixel.000webhostapp.com/users_images/2022-04-22 01:57:29.733.jpg', '2022-04-22 01:56:34.438', 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `image` text COLLATE utf8_unicode_ci NOT NULL,
  `followers` int(11) NOT NULL,
  `following` int(11) NOT NULL,
  `posts` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `email`, `image`, `followers`, `following`, `posts`) VALUES
(11, 'selena_doe', '202cb962ac59075b964b07152d234b70', 'selenadoe345@gmail.com', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:53:21.016.jpg', 10, 3, 0),
(12, 'john_wilson', '202cb962ac59075b964b07152d234b70', 'johnwilson@gmail.com', 'https://sharepixel.000webhostapp.com/users_images/2022-03-12 16:56:05.802.jpg', 2, 3, 0),
(13, 'suzan', '202cb962ac59075b964b07152d234b70', 'suzan@gmail.com', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 12:02:30.908.jpg', 5, 2, 0),
(14, 'annnuu136', '7940ab47468396569a906f75ff3f20ef', 'anuuuu1306@gmail.com', 'https://sharepixel.000webhostapp.com/users_images/2022-03-14 12:49:46.75.jpg', 2, 1, 0),
(15, 'priya123', '48467d2cc726e8847fbc51f5b0bdc1d1', 'priya@gmail.com', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', 3, 1, 0),
(16, 'jenny333', '202cb962ac59075b964b07152d234b70', 'jenny333@gmail.com', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', 2, 0, 0),
(17, 'issac_einstein', 'e99a18c428cb38d5f260853678922e03', 'issac@einstein.com', 'https://sharepixel.000webhostapp.com/users_images/2022-04-16 11:59:23.787.jpg', 1, 1, 0),
(18, 'albert_newton', 'e99a18c428cb38d5f260853678922e03', 'albert@newton.com', 'https://sharepixel.000webhostapp.com/users_images/2022-04-03 18:19:48.275.jpg', 2, 1, 0),
(19, 'vaishnavimanchanda', '5ca643b50d1e7892b291d30827329fd0', 'vaishnavi.manchanda.vm@gmail.com', 'https://sharepixel.000webhostapp.com/users_images/2022-04-21 13:15:53.021.jpg', 0, 7, 0),
(20, 'charles', '202cb962ac59075b964b07152d234b70', 'charles@gmail.com', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', 0, 1, 0),
(21, 'charlie', '202cb962ac59075b964b07152d234b70', 'charlie@gmail.com', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', 0, 1, 0),
(22, 'charlie123', '202cb962ac59075b964b07152d234b70', 'charlie133@gmail.com', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', 0, 1, 0),
(23, 'charlie9', '202cb962ac59075b964b07152d234b70', 'charlie9@gmail.com', 'https://sharepixel.000webhostapp.com/users_images/2022-04-22 01:57:29.733.jpg', 0, 2, 0),
(24, 'charlie5', '202cb962ac59075b964b07152d234b70', 'charlie_dem@gmail.com', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', 0, 1, 0),
(25, 'james', '202cb962ac59075b964b07152d234b70', 'char@gmail.com', 'https://sharepixel.000webhostapp.com/users_images/2022-04-17 08:41:56.722.jpg', 0, 2, 0),
(26, 'james6', '202cb962ac59075b964b07152d234b70', 'james6@gmail.com', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', 0, 0, 0),
(27, 'james7', '202cb962ac59075b964b07152d234b70', 'james7@gmail.com', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', 0, 0, 0),
(28, 'p.r', '202cb962ac59075b964b07152d234b70', 'p@gmail.com', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', 0, 0, 0),
(29, 'PO', '202cb962ac59075b964b07152d234b70', 'pggg@gmail.com', 'http://mifo.000webhostapp.com/users_images/default_image.jpg', 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `following`
--
ALTER TABLE `following`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `likes`
--
ALTER TABLE `likes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stories`
--
ALTER TABLE `stories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;

--
-- AUTO_INCREMENT for table `following`
--
ALTER TABLE `following`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `images`
--
ALTER TABLE `images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT for table `likes`
--
ALTER TABLE `likes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `reports`
--
ALTER TABLE `reports`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `stories`
--
ALTER TABLE `stories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
