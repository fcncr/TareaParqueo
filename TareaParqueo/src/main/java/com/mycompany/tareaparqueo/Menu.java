package com.mycompany.tareaparqueo;

import java.util.Scanner;

public class Menu {

    private Scanner teclado;
    private Parqueo parqueo;

    //Constructor
    public Menu() {
        teclado = new Scanner(System.in);
        parqueo = new Parqueo();
    }

    public void ejecutar() {
        String opcion="";
        while (!opcion.equals("7")) {
            
            System.out.println("");
            System.out.println("------------------------------");
            System.out.println("           PARQUEO            ");
            System.out.println("------------------------------");
            System.out.println("1. Ingresar Vehiculo");
            System.out.println("2. Consultar Vehiculo");
            System.out.println("3. Salida de Vehiculo");
            System.out.println("4. Consultar Parqueo");
            System.out.println("5. Consultar Historial");
            System.out.println("6. Cierre del Dia");
            System.out.println("7. Salir");
            System.out.println("");
            System.out.print("Digite una opcion: ");

            opcion = teclado.nextLine();
            switch (opcion) {

                case "1":
                    ingresarVehiculo();
                    break;
                case "2":
                    consultarVehiculo();
                    break;
                case "3":
                    salidaVehiculo();
                    break;
                case "4":
                    parqueo.consultarParqueo();
                    break;
                case "5":
                    consultarHistorial();
                    break;
                case "6":
                    parqueo.cierreDia();
                    break;
                case "7":
                    System.out.println("");
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("");
                    System.out.println("Opcion invalida.");
                    break;
            }
        }
    }

    private void ingresarVehiculo() {
        
        System.out.println("");
        System.out.println("--------- INGRESAR VEHICULO ---------");
        System.out.println("1. Vehiculo Liviano");
        System.out.println("2. Motocicleta");
        System.out.println("3. Bicicleta");
        System.out.println("4. Vehiculo Grande");
        System.out.println("");
        System.out.print("Digite el tipo: ");

        String tipo = teclado.nextLine();
        Vehiculo vehiculo = null;
        
        System.out.println("");
        switch (tipo) {
            case "1":
                System.out.print("Digite la placa: ");
                String placaLiviano = teclado.nextLine();
                
                if (placaLiviano.trim().isEmpty()){
                    System.out.println("La placa no puede estar vacia.");
                    return;
                }
                vehiculo = new Vehiculo("LIVIANO", placaLiviano,1);
                break;

            case "2":
                System.out.print("Digite la placa: ");
                String placaMoto = teclado.nextLine();
                
                if (placaMoto.trim().isEmpty()){
                    System.out.println("La placa no puede estar vacia.");
                    return;
                }
                
                vehiculo = new Vehiculo("MOTOCICLETA",placaMoto,1);
                break;

            case "3":
                System.out.print("Digite la descripcion de la bicicleta: ");
                String descripcion = teclado.nextLine();
                
                if (descripcion.trim().isEmpty()){
                    System.out.println("La descripcion no puede estar vacia.");
                    return;
                }
                
                vehiculo = new Vehiculo("BICICLETA",1,descripcion);
                break;

            case "4":
                System.out.print("Digite la placa: ");
                String placaGrande = teclado.nextLine();
                
                if (placaGrande.trim().isEmpty()){
                    System.out.println("La placa no puede estar vacia.");
                    return;
                }
                
                System.out.print("Digite la cantidad de espacios que necesita: ");
                try{
                    int cantidadEspacios = Integer.parseInt(teclado.nextLine());

                    if (cantidadEspacios < 1 || cantidadEspacios > 10) {
                        System.out.println("Cantidad de espacios invalida");
                        return;
                    }              
       
                    vehiculo = new Vehiculo("GRANDE",placaGrande,cantidadEspacios);
                }
                catch (NumberFormatException e){
                    System.out.println("Debe ingresar un numero entero");
                    return;
                }
                break;

            default:
                System.out.print("Tipo de vehiculo invalido.");
                return;
        }

        if (parqueo.Ingresarvehiculo(vehiculo)) {
            System.out.println("Vehiculo ingresado correctamente.");
        } else {
            System.out.println("No se pudo ingresar el vehiculo.");
        }
    }

    private void consultarVehiculo() {
        System.out.println("");
        System.out.println("--------- CONSULTAR VEHICULO ---------");
        System.out.println("");
        System.out.print("Digite la placa o descripcion de la bicicleta: ");
        
        String id = teclado.nextLine();
        parqueo.consultarVehiculo(id);
    }

    private void salidaVehiculo() {
        System.out.println("");
        System.out.println("--------- SALIDA DE VEHICULO ---------");
        System.out.println("1. Salida por placa");
        System.out.println("2. Salida por posicion");
        System.out.println("");
        System.out.print("Digite una opcion: ");

        String opcionSalida = teclado.nextLine();
        
        System.out.println("");
        switch (opcionSalida) {

            case "1":
                System.out.print("Digite la placa: ");
                String placa = teclado.nextLine();
                parqueo.salidaPorPlaca(placa);
                break;

            case "2":
                System.out.print("Digite la posicion (Ejemplo: 5 o M3): ");
                String posicion = teclado.nextLine();
                parqueo.salidaPorPosicion(posicion);
                break;

            default:
                System.out.println("Opcion de salida invalida.");
                break;
        }
    }

    private void consultarHistorial() {
        System.out.println("");
        System.out.println("--------- CONSULTAR VEHICULO ---------");
        System.out.println("");
        System.out.print("Digite la placa: ");

        String placa = teclado.nextLine();
        parqueo.consultarHistorial(placa);
    }
}