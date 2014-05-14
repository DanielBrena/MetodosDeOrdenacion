package metodos;

import tiempo.Tiempo;

public class MetodosOrdenacion {
	private Tiempo tiempo;

	public MetodosOrdenacion(){
		this.tiempo = new Tiempo();
	}
	
	public Integer[] Burbuja(Integer[] arreglo){
		Integer[] aux = arreglo;
		Integer aux1;
		this.tiempo.inicia();
		for(int i = 0; i < aux.length-1; i++){
			for(int j = 0; j< aux.length-1; j++){
				if(aux[j + 1] < aux[j]){
					aux1 = aux[j+1];
					aux[j+1] = aux[j];
					aux[j] = aux1;
				}
			}
		}
		this.tiempo.termina();
		return aux;
		
	}
	
	public  Integer[] Heap(Integer[] arreglo) {
		Integer[] v = arreglo;
        final Integer N = v.length;
        this.tiempo.inicia();
        for(Integer nodo = N/2; nodo>=0; nodo--) hacerMonticulo(v, nodo, N-1);
        for(Integer nodo = N-1; nodo>=0; nodo--) {
            int tmp = v[0];
            v[0]    = v[nodo];
            v[nodo] = tmp;
            hacerMonticulo(v, 0, nodo-1);
        }
        this.tiempo.termina();
        
        return v;
    }
	
	public Integer[] Shell(Integer[] arreglo){
		Integer[] aux = arreglo;
		
		Integer n = aux.length;
		Integer incremento = 0;
		do{
			for(int i = 0; i < incremento; i++){
				for(int j = incremento + i; j < aux.length; j += incremento){
					int k = j;
					while(k - incremento >= 0 && aux[k] < aux[k - incremento]){
						int aux2 = aux[k];
						aux[k] = aux[k - incremento];
						aux[k - incremento] = aux2;
						k -= incremento;
					}
				}
			}
			
		}while(incremento > 1);
		
		return aux;
	}
 
    private  void hacerMonticulo(Integer[] v, Integer nodo, Integer fin) {
    	Integer izq = 2*nodo+1;
    	Integer der = izq+1;
    	Integer may;
        if(izq>fin) return;
        if(der>fin) may=izq;
        else may= v[izq]>v[der]?izq:der;
        if(v[nodo] < v[may]) {
        	Integer tmp = v[nodo];
            v[nodo] = v[may];
            v[may]  = tmp;
            hacerMonticulo(v, may, fin);
        }
    }
	
	
	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}
	
	
	
}
