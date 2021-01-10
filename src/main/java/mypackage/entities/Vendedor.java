
package mypackage.entities;


public class Vendedor {
    
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private int nro_documento;
    private int telefono;
    private String email;
    
    public Vendedor() {
    }
    
    public Vendedor(String nombre, String apellido, int edad, int nro_documento, int telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nro_documento = nro_documento;
        this.telefono = telefono;
        this.email = email;
    }
    
    public Vendedor(int id, String nombre, String apellido, int edad, int nro_documento, int telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.nro_documento = nro_documento;
        this.telefono = telefono;
        this.email = email;
    }
    
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getNro_documento() {
        return nro_documento;
    }
    public void setNro_documento(int nro_documento) {
        this.nro_documento = nro_documento;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    
    @Override
    public String toString() {
        return "Vendedor{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", nro_documento=" + nro_documento + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    
    
    
    
    
}
