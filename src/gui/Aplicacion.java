package gui;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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
	
	JLabel comparaciones;
	
	JLabel swaps;
	
	String archivo ;
	
	Lectura lectura;
	MetodosOrdenacion mo;
	
	public Aplicacion(){
		super("Ordenamiento");
		
		this.mo = new MetodosOrdenacion();
		this.informacion = new JLabel("Informacion");
		this.comparaciones = new JLabel("Comparaciones");
		this.swaps = new JLabel("Swaps");
		
		this.text = new JTextArea();
		this.text.setEditable(false);
		this.scrollPane = new JScrollPane(text);
		this.scrollPane.setBounds(20, 20, 450, 150);
		
		this.text2 = new JTextArea();
		this.text2.setEditable(false);
		this.scrollPane2 = new JScrollPane(text2);
		this.scrollPane2.setBounds(20, 190, 450, 150);
		
		this.informacion.setBounds(20, 350, 450, 20);
		this.comparaciones.setBounds(20, 375, 450, 20);
		this.swaps.setBounds(20, 400, 450, 20);
		
		super.setLayout(null);
		this.menu = new JMenuBar();
		super.setJMenuBar(menu);
		this.submenu1 = new JMenu("Archivo");
		this.submenu2 = new JMenu("Ordenar");
		this.submenu3 = new JMenu("Ayuda");
		
		this.items1 = new JMenuItem[4];
		this.items2 = new JMenuItem[7];
		this.items3 = new JMenuItem("Acerca De");
		
		
		
		items1[0] = new JMenuItem("Cargar Archivo");
		items1[1] = new JMenuItem("Guardar Archivo");
		items1[3] = new JMenuItem("Generar archivo");
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
		submenu1.add(items1[3]);
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
		super.add(comparaciones);
		super.add(swaps);
		
		items1[0].addActionListener(this);
		items1[1].addActionListener(this);
		items1[2].addActionListener(this);
		items1[3].addActionListener(this);
		
		items2[0].addActionListener(this);
		items2[1].addActionListener(this);
		items2[2].addActionListener(this);
		items2[3].addActionListener(this);
		items2[4].addActionListener(this);
		items2[5].addActionListener(this);
		items2[6].addActionListener(this);
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
				
				
				JFileChooser jf = new JFileChooser();
				int valor = jf.showOpenDialog(this);
				if(valor == jf.APPROVE_OPTION){
					this.lectura = new Lectura(jf.getSelectedFile().getPath());
					
					this.lectura.generar();
					this.text.setText(this.lectura.getTexto());
				}
				
				
			} catch (HeadlessException | ExceptionArchivo e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
        }
		
		if(e.getSource() == items1[1]){
			String nombre = "";
            JFileChooser jf = new JFileChooser(System.getProperty("user.dir"));
            jf.showSaveDialog(this);
            File g = jf.getSelectedFile();
            
            if(g != null){
            	Random r = new Random();
    			FileWriter fw;
				try {
					fw = new FileWriter(g);
					fw.write(this.text2.getText());
	    			fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
            }
			
			
        }
		
		if(e.getSource() == items1[3]){
			String nombre = "";
            JFileChooser jf = new JFileChooser(System.getProperty("user.dir"));
            jf.showSaveDialog(this);
            File g = jf.getSelectedFile();
            
            if(g != null){
            	Random r = new Random();
    			String texto = "";
    			
    			for(int i = 1; i <=10000; i++){
    				texto += r.nextInt(1000)+ " ";
    				if(i%20 == 0){
    					texto += "\n";
    					
    				}
    			}
    			FileWriter fw;
				try {
					fw = new FileWriter(g);
					fw.write(texto);
	    			fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
				/*FileWriter gu = new FileWriter(g);
				gu.write("daniel2");
				
				gu.close();
				*/
            	
            }
        }
		
		
		if(e.getSource() == items2[0]){
           Integer[] aux = this.mo.Burbuja(this.lectura.ArrayInteger());
           String txt = "";
           int cont = 1;
           for(Integer i: aux){
        	   txt += i+ " ";
        	   if(cont % 20 == 0){
        		   txt += "\n";
        	   }
        	   cont++;
           }
           this.text2.setText(txt);
           this.informacion.setText(this.mo.getTiempo().mostrarDiferencia());
           this.comparaciones.setText("Comparaciones: " + this.mo.getComparaciones()); 
           this.swaps.setText("Swaps: " + this.mo.getSwaps());
        }
		
		if(e.getSource() == items2[1]){
	           Integer[] aux = this.mo.Shell(this.lectura.ArrayInteger());
	           String txt = "";
	           int cont = 1;
	           for(Integer i: aux){
	        	   txt += i+ " ";
	        	   if(cont % 20 == 0){
	        		   txt += "\n";
	        	   }
	        	   cont++;
	           }
	           this.text2.setText(txt);
	           this.informacion.setText(this.mo.getTiempo().mostrarDiferencia());
	           this.comparaciones.setText("Comparaciones: " + this.mo.getComparaciones()); 
	           this.swaps.setText("Swaps: " + this.mo.getSwaps());
	     }
		
		if(e.getSource() == items2[2]){
	           Integer[] aux = this.mo.Insercion(this.lectura.ArrayInteger());
	           String txt = "";
	           int cont = 1;
	           for(Integer i: aux){
	        	   txt += i+ " ";
	        	   if(cont % 20 == 0){
	        		   txt += "\n";
	        	   }
	        	   cont++;
	           }
	           this.text2.setText(txt);
	           this.informacion.setText(this.mo.getTiempo().mostrarDiferencia());
	           this.comparaciones.setText("Comparaciones: " + this.mo.getComparaciones()); 
	           this.swaps.setText("Swaps: " + this.mo.getSwaps());
	     }
		
		if(e.getSource() == items2[3]){
	           Integer[] aux = this.mo.Seleccion(this.lectura.ArrayInteger());
	           String txt = "";
	           int cont = 1;
	           for(Integer i: aux){
	        	   txt += i+ " ";
	        	   if(cont % 20 == 0){
	        		   txt += "\n";
	        	   }
	        	   cont++;
	           }
	           this.text2.setText(txt);
	           this.informacion.setText(this.mo.getTiempo().mostrarDiferencia());
	           this.comparaciones.setText("Comparaciones: " + this.mo.getComparaciones()); 
	           this.swaps.setText("Swaps: " + this.mo.getSwaps());
	     }
		
		if(e.getSource() == items2[4]){
	           Integer[] aux = this.mo.Heap(this.lectura.ArrayInteger());
	           String txt = "";
	           int cont = 1;
	           for(Integer i: aux){
	        	   txt += i+ " ";
	        	   if(cont % 20 == 0){
	        		   txt += "\n";
	        	   }
	        	   cont++;
	           }
	           this.text2.setText(txt);
	           this.informacion.setText(this.mo.getTiempo().mostrarDiferencia());
	           this.comparaciones.setText("Comparaciones: " + this.mo.getComparaciones()); 
	           this.swaps.setText("Swaps: " + this.mo.getSwaps());
	     }
		
		if(e.getSource() == items2[5]){
	           Integer[] aux = this.mo.BurbujaMejorada(this.lectura.ArrayInteger());
	           String txt = "";
	           int cont = 1;
	           for(Integer i: aux){
	        	   txt += i+ " ";
	        	   if(cont % 20 == 0){
	        		   txt += "\n";
	        	   }
	        	   cont++;
	           }
	           this.text2.setText(txt);
	           this.informacion.setText(this.mo.getTiempo().mostrarDiferencia());
	           this.comparaciones.setText("Comparaciones: " + this.mo.getComparaciones()); 
	           this.swaps.setText("Swaps: " + this.mo.getSwaps());
	     }
		
		
		if(e.getSource() == items2[6]){
	           Integer[] aux = this.mo.QuickSort(this.lectura.ArrayInteger());
	           String txt = "";
	           int cont = 1;
	           for(Integer i: aux){
	        	   txt += i+ " ";
	        	   if(cont % 20 == 0){
	        		   txt += "\n";
	        	   }
	        	   cont++;
	           }
	           this.text2.setText(txt);
	           this.informacion.setText(this.mo.getTiempo().mostrarDiferencia());
	           this.comparaciones.setText("Comparaciones: " + this.mo.getComparaciones()); 
	           this.swaps.setText("Swaps: " + this.mo.getSwaps());
	     }
		
		if(e.getSource() == items3){
           JOptionPane.showMessageDialog(null, "Creado por Daniel Brena Aquino");
			
        }
	}
}
