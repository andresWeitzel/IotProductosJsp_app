
package mypackage.entities;


public class EspecificacionTecnica {

    private int id;
    private float longitud;
    private float ancho;
    private float peso;
    private String material;
    private float voltaje_de_funcionamiento;
    private float voltaje_min_entrada;
    private float voltaje_max_entrada;
    private int tiempo_de_vida;


    public EspecificacionTecnica() {
    }


    public EspecificacionTecnica(float longitud, float ancho, float peso, String material, float voltaje_de_funcionamiento, float voltaje_min_entrada, float voltaje_max_entrada, int tiempo_de_vida) {
        this.longitud = longitud;
        this.ancho = ancho;
        this.peso = peso;
        this.material = material;
        this.voltaje_de_funcionamiento = voltaje_de_funcionamiento;
        this.voltaje_min_entrada = voltaje_min_entrada;
        this.voltaje_max_entrada = voltaje_max_entrada;
        this.tiempo_de_vida = tiempo_de_vida;
    }


    public EspecificacionTecnica(int id, float longitud, float ancho, float peso, String material, float voltaje_de_funcionamiento, float voltaje_min_entrada, float voltaje_max_entrada, int tiempo_de_vida) {
        this.id = id;
        this.longitud = longitud;
        this.ancho = ancho;
        this.peso = peso;
        this.material = material;
        this.voltaje_de_funcionamiento = voltaje_de_funcionamiento;
        this.voltaje_min_entrada = voltaje_min_entrada;
        this.voltaje_max_entrada = voltaje_max_entrada;
        this.tiempo_de_vida = tiempo_de_vida;
    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getLongitud() {
        return longitud;
    }
    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }
    public float getAncho() {
        return ancho;
    }
    public void setAncho(float ancho) {
        this.ancho = ancho;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public float getVoltaje_de_funcionamiento() {
        return voltaje_de_funcionamiento;
    }
    public void setVoltaje_de_funcionamiento(float voltaje_de_funcionamiento) {
        this.voltaje_de_funcionamiento = voltaje_de_funcionamiento;
    }
    public float getVoltaje_min_entrada() {
        return voltaje_min_entrada;
    }
    public void setVoltaje_min_entrada(float voltaje_min_entrada) {
        this.voltaje_min_entrada = voltaje_min_entrada;
    }
    public float getVoltaje_max_entrada() {
        return voltaje_max_entrada;
    }
    public void setVoltaje_max_entrada(float voltaje_max_entrada) {
        this.voltaje_max_entrada = voltaje_max_entrada;
    }
    public int getTiempo_de_vida() {
        return tiempo_de_vida;
    }
    public void setTiempo_de_vida(int tiempo_de_vida) {
        this.tiempo_de_vida = tiempo_de_vida;
    }
    
    @Override
    public String toString() {
        return "Longitud=" + longitud + "mm , Ancho=" + ancho + "mm, Peso=" + peso + " Kg, Material=" + material + ", Voltaje de Funcionamiento=" + voltaje_de_funcionamiento + " Volts, Voltaje Minimo de Entrada=" + voltaje_min_entrada + " Volts, Voltaje Maximo de Entrada=" + voltaje_max_entrada + "Volts, Tiempo de Vida Util=" + tiempo_de_vida +" Años.";
    }




    
}
