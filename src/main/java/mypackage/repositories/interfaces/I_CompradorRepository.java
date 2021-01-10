
package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Comprador;

public interface I_CompradorRepository {

    void save(Comprador comprador);

    void remove(Comprador comprador);

    void update(Comprador comprador);

    List<Comprador> getAll();

    default Stream<Comprador> getStream() {
        return getAll().stream();
    }

    default Comprador getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Comprador());
    }

    default List<Comprador> getLikeNombre(String nombre) {
        if(nombre == null){
            return new ArrayList<Comprador>();
        }

        return getStream()
                .filter(objeto -> objeto.getNombre().toLowerCase()
                .contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
 default List<Comprador> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList<Comprador>();
        }
        return getStream()
                .filter(objeto -> objeto.getApellido().toLowerCase()
                .contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }
 
  default List <Comprador> getByTelefono(int telefono) {
        return getStream()
                .filter(objeto -> objeto.getTelefono() == telefono)
                .collect(Collectors.toList());
    }

    default List<Comprador> getLikeEmail(String email) {
        if (email == null) {
            return new ArrayList<Comprador>();
        }
        return getStream()
                .filter(objeto -> objeto.getEmail().toLowerCase()
                .contains(email.toLowerCase()))
                .collect(Collectors.toList());
    }
}
