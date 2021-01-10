
use iot_productos;

-- ====================INSERT===========================

-- especificaciones tecnicas
insert into especificaciones_tecnicas(longitud, 
ancho, peso, material, voltaje_de_funcionamiento, voltaje_min_entrada,
 voltaje_max_entrada, tiempo_de_vida)values
 
 ( 110.0 , 40.0 , 0.880, 'Fibra de Vidrio', 5.0, 7.0, 12.0 , 2),
 ( 120.0 , 65.0 , 0.668, 'Aluminio',5.0, 7.0, 12.0 , 6),
 (190.0 , 165.0 , 1.200, 'Aluminio', 12.0, 12.0, 24.0 , 28),
 ( 170.0 , 120.0 , 0.700, 'Fibra de Carbono', 12.0, 12.0, 24.0 , 50),
 ( 2400.0 , 600.1 , 2.400, 'Plastico PLA', 12.0, 12.0, 24.0 , 50), -- Posee un nucleo de procesamiento(ej)
 ( 3200.0 , 900.0 , 1.800, 'Plastico Reforzado', 12.0, 12.0, 24.0 , 50);
 
 
 -- productos
 insert into productos(id_especificacion_tecnica, area, funcion, tipo, nombre, modelo, tamaño
 , precio, estado) values
 
 (7, 'Domotica', 'Indicacion', 'Reloj', 'AlphaTime', 'rlj01', 'Pequeño', 10, 'Disponible'),
 (8, 'Domotica', 'Indicacion', 'Reloj', 'AlphaTimePlus', 'rlj02', 'Pequeño', 13, 'Disponible'),
 (9, 'Industrial', 'Sensado', 'Sensor de Temperatura', 'TemperatureSensor', 'tmp01', 'Mediano', 33, 'Disponible'),
 (10, 'Industrial', 'Sensado', 'Sensor de Temperatura', 'TemperatureSensor2.0', 'tmp02', 'Mediano', 39, 'Disponible'),
 (11, 'Telecomunicaciones', 'Control', 'Switch', 'IotSwitch1.0', 'swt01', 'Grande', 29, 'Disponible'),
 (12, 'Telecomunicaciones', 'Control', 'Switch', 'IotSwitch2.0', 'swt02', 'Grande', 39, 'Disponible');
 

 
 -- vendedores
 insert into vendedores(nombre, apellido, edad, nro_documento, telefono, email) values
 ('Miguel', 'Castro', 28, 56980789, 1145678765, 'migue@gmail.com' );

 
-- compradores
insert into compradores(nombre, apellido, telefono, email) values
('Romina', 'Contreras',1145678923, 'romina67@hotmail.com');

insert into compradores(nombre, apellido, email) values
('Martin','Alvarez','martin98@gmail.com'); 


-- ventas
insert into ventas( id_producto, id_vendedor, id_comprador, cantidad, fecha_de_venta, detalle)values
( 7, 3, 5, 1, now(), ''),
( 8, 3, 5, 1, now(), ''),
( 9, 5, 5, 4, now(), 'Se vendio un sensor de temperatura industrial'),
( 10, 5, 6, 1, now(), 'Se vendio un sensor de temperatura industrial mediano');


 
-- ====================FIN INSERT===========================


