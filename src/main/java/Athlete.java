/**
 * Created by Alvaro on 20/01/2017.
 */
public class Athlete {

    public Long id;
    public String nombre;
    public String apellidos;
    public String nacionalidad;

    public Athlete() {}

    public Athlete(String nombre, String apellidos, String nacionalidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}

    public String getNacionalidad() {return nacionalidad;}
    public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}

    @Override
    public String toString() {
        return "Athlete{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}