create database gestorclientes;
use gestorclientes;

-- Tabla de Clientes
CREATE TABLE Clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    email VARCHAR(255)
);

-- Tabla de Direcciones
CREATE TABLE Direcciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    clienteId INT,
    direccion VARCHAR(255),
    ciudad VARCHAR(255),
    codigoPostal VARCHAR(10),
    FOREIGN KEY (clienteId) REFERENCES Clientes(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
