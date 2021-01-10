
package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.Comprador;
import mypackage.entities.Vendedor;
import mypackage.repositories.interfaces.I_CompradorRepository;


public class CompradorRepository implements I_CompradorRepository{

    private Connection conexionDB;

    public CompradorRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }

    @Override
    public void save(Comprador comprador) {
        if (comprador == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO compradores(nombre,apellido,telefono,email)"
                        + "VALUES(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setString(1, comprador.getNombre());
                    consultaPreparada.setString(2, comprador.getApellido());
                    consultaPreparada.setInt(3, comprador.getTelefono());
                    consultaPreparada.setString(4, comprador.getEmail());
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        comprador.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(Comprador comprador) {
        if (comprador == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM compradores WHERE id=?")) {

            consultaPreparada.setInt(1, comprador.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Comprador compradores) {
        if (compradores == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE compradores SET nombre=? , apellido=? , telefono=? , email=? "
                        + "WHERE id=?")) {

            consultaPreparada.setString(1, compradores.getNombre());
            consultaPreparada.setString(2, compradores.getApellido());
            consultaPreparada.setInt(3, compradores.getTelefono());
            consultaPreparada.setString(4, compradores.getEmail());
            consultaPreparada.setInt(5, compradores.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Comprador> getAll() {

        List<Comprador> listaCompradores = new ArrayList();

        try ( ResultSet resultSetComprador
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM compradores")) {
                    while (resultSetComprador.next()) {

                        listaCompradores.add(new Comprador(
                                resultSetComprador.getInt("id"),
                                resultSetComprador.getString("nombre"),
                                resultSetComprador.getString("apellido"),
                                resultSetComprador.getInt("telefono"),
                                resultSetComprador.getString("email")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaCompradores;
    }

}
