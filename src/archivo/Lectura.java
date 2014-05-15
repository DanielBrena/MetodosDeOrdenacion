package archivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import excepcion.ExceptionArchivo;

public class Lectura {
	private Scanner sc;
	private FileReader fr;
	private File  file;
	private Integer tamanio;
	private ArrayList<String> arrayString;
	private ArrayList<Integer> arrayInteger;
	private PrintWriter out;
	PrintWriter pw; 
	
	private String texto = "";
	
	
	public Lectura(){
		
	}
	
	public Lectura(String ruta) throws ExceptionArchivo{
		this.file = new File(ruta);
		this.arrayInteger = new ArrayList<Integer>();
		this.arrayString = new ArrayList<String>();
		if(this.existe()){
			try {
				this.fr = new FileReader(file);
				this.sc = new Scanner(this.fr);
				this.out = new PrintWriter(System.out,true);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
		}else{
			throw new ExceptionArchivo("No se encontro la ruta del archivo");
		}
		
	}
	
	public Integer contar(){
		Integer cont = 0;
		if(this.existe()){
			
			while(this.sc.hasNext()){
				String contLinea = this.sc.nextLine();
				String[] auxLinea = contLinea.split(" ");
				
				cont += auxLinea.length;
			}
			return cont;
		}else{
			return 0;
		}
		
	}
	
	public void mostrar() throws ExceptionArchivo, IOException{
		if(this.existe()){
			while(this.sc.hasNext()){
				System.out.print(this.sc.next() + " ");
			}
			
		}else{
			throw new ExceptionArchivo("No se encontro la ruta del archivo");
		}
		
	}
	
	public void escribir(String titulo){
		try {
			this.out =new PrintWriter(titulo+".txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 1; i < this.arrayInteger.size()-1;i++){
			if(i % 20 == 0){
				this.out.println();
			}else{
				 this.out.print(i +" ");
			}
		}
	}
	
	public void escribir2(File file) throws IOException{
		
		
			
			
		
	}
	
	public ArrayList<String> generarArrayString(){
		ArrayList<String> auxArray = new ArrayList<String>();
		while(this.sc.hasNext()){
			auxArray.add(this.sc.next());
		}
		return auxArray;
	}
	
	public void generar(){
		
		if(this.existe()){
			while(this.sc.hasNext()){
				String aux = this.sc.next();
				this.arrayString.add(aux);
				this.arrayInteger.add(Integer.parseInt(aux));
				this.texto += aux + " ";
				
			}
		}
	}
	
	public boolean existe(){
		if(this.file.exists()){
			return true;
		}else{
			return false;
		}
	
	}
	
	
	
	public Integer[] ArrayInteger(){
		Integer[] aux = new Integer[this.arrayInteger.size()];
		for(int i = 0; i < this.arrayInteger.size(); i++){
			aux[i] = this.arrayInteger.get(i);
		}
		return aux;
	}
	
	public String[] ArrayString(){
		String[] aux = new String[this.arrayString.size()];
		for(int i = 0; i < this.arrayString.size(); i++){
			aux[i] = this.arrayString.get(i);
		}
		return aux;
	}
	
	public void CrearString(){
		String aux = "";
		for(int i = 0; i < this.arrayString.size(); i++){
			aux += this.arrayString.get(i);
		}
		this.texto = aux;
		
	}
	
	public void close() throws ExceptionArchivo{
		if(this.existe()){
			try {
				this.fr.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}else{
			throw new ExceptionArchivo("No se encontro la ruta del archivo");
		}
		
	}
	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public FileReader getFr() {
		return fr;
	}

	public void setFr(FileReader fr) {
		this.fr = fr;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public ArrayList<String> getArrayString() {
		return arrayString;
	}

	public void setArrayString(ArrayList<String> arrayString) {
		this.arrayString = arrayString;
	}

	public ArrayList<Integer> getArrayInteger() {
		return arrayInteger;
	}

	public void setArrayInteger(ArrayList<Integer> arrayInteger) {
		this.arrayInteger = arrayInteger;
	}

	public Integer getTamanio() {
		return tamanio;
	}

	public void setTamanio(Integer tamanio) {
		this.tamanio = tamanio;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	
	
}
