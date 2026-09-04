package com.mycompany.tareaparqueo_fabiancn_genesisvu;

import java.time.LocalDateTime;

public class Parqueo {

    private Vehiculo[] espaciosLivianos;
    private Vehiculo[] espaciosMotoBici;

    private Vehiculo[] vehiculos;
    private int cantidadVehiculos;

    public Parqueo() {

        espaciosLivianos = new Vehiculo[25];
        espaciosMotoBici = new Vehiculo[10];

        vehiculos = new Vehiculo[1000];
        cantidadVehiculos = 0;
    }

    // OPCION 1
    public boolean ingresarVehiculo(Vehiculo vehiculo) {

        return false;
    }

    // OPCION 2
    public void consultarVehiculo(String criterio) {

    }

    // OPCION 3
    public void salidaPorPlaca(String placa) {

    }

    public void salidaPorPosicion(String posicion) {

    }

    // OPCION 4
    public void consultarParqueo() {

    }

    // OPCION 5
    public void consultarHistorico(String placa) {

    }

    // OPCION 6
    public void cierreDia() {

    }

    // -------------------------
    // METODOS AUXILIARES
    // -------------------------

    private Vehiculo buscarVehiculoPorPlaca(String placa) {

        return null;
    }

    private boolean placaEstaActiva(String placa) {

        return false;
    }

    private int buscarEspacioLiviano() {

        return -1;
    }

    private int buscarEspacioMotoBici() {

        return -1;
    }

    private int buscarEspaciosContiguos(int cantidad) {

        return -1;
    }

    private void liberarEspacios(Vehiculo vehiculo) {

    }

    private double calcularHoras(LocalDateTime entrada,
                                 LocalDateTime salida) {

        return 0;
    }

    private double obtenerTarifa(Vehiculo vehiculo) {

        return 0;
    }

    private double calcularMonto(Vehiculo vehiculo,
                                 double horas) {

        return 0;
    }

    public Vehiculo[] getEspaciosLivianos() {
        return espaciosLivianos;
    }

    public Vehiculo[] getEspaciosMotoBici() {
        return espaciosMotoBici;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }
}