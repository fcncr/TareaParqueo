package com.mycompany.tareaparqueo_fabiancn_genesisvu;

import java.util.Scanner;

public class Menu {

    private Scanner entrada;

    public Menu() {
        entrada = new Scanner(System.in);
    }

    public void ejecutar() {

        int opcion;

        do {
            System.out.println("\n===== MENU PARQUEO =====");
            System.out.println("1. Ingresar Vehiculo");
            System.out.println("2. Consultar Vehiculo");
            System.out.println("3. Salida de Vehiculo");
            System.out.println("4. Consultar parqueo");
            System.out.println("5. Consultar historico de Vehiculo");
            System.out.println("6. Cierre del dia");
            System.out.println("7. Salir");
            System.out.print("Digite una opcion: ");

            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingresar Vehiculo");
                    break;

                case 2:
                    System.out.println("Consultar Vehiculo");
                    break;

                case 3:
                    System.out.println("Salida de Vehiculo");
                    break;

                case 4:
                    System.out.println("Consultar parqueo");
                    break;

                case 5:
                    System.out.println("Consultar historico de Vehiculo");
                    break;

                case 6:
                    System.out.println("Cierre del dia");
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 7);
    }
}