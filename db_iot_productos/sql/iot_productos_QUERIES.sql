/*

use iot_productos;

-- tablas de la db
show tables;

-- ====================SELECT===========================

-- descripcion d c/u de las tablas
describe productos;
describe especificaciones_tecnicas;
describe ventas;
describe vendedores;
describe compradores;


-- todos los campos de tablas
select * from productos;
select * from especificaciones_tecnicas;
select * from ventas;
select * from vendedores;
select * from compradores;

-- ids de c/tabla
select id from productos;
select id from especificaciones_tecnicas;
select id from ventas;
select id from vendedores;
select id from compradores;

-- numero de registros por tabla
select count(*) from productos;
select count(*) from especificaciones_tecnicas;
select count(*) from ventas;
select count(*) from vendedores;
select count(*) from compradores;


-- ordenaciones por tabla
select id, precio from productos  group by precio;
select id, peso from especificaciones_tecnicas  group by peso;
select id, cantidad from ventas  group by cantidad;
select id, nro_documento from vendedores  group by nro_documento;
select id, nombre from compradores  group by nombre;

-- relaciones de tablas
-- productos/especificacion tecnica
select productos.nombre, especificaciones_tecnicas.* from productos 
join especificaciones_tecnicas
on productos.id_especificacion_tecnica=especificaciones_tecnicas.id;

-- ventas/productos
select ventas.id, ventas.detalle, productos.* from ventas 
join productos
on ventas.id_producto=productos.id;

-- ventas/vendedors
select ventas.id_vendedor,ventas.detalle, vendedores.* from ventas
join vendedores
on ventas.id_vendedor=vendedores.id;

-- ventas/compradores
select ventas.id_comprador,ventas.detalle, compradores.* from ventas
join compradores
on ventas.id_comprador=compradores.id;

-- ====================FIN SELECT===========================


-- ====================INSERT===========================

-- especificaciones tecnicas
insert into especificaciones_tecnicas(tamaño, longitud, 
ancho, peso, material, funcion, voltaje_de_funcionamiento, voltaje_min_entrada,
 voltaje_max_entrada, tiempo_de_vida)values
 
 ('Pequeño' , 110.0 , 40.0 , 0.880, 'Fibra de Vidrio', 'Accionamiento' , 5.0, 7.0, 12.0 , 2),
 ('Pequeño' , 120.0 , 65.0 , 0.668, 'Aluminio', '' , 5.0, 7.0, 12.0 , 6),
 ('Mediano' , 190.0 , 165.0 , 1.200, 'Aluminio', 'Sensado' , 12.0, 12.0, 24.0 , 28),
 ('Mediano' , 170.0 , 120.0 , 0.700, 'Fibra de Carbono', 'Sensado' , 12.0, 12.0, 24.0 , 50),
 ('Grande' , 2400.0 , 600.1 , 2.400, 'Plastico PLA', 'Control' , 12.0, 12.0, 24.0 , 50), -- Posee un nucleo de procesamiento(ej)
 ('Grande' , 3200.0 , 900.0 , 1.800, 'Plastico Reforzado', 'Control' , 12.0, 12.0, 24.0 , 50);
 
-- ====================FIN INSERT===========================

*/


