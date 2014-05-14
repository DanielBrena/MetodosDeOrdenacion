package main;

import java.io.IOException;
import java.util.Random;

import metodos.MetodosOrdenacion;
import excepcion.ExceptionArchivo;
import gui.Aplicacion;
import archivo.Lectura;

public class Main {
	public static void main(String[] args) throws ExceptionArchivo, IOException{
		/*Lectura l = new Lectura("archivo.txt");
		l.generar();
		MetodosOrdenacion mo = new MetodosOrdenacion();
		Integer [] a = mo.Burbuja(l.ArrayInteger());
		for(Integer i: l.ArrayInteger()){
			System.out.print(i+ " ");
		}
		System.out.println();
		for(Integer i: a){
			System.out.print(i+ " ");
		}
		System.out.println();
		mo.getTiempo().mostrarDiferencia();
		*/
		Aplicacion app = new Aplicacion();
	}
}
