/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview;

/**
 *
 * @author PC
 */
public class Utiles {
    
    
    public static Persona[] Rellenar( Persona array[]){
    
      String nombres[]={"Mario","Alberto","Israel"};
      int edades[]={35,33,40};
      String ciudades[]={"Madrid","Almeria","Mexico"};
      int cont=1;  
        for (int i = 0; i < array.length; i++) {
        array[i] = new Persona(cont,nombres[i],edades[i],ciudades[i]);
        cont++;
        
        }
    
    return array;
    }
    
    public static void salir(){
    
    
    
    
    }
    
    
}
