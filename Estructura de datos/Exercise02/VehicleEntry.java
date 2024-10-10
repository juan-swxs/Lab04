package Exercise02;

public class VehicleEntry {

    private String placa;
    private String tipoVehiculo;
    private String hora;

    public VehicleEntry(String placa, String tipoVehiculo, String hora) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.hora = hora;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipoVehiculo;
    }

    public String getHora() {
        return hora;
    }
    
}
