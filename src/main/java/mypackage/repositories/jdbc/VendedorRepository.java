package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.EspecificacionTecnica;
import mypackage.entities.Vendedor;
import mypackage.repositories.interfaces.I_VendedorRepository;

public class VendedorRepository implements I_VendedorRepository {

    private Connection conexionDB;

    public VendedorRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Vendedor vendedor) {
        if (vendedor == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO vendedores(nombre,apellido,edad,nro_documento,telefono,email)"
                        + "VALUES(?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setString(1, vendedor.getNombre());
                    consultaPreparada.setString(2, vendedor.getApellido());
                    consultaPreparada.setInt(3, vendedor.getEdad());
                    consultaPreparada.setInt(4, vendedor.getNro_documento());
                    consultaPreparada.setInt(5, vendedor.getTelefono());
                    consultaPreparada.setString(6, vendedor.getEmail());
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        vendedor.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(Vendedor vendedor) {
        if (vendedor == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM vendedores WHERE id=?")) {

            consultaPreparada.setInt(1, vendedor.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Vendedor vendedor) {
        if (vendedor == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE vendedores SET nombre=? , apellido=? , edad=? , nro_documento=? , telefono=? , email=? "
                        + "WHERE id=?")) {

            consultaPreparada.setString(1, vendedor.getNombre());
            consultaPreparada.setString(2, vendedor.getApellido());
            consultaPreparada.setInt(3, vendedor.getEdad());
            consultaPreparada.setInt(4, vendedor.getNro_documento());
            consultaPreparada.setInt(5, vendedor.getTelefono());
            consultaPreparada.setString(6, vendedor.getEmail());
            consultaPreparada.setInt(7, vendedor.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Vendedor> getAll() {

        List<Vendedor> listaVendedores = new ArrayList();

        try ( ResultSet resultSetVendedor
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM vendedores")) {
                    while (resultSetVendedor.next()) {

                        listaVendedores.add(new Vendedor(
                                resultSetVendedor.getInt("id"),
                                resultSetVendedor.getString("nombre"),
                                resultSetVendedor.getString("apellido"),
                                resultSetVendedor.getInt("edad"),
                                resultSetVendedor.getInt("nro_documento"),
                                resultSetVendedor.getInt("telefono"),
                                resultSetVendedor.getString("email")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaVendedores;
    }

}
