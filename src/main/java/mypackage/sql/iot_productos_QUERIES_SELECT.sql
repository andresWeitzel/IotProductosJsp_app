

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

