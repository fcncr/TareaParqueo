package com.mycompany.tareaparqueo_fabiancn_genesisvu;

import java.time.LocalDateTime;

public class Movimiento {

    private String tipo;
    private LocalDateTime fechaHora;
    private double horasCobradas;
    private double tarifaHora;
    private double monto;

    public Movimiento(String tipo, LocalDateTime fechaHora) {
        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.horasCobradas = 0;
        this.tarifaHora = 0;
        this.monto = 0;
    }

    public Movimiento(String tipo, LocalDateTime fechaHora,
                      double horasCobradas, double tarifaHora, double monto) {

        this.tipo = tipo;
        this.fechaHora = fechaHora;
        this.horasCobradas = horasCobradas;
        this.tarifaHora = tarifaHora;
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getHorasCobradas() {
        return horasCobradas;
    }

    public void setHorasCobradas(double horasCobradas) {
        this.horasCobradas = horasCobradas;
    }

    public double getTarifaHora() {
        return tarifaHora;
    }

    public void setTarifaHora(double tarifaHora) {
        this.tarifaHora = tarifaHora;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}