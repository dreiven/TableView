/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author PC
 *
 *
 */
public class TableView implements ActionListener {

    Persona grupo[];
    JFrame ventana;
    JPanel panel;
    JButton btn_slr;
    JButton btn_mst;
    JCheckBox chk_btn_ordNombre;
    JCheckBox chk_btn_ordEdad;
    JLabel porNombre;
    ModeloTabla modelo;
    JTable tabla;
    JScrollPane scrTbl;
    TableView t;

    public TableView() {
        //se declara un array de Strings con los identificadores de cada columna
        String[] columnas = {"id", "Nombre", "Edad", "Ciudad"};
        ventana = new JFrame();
        modelo = new ModeloTabla();
        tabla = new JTable();
        panel = new JPanel();
        grupo = new Persona[4];
         //se crea el objeto btn_slr
        btn_slr = new JButton();
        //se crea el objeto btn_mst
        btn_mst = new JButton();
        //se crea el objeto chk_btn_ordNombre
        chk_btn_ordNombre = new JCheckBox();
        chk_btn_ordEdad= new JCheckBox();
        //se declara Obj JScrollpane para introducir dentro la tabla y se visualice el header()
        //JScrollPane scrTbl = new JScrollPane();
        //se setea en el objeto Modelotabla los identificadores  de las columnas
        modelo.setColumnIdentifiers(columnas);
        //se setea el modelo de la tabla declarado en la tabla actual
        tabla.setModel(modelo);
        //se llama al metodo Rellenar para introducir datos en el array de personas grupo , el cual se le pasa por parametro
        Utiles.Rellenar(grupo);
//        Utiles.ordenNombre(grupo);
//        Utiles.OrdenEdad(grupo);
        //se setean distintas propiedades de la ventana objeto JFrame, como,el titulo,tamaño,color,localizacion
        //se añade el componente panel al JFrame
        ventana.add(panel);
        ventana.setTitle("Tabla de Datos");
        ventana.setSize(500, 500);
        ventana.setBackground(Color.BLACK);
        ventana.setLocation(250, 200);
        ventana.setVisible(true);
        //se añade un nuevo header a traves del layout sino deberá contenerse la tabla en un objeto JScrollpanel,
        //de otro modo no se veria el header con los identificadores en la tabla
        ventana.add(tabla.getTableHeader(), BorderLayout.NORTH);
        ventana.add(tabla);
        //se setean las propiedades de tamaño,localizacion,color
        //se añaden al panel los componentes btn_slr y btn_mst y se muestra el panel a traves del metodo setVisible a true
        panel.setSize(250, 500);
        panel.setLocation(150, 350);
        panel.setBackground(Color.red);
        panel.add(btn_slr);
        panel.add(btn_mst);
        panel.add(chk_btn_ordNombre);
        panel.add(chk_btn_ordEdad);
        panel.setVisible(true);
        //se setean las propiedades de los botones , tamaño texto,localizacion
        btn_slr.setSize(100, 35);
        btn_slr.setText("Salir");
        btn_slr.setLocation(350, 350);
        btn_mst.setSize(100, 35);
        btn_mst.setText("Mostrar");
        btn_mst.setLocation(150, 350);
        //se setean las propiedades del CheckButton como localizacion,texto a mostrar,tamaño
        chk_btn_ordNombre.setLocation(150, 250);
        chk_btn_ordNombre.setText("Ordenar \npor Nombre");
        chk_btn_ordNombre.setSize(100, 35);
        //se setean las propiedades del CheckButton como localizacion,texto a mostrar,tamaño
        chk_btn_ordEdad.setLocation(50, 250);
        chk_btn_ordEdad.setText("Ordenar \npor Edad");
        chk_btn_ordEdad.setSize(100, 35);
        //ventana.add(scrTbl);
        //añadimos a la tabla un nuevo obeto layout con el fin de definir el header de la tabla
        tabla.setLayout(new BorderLayout());
        tabla.setLocation(250, 400);
        //scrTbl.setViewportView(tabla);
        //asociamos al boton salir una ListenerAction generico que hace referencia a la ventana 
        btn_slr.addActionListener(this);
        //identidicamos las columnas del header pasandole al metodo serColumnIdentifiers un array de Strings
        modelo.setColumnIdentifiers(columnas);
        
        
        ActionListener accionOrdenEdad = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                Utiles.OrdenEdad(grupo);
                
            }
        };
      
        ActionListener accionOrdenNombre = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
                Utiles.ordenNombre(grupo);
                
            }
        };
        //se crea el objeto ActionListener para capturar acciones en los componentes ,boton mostrar en este caso
        ActionListener accionMostrar = new ActionListener() {
            //se reescribe el metodo de accion realizada en el componente
            @Override
            public void actionPerformed(ActionEvent e) {
                //se declara un int como contador , se ocupara de controlar las filas ,se inicializa en 0
                int nroFilas = 0;
                //bucle for para recorrer el array de objetos persona grupo
                for (int i = 0; i < grupo.length; i++) {
                    //se setean los datos del id del objeto persona del array grupo, se indica el contador 0,y la posicion en la columna
                    tabla.setValueAt(grupo[i].getId(), nroFilas, 0);
                    tabla.setValueAt(grupo[i].getNombre(), nroFilas, 1);
                    tabla.setValueAt(grupo[i].getEdad(), nroFilas, 2);
                    tabla.setValueAt(grupo[i].getciudad(), nroFilas, 3);
                    //se aumenta en 1 el contador para pasar por el numero de filas correspondiente
                    nroFilas++;

                }
            }
        };
        //asociamos al componente btn_mst el objeto action Listener declara anteriormente
        btn_mst.addActionListener(accionMostrar);
        //asociamos al componente chk_btn_ordNombre el objeto action Listener
        chk_btn_ordNombre.addActionListener(accionOrdenNombre);
        //asociamos al componente chk_btn_ordEdad el objeto action Listener
        chk_btn_ordEdad.addActionListener(accionOrdenEdad);
    }

    public static void main(String[] args) {
        //se declara e incializa el objeto Tableview en el metodo main
        TableView t = new TableView();
    }

    @Override
    //metodo overrideado de action event para salir de la aplicacion
    public void actionPerformed(ActionEvent e) {
        //Metodo de el sistema para terminar la java aplication       
        System.exit(0);

    }
}
