package metodos;

import tiempo.Tiempo;

public class MetodosOrdenacion {
	private Tiempo tiempo;
	private Integer comparaciones;
	private Integer swaps;
	
	public MetodosOrdenacion(){
		this.tiempo = new Tiempo();
	}
	
	public Integer[] Burbuja(Integer[] arreglo){
		this.comparaciones = 0;
		this.swaps = 0;
		Integer[] aux = arreglo;
		Integer aux1;
		this.tiempo.inicia();
		for(int i = 0; i < aux.length-1; i++){
			for(int j = 0; j< aux.length-1; j++){
				this.comparaciones++;
				if(aux[j + 1] < aux[j]){
					aux1 = aux[j+1];
					aux[j+1] = aux[j];
					aux[j] = aux1;
					this.swaps++;
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
		this.comparaciones = 0;
		this.swaps = 0;
		Integer[] aux = arreglo;
		
		Integer k = aux.length/2;
		this.tiempo.inicia();
		while(k >= 1){
			for(int i = k; i < aux.length; i++){
				Integer v = aux[i];
				Integer j = i - k;
				
				while(j >= 0 && aux[j] > v){
					aux[j + k] = aux[j];
					j-= k;
				}
				aux[j + k] = v;
			}
			k /=2;
			
		}
		this.tiempo.termina();
		
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
	
    
    public Integer[] Insercion(Integer[] arreglo){
    	this.comparaciones = 0;
		this.swaps = 0;
    	Integer[] aux = arreglo;
    	Integer aux_n = 0;
    	this.tiempo.inicia();
    	for (int i = 1; i < aux.length; i++) {
    		System.out.println(i);
            aux_n = aux[i];
            for (int j = i-1; j >=0 && aux[j]>aux_n; j--) {
            	
                aux[j+1]=aux[j];
                aux[j]=aux_n;
            }
        }
    	this.tiempo.termina();
    	return aux;
    }
    
    public Integer[] Seleccion(Integer[] arreglo){
    	this.comparaciones = 0;
		this.swaps = 0;
    	Integer[] aux = arreglo;
    	Integer n = aux.length;
    	this.tiempo.inicia();
        for(int i=0; i<n; i++) {
            int posMenor = i;
            for(int j=i+1; j<n; j++) {
                if(aux[j] < aux[posMenor]){
                	posMenor=j;
                }
            }
            if(posMenor!=i) {
                int tmp  = aux[i];
                aux[i] = aux[posMenor];
                aux[posMenor] = tmp;
            }
        }
        this.tiempo.termina();
        return aux;
    }
    
    
	
	public Tiempo getTiempo() {
		return tiempo;
	}

	public void setTiempo(Tiempo tiempo) {
		this.tiempo = tiempo;
	}

	public Integer getComparaciones() {
		return comparaciones;
	}

	public void setComparaciones(Integer comparaciones) {
		this.comparaciones = comparaciones;
	}

	public Integer getSwaps() {
		return swaps;
	}

	public void setSwaps(Integer swaps) {
		this.swaps = swaps;
	}
	
	
	
	
}
