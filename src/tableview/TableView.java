/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.lang.reflect.Array;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author PC
 *
 */
public class TableView implements ActionListener {

    /**
     */
    Persona grupo[] = new Persona[3];
    JFrame ventana;
    JPanel panel;
    JButton btn_slr;
    ModeloTabla modelo;
    JTable tabla;
    JScrollPane desplazamiento;
    
    public TableView() {
        String[] columnas = {"id", "Nombre", "Edad", "Ciudad"};
        JFrame ventana = new JFrame();
        ModeloTabla modelo = new ModeloTabla();              
        modelo.setColumnIdentifiers(columnas);
        JTable tabla=new JTable(modelo);
        JScrollPane desplazamiento = new JScrollPane(tabla);
        btn_slr = new JButton();
        Utiles.Rellenar(grupo);               
        ventana.add(btn_slr);
        ventana.setTitle("Tabla de Datos");
        ventana.setSize(500, 500);
        ventana.add(desplazamiento);
        tabla.setModel(modelo);       
        ventana.setLocation(350, 150);
        btn_slr.setSize(70, 35);
        btn_slr.setText("Salir");
        btn_slr.setLocation(150, 250);
        ventana.add(tabla);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        ventana.setVisible(true);
        btn_slr.addActionListener(this);

    }
    
    
   
    
    
    

    public static void main(String[] args) {

//        JFrame ventana = new JFrame();
//        ModeloBoton btn_slr = new ModeloBoton();
        TableView t = new TableView();
        
//        t.ventana.setVisible(true);
//        ventana.setVisible(true);
        

//        ventana.setTitle("Tabla de Datos");
//        ventana.setSize(500, 500);
////        ventana.add(btn_slr);
        
//      
//        ventana.getContentPane();
       

        
        
       
    }

//    public static void salir(ActionEvent e) throws IOException {
//        JButton btn_slr = new JButton(); 
//        JFrame ventana = new JFrame();
//        System.out.println("prueba1");
//        ventana.setTitle("cambio");
//    }


    @Override
    public void actionPerformed(ActionEvent e) {
         JFrame ventana = new JFrame();
       
        System.out.println("Prueba001");
        ventana.dispose();
        
    }
}
