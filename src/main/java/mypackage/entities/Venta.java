
package mypackage.entities;


public class Venta {

    private int id;
    private int id_producto;
    private int id_vendedor;
    private int id_comprador;
    private int cantidad;
    private String fecha_de_venta;
    private String detalle;
    
    
    public Venta() {
    }
    
    public Venta(int id_producto, int id_vendedor, int id_comprador, int cantidad, String fecha_de_venta, String detalle) {
        this.id_producto = id_producto;
        this.id_vendedor = id_vendedor;
        this.id_comprador = id_comprador;
        this.cantidad = cantidad;
        this.fecha_de_venta = fecha_de_venta;
        this.detalle = detalle;
    }
    
    public Venta(int id, int id_producto, int id_vendedor, int id_comprador, int cantidad, String fecha_de_venta, String detalle) {
        this.id = id;
        this.id_producto = id_producto;
        this.id_vendedor = id_vendedor;
        this.id_comprador = id_comprador;
        this.cantidad = cantidad;
        this.fecha_de_venta = fecha_de_venta;
        this.detalle = detalle;
    }
    
    
    
    
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_producto() {
        return id_producto;
    }
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    public int getId_vendedor() {
        return id_vendedor;
    }
    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }
    public int getId_comprador() {
        return id_comprador;
    }
    public void setId_comprador(int id_comprador) {
        this.id_comprador = id_comprador;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getFecha_de_venta() {
        return fecha_de_venta;
    }
    public void setFecha_de_venta(String fecha_de_venta) {
        this.fecha_de_venta = fecha_de_venta;
    }


    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", id_producto=" + id_producto + ", id_vendedor=" + id_vendedor + ", id_comprador=" + id_comprador + ", cantidad=" + cantidad + ", fecha_de_venta=" + fecha_de_venta + ", detalle=" + detalle + '}';
    }

    
    
}


