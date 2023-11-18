CREATE DATABASE reto1;

CREATE TABLE Clientes(
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    cedula INT NOT NULL,
    nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
	fecha_nacimiento DATE NOT NULL,
    fecha_registro DATE NOT NULL
);

CREATE TABLE Juegos(
	id_juego INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    director VARCHAR(50) NOT NULL,
    protagonistas VARCHAR(50) NOT NULL,
    productor VARCHAR(50) NOT NULL,
    fecha_lanzamiento DATE NOT NULL,
    plataforma VARCHAR(50) NOT NULL
);

CREATE TABLE Precio_Alquiler(
	id_precio_alquiler INT PRIMARY KEY AUTO_INCREMENT,
    precio INT NOT NULL,
    fk_id_juego INT,
    FOREIGN KEY (fk_id_juego) REFERENCES Juegos(id_juego)
);

CREATE TABLE Alquiler(
	id_alquiler INT PRIMARY KEY AUTO_INCREMENT,
    fecha_alquiler DATE NOT NULL,
    periodo_alquiler DATE NOT NULL,
    fk_id_cliente INT,
    fk_id_juego INT,
    fk_id_precio_alquiler INT,
    FOREIGN KEY (fk_id_cliente) REFERENCES Clientes(id_cliente),
    FOREIGN KEY (fk_id_juego) REFERENCES Juegos(id_juego),
    FOREIGN KEY (fk_id_precio_alquiler) REFERENCES Precio_Alquiler(id_precio_alquiler)
);

