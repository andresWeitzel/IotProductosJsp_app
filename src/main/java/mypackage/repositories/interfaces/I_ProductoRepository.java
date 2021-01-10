
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Producto;


public interface I_ProductoRepository {
  
    
    void save(Producto producto);
    
    void remove(Producto producto);

    void update(Producto producto);

    List <Producto> getAll();
    
    default Stream <Producto> getStream(){
        return getAll().stream();
    }
    
    default Producto getById(int id){
        return getStream()
                .filter(objeto->objeto.getId() == id)
                .findAny()
                .orElse(new Producto());
    }


    default List<Producto> getByIdEspecificacionTecnica(float id_especificacion_tecnica) {
        return getStream()
                .filter(objeto -> objeto.getId_especificacion_tecnica() == id_especificacion_tecnica)
                .collect(Collectors.toList());

    }
    
    

    default List<Producto> getLikeArea(String area) {
        if(area == null){
            return new ArrayList<Producto>();
        }

        return getStream()
                .filter(objeto -> objeto.getArea().toLowerCase()
                .contains(area.toLowerCase()))
                .collect(Collectors.toList());
    }


    default List<Producto> getLikeFuncion(String funcion) {
        if(funcion == null){
            return new ArrayList<Producto>();
        }

        return getStream()
                .filter(objeto -> objeto.getFuncion().toLowerCase()
                .contains(funcion.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    
    default List<Producto> getLikeTipo(String tipo) {
        if(tipo == null){
            return new ArrayList<Producto>();
        }

        return getStream()
                .filter(objeto -> objeto.getTipo().toLowerCase()
                .contains(tipo.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    default List<Producto> getLikeNombre(String nombre) {
        if(nombre == null){
            return new ArrayList<Producto>();
        }

        return getStream()
                .filter(objeto -> objeto.getNombre().toLowerCase()
                .contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    
    default List<Producto> getLikeModelo(String modelo) {
        if(modelo == null){
            return new ArrayList<Producto>();
        }

        return getStream()
                .filter(objeto -> objeto.getModelo().toLowerCase()
                .contains(modelo.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    default List<Producto> getByTamaño(String tamaño) {
        if(tamaño == null){
            return new ArrayList<Producto>();
        }

        return getStream()
                .filter(objeto -> objeto.getTamaño().toLowerCase()
                .contains(tamaño.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    
    default List<Producto> getByPrecio(float precio) {
        return getStream()
                .filter(objeto -> objeto.getPrecio() == precio)
                .collect(Collectors.toList());
    }
    
    
    default List<Producto> getByPrecioMayorQue(float precio) {
        return getStream()
                .filter(objeto -> objeto.getPrecio() > precio)
                .collect(Collectors.toList());
    }
    
    
    default List<Producto> getByPrecioMenorQue(float precio) {
        return getStream()
                .filter(objeto -> objeto.getPrecio() < precio)
                .collect(Collectors.toList());
    }
    
       default List<Producto> getLikeEstado(String estado) {
        if(estado == null){
            return new ArrayList<Producto>();
        }

        return getStream()
                .filter(objeto -> objeto.getEstado().toLowerCase()
                .startsWith(estado.toLowerCase()))
                .collect(Collectors.toList());
    }
 
    
}

