CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) PRIMARY KEY NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS `authorities` (
  `id` int(11) PRIMARY KEY NOT NULL,
  `username` varchar(255) NOT NULL,
  `authority` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `posts` (
  `id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `status` varchar(10) NOT NULL,
  `created_at` DATETIME NOT NULL,
  `updated_at` DATETIME NOT NULL,
  `deadline` DATETIME NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;