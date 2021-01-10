-- /////////////////////////////////////////////////////////////////////////////////////////////////////
-- //////PRODUCTOS DE INTERNET DE LAS COSAS, DOMOTICA, INDUSTRIAL,ETC//////////////////////////////////
-- ////////////////////////////////////////////////////////////////////////////////////////////////////

use iot_productos;


insert into especificaciones_tecnicas(id, longitud, 
ancho, peso, material,voltaje_de_funcionamiento, voltaje_min_entrada,
 voltaje_max_entrada, tiempo_de_vida)values
 
 (1 ,  120.0 , 100.0 , 0.880, 'Plastico PLA' , 5.0, 7.0, 12.0 , 10),
 (2 ,  100.0 , 85.0 , 0.668, 'Aluminio', 5.0, 7.0, 12.0 , 12),
 (3 , 200.0 , 165.0 , 1.200, 'Aluminio' , 12.0, 12.0, 24.0 , 28),
 (4 ,  140.0 , 100.0 , 0.700, 'Fibra de Carbono' , 12.0, 12.0, 24.0 , 50),
 (5 ,  1400.0 , 900.0 , 2.400, 'Plastico PLA' , 12.0, 12.0, 24.0 , 50), -- Posee un nucleo de procesamiento(ej)
 (6 ,  1200.0 , 700.0 , 1.800, 'Plastico Reforzado' , 12.0, 12.0, 24.0 , 50);
 
 
 
insert into productos(id, id_especificacion_tecnica, area,funcion,tipo,nombre,modelo,tamaño,precio,estado) values
(1, 1, 'Domotica','Sensado','Alarma','SecurityHouse','mtp01','Pequeño',20.0,'Disponible'),
(2, 2, 'Domotica','Sensado','Alarma','SecurityHouse','mtp02','Pequeño' ,22.0,'Disponible'),
(3, 3, 'Industrial','Sensado','Alarma','SecurityIndustrial','ssp01','Mediano' , 30.0,'Disponible'),
(4, 4, 'Industrial','Sensado','Alarma','SecurityIndustrial','ssp02', 'Mediano' ,32.0,'No disponible'),
(5, 5, 'Telecomunicaciones','Control','Rack','IntelligenceRack','rzp01', 'Grande' ,30.0,'Disponible'),
(6, 6, 'Telecomunicaciones','Control','Rack','IntelligenceRack','rzp02', 'Grande' ,34.0,'No Disponible');


insert into vendedores(id, nombre, apellido, edad, nro_documento, telefono, email)values
(1, 'Javier', 'Perez', 26,39265145,1548964796, 'javierPerez@hotmail.com'),
(2, 'Martin', 'Caceres', 36,65412478,1558632589, 'elmatin23@hotmail.com'),
(3, 'Gimena', 'Gonzalez', 21,56987145,1531231231, 'lagime98@hotmail.com'),
(4, 'Lucia', 'Pereira', 36,69369784,1585962145, 'luciP45@hotmail.com');

insert into compradores(id, nombre, apellido, email)values
(1, 'Alvaro', 'Lafrench', 'alvarito@gmail.com'),
(2, 'Gustavo', 'Sanchez', 'gusta98@gmail.com'),
(3, 'Ramiro', 'Caceres', 'rami78@gmail.com'),
(4, 'Lorena', 'Martinez', 'lore90@gmail.com');

insert into ventas(id, id_producto, id_vendedor, id_comprador, cantidad, fecha_de_venta, detalle)values
(1, 1, 1, 1, 1, now(), 'Se vendio una alarma security house modelo mtp01'),
(2, 2, 1, 2, 2, now(), 'Se vendieron dos alarmas security house modelo mtp02'),
(3, 3, 2, 2, 4, now(), 'Se vendieron cuatro alarmas security industrial modelo ssp01'),
(4, 6, 4, 4, 1, now(), 'Se vendio un rack de telecomunicaciones modelo rzp02');

