
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.EspecificacionTecnica;
import mypackage.entities.Producto;

public interface I_EspecificacionTecnicaRepository {
    
      void save(EspecificacionTecnica especificacion_tecnica);
    
    void remove(EspecificacionTecnica especificacion_tecnica);

    void update(EspecificacionTecnica especificacion_tecnica);

    List <EspecificacionTecnica> getAll();
    
    default Stream <EspecificacionTecnica> getStream(){
        return getAll().stream();
    }
    
    default EspecificacionTecnica getById(int id){
        return getStream()
                .filter(objeto->objeto.getId() == id)
                .findAny()
                .orElse(new EspecificacionTecnica());
    }
    
    default List <EspecificacionTecnica> getByLongitud(float longitud){
        return  getStream()
                .filter(objeto->objeto.getLongitud() == longitud)
                .collect(Collectors.toList());
    }
    
    
    default List <EspecificacionTecnica> getByAncho(float ancho){
        return  getStream()
                .filter(objeto->objeto.getAncho() == ancho)
                .collect(Collectors.toList());
    }
    
    default List <EspecificacionTecnica> getByPeso(float peso){
        return  getStream()
                .filter(objeto->objeto.getPeso() == peso)
                .collect(Collectors.toList());
    }
    
        default List<EspecificacionTecnica> getLikeMaterial(String material) {
        if(material == null){
            return new ArrayList<EspecificacionTecnica>();
        }

        return getStream()
                .filter(objeto -> objeto.getMaterial().toLowerCase()
                .contains(material.toLowerCase()))
                .collect(Collectors.toList());
    }

     
    default List <EspecificacionTecnica> getByVoltajeDeFuncionamiento(float voltaje_de_funcionamiento){
        return  getStream()
                .filter(objeto->objeto.getVoltaje_de_funcionamiento() == voltaje_de_funcionamiento)
                .collect(Collectors.toList());
    }
    
    
    default List <EspecificacionTecnica> getByVoltajeMinEntrada(float voltaje_min_entrada){
        return  getStream()
                .filter(objeto->objeto.getVoltaje_min_entrada() == voltaje_min_entrada)
                .collect(Collectors.toList());
    }
    
    
    default List <EspecificacionTecnica> getByVoltajeMaxEntrada(float voltaje_max_entrada){
        return  getStream()
                .filter(objeto->objeto.getVoltaje_max_entrada() == voltaje_max_entrada)
                .collect(Collectors.toList());
    }
    
   
    default List <EspecificacionTecnica> getByTiempoDeVida(int tiempo_de_vida){
        return  getStream()
                .filter(objeto->objeto.getTiempo_de_vida() == tiempo_de_vida)
                .collect(Collectors.toList());
    }
    


}
