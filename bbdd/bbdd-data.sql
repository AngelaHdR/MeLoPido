-- Selecciona la base de datos
USE melopido;

-- Inserta Usuarios
INSERT INTO users (id_user, name, surname1, surname2, email, birth_date, username, password) VALUES
('1','Maria','Lopez','Romero','maria_lop@example.com','1990-05-10','mariaLo','mariaPass123'),
('2','Ana','Ortiz','Gomez','ana_ort@example.com','1995-08-02','ana_02','anaPass123'),
('3','Lucas','Romero','Perez','lucas_fer@example.com','2001-11-25','lucas_fer','lucasPass123'),
('4','Carla','Ortiz','Mulero','carla_ort@example.com','1999-04-12','carla_99','carlaPass123'),
('5','Luis','Senderos','','luis_senderos@example.com','1988-03-15','luis_s','luisPass123'),
('6','Clara','Montaña','','clara_montana@example.com','1992-07-22','clara_m','claraPass123'),
('7','Carlos','Senderos','','carlos_senderos@example.com','1985-11-30','carlos_s','carlosPass123');

-- Inserta Grupos
INSERT INTO groups_detail (id_group, name, icon, theme, description) VALUES
('1','Reyes Familia Ortiz','fa-solid fa-face-smile','3_wise_men','Regalos de reyes de la familia Ortiz'),
('2','Cumples Romero','fa-solid fa-heart','birthday','Celebraciones de cumple de la familia Romero'),
('4','Amigos del Senderismo','fa-solid fa-hiking','outdoor','Grupo para organizar actividades de senderismo'),
('5','Navidad en Familia','fa-solid fa-gift','christmas','Regalos de navidad en familia');

-- Inserta Relaciones Usuario-Grupo
INSERT INTO user_group (id_user, id_group) VALUES
('1','1'), -- Maria en Reyes Familia Ortiz
('1','2'), -- Maria en Cumples Romero
('2','1'), -- Ana en Reyes Familia Ortiz
('2','4'), -- Ana en Amigos del Senderismo
('2','5'), -- Ana en Navidad en Familia
('3','4'), -- Lucas en Amigos del Senderismo
('4','4'), -- Carla en Amigos del Senderismo
('5','4'); -- Luis en Amigos del Senderismo

-- Inserta Cartas
INSERT INTO letters (id_letter, description, creation_date, send_date, expiration_date, id_user, id_group) VALUES
('1','Querida familia mi cumple se acerca y os dejo unas ideas de regalos','2025-02-02 23:00:00','2025-02-14 23:00:00','2025-05-19 22:00:00','1','2'),
('2','Queridos reyes magos, para estas navidades quiero los siguientes regalos','2025-09-11 22:00:00','2025-09-28 22:00:00','2026-01-14 23:00:00','2','1'),
('3','Rutas recomendadas para principiantes','2025-09-05 00:00:00','2025-09-15 00:00:00','2025-12-31 00:00:00','5','4'),
('4','Estimados reyes magos, aqui teneis algunas ideas','2025-08-24 22:00:00','2025-09-14 22:00:00','2026-01-17 23:00:00','4','1');
INSERT INTO letters (id_letter, description, creation_date, send_date, expiration_date, id_user, id_group) VALUES
('5', 'Ideas para la próxima ruta de senderismo', '2025-10-01 10:00:00', '2025-10-05 10:00:00', '2026-01-01 00:00:00', '3', '4'), -- Lucas
('6', 'Material recomendado para rutas nocturnas', '2025-10-10 12:00:00', '2025-10-15 12:00:00', '2026-02-01 00:00:00', '6', '4'), -- Clara
('7', 'Propuestas para escapada de fin de semana', '2025-10-20 09:00:00', '2025-10-25 09:00:00', '2026-03-01 00:00:00', '7', '4'); -- Carlos

