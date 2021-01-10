
package mypackage.test;

import mypackage.connector.LocalConnector;
import mypackage.entities.Comprador;
import mypackage.repositories.interfaces.I_CompradorRepository;
import mypackage.repositories.jdbc.CompradorRepository;

public class TestCompradores {
    
    public static void main(String[] args) {
        
        I_CompradorRepository compradorRepository = new CompradorRepository(LocalConnector.getLocalConnection());

        //----------INSERT----------
        System.out.println("\n=================Agregamos un nuevo Comprador===============\n");
        Comprador nuevoComprador = new Comprador("Marcela","Gutieerez",1187654563,"marce89@hotmail.com");
        compradorRepository.save(nuevoComprador);
        System.out.println(nuevoComprador);
        System.out.println("\n=================Lista de Compradores Actualizada===============\n");
        compradorRepository.getAll().forEach(System.out::println);
        //----------FIN INSERT------
        
                //----------DELETE-----------
        System.out.println("\n=================Eliminamos el nuevo comrpador agregado===============\n");
        compradorRepository.remove(nuevoComprador);
        System.out.println("\n=================Lista de Compradores Actualizada===============\n");
        compradorRepository.getAll().forEach(System.out::println);
        //----------FIN DELETE----------
        
          //----------UPDATE--------------
        System.out.println("\n=================Actualizamos el telefono del comrpador con el id 2 ===============\n");
        nuevoComprador = compradorRepository.getById(2);

        if (nuevoComprador != null && nuevoComprador.getId() != 0) {
            nuevoComprador.setTelefono(1167564890);
            compradorRepository.update(nuevoComprador);
        }

        System.out.println("\n=================Lista de Comrpadores Actualizada===============\n");
        compradorRepository.getAll().forEach(System.out::println);

        //----------FIN UPDATE-----------

         //----------SELECT-----------------
        System.out.println("\n=================Comprador con el id 1===============\n");
        System.out.println(compradorRepository.getById(1));

        System.out.println("\n=================Comprador/es cuyo/s  nombre sea/n Gustavo===============\n");
        compradorRepository.getLikeNombre("Gustavo").forEach(System.out::println);
       
         System.out.println("\n=================Comprador/es cuyo/s  apellido sea/n Sanchez===============\n");
        compradorRepository.getLikeApellido("Sanchez").forEach(System.out::println);
        
          
        System.out.println("\n=================Comprador/es cuyo telefono sea 1187654563===============\n");
        compradorRepository.getByTelefono(1187654563).forEach(System.out::println);
        
        System.out.println("\n=================Comprador/es cuyo email sea rami78@gmail.com===============\n");
        compradorRepository.getLikeEmail("rami78@gmail.com").forEach(System.out::println);
    
       
        //---------FIN SELECT-----------------

        
    }
        
}
