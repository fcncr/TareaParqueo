
package com.mycompany.tareaparqueo;

public class Vehiculo {
    private String tipo;
    private String placa;
    private String descripcion;
    private boolean enParqueo;
    private int cantidadEspacios;
    private Movimiento[] movimientos;
    private int cantidadMovimientos;

    //Constructor

    public Vehiculo(String tipo, String placa, int cantidadEspacios) {
        this.tipo = tipo;
        this.placa = placa;
        this.cantidadEspacios = cantidadEspacios;
        
     
        this.enParqueo = false;

        movimientos = new Movimiento[100];
        cantidadMovimientos = 0;
    }
    
    public Vehiculo(String tipo, int cantidadEspacios, String descripcion) {
        this.tipo = tipo;
        this.cantidadEspacios = cantidadEspacios;
        this.descripcion = descripcion;
        
        this.enParqueo = false;

        movimientos = new Movimiento[100];
        cantidadMovimientos = 0;
    }
    
    //TO STRING
    /*
    @Override
    public String toString() {
        
        String texto = "";
        
        texto = "Vehiculo tipo: " + tipo + "\n"+
                "Placa: " + placa +"\n"+
                "Descripcion" + descripcion + "\n";
                
        return texto;
    }*/
    
    
    //GETTERS
    
     public String getTipo() {
        return tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isEnParqueo() {
        return enParqueo;
    }

    public int getCantidadEspacios() {
        return cantidadEspacios;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public int getCantidadMovimientos() {
        return cantidadMovimientos;
    }
    
    //SETTERS

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEnParqueo(boolean enParqueo) {
        this.enParqueo = enParqueo;
    }

    public void setCantidadEspacios(int cantidadEspacios) {
        this.cantidadEspacios = cantidadEspacios;
    }

    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }

    public void setCantidadMovimientos(int cantidadMovimientos) {
        this.cantidadMovimientos = cantidadMovimientos;
    }
    
    
    
    public void agregarMovimiento(Movimiento movimiento){
        
        if (this.cantidadMovimientos < movimientos.length){
            this.movimientos[this.cantidadMovimientos] = movimiento;
            this.cantidadMovimientos++;
        }
 
    }
    
    public void cambiarEstado(){
        if (this.enParqueo){
                this.enParqueo = false;
            }
            else
                this.enParqueo = true;
    }
   
}
