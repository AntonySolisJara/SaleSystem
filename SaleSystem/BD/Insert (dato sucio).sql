USE SistemaVentas
GO

INSERT INTO cliente (Cedula, Nombre, Telefono, Correo, Direccion, Estado) VALUES
('2', 'Juan Guerrero Solis', '987654', 'all@gmail.com', 'Los Alamos', '1'),
('1', 'Maria Rosas Villanueva', '6543213', 'all@gmail.com', 'Los Laureles 234', '1'),
('3', 'Andres de Santa Cruz', '1894198', 'all@gmail.com', 'Av. La Frontera 347', '1'),
('4', 'Andres Mendoza', '5465654', 'all@gmail.com', 'Chosica, Lurigancho', '1');
GO

INSERT INTO empleado (Cedula, Nombre, Telefono, Correo, Usuario, Contrasena, Estado) VALUES
('1237676', 'Pedro Hernandez', '988252459', 'all@gmail.com', 'emp01', '123', '1'),
('12378686', 'Roman Riquelme', '988252459', 'loud@hotmail.com', 'Jo46', '1234', '1'),
('12367868', 'Palermo Suarez', '453536458', 'tale@icloud.com', 'Em22', '12345', '1');
GO

INSERT INTO producto (Descripcion, Precio, Stock, Estado) VALUES
('Teclado Logitech 345 Editado', 150, 99, '1'),
('Mouse Logitech 567', 20, 98, '1'),
('Laptop Lenovo Ideapad 520', 800, 100, '1'),
('HeadPhones Sony M333', 500, 98, '1'),
('Producto Nuevo w', 22, 35, '1');
GO