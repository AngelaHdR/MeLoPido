USE melopido;

-- Insert Users
INSERT INTO users (id_user, name, surname1, surname2, email, birth_date, username, password) VALUES
('1','Maria','Lopez','Romero','maria_lop@example.com','1990-05-10','mariaLo','mariaPass123'),
('2','Ana','Ortiz','Gomez','ana_ort@example.com','1995-08-02','ana_02','anaPass123'),
('3','Lucas','Romero','Perez','lucas_fer@example.com','2001-11-25','lucas_fer','lucasPass123'),
('4','Carla','Ortiz','Mulero','carla_ort@example.com','1999-04-12','carla_99','carlaPass123');

-- Insert Groups
INSERT INTO groups_detail (id_group, name, icon, theme, description) VALUES
('1','Reyes Familia Ortiz','star','3_wise_men','Regalos de reyes de la familia Ortiz'),
('2','Cumples Romero','heart','birthday','Celebraciones de cumple de la familia Romero');

-- Insert User-Group Relationships
INSERT INTO user_group (id_user, id_group) VALUES
('1','2'),
('2','1'),
('3','2'),
('4','1');

-- Insert Letters
INSERT INTO letters (id_letter, description, creation_date, send_date, expiration_date, id_user, id_group) VALUES
('1','Querida familia mi cumple se acerca y os dejo unas ideas de regalos','2025-02-02 23:00:00','2025-02-14 23:00:00','2025-05-19 22:00:00','1','2'),
('2','Queridos reyes magos, para estas navidades quiero los siguientes regalos','2025-09-11 22:00:00','2025-09-28 22:00:00','2026-01-14 23:00:00','2','1'),
('3','Para mi cumple propongo las siguientes opciones','2025-04-06 22:00:00',NULL,NULL,'3',NULL),
('4','Estimados reyes magos, aqui teneis algunas ideas','2025-08-24 22:00:00','2025-09-14 22:00:00','2026-01-17 23:00:00','4','1');

-- Insert Products
INSERT INTO products (id_product, name, detail, url, state, assigned_to, id_letter) VALUES
('1','Libro de misterio', 'Parecido a Sherlock Holmes o novela negra', 'http://lacasadellibro.com', 'reserved', 3, 1), -- Carta: Maria, Grupo: Cumples Romero
('2','Puzzle 3D de ciudad', 'Edificio famoso o skyline en 3D, mínimo 1000 piezas', 'http://puzzleshop.com', 'available', NULL, 1), -- Carta: Maria, Grupo: Cumples Romero
('3','Cargador portatil solar', 'Al menos 2 cargas y carga solar', 'http://amazon.com', 'available', NULL, 2), -- Carta: Ana, Grupo: Reyes Familia Ortiz
('4','Smartwatch', 'Con GPS y musica', NULL, 'reserved', 4, 2), -- Carta: Ana, Grupo: Reyes Familia Ortiz
('5','Sudadera personalizada', 'Con diseño friki o personalizado', 'http://etsy.com', 'available', NULL, 3), -- Carta: Lucas, Grupo: Cumples Romero
('6','Auriculares bluetooth', 'Pequeños, con cancelación de ruido', NULL, 'available', NULL, 3), -- Carta: Lucas, Grupo: Cumples Romero
('7','Mochila de senderismo 30L', 'Con chubasquero y sujeciones', 'http://decathlon.com', 'delivered', 2, 4), -- Carta: Carla, Grupo: Reyes Familia Ortiz
('8','Juego de mesa cooperativo', 'Ideal para jugar en familia, estilo Codenames o Dixit', 'http://juegosdemesa.com', 'available', NULL, 4); -- Carta: Carla, Grupo: Reyes Familia Ortiz


-- Insert Chats
INSERT INTO chats (id_chat, id_product, creation_date) VALUES
('1','1', '2025-02-25 11:00:00'),  -- Producto: Libro de misterio
('2','4', '2025-10-08 14:05:00'), -- Producto: Smartwatch
('3','7', '2025-09-24 17:08:00'); -- Producto: Mochila senderismo

-- Insert Messages
INSERT INTO messages (id_message, id_chat, sender, content, send_date) VALUES
('1','1', '3', '¡Hola Maria! ¿Prefieres un libro tipo Sherlock Holmes o algo más moderno?', '2025-02-25 11:03:00'), -- Chat: Maria, Lucas, Regalo: Maria
('2','1', '1', 'Hola, me encanta el estilo clásico como Holmes', '2025-02-25 11:06:45'), -- Chat: Maria, Lucas, Regalo: Maria
('3','2', '4', 'Ana, ¿quieres que el smartwatch tenga también pulsómetro o solo GPS y música?', '2025-10-08 14:08:00'), -- Chat: Ana, Carla, Regalo: Ana
('4','2', '2', 'Con GPS y música es suficiente. Que sea resistente al agua si puede ser', '2025-10-08 14:10:15'), -- Chat: Ana, Carla, Regalo: Ana
('5','3', '2', 'Carla, ¿prefieres la mochila en algún color específico?', '2025-09-24 17:10:00'), -- Chat: Ana, Carla, Regalo: Carla
('6','3', '4', 'En verde militar o azul oscuro estaría genial. ¡Gracias!', '2025-09-24 17:13:40'); -- Chat: Ana, Carla, Regalo: Carla