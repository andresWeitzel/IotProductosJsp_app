package mypackage.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mypackage.entities.EspecificacionTecnica;
import mypackage.repositories.interfaces.I_EspecificacionTecnicaRepository;

public class EspecificacionTecnicaRepository implements I_EspecificacionTecnicaRepository {

    private Connection conexionDB;

    public EspecificacionTecnicaRepository(Connection conexionDB) {
        this.conexionDB = conexionDB;
    }
    @Override
    public void save(EspecificacionTecnica especificacion_tecnica) {
        if (especificacion_tecnica == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement(
                        "INSERT INTO especificaciones_tecnicas(longitud,ancho,peso,material,voltaje_de_funcionamiento,"
                        + "voltaje_min_entrada,voltaje_max_entrada,tiempo_de_vida)"
                        + "VALUES(?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS
                )) {

                    consultaPreparada.setFloat(1, especificacion_tecnica.getLongitud());
                    consultaPreparada.setFloat(2, especificacion_tecnica.getAncho());
                    consultaPreparada.setFloat(3, especificacion_tecnica.getPeso());
                    consultaPreparada.setString(4, especificacion_tecnica.getMaterial());
                    consultaPreparada.setFloat(5, especificacion_tecnica.getVoltaje_de_funcionamiento());
                    consultaPreparada.setFloat(6, especificacion_tecnica.getVoltaje_min_entrada());
                    consultaPreparada.setFloat(7, especificacion_tecnica.getVoltaje_max_entrada());
                    consultaPreparada.setInt(8, especificacion_tecnica.getTiempo_de_vida());
                    consultaPreparada.execute();

                    ResultSet resultadoQuery = consultaPreparada.getGeneratedKeys();

                    if (resultadoQuery.next()) {
                        especificacion_tecnica.setId(resultadoQuery.getInt(1));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
    }
    @Override
    public void remove(EspecificacionTecnica especificacion_tecnica) {
        if (especificacion_tecnica == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada
                = conexionDB.prepareStatement("DELETE FROM especificaciones_tecnicas WHERE id=?")) {

            consultaPreparada.setInt(1, especificacion_tecnica.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(EspecificacionTecnica especificacion_tecnica) {
        if (especificacion_tecnica == null) {
            return;
        }
        try ( PreparedStatement consultaPreparada = conexionDB
                .prepareStatement(
                        "UPDATE especificaciones_tecnicas SET longitud=? , ancho=? , peso=? , material=? , voltaje_de_funcionamiento=? , voltaje_min_entrada=? , voltaje_max_entrada=? , tiempo_de_vida=?"
                        + "WHERE id=?")) {

            consultaPreparada.setFloat(1, especificacion_tecnica.getLongitud());
            consultaPreparada.setFloat(2, especificacion_tecnica.getAncho());
            consultaPreparada.setFloat(3, especificacion_tecnica.getPeso());
            consultaPreparada.setString(4, especificacion_tecnica.getMaterial());
            consultaPreparada.setFloat(5, especificacion_tecnica.getVoltaje_de_funcionamiento());
            consultaPreparada.setFloat(6, especificacion_tecnica.getVoltaje_min_entrada());
            consultaPreparada.setFloat(7, especificacion_tecnica.getVoltaje_max_entrada());
            consultaPreparada.setInt(8, especificacion_tecnica.getTiempo_de_vida());
            consultaPreparada.setInt(9, especificacion_tecnica.getId());

            consultaPreparada.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<EspecificacionTecnica> getAll() {

        List<EspecificacionTecnica> listaEspecificacionTecnica = new ArrayList();

        try ( ResultSet resultSetEspecificacionTecnica
                = conexionDB
                        .createStatement()
                        .executeQuery("SELECT * FROM especificaciones_tecnicas")) {
                    while (resultSetEspecificacionTecnica.next()) {

                        listaEspecificacionTecnica.add(new EspecificacionTecnica(
                                
                                resultSetEspecificacionTecnica.getInt("id"),
                                resultSetEspecificacionTecnica.getFloat("longitud"),
                                resultSetEspecificacionTecnica.getFloat("ancho"),
                                resultSetEspecificacionTecnica.getFloat("peso"),
                                resultSetEspecificacionTecnica.getString("material"),
                                resultSetEspecificacionTecnica.getFloat("voltaje_de_funcionamiento"),
                                resultSetEspecificacionTecnica.getFloat("voltaje_min_entrada"),
                                resultSetEspecificacionTecnica.getFloat("voltaje_max_entrada"),
                                resultSetEspecificacionTecnica.getInt("tiempo_de_vida")
                        ));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return listaEspecificacionTecnica;
    }

}
