package mx.com.gtsf.arquitecturaibero.model;

public class AlumnosLoginModelDatos {

    private String nombre;
    private String carrera;

    public AlumnosLoginModelDatos() {
    }

    public AlumnosLoginModelDatos(String nombre, String carrera) {
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "AlumnosLoginModelDatos{" +
                "nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
