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

    public int calcularPrioridad() {
        if (condicion.equals("Embarazo")) {
            return 4;
        }
        if (edad < 12 || edad >= 60) {
            return 3;
        }
        if (condicion.equals("Limitacion motriz")) {
            return 2;
        }
        if (afiliacion.equals("PC")) {
            return 1;
        }
        return 0;
    }

}
