
import java.time.LocalDateTime;

public class Movimiento {
    private String tipo;
    private LocalDateTime fechaHora;
    private double horasCobradas;
    private double tarifaHora;
    private double monto;
    
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
    
}
