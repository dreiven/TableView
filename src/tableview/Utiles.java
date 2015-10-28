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
    
    
    public static Persona[] Rellenar(Persona array[]){
      
      String nombres[]={"Mario","Alberto","Israel","Diego"};
      int edades[]={35,33,40,41};
      String ciudades[]={"Madrid","Almeria","Mexico","Alcobendas"};
      int cont=1;  
        for (int i = 0; i < array.length; i++) {
        array[i] = new Persona(cont,nombres[i],edades[i],ciudades[i]);
        cont++;
        
        }
    
    return array;
    }
    //metodo para ordenar por orden alfabetico cualquier array de Strings u objetos con atrbutos string
      public static void ordenNombre(Persona lista[]){
 
        //Usamos un bucle for doble
                for(int i=0;i<(lista.length-1);i++){
                    for(int j=i+1;j<lista.length;j++){
                        if(lista[i].getNombre().compareToIgnoreCase(lista[j].getNombre())>0){
                            //Intercambiamos valores
                            Persona variableauxiliar=lista[i];
                            lista[i]=lista[j];
                            lista[j]=variableauxiliar;
 
                        }
                    }
                }
    }
       //metodo para ordenar por orden de menor a mayor cualquier array de numeros
      public static void OrdenEdad(Persona lista[]){
 
        //Usamos un bucle for dentro de otro for
                for(int i=0;i<(lista.length-1);i++){
                    for(int j=i+1;j<lista.length;j++){
                        //si la edad del objeto actual(i) es mayor que la edad del objeto siguiente (j)
                        if(lista[i].getEdad() > lista[j].getEdad()){
                            //Intercambiamos valores a traves de una variable auxiliar de uso local
                            //guardamos el valor del objeto actual(i) en la variable auxiliar
                            Persona variableauxiliar = lista[i];
                            //cambiamos el objeto (i) por  el (j) 
                            lista[i]= lista[j];
                            //y a su vez le pasamos al objeto (j) el valor de la variable auxiliar 
                            lista[j] = variableauxiliar;
 
                        }
                    }
                }
    }
    
}
