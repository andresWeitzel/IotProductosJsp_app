package mypackage.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import mypackage.entities.Venta;

public interface I_VentaRepository {

    void save(Venta venta);

    void remove(Venta venta);

    void update(Venta venta);

    List<Venta> getAll();

    default Stream<Venta> getStream() {
        return getAll().stream();
    }

    default Venta getById(int id) {
        return getStream()
                .filter(objeto -> objeto.getId() == id)
                .findAny()
                .orElse(new Venta());
    }

    default Venta getByIdProducto(int id_producto) {
        return getStream()
                .filter(objeto -> objeto.getId_producto() == id_producto)
                .findAny()
                .orElse(new Venta());
    }

    default Venta getByIdVendedor(int id_vendedor) {
        return getStream()
                .filter(objeto -> objeto.getId_vendedor() == id_vendedor)
                .findAny()
                .orElse(new Venta());
    }

    default Venta getByIdComprador(int id_comprador) {
        return getStream()
                .filter(objeto -> objeto.getId_comprador() == id_comprador)
                .findAny()
                .orElse(new Venta());
    }

    default Venta getByCantidad(int cantidad) {
        return getStream()
                .filter(objeto -> objeto.getCantidad() == cantidad)
                .findAny()
                .orElse(new Venta());
    }

    default List<Venta> getLikeFechaDeVenta(String fecha_de_venta) {
        if (fecha_de_venta == null) {
            return new ArrayList<Venta>();
        }
        return getStream()
                .filter(objeto -> objeto.getFecha_de_venta().toLowerCase()
                .contains(fecha_de_venta.toLowerCase()))
                .collect(Collectors.toList());
    }

    default List<Venta> getLikeDetalle(String detalle) {
        if (detalle == null) {
            return new ArrayList<Venta>();
        }
        return getStream()
                .filter(objeto -> objeto.getDetalle().toLowerCase()
                .contains(detalle.toLowerCase()))
                .collect(Collectors.toList());
    }

}
