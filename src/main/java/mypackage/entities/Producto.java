package mypackage.entities;

public class Producto {

    private int id;
    private int id_especificacion_tecnica;
    private  String area;
    private String funcion;
    private String tipo;
    private String nombre;
    private String modelo;
    private String tamaño;
    private float precio;
    private String estado;
    
    
    
    public Producto() {
    }
    
    
    public Producto(int id_especificacion_tecnica, String area, String funcion, String tipo, String nombre, String modelo, String tamaño, float precio, String estado) {
        this.id_especificacion_tecnica = id_especificacion_tecnica;
        this.area = area;
        this.funcion = funcion;
        this.tipo = tipo;
        this.nombre = nombre;
        this.modelo = modelo;
        this.tamaño = tamaño;
        this.precio = precio;
        this.estado = estado;
    }
    
    
    public Producto(int id, int id_especificacion_tecnica, String area, String funcion, String tipo, String nombre, String modelo, String tamaño, float precio, String estado) {
        this.id = id;
        this.id_especificacion_tecnica = id_especificacion_tecnica;
        this.area = area;
        this.funcion = funcion;
        this.tipo = tipo;
        this.nombre = nombre;
        this.modelo = modelo;
        this.tamaño = tamaño;
        this.precio = precio;
        this.estado = estado;
    }
    
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_especificacion_tecnica() {
        return id_especificacion_tecnica;
    }
    public void setId_especificacion_tecnica(int id_especificacion_tecnica) {
        this.id_especificacion_tecnica = id_especificacion_tecnica;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getFuncion() {
        return funcion;
    }
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getTamaño() {
        return tamaño;
    }
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", id_especificacion_tecnica=" + id_especificacion_tecnica + ", area=" + area + ", funcion=" + funcion + ", tipo=" + tipo + ", nombre=" + nombre + ", modelo=" + modelo + ", tama\u00f1o=" + tamaño + ", precio=" + precio + ", estado=" + estado + '}';
    }
    
   
    
}
