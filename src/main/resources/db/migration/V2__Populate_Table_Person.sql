<<<<<<< HEAD
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
=======
INSERT INTO person (id, address, first_name, gender, last_name) VALUES
(1, 'Sao Paulo - Brasil', 'Ayrton', 'Male', 'Senna'),
(2, 'Anchiano - Italy', 'Leonardo', 'Male', 'da Vinci'),
(4, 'Porbandar - India', 'Indira', 'Female', 'Gandhi'),
(5, 'Porbandar - India', 'Mahatma', 'Male', 'Gandhi'),
(7, 'Kentucky - US', 'Muhamamd', 'Male', 'Ali'),
(9, 'Mvezo - South Africa', 'Nelson', 'Male', 'Mandela'),
(10, 'Mvezo - South Africa', 'Nelson', 'Male', 'Mandela'),
(11, 'Smiljan - Croatia', 'Nikola', 'Male', 'Tesla'),
(12, 'Smiljan - Croatia', 'Nikola', 'Male', 'Tesla');
>>>>>>> 4c8ad5d (feat: 12 - Custom JSON Serialization)
