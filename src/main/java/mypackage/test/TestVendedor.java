
package mypackage.test;

import mypackage.connector.LocalConnector;
import mypackage.entities.Vendedor;
import mypackage.repositories.interfaces.I_VendedorRepository;
import mypackage.repositories.jdbc.VendedorRepository;


public class TestVendedor {
    
    public static void main(String[] args) {
        
        I_VendedorRepository vendedorRepository = new VendedorRepository(LocalConnector.getLocalConnection());

        //----------INSERT----------
        System.out.println("\n=================Agregamos un nuevo Vendedor===============\n");
        Vendedor nuevoVendedor = new Vendedor("Mauricio", "Rosas", 20, 55867456, 1567835492, "mauricioCaliba234@gmail.com");
        vendedorRepository.save(nuevoVendedor);
        System.out.println(nuevoVendedor);
        System.out.println("\n=================Lista de Vendedores Actualizada===============\n");
        vendedorRepository.getAll().forEach(System.out::println);
        //----------FIN INSERT------
        //----------DELETE-----------
        System.out.println("\n=================Eliminamos el nuevo vendedor agregado===============\n");
        vendedorRepository.remove(nuevoVendedor);
        System.out.println("\n=================Lista de Vendedores Actualizada===============\n");
        vendedorRepository.getAll().forEach(System.out::println);
        //----------FIN DELETE----------

        //----------UPDATE--------------
        System.out.println("\n=================Actualizamos la edad del vendedor con el id 2 ===============\n");
        nuevoVendedor = vendedorRepository.getById(2);

        if (nuevoVendedor != null && nuevoVendedor.getId() != 0) {
            nuevoVendedor.setEdad(37);
            vendedorRepository.update(nuevoVendedor);
        }

        System.out.println("\n=================Lista de Vendedores Actualizada===============\n");
        vendedorRepository.getAll().forEach(System.out::println);

        //----------FIN UPDATE-----------

         //----------SELECT-----------------
        System.out.println("\n=================Vendedor con el id 4===============\n");
        System.out.println(vendedorRepository.getById(4));

        System.out.println("\n=================Vendedor/es cuyo/s  nombre sea/n Lucia===============\n");
        vendedorRepository.getLikeNombre("Lucia").forEach(System.out::println);
        
        System.out.println("\n=================Vendedor/es cuyo/s  apellido sea/n Caceres===============\n");
        vendedorRepository.getLikeApellido("Caceres").forEach(System.out::println);
        
        
        System.out.println("\n=================Vendedor/es cuya/s  edad sea/n 21 años===============\n");
        vendedorRepository.getByEdad(21).forEach(System.out::println);
        
        
        System.out.println("\n=================Vendedor/es cuyo numero de documento sea 65412478===============\n");
        vendedorRepository.getByNroDocumento(65412478).forEach(System.out::println);
        
        
        System.out.println("\n=================Vendedor/es cuyo telefono sea 1585962145===============\n");
        vendedorRepository.getByTelefono(1585962145).forEach(System.out::println);
        
        System.out.println("\n=================Vendedor/es cuyo email sea javierPerez@hotmail.com===============\n");
        vendedorRepository.getLikeEmail("javierPerez@hotmail.com").forEach(System.out::println);
    
        
//-----------FIN SELECT--------------
    }

}
