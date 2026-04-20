/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

/**
 *
 * @author USER
 */
public class EmailAccount {
    private String direccion; 
    private String contrase;
    private String nombre;
    private Email[] inbox;
    
    
    public EmailAccount(String direccion, String contrase, String nombre){
        this.direccion = direccion;
        this.contrase=contrase;
        this.nombre = nombre; 
        this.inbox = new Email[100];
        
        
        
        
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContrase() {
        return contrase;
    }

    public String getNombre() {
        return nombre;
    }
    
    public boolean recibirCorreo(Email mail){
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i]== null) {
                inbox[i]= mail;
                return true;
            }
        }
        return false;
    }
    
    
    
        public void mostrarInbox() {
        System.out.println("\nCUENTA: " + direccion + " | USUARIO: " + nombre);
        int sinLeer = 0;
        int total = 0;

        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null) {
                total++;
                String estado = inbox[i].isleido() ? "LEIDO" : "SIN LEER";
                if (!inbox[i].isleido()) sinLeer++;
                
                System.out.printf("%d - %s - %s - (%s)\n", 
                    (i+1) , inbox[i].getEmisor(), inbox[i].getAsunto(), estado);
            }
        }
        System.out.println("Correos sin leer: " + sinLeer);
        System.out.println("Total recibidos: " + total);
    }
    
    
    
    
    public void leerCorreo(int posicion) {
        if (posicion >= 0 && posicion < 100 && inbox[posicion] != null) {
            inbox[posicion].imprimir();
            inbox[posicion].marcarComoLEido();
        } else {
            System.out.println("Correo No Existe :c");
        }
    }
        public void eliminarLeidos() {
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null && inbox[i].isleido()) {
                inbox[i] = null;
            }
        }
        System.out.println("Inbox limpiado");
    }
    
    
    
}
