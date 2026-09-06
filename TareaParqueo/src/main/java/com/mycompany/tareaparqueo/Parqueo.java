
package com.mycompany.tareaparqueo;
import java.time.LocalDateTime;
import java.time.Duration;

public class Parqueo {
    private Vehiculo[] parqueoLivianos;
    private Vehiculo[] parqueoMotocicletas;
    private Vehiculo[] vehiculos;
    private int cantidadVehiculos;
    
    //Constructores
    public Parqueo(){
        this.parqueoLivianos = new Vehiculo[25];
        this.parqueoMotocicletas = new Vehiculo[10];;
        this.vehiculos = new Vehiculo[100];
        this.cantidadVehiculos = 0;
    }
    
    //E: entero cantidad
    //S: entero (posicion o -1 si no hay espacio disponible)
    private int buscarContiguos(int cantidad){
        int counter = 0;
        for (int i =0; i <25; i++){
            if (i==10 || i==20){
                counter = 0;
            }
            if (this.parqueoLivianos[i] == null){
                counter ++;
                if (counter == cantidad){
                    return i-cantidad +1;
                }
            }
            else {
                counter = 0;
            }
        }
        return -1;    
    }
    
    //E: Horas de entrada y salida
    //S: Double horasCobradas
    private double calcularHoras(LocalDateTime entrada, LocalDateTime salida){
        long minutos = Duration.between(entrada, salida).toMinutes();
        long horasCompletas = minutos/60;
        long minutosRestantes = minutos% 60;
        double horasCobradas = horasCompletas;
        
        if(minutosRestantes > 0 && minutosRestantes <= 30){
            horasCobradas += 0.5;
        }
        else if (minutosRestantes > 30){
            horasCobradas += 1;
        }
        
        return horasCobradas;
    }
    
    private double calcularMonto (Vehiculo vehiculo, double horasCobradas){
        double resultado = 0;
        if (vehiculo.getTipo().equalsIgnoreCase("BICICLETA") || vehiculo.getTipo().equalsIgnoreCase("MOTOCICLETA")){
            resultado = horasCobradas * 800;
        }
        else
            resultado = horasCobradas * 1000;
        
        return resultado;
    }
}
