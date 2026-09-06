
package com.mycompany.tareaparqueo;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Duration;

public class Parqueo {
    private Vehiculo[] parqueoLivianos;
    private Vehiculo[] parqueoMotocicletas;
    private Vehiculo[] vehiculos;
    private int cantidadVehiculos;
    
    //Constructores
    public Parqueo(){
        this.parqueoLivianos = new Vehiculo[25];
        this.parqueoMotocicletas = new Vehiculo[10];
        this.vehiculos = new Vehiculo[100];
        this.cantidadVehiculos = 0;
    }
    
    //E: Vehiculo
    //S: boleano (True si se añadió con éxito)
    public boolean Ingresarvehiculo(Vehiculo vehiculo){
        
        if (cantidadVehiculos >= vehiculos.length){
            System.out.println("No hay espacio disponible en el historial.");
            return false;
        }
        
        if (vehiculo.getTipo().equalsIgnoreCase("BICICLETA")){
            for (int i=0; i<10; i++){
                if (this.parqueoMotocicletas[i] == null){
                    this.parqueoMotocicletas[i] = vehiculo;
                    vehiculo.setEnParqueo(true);
                    Movimiento movimiento = new Movimiento("ENTRADA",LocalDateTime.now());
                    vehiculo.agregarMovimiento(movimiento);
           
                    vehiculos[cantidadVehiculos] = vehiculo;
                    cantidadVehiculos++;
                    return true;
                }
            }
            return false;
        }else{
            if (!buscarPlaca(vehiculo.getPlaca())){
                        if (vehiculo.getTipo().equalsIgnoreCase("MOTOCICLETA")){
                            for (int i=0; i<10; i++){
                                if (this.parqueoMotocicletas[i] == null){
                                   
                                    vehiculos[cantidadVehiculos] = vehiculo;
                                    cantidadVehiculos++;

                                    this.parqueoMotocicletas[i] = vehiculo;
                                    vehiculo.setEnParqueo(true);
                                    Movimiento movimiento = new Movimiento("ENTRADA",LocalDateTime.now());
                                    vehiculo.agregarMovimiento(movimiento);
                                    return true;
                                }
                            }
                            return false;
                        }else{
                            int posicion = buscarContiguos(vehiculo.getCantidadEspacios());
                            if (posicion==-1){return false;}
                                
                            for (int i = posicion; i < posicion + vehiculo.getCantidadEspacios();i++) {
                                   this.parqueoLivianos[i] = vehiculo;
                            }
                           
                            vehiculo.setEnParqueo(true);
                            Movimiento movimiento = new Movimiento("ENTRADA", LocalDateTime.now());
                            vehiculo.agregarMovimiento(movimiento);
                            vehiculos[cantidadVehiculos] = vehiculo;
                            cantidadVehiculos++;
                            return true;
                        }
                }
            }
            return false;
        }
        
    public void consultarHistorial(String placa){
        boolean encontrado = false;
        for (int i = 0;i < cantidadVehiculos;i++){
            if (vehiculos[i].getPlaca() != null && vehiculos[i].getPlaca().equalsIgnoreCase(placa)){
                for (int k=0;k < vehiculos[i].getCantidadMovimientos();k++){
                    System.out.println(vehiculos[i].getMovimientos()[k].toString());
                }
                if (vehiculos[i].getMovimientos()[vehiculos[i].getCantidadMovimientos()-1].getTipo().equalsIgnoreCase("ENTRADA")){
                    System.out.println("-> Vehiculo aun esta en el parqueo <-");
                }
                encontrado = true;
            }
        }
        if (!encontrado){
            System.out.println("No se encontro historial para esa placa.");
        }
    }
     
    //E: String identificador
    //S: N/A
    public void consultarVehiculo(String id){
        boolean bandera = false;
        for (int i = 0; i < 25; i ++){
            if(parqueoLivianos[i] != null && parqueoLivianos[i].getPlaca() != null && id.equalsIgnoreCase(parqueoLivianos[i].getPlaca())){
                mostrarConsulta(parqueoLivianos[i]);
                return;
            }
        }
        for (int i = 0; i < 10; i ++){
            if(parqueoMotocicletas[i] != null && parqueoMotocicletas[i].getPlaca() != null && id.equalsIgnoreCase(parqueoMotocicletas[i].getPlaca())){
                mostrarConsulta(parqueoMotocicletas[i]);
                return;
            }
        }
        for (int i = 0; i < 10; i ++){
            if(parqueoMotocicletas[i] != null && parqueoMotocicletas[i].getDescripcion() != null && parqueoMotocicletas[i].getDescripcion().toLowerCase().contains(id.toLowerCase())){
                mostrarConsulta(parqueoMotocicletas[i]);
                bandera = true;
            }
        }
        
        if(bandera == false)
            System.out.println("No se encontro el vehiculo");   
    }
            
