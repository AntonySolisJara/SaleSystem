/****Creacion de la BD*****/
USE MASTER
GO

/*Validamos si la BD ya existe para eliminarla completamente*/
BEGIN
IF EXISTS(SELECT NAME FROM SYS.DATABASES WHERE NAME = 'SistemaVentas')
DROP DATABASE SistemaVentas
END

/*Creamos la BD desde cero*/
CREATE DATABASE SistemaVentas
PRINT 'La base de datos ha sido creada exitosamente'
GO

USE SistemaVentas
GO

/*No toma en cuenta Null*/
SET ANSI_NULLS ON
GO

/*Manejo de comillas*/
SET QUOTED_IDENTIFIER ON
GO

/*Uso de T-SQL (COMMIT Y ROLLBACK de Transact)*/
SET IMPLICIT_TRANSACTIONS OFF 
GO

/****Creacion de las Tablas****/
/*Creamos las Tablas y Campos*/
Create Table cliente
(
IdCliente int IDENTITY (1,1),
Cedula varchar(15) NOT NULL,
Nombre varchar(244) NOT NULL,
Direccion varchar(244) NOT NULL,
Estado varchar(1) NOT NULL
);
ALTER TABLE cliente ADD CONSTRAINT PK_SV_cliente PRIMARY KEY (IdCliente);
GO

Create Table empleado
(
IdEmpleado int IDENTITY (1,1),
Cedula varchar (8) NOT NULL,
Nombre varchar (255) NOT NULL,
Telefono varchar (11) NOT NULL,
Estado varchar (1) NOT NULL,
Usuario varchar(8) NULL
);
ALTER TABLE empleado ADD CONSTRAINT PK_SV_empleado	PRIMARY KEY (IdEmpleado);
GO

Create Table producto
(
IdProducto int IDENTITY (1,1),
Descripcion varchar(244) NOT NULL,
Precio decimal NOT NULL,
Stock int NOT NULL,
Estado varchar (1) NOT NULL
);
ALTER TABLE producto ADD CONSTRAINT PK_SV_producto PRIMARY KEY (IdProducto);
GO

Create Table ventas
(
IdVentas int IDENTITY (1,1),
IdCliente int NOT NULL,
IdEmpleado int NOT NULL,
NumeroSerie varchar(244) NOT NULL,
FechaVentas date NOT NULL,
Monto decimal NOT NULL,
Estado varchar(1) NOT NULL
);
ALTER TABLE ventas ADD CONSTRAINT PK_SV_ventas PRIMARY KEY (IdVentas);
ALTER TABLE ventas ADD CONSTRAINT FK_SV_ventasC	FOREIGN KEY (IdCliente) REFERENCES cliente(IdCliente);
ALTER TABLE ventas ADD CONSTRAINT FK_SV_ventasE	FOREIGN KEY (IdEmpleado) REFERENCES empleado(IdEmpleado);
GO

Create Table detalle_ventas
(
IdDetalleVentas	int IDENTITY (1,1),
IdVentas int NOT NULL,
IdProducto int NOT NULL,
Cantidad int NOT NULL,
PrecioVenta decimal NOT NULL
);
ALTER TABLE detalle_ventas ADD CONSTRAINT PK_SV_detalle_ventas	PRIMARY KEY (IdDetalleVentas);
ALTER TABLE detalle_ventas ADD CONSTRAINT FK_SV_detalle_ventasV	FOREIGN KEY (IdVentas) REFERENCES ventas(IdVentas);
ALTER TABLE detalle_ventas ADD CONSTRAINT FK_SV_detalle_ventasP	FOREIGN KEY (IdProducto) REFERENCES producto(IdProducto);
GO