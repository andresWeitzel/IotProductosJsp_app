package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Venta;
import mypackage.repositories.interfaces.I_VentaRepository;

public class VentaRepository implements I_VentaRepository {

    private Connection conexionDB;

    public VentaRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Venta venta) {
        if (venta == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO ventas(id_producto,id_vendedor,id_comprador,cantidad,fecha_de_venta,detalle)"
                        + "VALUES(?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setInt(1, venta.getId_producto());
                    consultaPreparada.setInt(2, venta.getId_vendedor());
                    consultaPreparada.setInt(3, venta.getId_comprador());
                    consultaPreparada.setInt(4, venta.getCantidad());
                    consultaPreparada.setString(5, venta.getFecha_de_venta());
                    consultaPreparada.setString(6, venta.getDetalle());
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        venta.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(Venta venta) {
        if (venta == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM ventas WHERE id=?")) {

            consultaPreparada.setInt(1, venta.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Venta venta) {
        if (venta == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE ventas SET id_producto=? , id_vendedor=? , id_comprador=? , cantidad=? , fecha_de_venta=? , detalle=? "
                        + "WHERE id=?")) {

            
            consultaPreparada.setInt(1, venta.getId_producto());
            consultaPreparada.setInt(2, venta.getId_vendedor());
            consultaPreparada.setInt(3, venta.getId_comprador());
            consultaPreparada.setInt(4, venta.getCantidad());
            consultaPreparada.setString(5, venta.getFecha_de_venta());
            consultaPreparada.setString(6, venta.getDetalle());
            consultaPreparada.setInt(7, venta.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Venta> getAll() {

        List<Venta> listaVenta = new ArrayList();

        try ( ResultSet resultSetVenta
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM ventas")) {
                    while (resultSetVenta.next()) {

                        listaVenta.add(new Venta(
                                resultSetVenta.getInt("id"),
                                resultSetVenta.getInt("id_producto"),
                                resultSetVenta.getInt("id_vendedor"),
                                resultSetVenta.getInt("id_comprador"),
                                resultSetVenta.getInt("cantidad"),
                                resultSetVenta.getString("fecha_de_venta"),
                                resultSetVenta.getString("detalle")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaVenta;
    }

}
