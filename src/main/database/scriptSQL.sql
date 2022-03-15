CREATE DATABASE  IF NOT EXISTS `paymybuddy`;
USE `paymybuddy`;

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` int NOT NULL,
  `receiver_id` bigint DEFAULT NULL,
  `sender_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKey21a233t8tlwfsbs228q3b2u` (`receiver_id`),
  KEY `FKjpter5yuohdb58gyg6k5nympt` (`sender_id`),
  CONSTRAINT `FKey21a233t8tlwfsbs228q3b2u` FOREIGN KEY (`receiver_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjpter5yuohdb58gyg6k5nympt` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `transaction` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `balance` double NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `user_friends`;
CREATE TABLE `user_friends` (
  `user_id` bigint NOT NULL,
  `friends_id` bigint NOT NULL,
  UNIQUE KEY `UK_bbrnh12js1l8culgfpipyat29` (`friends_id`),
  KEY `FK9i7cldnk7cx2g47qex8ovm2ah` (`user_id`),
  CONSTRAINT `FK9i7cldnk7cx2g47qex8ovm2ah` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKe1jhkryq5denjdrjngi7lj9h4` FOREIGN KEY (`friends_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user_friends` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `user_transactions`;

CREATE TABLE `user_transactions` (
  `user_id` bigint NOT NULL,
  `transactions_id` bigint NOT NULL,
  UNIQUE KEY `UK_k12ybnbbgjjr7jr9d2831xoua` (`transactions_id`),
  KEY `FK7ow9tl4pncou0lojsgqej6sce` (`user_id`),
  CONSTRAINT `FK7ow9tl4pncou0lojsgqej6sce` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKli5uya1wifm860dqhjke7kyuj` FOREIGN KEY (`transactions_id`) REFERENCES `transaction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `user_transactions` WRITE;

UNLOCK TABLES;