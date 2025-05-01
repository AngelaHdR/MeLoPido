DROP DATABASE IF EXISTS melopido;
CREATE DATABASE IF NOT EXISTS melopido;
USE melopido;

CREATE TABLE `chats` (
  `id_chat` int NOT NULL AUTO_INCREMENT,
  `id_product` int DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_chat`),
  UNIQUE KEY `id_product` (`id_product`)
)

CREATE TABLE `groups_detail` (
  `id_group` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `theme` enum('3_wise_men','birthday','secret_santa','general') NOT NULL,
  `description` text,
  PRIMARY KEY (`id_group`)
)

CREATE TABLE `letters` (
  `id_letter` int NOT NULL AUTO_INCREMENT,
  `description` text NOT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `send_date` timestamp NULL DEFAULT NULL,
  `expiration_date` timestamp NULL DEFAULT NULL,
  `id_user` int DEFAULT NULL,
  `id_group` int DEFAULT NULL,
  PRIMARY KEY (`id_letter`)
)

CREATE TABLE `messages` (
  `id_message` int NOT NULL AUTO_INCREMENT,
  `send_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `content` text NOT NULL,
  `id_chat` int DEFAULT NULL,
  `sender` int DEFAULT NULL,
  PRIMARY KEY (`id_message`)
)

CREATE TABLE `products` (
  `id_product` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `detail` text NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `state` enum('available','reserved','delivered') DEFAULT 'available',
  `assigned_to` int DEFAULT NULL,
  `id_letter` int DEFAULT NULL,
  PRIMARY KEY (`id_product`)
)

CREATE TABLE `user_group` (
  `id_user` int NOT NULL,
  `id_group` int NOT NULL,
  PRIMARY KEY (`id_user`,`id_group`)
)

CREATE TABLE `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname1` varchar(50) NOT NULL,
  `surname2` varchar(50) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `birth_date` date NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`)
)
