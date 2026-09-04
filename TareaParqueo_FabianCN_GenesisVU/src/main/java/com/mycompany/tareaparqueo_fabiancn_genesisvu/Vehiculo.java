package com.mycompany.tareaparqueo_fabiancn_genesisvu;

public class Vehiculo {

    private String placa;
    private String descripcion;
    private String tipo;
    private boolean enParqueo;
    private int cantidadEspacios;

    private Movimiento[] movimientos;
    private int cantidadMovimientos;

    public Vehiculo(String placa, String descripcion,
                    String tipo, int cantidadEspacios) {

        this.placa = placa;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidadEspacios = cantidadEspacios;

        this.enParqueo = false;

        movimientos = new Movimiento[100];
        cantidadMovimientos = 0;
    }

    public void agregarMovimiento(Movimiento movimiento) {

    }

    public String getIdentificacion() {

        return "";
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEnParqueo() {
        return enParqueo;
    }

    public void setEnParqueo(boolean enParqueo) {
        this.enParqueo = enParqueo;
    }

    public int getCantidadEspacios() {
        return cantidadEspacios;
    }

    public void setCantidadEspacios(int cantidadEspacios) {
        this.cantidadEspacios = cantidadEspacios;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public int getCantidadMovimientos() {
        return cantidadMovimientos;
    }

    public void setCantidadMovimientos(int cantidadMovimientos) {
        this.cantidadMovimientos = cantidadMovimientos;
    }
}