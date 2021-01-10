package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.EspecificacionTecnica;
import mypackage.entities.Vendedor;

public interface I_VendedorRepository {

    void save(Vendedor vendedor);

    void remove(Vendedor vendedor);

    void update(Vendedor vendedor);

    List<Vendedor> getAll();

    default Stream<Vendedor> getStream() {
        return getAll().stream();
    }

    default Vendedor getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Vendedor());
    }

    default List<Vendedor> getLikeNombre(String nombre) {
        if (nombre == null) {
            return new ArrayList<Vendedor>();
        }
        return getStream()
                .filter(objeto -> objeto.getNombre().toLowerCase()
                .contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Vendedor> getLikeApellido(String apellido) {
        if (apellido == null) {
            return new ArrayList<Vendedor>();
        }
        return getStream()
                .filter(objeto -> objeto.getApellido().toLowerCase()
                .contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List <Vendedor> getByEdad(int edad) {
        return getStream()
                .filter(objeto -> objeto.getEdad() == edad)
                .collect(Collectors.toList());
    }

    default List <Vendedor> getByNroDocumento(int nro_documento) {
        return getStream()
                .filter(objeto -> objeto.getNro_documento() == nro_documento)
                .collect(Collectors.toList());
    }

    default List <Vendedor> getByTelefono(int telefono) {
        return getStream()
                .filter(objeto -> objeto.getTelefono() == telefono)
                .collect(Collectors.toList());
    }

    default List<Vendedor> getLikeEmail(String email) {
        if (email == null) {
            return new ArrayList<Vendedor>();
        }
        return getStream()
                .filter(objeto -> objeto.getEmail().toLowerCase()
                .contains(email.toLowerCase()))
                .collect(Collectors.toList());
    }

}
