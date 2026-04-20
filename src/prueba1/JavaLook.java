/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class JavaLook {
    private static EmailAccount[] cuentas = new EmailAccount[100];
    private static EmailAccount cuentaActiva = null;
    private static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
         int opcion;
        do {
            System.out.println("\n--- JAVALOOK INICIO ---");
            System.out.println("1. Login");
            System.out.println("2. Crear Cuenta");
            System.out.println("3. Salir");
            System.out.print("Seleccione: ");
            opcion = scn.nextInt();

            switch (opcion) {
                case 1 -> login();
                case 2 -> crearCuenta();
            }

            if (cuentaActiva != null) {
                menuPrincipal();
            }
        } while (opcion != 3);
    }

    private static void login() {
        boolean haycuentas = false;
        for (EmailAccount acc : cuentas){
            if (acc != null) {
                haycuentas = true;
                break;
            }
        }
        if (!haycuentas) {
            System.out.println("ERROR: no hay cuentas registradas en el sistema :c");
            return;
        }
        System.out.print("Email: ");
        String correo = scn.next();
        System.out.print("Password: ");
        String pass = scn.next();

        for (EmailAccount acc : cuentas) {
            if (acc != null && acc.getDireccion().equals(correo) && acc.getContrase().equals(pass)) {
                cuentaActiva = acc;
                return;
            }
        }
        System.out.println("Credenciales incorrectas");
    }

    private static void crearCuenta() {
        System.out.print("Direccion de correo: ");
        String correo = scn.next();
        
        for (EmailAccount acc : cuentas) {
            if (acc != null && acc.getDireccion().equals(correo)) {
                System.out.println("Error: El correo ya existe");
                return;
            }
        }

        System.out.print("Nombre completo: ");
        scn.nextLine(); 
        String nombre = scn.nextLine();
        System.out.print("Contraseña: ");
        String pass = scn.next();

        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = new EmailAccount(correo, pass, nombre);
                cuentaActiva = cuentas[i];
                System.out.println("Cuenta creada exitosamente");
                return;
            }
        }
    }

    private static void menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL (" + cuentaActiva.getNombre() + ") ---");
            System.out.println("1. Ver Inbox");
            System.out.println("2. Mandar Correo");
            System.out.println("3. Leer un Correo");
            System.out.println("4. Limpiar Inbox");
            System.out.println("5. Cerrar Sesion");
            System.out.print("Seleccione: ");
            opcion = scn.nextInt();

            switch (opcion) {
                case 1 -> cuentaActiva.mostrarInbox();
                case 2 -> mandarCorreo();
                case 3 -> {
                    System.out.print("Posicion: ");
                    cuentaActiva.leerCorreo(scn.nextInt());
                }
                case 4 -> cuentaActiva.eliminarLeidos();
                case 5 -> cuentaActiva = null;
            }
        } while (cuentaActiva != null);
    }

    private static void mandarCorreo() {
        System.out.print("Destinatario: ");
        String destino = scn.next();
        System.out.print("Asunto: ");
        scn.nextLine();
        String asunto = scn.nextLine();
        System.out.print("Contenido: ");
        String contenido = scn.nextLine();

        for (EmailAccount acc : cuentas) {
            if (acc != null && acc.getDireccion().equals(destino)) {
                Email nuevo = new Email(cuentaActiva.getDireccion(), asunto, contenido);
                if (acc.recibirCorreo(nuevo)) {
                    System.out.println("Correo enviado");
                } else {
                    System.out.println("Buzon lleno");
                }
                return;
            }
        }
        System.out.println("Destinatario no existe.");
    }
    
    
    
    
    
}
