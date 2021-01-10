package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.connector.LocalConnector;
import mypackage.entities.Producto;
import mypackage.repositories.interfaces.I_ProductoRepository;

public class ProductoRepository implements I_ProductoRepository {

    private Connection conexionDB;

    public ProductoRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Producto producto) {
        if (producto == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO productos(id_especificacion_tecnica,area,funcion,tipo,nombre,modelo,tamaño,precio,estado)"
                        + "VALUES(?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, producto.getId_especificacion_tecnica());
                    consultaPreparada.setString(2, producto.getArea());
                    consultaPreparada.setString(3, producto.getFuncion());
                    consultaPreparada.setString(4, producto.getTipo());
                    consultaPreparada.setString(5, producto.getNombre());
                    consultaPreparada.setString(6, producto.getModelo());
                    consultaPreparada.setString(7, producto.getTamaño());
                    consultaPreparada.setFloat(8, producto.getPrecio());
                    consultaPreparada.setString(9, producto.getEstado());

                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        producto.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(Producto producto) {
        if (producto == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM productos WHERE id=?")) {

            consultaPreparada.setInt(1, producto.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void update(Producto producto) {
        if (producto == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE productos SET id_especificacion_tecnica=?, area=?, funcion=?,  tipo=?, nombre=?, modelo=?, tamaño=?, precio=?, estado=?"
                        + "WHERE id=?")) {
            consultaPreparada.setInt(1, producto.getId_especificacion_tecnica());
            consultaPreparada.setString(2, producto.getArea());
            consultaPreparada.setString(3, producto.getFuncion());
            consultaPreparada.setString(4, producto.getTipo());
            consultaPreparada.setString(5, producto.getNombre());
            consultaPreparada.setString(6, producto.getModelo());
             consultaPreparada.setString(7, producto.getTamaño());
            consultaPreparada.setFloat(8, producto.getPrecio());
            consultaPreparada.setString(9, producto.getEstado());
            consultaPreparada.setInt(10, producto.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Producto> getAll() {

        List<Producto> listaProductos = new ArrayList();

        try ( ResultSet resultSetProductos
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM productos")) {
                    while (resultSetProductos.next()) {

                        listaProductos.add(new Producto(
                                resultSetProductos.getInt("id"),
                                resultSetProductos.getInt("id_especificacion_tecnica"),
                                resultSetProductos.getString("area"),
                                resultSetProductos.getString("funcion"),
                                resultSetProductos.getString("tipo"),
                                resultSetProductos.getString("nombre"),
                                resultSetProductos.getString("modelo"),
                                resultSetProductos.getString("tamaño"),
                                resultSetProductos.getFloat("precio"),
                                resultSetProductos.getString("estado")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaProductos;
    }

}
