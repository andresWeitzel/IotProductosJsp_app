package mypackage.test;

import mypackage.connector.LocalConnector;
import mypackage.entities.Producto;
import mypackage.repositories.interfaces.I_ProductoRepository;
import mypackage.repositories.jdbc.ProductoRepository;

public class TestProducto {

    public static void main(String[] args) {

        I_ProductoRepository productoRepository = new ProductoRepository(LocalConnector.getLocalConnection());

        //----------INSERT----------
        System.out.println("\n=================Agregamos un nuevo Producto===============\n");
        Producto nuevoProducto = new Producto(3, "Telecomunicaciones", "Recepcion", "Antena", "ReceptionMotion2.0", "tvb01", "Grande", 42f, "Disponible");
        productoRepository.save(nuevoProducto);
        System.out.println(nuevoProducto);
        System.out.println("\n=================Lista de Productos Actualizada===============\n");
        productoRepository.getAll().forEach(System.out::println);
        //----------FIN INSERT------

        //----------DELETE-----------
        System.out.println("\n=================Eliminamos el nuevo producto agregado===============\n");
        productoRepository.remove(nuevoProducto);
        System.out.println("\n=================Lista de Productos Actualizada===============\n");
        productoRepository.getAll().forEach(System.out::println);
        //----------FIN DELETE----------

        //----------UPDATE--------------
        System.out.println("\n=================Actualizamos el  producto con el id 2 ===============\n");
        nuevoProducto = productoRepository.getById(2);

        if (nuevoProducto != null && nuevoProducto.getId() != 0) {
            nuevoProducto.setPrecio(24f);
            productoRepository.update(nuevoProducto);
        }

        System.out.println("\n=================Lista de Productos Actualizada===============\n");
        productoRepository.getAll().forEach(System.out::println);

        //----------FIN UPDATE-----------
        //----------SELECT-----------------
        System.out.println("\n=================Producto con el id 4===============\n");
        System.out.println(productoRepository.getById(4));

        System.out.println("\n=================Producto/s cuyo/s id de especificacion tecnica sea/n 1===============\n");
        productoRepository.getByIdEspecificacionTecnica(1).forEach(System.out::println);
        
        System.out.println("\n=================Producto/s que sea/n del area de Telecomunicaciones===============\n");
        productoRepository.getLikeArea("Telecomunicaciones").forEach(System.out::println);
        
        
        System.out.println("\n=================Producto/s cuya funcion sea la de sensado===============\n");
        productoRepository.getLikeFuncion("Sensado").forEach(System.out::println);
        
        
        System.out.println("\n=================Producto/s cuyo tipo sea Alarma===============\n");
        productoRepository.getLikeTipo("alarma").forEach(System.out::println);
        
        
        System.out.println("\n=================Producto/s cuyo nombre sea SecurityHouse===============\n");
        productoRepository.getLikeNombre("securityHouse").forEach(System.out::println);
        
        
        System.out.println("\n=================Producto/s cuyo modelo sea mtp01 ==============\n");
        productoRepository.getLikeModelo("mtp01").forEach(System.out::println);
        
        
        System.out.println("\n=================Producto/s cuyo tamaño sea pequeño===============\n");
        productoRepository.getByTamaño("pequeño").forEach(System.out::println);
        
        
        System.out.println("\n=================Producto/s cuyo precio sea us$34===============\n");
        productoRepository.getByPrecio(34f).forEach(System.out::println);
        
        
        System.out.println("\n=================Producto/s cuyo precio sea mayor a us$34===============\n");
        productoRepository.getByPrecioMayorQue(34f).forEach(System.out::println);
        
        
        System.out.println("\n=================Producto/s cuyo precio sea menor a us$34===============\n");
        productoRepository.getByPrecioMenorQue(34f).forEach(System.out::println);
        
        
        System.out.println("\n=================Producto/s cuyo estado sea disponible===============\n");
        productoRepository.getLikeEstado("Disponible").forEach(System.out::println);
        
        
        System.out.println("\n=================Producto/s cuyo estado sea no disponible===============\n");
        productoRepository.getLikeEstado("no Disponible").forEach(System.out::println);
        
        

//-----------FIN SELECT------------
    }

}