    //E: Vehiculo
    //S: N/A
    private void mostrarConsulta(Vehiculo vehiculo) {
        Movimiento entrada = null;
        //Buscar el ultimo movimiento de ENTRADA
        for (int i = vehiculo.getCantidadMovimientos() - 1; i >= 0; i--) {
            if (vehiculo.getMovimientos()[i] != null
                    && vehiculo.getMovimientos()[i].getTipo().equalsIgnoreCase("ENTRADA")) {

                entrada = vehiculo.getMovimientos()[i];
                break;
            }
        }

        if (entrada == null) {
            return;
        }

        double horas = calcularHoras(entrada.getFechaHora(),LocalDateTime.now());
        double monto = calcularMonto(vehiculo,horas);
        
        System.out.println("");
        System.out.println("-------> VEHICULO <-------");
        
        if (vehiculo.getTipo().equalsIgnoreCase("BICICLETA")) {
            System.out.println( "Descripcion: " + vehiculo.getDescripcion());
        } else {
            System.out.println("Placa: " + vehiculo.getPlaca());
        }

        System.out.println("Tipo: " + vehiculo.getTipo());
        System.out.println("Entrada: " + entrada.getFechaHora());
        System.out.println("Horas hasta el momento: " + horas);
        System.out.println("Monto hasta el momento: " + monto);
        System.out.println("");
    }
    
    //E: Strings (placa y tipo)
    //S: booleano (True si se encontró, False si no)
    public boolean buscarPlaca(String placa){
        for (int i=0; i<10;i++){
            if (parqueoMotocicletas[i] != null && parqueoMotocicletas[i].getPlaca() != null && parqueoMotocicletas[i].getPlaca().equalsIgnoreCase(placa)){
                return true;
            }
        }
        
        for (int i=0; i<25;i++){
            if (parqueoLivianos[i] != null && parqueoLivianos[i].getPlaca() != null && parqueoLivianos[i].getPlaca().equalsIgnoreCase(placa)){
                return true;
            }
        }
        return false;        
    }
    
    
    //E: N/A
    //S: N/A
    public void consultarParqueo(){
        for (int i = 0; i < 25; i++) {
            if (parqueoLivianos[i] != null){
                System.out.println("");
                System.out.println("ESPACIO " + (i+1) + " OCUPADO");
                mostrarConsulta(parqueoLivianos[i]);
            }else{
                System.out.println("ESPACIO " + (i+1) + " DISPONIBLE");
            }
        }
        
        for (int i = 0; i < 10; i++) {
            if (parqueoMotocicletas[i] != null){
                System.out.println("");
                System.out.println("ESPACIO M" + (i+1) + " OCUPADO");
                mostrarConsulta(parqueoMotocicletas[i]);
            }else{
                System.out.println("ESPACIO M" + (i+1) + " DISPONIBLE");
            }
        }
    }
    
    //E: Placa del vehiculo
    //S: N/A
    public void salidaPorPlaca(String placa) {
        //Buscar en vehiculos livianos y grandes
        for (int i = 0; i < 25; i++) {

            if (parqueoLivianos[i] != null && parqueoLivianos[i].getPlaca() != null && parqueoLivianos[i].getPlaca().equalsIgnoreCase(placa)) {
                salidaPorPosicion(Integer.toString(i + 1));
                return;
            }
        }
        //Buscar en motocicletas
        for (int i = 0; i < 10; i++) {
            if (parqueoMotocicletas[i] != null && parqueoMotocicletas[i].getPlaca() != null && parqueoMotocicletas[i].getPlaca().equalsIgnoreCase(placa)) {
                salidaPorPosicion("M" + (i + 1));
                return;
            }
        }
        System.out.println("No se encontro un vehiculo con esa placa.");
    }
    
