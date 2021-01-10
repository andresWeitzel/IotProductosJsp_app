package mypackage.interfaces.utils;

//Diseño de una herramienta que nos permite automatizar los tags de las tablas
import java.lang.reflect.Field;
import java.util.List;

public class TableHTML<E> {

    public String getTable(List<E> list) {

        if (list == null || list.isEmpty()) {
            return "<table></table>";
        }

        String tableHtml = "<table>";

        //Colocamos el primer elemento de la lista
        E e = list.get(0);

        //Tenemos el vector con los campos
        Field[] campos = e.getClass().getDeclaredFields();

        tableHtml += "<tr>";

        //Por cada campo agregamos un tag th
        for (Field f : campos) {

            tableHtml += "<th>";

            tableHtml += f.getName();

            tableHtml += "</th>";

        }

        tableHtml += "</tr>";

        //por cada registro tendremos una fila
        for (E ee : list) {

            tableHtml += "<tr>";

            for (Field f : campos) {

                tableHtml += "<td>";

                //nombre del campo
                String method = "get"
                        + f.getName().substring(0, 1).toUpperCase()
                        + f.getName().substring(1);

                try {
                    tableHtml += e.getClass().getDeclaredMethod(method, null).invoke(ee, null);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                tableHtml += "</td>";

            }
            tableHtml += "</tr>";
        }

        tableHtml += "</table>";

        return tableHtml;

    }

    public String getTable(List<E> list, String linkRemove, String linkUpdate) {

        if (list == null || list.isEmpty()) {
            return "<table></table>";
        }

        String tableHtml = "<table>";

        //Colocamos el primer elemento de la lista
        E e = list.get(0);

        //Tenemos el vector con los campos
        Field[] campos = e.getClass().getDeclaredFields();

        tableHtml += "<tr>";

        //Por cada campo agregamos un tag th
        for (Field f : campos) {

            tableHtml += "<th>";

            tableHtml += f.getName();

            tableHtml += "</th>";

        }
        //tableHtml
        tableHtml += "</tr>";

        //por cada registro tendremos una fila
        for (E ee : list) {

            tableHtml += "<tr>";

            for (Field f : campos) {

                tableHtml += "<td>";

                //nombre del campo
                String method = "get"
                        + f.getName().substring(0, 1).toUpperCase()
                        + f.getName().substring(1);

                try {
                    tableHtml += e.getClass().getDeclaredMethod(method, null).invoke(ee, null);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                tableHtml += "</td>";

            }

            try {

                tableHtml += "<td>";

                tableHtml += "<a href  =" + linkRemove + " ?id=" 
                        + e.getClass().getDeclaredMethod("getId", null).invoke(ee, null) + ">"+"Eliminar</a>";

                tableHtml += "</td>";

                tableHtml += "<td>";

                tableHtml += "<a href  =" + linkUpdate + " ?id=" 
                        + e.getClass().getDeclaredMethod("getId", null).invoke(ee, null) + ">"+"Actualizar</a>";

                tableHtml += "</td>";

            } catch (Exception ex) {

                ex.printStackTrace();
            }

            tableHtml += "</tr>";
        }

        tableHtml += "</table>";

        return tableHtml;

    }

}
