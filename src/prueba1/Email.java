/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba1;

/**
 *
 * @author USER
 */
public class Email {
    private String emisor;
    private String Asunto;
    private String contenido;
    private boolean marcarleido;
    
    //atributos 
    public Email(String emisor, String asunto, String Contenido){
     //constructor
        this.emisor = emisor;
        this.Asunto = asunto;
        this.contenido = Contenido;
        this.marcarleido= false;
        
        
        
    }

    public String getEmisor() {
        return emisor;
    }

    public String getAsunto() {
        return Asunto;
    }

    public String getContenido() {
        return contenido;
    }
    
    
    public boolean isleido(){
        return marcarleido;
    }
       
    public void marcarComoLEido(){
        this.marcarleido =true;
    }
            
    public void imprimir(){
        System.out.println("DE: "+emisor);
        System.out.println("ASUNTO: "+ Asunto);
        System.out.println(contenido);
    }        
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
    
}
