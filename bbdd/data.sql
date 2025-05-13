USE melopido;

INSERT INTO `chats` VALUES
(1,1,'2025-02-25 10:00:00'),
(2,4,'2025-10-08 12:05:00'),
(3,7,'2025-09-24 15:08:00');

INSERT INTO `groups_detail` VALUES
(1,'Reyes Familia Ortiz','star','3_wise_men','Regalos de reyes de la familia Ortiz'),
(2,'Cumples Romero','heart','birthday','Celebraciones de cumple de la familia Romero');

INSERT INTO `letters` VALUES
(1,'Querida familia mi cumple se acerca y os dejo unas ideas de regalos','2025-02-02 23:00:00','2025-02-14 23:00:00','2025-05-19 22:00:00',1,2),
(2,'Queridos reyes magos, para estas navidades quiero los siguientes regalos','2025-09-11 22:00:00','2025-09-28 22:00:00','2026-01-14 23:00:00',2,1),
(3,'Para mi cumple propongo las siguientes opciones','2025-04-06 22:00:00',NULL,NULL,3,NULL),
(4,'Estimados reyes magos, aqui teneis algunas ideas','2025-08-24 22:00:00','2025-09-14 22:00:00','2026-01-17 23:00:00',4,1);

INSERT INTO `messages` VALUES
(1,'2025-02-25 10:03:00','¡Hola Maria! ¿Prefieres un libro tipo Sherlock Holmes o algo más moderno?',1,3),
(2,'2025-02-25 10:06:45','Hola, me encanta el estilo clásico como Holmes',1,1),
(3,'2025-10-08 12:08:00','Ana, ¿quieres que el smartwatch tenga también pulsómetro o solo GPS y música?',2,4),
(4,'2025-10-08 12:10:15','Con GPS y música es suficiente. Que sea resistente al agua si puede ser',2,2),
(5,'2025-09-24 15:10:00','Carla, ¿prefieres la mochila en algún color específico?',3,2),
(6,'2025-09-24 15:13:40','En verde militar o azul oscuro estaría genial. ¡Gracias!',3,4);

INSERT INTO `products` VALUES
(1,'Libro de misterio','Parecido a Sherlock Holmes o novela negra','http://lacasadellibro.com','reserved',3,1),
(2,'Puzzle 3D de ciudad','Edificio famoso o skyline en 3D, mínimo 1000 piezas','http://puzzleshop.com','available',NULL,1),
(3,'Cargador portatil solar','Al menos 2 cargas y carga solar','http://amazon.com','available',NULL,2),
(4,'Smartwatch','Con GPS y musica',NULL,'reserved',4,2),
(5,'Sudadera personalizada','Con diseño friki o personalizado','http://etsy.com','available',NULL,3),
(6,'Auriculares bluetooth','Pequeños, con cancelación de ruido',NULL,'available',NULL,3),
(7,'Mochila de senderismo 30L','Con chubasquero y sujeciones','http://decathlon.com','delivered',2,4),
(8,'Juego de mesa cooperativo','Ideal para jugar en familia, estilo Codenames o Dixit','http://juegosdemesa.com','available',NULL,4);

INSERT INTO `user_group` VALUES
(1,2),
(2,1),
(3,2),
(4,1);

INSERT INTO `users` VALUES
(1,'Maria','Lopez','Romero','maria_lop@example.com','1990-05-10','mariaLo','mariaPass123'),
(2,'Ana','Ortiz','Gomez','ana_ort@example.com','1995-08-02','ana_02','anaPass123'),
(3,'Lucas','Romero','Perez','lucas_fer@example.com','2001-11-25','lucas_fer','lucasPass123'),
(4,'Carla','Ortiz','Mulero','carla_ort@example.com','1999-04-12','carla_99','carlaPass123');