    //E: Posicion del vehiculo
    //S: N/A
    public void salidaPorPosicion(String pos){
        int posActual =0;
        for(int i = 0; i < 25; i++){
            posActual = i+1;
            if(Integer.toString(posActual).equalsIgnoreCase(pos) && parqueoLivianos[i] != null){
                double horasCalculadas = calcularHoras(parqueoLivianos[i].getMovimientos()[parqueoLivianos[i].getCantidadMovimientos()-1].getFechaHora(), LocalDateTime.now());
                double monto = calcularMonto(parqueoLivianos[i], horasCalculadas);
                Movimiento nuevoMovimiento = new Movimiento("SALIDA", LocalDateTime.now(), horasCalculadas, 1000, monto);
                parqueoLivianos[i].agregarMovimiento(nuevoMovimiento);
                parqueoLivianos[i].setEnParqueo(false);
                System.out.println("\nVehiculo: " + parqueoLivianos[i].getPlaca());
                System.out.println("Entrada: " + parqueoLivianos[i].getMovimientos()[parqueoLivianos[i].getCantidadMovimientos() - 2].getFechaHora());
                System.out.println("Salida: " + nuevoMovimiento.getFechaHora());
                System.out.println("Horas cobradas: " + horasCalculadas);
                System.out.println("Tarifa: 1000");
                System.out.println("Monto: " + monto);
                
                Vehiculo vehiculo = parqueoLivianos[i];
                for (int k = 0; k < parqueoLivianos.length; k++) {
                    if (parqueoLivianos[k] == vehiculo) {
                        parqueoLivianos[k] = null;
                    }
                }
                return;
            }
        }
        for(int i = 0; i < 10; i++){
            posActual = i+1;
            if(("M" + posActual).equalsIgnoreCase(pos) && parqueoMotocicletas[i] != null){
                double horasCalculadas = calcularHoras(parqueoMotocicletas[i].getMovimientos()[parqueoMotocicletas[i].getCantidadMovimientos()-1].getFechaHora(), LocalDateTime.now());
                double monto = calcularMonto(parqueoMotocicletas[i], horasCalculadas);
                Movimiento nuevoMovimiento = new Movimiento("SALIDA", LocalDateTime.now(), horasCalculadas, 800, monto);
                parqueoMotocicletas[i].agregarMovimiento(nuevoMovimiento);
                parqueoMotocicletas[i].setEnParqueo(false);
                
                
                if (parqueoMotocicletas[i].getTipo().equalsIgnoreCase("BICICLETA")) {
                    System.out.println("\nDescripcion: " + parqueoMotocicletas[i].getDescripcion());
                }
                else{
                    System.out.println("\nPlaca: " + parqueoMotocicletas[i].getPlaca());
                }
                System.out.println("Entrada: "+ parqueoMotocicletas[i].getMovimientos()[parqueoMotocicletas[i].getCantidadMovimientos() - 2].getFechaHora());
                System.out.println("Salida: " + nuevoMovimiento.getFechaHora());
                System.out.println("Horas cobradas: " + horasCalculadas);
                System.out.println("Tarifa: 800");
                System.out.println("Monto: " + monto);

                parqueoMotocicletas[i] = null;
                return;
            }
        } 
        System.out.println("No se encontro un vehiculo en esa posicion.");
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
        
        long segundos = Duration.between(entrada, salida).getSeconds();
        long horasCompletas = segundos/3600;
        long segundosRestantes = segundos%3600;
        double horasCobradas = horasCompletas;
        
        if(segundosRestantes > 0 && segundosRestantes <= 1800){
            horasCobradas += 0.5;
        }
        else if (segundosRestantes > 1800){
            horasCobradas += 1;
        }
        
        return horasCobradas;
    }
    
    //E: Vehiculo y horas cobradS
    //S: double monto a cobrar 
    private double calcularMonto (Vehiculo vehiculo, double horasCobradas){
        double resultado = 0;
        if (vehiculo.getTipo().equalsIgnoreCase("BICICLETA") || vehiculo.getTipo().equalsIgnoreCase("MOTOCICLETA")){
            resultado = horasCobradas * 800;
        }
        else
            resultado = horasCobradas * 1000;
        
        return resultado;
    }
    
    //E: N/A
    //S: N/A
    public void cierreDia(){
        double totalRecaudado = 0;
        System.out.println("\n------- CIERRE DEL DIA -------");
        System.out.println("Ultimos vehiculos en salir: ");
        System.out.println("");

        for (int i = 0; i < parqueoLivianos.length; i++){
            if (parqueoLivianos[i] != null){
                salidaPorPosicion(Integer.toString(i + 1));
            }
        }

        for (int i = 0; i < parqueoMotocicletas.length; i++){
            if (parqueoMotocicletas[i] != null){
                salidaPorPosicion("M" + (i + 1));
            }
        }
        
        
        System.out.println("\n------- HISTORIAL DEL DIA -------");
        for (int i = 0; i < cantidadVehiculos; i++){
            Movimiento ultimoMovimiento = vehiculos[i].getMovimientos()[vehiculos[i].getCantidadMovimientos() - 1];

            if (ultimoMovimiento.getTipo().equalsIgnoreCase("SALIDA") && ultimoMovimiento.getFechaHora().toLocalDate().equals(LocalDate.now())){
                System.out.println("");
                if (vehiculos[i].getTipo().equalsIgnoreCase("BICICLETA")){
                    System.out.println("Descripcion: " + vehiculos[i].getDescripcion());
                }
                else{
                    System.out.println("Placa: " + vehiculos[i].getPlaca());}

                    System.out.println("Horas cobradas: " + ultimoMovimiento.getHorasCobradas());
                    System.out.println("Monto: " + ultimoMovimiento.getMonto());
                    System.out.println("------------------------------");
                    totalRecaudado += ultimoMovimiento.getMonto();
            }
        }
        System.out.println("");
        System.out.println("TOTAL RECAUDADO DEL DIA: " + totalRecaudado);
    }
}
