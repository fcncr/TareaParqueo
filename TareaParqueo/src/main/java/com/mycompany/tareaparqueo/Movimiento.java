
import java.time.LocalDateTime;

public class Movimiento {
    private String tipo;
    private LocalDateTime fechaHora;
    private double horasCobradas;
    private double tarifaHora;
    private double monto;
    
    //CONSTRUCTORES
    public Movimiento(String tipo, LocalDateTime fechaHora, double horasCobradas, double tarifaHora, double monto) {
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.horasCobradas = horasCobradas;
        this.tarifaHora = tarifaHora;
        this.monto = monto;
    }

    public Movimiento(String tipo, LocalDateTime fechaHora) {
        this.tipo = tipo;
        this.fechaHora = fechaHora;
    }
    
    //TO STRING
    @Override
    public String toString() {
        return "Movimiento{" + "tipo=" + tipo + ", fechaHora=" + fechaHora + ", horasCobradas=" + horasCobradas + ", tarifaHora=" + tarifaHora + ", monto=" + monto + '}';
    }
        
    //GETTERS
    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public double getHorasCobradas() {
        return horasCobradas;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public double getMonto() {
        return monto;
    }
    
    //SETTERS

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setHorasCobradas(double horasCobradas) {
        this.horasCobradas = horasCobradas;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
}
