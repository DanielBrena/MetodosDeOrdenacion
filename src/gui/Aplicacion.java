package gui;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import excepcion.ExceptionArchivo;
import metodos.MetodosOrdenacion;
import archivo.Lectura;
public class Aplicacion extends JFrame implements ActionListener {
	JMenuBar menu;
	JMenu submenu1;
	JMenu submenu2;
	JMenu submenu3;
	JMenuItem[] items1;
	JMenuItem[] items2;
	JMenuItem items3;
	
	JScrollPane scrollPane;
	JTextArea text;
	
	JScrollPane scrollPane2;
	JTextArea text2;
	
	JLabel informacion;
	
	String archivo ;
	
	Lectura lectura;
	MetodosOrdenacion mo;
	
	public Aplicacion(){
		super("Ordenamiento");
		
		mo = new MetodosOrdenacion();
		informacion = new JLabel("Informacion");
		
		text = new JTextArea();
		text.setEditable(false);
		scrollPane = new JScrollPane(text);
		scrollPane.setBounds(20, 20, 450, 150);
		
		text2 = new JTextArea();
		text2.setEditable(false);
		scrollPane2 = new JScrollPane(text2);
		scrollPane2.setBounds(20, 190, 450, 150);
		
		informacion.setBounds(20, 350, 450, 20);
		
		setLayout(null);
		menu = new JMenuBar();
		setJMenuBar(menu);
		submenu1 = new JMenu("Archivo");
		submenu2 = new JMenu("Ordenar");
		submenu3 = new JMenu("Ayuda");
		
		items1 = new JMenuItem[3];
		items2 = new JMenuItem[7];
		items3 = new JMenuItem("Acerca De");
		
		
		
		items1[0] = new JMenuItem("Cargar Archivo");
		items1[1] = new JMenuItem("Guardar Archivo");
		items1[2] = new JMenuItem("Salir");
		
		items2[0] = new JMenuItem("Burbuja");
		items2[1] = new JMenuItem("Shell");
		items2[2] = new JMenuItem("Insercion");
		items2[3] = new JMenuItem("Seleccion");
		items2[4] = new JMenuItem("Heap");
		items2[5] = new JMenuItem("Burbuja Mejorada");
		items2[6] = new JMenuItem("QuickSort");
		
		submenu1.add(items1[0]);
		submenu1.add(items1[1]);
		submenu1.add(items1[2]);
		
		
		submenu2.add(items2[0]);
		submenu2.add(items2[1]);
		submenu2.add(items2[2]);
		submenu2.add(items2[3]);
		submenu2.add(items2[4]);
		submenu2.add(items2[5]);
		submenu2.add(items2[6]);
		
		submenu3.add(items3);
		
		
		menu.add(submenu1);
		menu.add(submenu2);
		menu.add(submenu3);
		
		super.add(scrollPane);
		super.add(scrollPane2);
		
		super.add(informacion);
		
		items1[0].addActionListener(this);
		items1[1].addActionListener(this);
		items1[2].addActionListener(this);
		
		items2[0].addActionListener(this);
		items2[4].addActionListener(this);
		
		items3.addActionListener(this);
		
		this.configuracion();
	}
	
	public void configuracion(){

        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBounds(500, 10, 500, 500);
        super.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == items1[2]){
            System.exit(0);
        }
		
		if(e.getSource() == items1[0]){
			
			try {
				this.lectura = new Lectura(JOptionPane.showInputDialog("Ruta del Archivo"));
				this.lectura.generar();
				this.text.setText(this.lectura.getTexto());
			} catch (HeadlessException | ExceptionArchivo e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
        }
		
		if(e.getSource() == items1[1]){
			this.lectura.escribir(JOptionPane.showInputDialog("Nombre del Archivo"));
        }
		
		
		if(e.getSource() == items2[0]){
           Integer[] aux = this.mo.Burbuja(this.lectura.ArrayInteger());
           String txt = "";
           for(Integer i: aux){
        	   txt += i+ " ";
           }
           this.text2.setText(txt);
           this.informacion.setText(this.mo.getTiempo().mostrarDiferencia());
        }
		
		if(e.getSource() == items2[1]){
	           Integer[] aux = this.mo.Shell(this.lectura.ArrayInteger());
	           String txt = "";
	           for(Integer i: aux){
	        	   txt += i+ " ";
	           }
	           this.text2.setText(txt);
	           this.informacion.setText(this.mo.getTiempo().mostrarDiferencia());
	        }
		
		if(e.getSource() == items2[4]){
	           Integer[] aux = this.mo.Heap(this.lectura.ArrayInteger());
	           String txt = "";
	           for(Integer i: aux){
	        	   txt += i+ " ";
	           }
	           this.text2.setText(txt);
	           this.informacion.setText(this.mo.getTiempo().mostrarDiferencia());
	     }
		
		if(e.getSource() == items3){
            JOptionPane.showMessageDialog(null, "Creado por Daniel Brena Aquino");
        }
	}
}
