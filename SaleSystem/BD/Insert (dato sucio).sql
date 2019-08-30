USE SistemaVentas
GO

INSERT INTO cliente (Cedula, Nombre, Direccion, Estado) VALUES
('2', 'Juan Guerrero Solis', 'Los Alamos', '1'),
('1', 'Maria Rosas Villanueva', 'Los Laureles 234', '1'),
('3', 'Andres de Santa Cruz', 'Av. La Frontera 347', '1'),
('4', 'Andres Mendoza', 'Chosica, Lurigancho', '1');
GO

INSERT INTO empleado (Cedula, Nombre, Telefono, Estado, Usuario) VALUES
('123', 'Pedro Hernandez', '988252459', '1', 'emp01'),
('123', 'Roman Riquelme', '988252459', '1', 'Jo46'),
('123', 'Palermo Suarez', '453536458', '1', 'Em22');
GO

INSERT INTO producto (Descripcion, Precio, Stock, Estado) VALUES
('Teclado Logitech 345 Editado', 150, 99, '1'),
('Mouse Logitech 567', 20, 98, '1'),
('Laptop Lenovo Ideapad 520', 800, 100, '1'),
('HeadPhones Sony M333', 500, 98, '1'),
('Producto Nuevo w', 22, 35, '1');
GO