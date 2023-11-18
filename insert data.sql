INSERT INTO clientes (cedula, nombre, apellido, fecha_nacimiento, fecha_registro)
VALUES
	(123456, 'Juan', 'Perez', '1990-05-15', '2022-01-01'),
	(789012, 'Maria', 'Rodriguez', '1985-08-22', '2022-02-05'),
	(345678, 'Carlos', 'Sanchez', '1998-11-10', '2022-03-12'),
	(901234, 'Laura', 'Gomez', '1982-04-28', '2022-04-18'),
	(567890, 'Javier', 'Hernandez', '1995-07-03', '2022-05-25'),
	(234567, 'Ana', 'Martinez', '1987-09-17', '2022-06-30'),
	(890123, 'Oscar', 'Torres', '1993-02-09', '2022-07-07'),
	(456789, 'Silvia', 'Diaz', '1980-12-01', '2022-08-14'),
	(012345, 'Daniel', 'Ramirez', '1991-06-20', '2022-09-20');
    

INSERT INTO Juegos (nombre, director, protagonistas, productor, fecha_lanzamiento, plataforma)
VALUES
	('The Legend of Adventure', 'John Smith', 'Alice Johnson, Bob Davis', 'Game Studios', '2022-01-15', 'PC'),
	('Galactic Explorers', 'Emily White', 'Chris Turner, Jessica Lee', 'Space Games Inc.', '2022-03-20', 'Xbox'),
	('Epic Quest', 'Michael Brown', 'Sophia Clark, David Miller', 'Adventure Studios', '2022-05-10', 'PlayStation'),
	('Cyber Nexus', 'Amanda Taylor', 'Ryan Wilson, Emma Garcia', 'Tech Entertainment', '2022-07-05', 'PC'),
	('Mystic Realm', 'Brian Johnson', 'Olivia Walker, Ethan Martinez', 'Fantasy Games Ltd.', '2022-09-12', 'PlayStation'),
	('Speed Rivals', 'Sarah Davis', 'Alex Turner, Lily Johnson', 'Racing Studios', '2022-11-08', 'Xbox'),
	('Zombie Apocalypse', 'Daniel Miller', 'Mia Turner, Jake Davis', 'Horror Games Inc.', '2023-01-25', 'PC'),
	('Galactic Warfare', 'Laura Anderson', 'Mark Turner, Chloe White', 'Space Games Inc.', '2023-03-15', 'Xbox'),
	('Fantasy Kingdom', 'Chris Harris', 'Sophie White, Matthew Turner', 'Fantasy Games Ltd.', '2023-05-20', 'PlayStation'),
	('Future Shooter', 'Jennifer Wilson', 'Nathan Davis, Zoe Turner', 'Tech Entertainment', '2023-07-10', 'PC');
    
INSERT INTO precio_alquiler (id_precio_alquiler, precio, fk_id_juego)
VALUES
	(1, 150000, 1),
	(2, 200000, 2),
	(3, 180000, 3),
	(4, 250000, 4),
	(5, 220000, 5),
	(6, 300000, 6),
	(7, 170000, 7),
	(8, 280000, 8),
	(9, 210000, 9);
    
INSERT INTO alquiler (id_alquiler, fecha_alquiler, periodo_alquiler, fk_id_cliente, fk_id_juego, fk_id_precio_alquiler)
VALUES
	(2, '2023-02-05', '2023-07-12', 4, 2, 2),
	(3, '2023-03-10', '2023-04-17', 5, 3, 3),
	(4, '2023-04-18', '2023-08-25', 6, 4, 4),
	(5, '2023-05-23', '2023-06-30', 7, 5, 5),
	(6, '2023-06-28', '2023-07-05', 8, 6, 6),
	(7, '2023-07-15', '2023-08-22', 9, 7, 7),
	(8, '2023-08-20', '2023-09-27', 10, 8, 8),
	(9, '2023-09-25', '2023-10-02', 11, 9, 9),
	(10, '2023-10-30', '2023-11-06', 12, 10, 11),
	(11, '2023-11-12', '2023-12-19', 3, 1, 1),
	(12, '2023-12-18', '2024-01-25', 4, 2, 2),
	(13, '2024-01-22', '2024-05-29', 5, 3, 3),
	(14, '2024-02-26', '2024-07-04', 6, 4, 4),
	(15, '2024-03-10', '2024-08-17', 7, 5, 5),
	(16, '2024-04-15', '2024-05-22', 8, 6, 6),
	(17, '2024-05-20', '2024-09-27', 9, 7, 7),
	(18, '2024-06-25', '2024-10-02', 10, 8, 8),
	(19, '2024-07-30', '2024-10-06', 11, 9, 9),
	(20, '2024-08-15', '2024-09-22', 12, 10, 4),
	(21, '2024-09-02', '2024-09-09', 3, 2, 2),
	(22, '2024-10-05', '2024-10-12', 4, 5, 5);

SELECT * FROM precio_alquiler;
SELECT * FROM clientes;
SELECT * FROM juegos;
SELECT * FROM alquiler;
