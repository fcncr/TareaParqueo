/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareaparqueo;

/**
 *
 * @author fabic
 */
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
}