-- Inserta Productos (todos con id numérico)
-- ...existing code...
INSERT INTO products (id_product, name, detail, url, state, assigned_to, id_letter) VALUES
('1','Libro de misterio', 'Parecido a Sherlock Holmes o novela negra', 'http://lacasadellibro.com', 'reserved', 3, 1),
('2','Puzzle 3D de ciudad', 'Edificio famoso o skyline en 3D, mínimo 1000 piezas', 'http://puzzleshop.com', 'available', NULL, 1),
('3','Cargador portatil solar', 'Al menos 2 cargas y carga solar', 'http://amazon.com', 'available', NULL, 2),
('4','Smartwatch', 'Con GPS y musica', NULL, 'reserved', 4, 2),
('5','Sudadera personalizada', 'Con diseño friki o personalizado', 'http://etsy.com', 'available', NULL, 3),
('6','Auriculares bluetooth', 'Pequeños, con cancelación de ruido', NULL, 'available', NULL, 3),
('7','Mochila de senderismo 30L', 'Con chubasquero y sujeciones', 'http://decathlon.com', 'delivered', 2, 4),
('8','Juego de mesa cooperativo', 'Ideal para jugar en familia, estilo Codenames o Dixit', 'http://juegosdemesa.com', 'available', NULL, 4),
('9','Botas de senderismo', 'Botas impermeables para largas caminatas', 'http://example.com/botas', 'reserved', 2, 3),
('10','Bastones de trekking', 'Bastones ajustables de aluminio', 'http://example.com/bastones', 'available', NULL, 3),
('11','Linterna frontal recargable', 'Linterna LED con batería recargable', 'http://example.com/linterna', 'delivered', 4, 3);
-- Productos para la carta de Lucas (id_letter = 5)
INSERT INTO products (id_product, name, detail, url, state, assigned_to, id_letter) VALUES
('12', 'Mapa topográfico', 'Mapa detallado de la zona de la próxima ruta', 'http://example.com/mapa', 'available', NULL, 5),
('13', 'Botella térmica', 'Botella de acero inoxidable, 1L', 'http://example.com/botella', 'reserved', 4, 5),
('14', 'Camiseta transpirable', 'Talla M, color azul', NULL, 'available', NULL, 5);

-- Productos para la carta de Clara (id_letter = 6)
INSERT INTO products (id_product, name, detail, url, state, assigned_to, id_letter) VALUES
('15', 'Linterna ultraligera', 'Linterna LED para cabeza, resistente al agua', 'http://example.com/linterna2', 'available', NULL, 6),
('16', 'Batería externa', 'Powerbank 20.000mAh', 'http://example.com/powerbank', 'reserved', 2, 6),
('17', 'Chaleco reflectante', 'Chaleco de alta visibilidad para senderismo nocturno', NULL, 'available', NULL, 6);

-- Productos para la carta de Carlos (id_letter = 7)
INSERT INTO products (id_product, name, detail, url, state, assigned_to, id_letter) VALUES
('18', 'Saco de dormir ligero', 'Saco de dormir para 0ºC, compacto', 'http://example.com/saco', 'available', NULL, 7),
('19', 'Kit de cocina portátil', 'Set de cocina para camping, incluye hornillo', 'http://example.com/kitcocina', 'delivered', 5, 7),
('20', 'Gafas de sol polarizadas', 'Protección UV400, color negro', NULL, 'reserved', 6, 7);
-- Inserta Chats
INSERT INTO chats (id_chat, id_product, creation_date) VALUES
('1','1', '2025-02-25 11:00:00'),
('2','4', '2025-10-08 14:05:00'),
('3','7', '2025-09-24 17:08:00');

-- Inserta Mensajes
INSERT INTO messages (id_message, id_chat, sender, content, send_date) VALUES
('1','1', '3', '¡Hola Maria! ¿Prefieres un libro tipo Sherlock Holmes o algo más moderno?', '2025-02-25 11:03:00'),
('2','1', '1', 'Hola, me encanta el estilo clásico como Holmes', '2025-02-25 11:06:45'),
('3','2', '4', 'Ana, ¿quieres que el smartwatch tenga también pulsómetro o solo GPS y música?', '2025-10-08 14:08:00'),
('4','2', '2', 'Con GPS y música es suficiente. Que sea resistente al agua si puede ser', '2025-10-08 14:10:15'),
('5','3', '2', 'Carla, ¿prefieres la mochila en algún color específico?', '2025-09-24 17:10:00'),
('6','3', '4', 'En verde militar o azul oscuro estaría genial. ¡Gracias!', '2025-09-24 17:13:40');