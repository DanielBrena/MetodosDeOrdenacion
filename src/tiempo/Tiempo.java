package tiempo;

import java.util.Calendar;

public class Tiempo {
	private long tinicia = 0;
	private long tfinal = 0;
	
	public void inicia(){
		this.tinicia = Calendar.getInstance().getTime().getTime();
	}
	
	public void termina(){
		this.tfinal = Calendar.getInstance().getTime().getTime();
	}
	
	public String mostrarDiferencia(){
		long diferencia = this.tfinal - this.tinicia;
		return String.format("Tiempo total: %d horas %d minutos %d segundos %d milisegundos  ",
				(diferencia/(60*60*1000))%60, (diferencia /( 60*1000))%60, diferencia/1000%60,diferencia%1000 );
	}
}
