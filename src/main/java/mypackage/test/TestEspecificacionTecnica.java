
package mypackage.test;

import mypackage.connector.LocalConnector;
import mypackage.entities.EspecificacionTecnica;
import mypackage.repositories.interfaces.I_EspecificacionTecnicaRepository;
import mypackage.repositories.jdbc.EspecificacionTecnicaRepository;


public class TestEspecificacionTecnica {

    public static void main(String[] args) {
        
        
        I_EspecificacionTecnicaRepository especificacionTecnicaRepository = new EspecificacionTecnicaRepository(LocalConnector.getLocalConnection());

        //----------INSERT----------
        System.out.println("\n=================Agregamos una nueva Especificacion===============\n");
        EspecificacionTecnica nuevaEspecificacionTecnica = new EspecificacionTecnica(1600f, 880f, 2.5f, "Metal Aleacion", 24f, 12f, 24f, 40);
        especificacionTecnicaRepository.save(nuevaEspecificacionTecnica);
        System.out.println(nuevaEspecificacionTecnica);
        System.out.println("\n=================Lista de Especificaciones Actualizada===============\n");
        especificacionTecnicaRepository.getAll().forEach(System.out::println);
        //----------FIN INSERT------
        
           //----------DELETE-----------
        System.out.println("\n=================Eliminamos la nueva especificacion agregada===============\n");
       especificacionTecnicaRepository.remove(nuevaEspecificacionTecnica);
        System.out.println("\n=================Lista de Especificaciones Actualizada===============\n");
       especificacionTecnicaRepository.getAll().forEach(System.out::println);
        //----------FIN DELETE----------
        
        
        //----------UPDATE--------------
        System.out.println("\n=================Actualizamos la longitud de la  especificacion con el id 3  ===============\n");
       nuevaEspecificacionTecnica = especificacionTecnicaRepository.getById(3);

        if (nuevaEspecificacionTecnica != null && nuevaEspecificacionTecnica.getId() != 0) {
           nuevaEspecificacionTecnica.setLongitud(240f);
             especificacionTecnicaRepository.update(nuevaEspecificacionTecnica);
        }

        System.out.println("\n=================Lista de Especificaciones Actualizada===============\n");
        especificacionTecnicaRepository.getAll().forEach(System.out::println);

        //----------FIN UPDATE-----------
        
        //----------SELECT-----------------
          System.out.println("\n=================Especificacion/es cuya longitud sea 120mm===============\n");
          especificacionTecnicaRepository.getByLongitud(120f).forEach(System.out::println);
          
          System.out.println("\n=================Especificacion/es cuyo ancho  sea 100mm===============\n");
          especificacionTecnicaRepository.getByAncho(100f).forEach(System.out::println);
          
          
          System.out.println("\n=================Especificacion/es cuyo peso sea 1.8 kg===============\n");
          especificacionTecnicaRepository.getByPeso(1.80f).forEach(System.out::println);
          
          System.out.println("\n=================Especificacion/es cuyo material sea Aluminio===============\n");
          especificacionTecnicaRepository.getLikeMaterial("Aluminio").forEach(System.out::println);
          
          
          System.out.println("\n=================Especificacion/es cuyo voltaje de funcionamiento sean 12 v===============\n");
          especificacionTecnicaRepository.getByVoltajeDeFuncionamiento(12f).forEach(System.out::println);
          
          
          System.out.println("\n=================Especificacion/es cuyo voltaje minimo de entrada sean 7 v===============\n");
          especificacionTecnicaRepository.getByVoltajeMinEntrada(7f).forEach(System.out::println);
          
          
          System.out.println("\n=================Especificacion/es cuyo voltaje maximo de entrada sean 24 v===============\n");
          especificacionTecnicaRepository.getByVoltajeMaxEntrada(24f).forEach(System.out::println);
          
          
          System.out.println("\n=================Especificacion/es cuyo tiempo de vida sean 50 años ===============\n");
          especificacionTecnicaRepository.getByTiempoDeVida(50).forEach(System.out::println);
          
          

//----------FIN SELECT------------

        
    }
    
}
