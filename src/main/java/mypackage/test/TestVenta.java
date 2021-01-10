package mypackage.test;

import java.time.LocalDateTime;
import mypackage.connector.LocalConnector;
import mypackage.entities.Comprador;
import mypackage.entities.Producto;
import mypackage.entities.Vendedor;
import mypackage.entities.Venta;
import mypackage.repositories.interfaces.I_CompradorRepository;
import mypackage.repositories.interfaces.I_ProductoRepository;
import mypackage.repositories.interfaces.I_VendedorRepository;
import mypackage.repositories.interfaces.I_VentaRepository;
import mypackage.repositories.jdbc.CompradorRepository;
import mypackage.repositories.jdbc.ProductoRepository;
import mypackage.repositories.jdbc.VendedorRepository;
import mypackage.repositories.jdbc.VentaRepository;

public class TestVenta {

    public static void main(String[] args) {

        I_ProductoRepository productoRepository = new ProductoRepository(LocalConnector.getLocalConnection());
        I_VendedorRepository vendedorRepository = new VendedorRepository(LocalConnector.getLocalConnection());
        I_CompradorRepository compradorRepository = new CompradorRepository(LocalConnector.getLocalConnection());
        I_VentaRepository ventaRepository = new VentaRepository(LocalConnector.getLocalConnection());



        //----------INSERT----------
        System.out.println("\n=================Agregamos un nuevo Producto===============\n");
        Producto nuevoProducto = new Producto(1, "Domotica", "Recepcion", "RFID", "ReceptionFI1.0", "rfd01", "Pequeño", 10f, "Disponible");
        productoRepository.save(nuevoProducto);
        System.out.println(nuevoProducto);

        System.out.println("\n=================Agregamos un nuevo Vendedor===============\n");
        Vendedor nuevoVendedor = new Vendedor("Jose", "Rosales", 25, 78967346, 157831292, "joseAlcalde@gmail.com");
        vendedorRepository.save(nuevoVendedor);
        System.out.println(nuevoVendedor);
        
         System.out.println("\n=================Agregamos un nuevo Comprador===============\n");
        Comprador nuevoComprador = new Comprador("Fabio", "Gutieerez", 1137892134, "fabian789@hotmail.com");
        compradorRepository.save(nuevoComprador);
        System.out.println(nuevoComprador);

        System.out.println("\n=================Agregamos una nueva Venta===============\n");
        Venta nuevaVenta = new Venta(10,6,7,2, String.valueOf(LocalDateTime.now()),"Se vendieron 2 Sensores rfid pequeños");
        ventaRepository.save(nuevaVenta);
        System.out.println(nuevaVenta);
        System.out.println("\n=================Lista de Ventas Actualizada===============\n");
        ventaRepository.getAll().forEach(System.out::println);
        //----------FIN INSERT------ 
        
            //----------UPDATE--------------
        System.out.println("\n=================Actualizamos la cantidad de ventas y el detalle de la venta con el id 4  ===============\n");
        nuevaVenta = ventaRepository.getById(3);

        if (nuevaVenta != null && nuevaVenta.getId() != 0) {
            nuevaVenta.setCantidad(3);
            nuevaVenta.setDetalle("El cliente compro otros racks de telecomunicaciones");
            ventaRepository.update(nuevaVenta);
        }

        System.out.println("\n=================Lista de Ventas Actualizada===============\n");
        ventaRepository.getAll().forEach(System.out::println);

        //----------FIN UPDATE-----------

            //----------DELETE-----------
        System.out.println("\n=================Eliminamos la nueva venta agregada===============\n");
        ventaRepository.remove(nuevaVenta);
        System.out.println("\n=================Lista de Ventas Actualizada===============\n");
        ventaRepository.getAll().forEach(System.out::println);
        //----------FIN DELETE----------
    

         //----------SELECT-----------------
        System.out.println("\n=================Venta con el id 1===============\n");
        System.out.println(ventaRepository.getById(1));

        
        System.out.println("\n=================Venta con el id de Producto 1===============\n");
        System.out.println(ventaRepository.getByIdProducto(1));

        
        System.out.println("\n=================Venta con el id de Vendedor 1===============\n");
        System.out.println(ventaRepository.getByIdVendedor(1));

        
        System.out.println("\n=================Venta con el id de Comprador 1===============\n");
        System.out.println(ventaRepository.getByIdComprador(1));

        
        System.out.println("\n=================Venta con 1 producto vendido===============\n");
        System.out.println(ventaRepository.getByCantidad(1));

        
        System.out.println("\n=================Venta cuya fecha de venta sea el 2020-09-26===============\n");
        ventaRepository.getLikeFechaDeVenta("2020-09-26").forEach(System.out::println);
        
      System.out.println("\n=================Venta cuyo detalle contenga alarma  ===============\n");
        ventaRepository.getLikeDetalle("alarma").forEach(System.out::println);
        
        
//-----------FIN SELECT--------------
    }

}
