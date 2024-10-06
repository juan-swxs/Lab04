package Exercise01;

public class Paciente {
    private String nombre;
    private int edad;
    private String afiliacion;
    private String condicion;

    public Paciente(String nombre, int edad, String afiliacion, String condicion) {
        this.nombre = nombre;
        this.edad = edad;
        this.afiliacion = afiliacion;
        this.condicion = condicion;
    }

   
    public String getNombre() { 
        return nombre;
     }

    public int getEdad() { 
        return edad; 
    }

    public String getAfiliacion() { 
        return afiliacion;
     }

    public String getCondicion() { 
        return condicion; 
    }

}
