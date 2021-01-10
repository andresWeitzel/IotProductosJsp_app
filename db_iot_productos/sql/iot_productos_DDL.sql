-- /////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////PRODUCTOS DE INTERNET DE LAS COSAS, DOMOTICA, INDUSTRIAL,ETC//////////////////////////////////
-- ////////////////////////////////////////////////////////////////////////////////////////////////////

drop database if exists iot_productos;

create database iot_productos;

use iot_productos;

drop table  if exists especificaciones_tecnicas;
drop table  if exists productos; 
drop table  if exists vendedores;
drop table  if exists compradores;
drop table  if exists ventas;
   


create table especificaciones_tecnicas(
	id 				int 		auto_increment primary key,
    longitud		float(15)		not null,-- 69.0 mm
    ancho			float(15)		not null,-- 56.7 mm
    peso			float(15)		not null,-- 0.8 kilos
    material		varchar(25)		not null,-- acero, plastico, etc
    voltaje_de_funcionamiento			float(8)		not null, -- 5 voltios
    voltaje_min_entrada				float(8)		not null,-- 7  voltios (recomendado)
    voltaje_max_entrada				float(8)		not null,-- 12  voltios (recomendado)
    tiempo_de_vida	int(25)		not null-- 2 años


);

create table productos(
	id 				int 		auto_increment primary key,
    id_especificacion_tecnica int		not null,
    constraint 		fk_id_especificacion_tecnica		foreign key(id_especificacion_tecnica) references especificaciones_tecnicas(id),
	area			varchar(35)		not null, -- Industrial, domestico, etc
    funcion			varchar(35)		not null, -- Sensado, control,etc
    tipo			varchar(35)		not null,-- Sensor, tablero, medidor, actuador, modulo, etc
	nombre			varchar(25)		not null,
    modelo			varchar(25)		not null,
    tamaño			varchar(15)		not null,-- pequeño, mediano, grande
	precio			float(5)		not null,-- dolares
	estado			varchar(35)		not null-- Disponible, vendido, agotado, etc

);



create table vendedores(
id				int 		auto_increment primary key,
nombre			varchar(25)	 not null,
apellido		varchar(25)		not null,
edad			int(25)		not null,
nro_documento	int(25)		not null,
telefono		int(25)		not null,
email			varchar(35)		not null

);

create table compradores(
id				int 		auto_increment primary key,
nombre			varchar(25)	 not null,
apellido		varchar(25)		not null,
telefono		int(25)		,
email			varchar(25)		not null

);

create table ventas(

	id 				int 		auto_increment primary key,
	id_producto		int 		not null,
    id_vendedor		int			not null,
    id_comprador		int			not null,
	constraint 		fk_id_producto_vendido 	foreign key(id_producto) references productos(id),
	constraint 		fk_id_vendedor 	foreign key(id_vendedor) references vendedores(id),
    constraint 		fk_id_comprador 	foreign key(id_comprador) references compradores(id),
	cantidad		int,
    fecha_de_venta		DATETIME	not null,
    detalle			varchar(75)	

);
