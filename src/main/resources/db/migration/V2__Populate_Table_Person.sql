  CREATE TABLE IF NOT EXISTS `person`(
  `id` bigint (20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar (100) NOT NULL,
  `last_name` varchar (80) NOT NULL,
   `address` varchar(100) NOT NULL,
  `gender` varchar (6) NOT NULL,
  PRIMARY KEY (`id`)
       )

INSERT INTO `person` (`id`, `address`, `first_name`, `gender`, `last_name`, `birth_day`) VALUES
	(1, 'Teste', 'Marcos', 'Male', 'Senna', NULL),
	(2, 'Teste', 'Marcos', 'Male', 'Senna', NULL),
	(3, 'Teste', 'Marcos', 'Male', 'Senna', NULL),
	(4, 'Teste', 'Marcos', 'Male', 'Senna', NULL);