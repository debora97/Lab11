package it.polito.tdp.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.PriorityQueue;
import java.util.Random;

import it.polito.tdp.model.Evento.TipoEvento;

public class Simulatore {
	// coda degli eventi
	private PriorityQueue<Evento> queue = new PriorityQueue<>();

	// modello del mondo
	private int tavolo10;
	private int tavolo8;
	private int tavolo6;
	private int tavolo4;

// parametri di simulazione
	private int T10 = 2;
	private int T8 = 4;
	private int T6 = 4;
	private int T4 = 5;
	private LocalTime T_inizio= LocalTime.now();

	private int NE=2000;
	int a1 = 1; // numero minimo
	int b1 = 10; // numero massimo
	int c1 = ((b1-a1) + 1);
	Random random= new Random();
	int num = (int) random.nextInt(c1) + a1;
	private Duration T_ARRIVAL =Duration.ofMinutes(num);
	
	//statistiche dfa calcolare
	private int numero_totale_clienti;
	private int numero_clienti_soddisfatti;
	private int numero_clienti_insoddisfatti;
	
	public void init() {
		//creo i tavoli 
		tavolo10=T10;
		tavolo8=T8;
		tavolo6=T6;
		tavolo4=T4;
		
		//creo gli eventi iniziali
		queue.clear();
		for(int i=0; i<=NE; i++) {
			queue.add(new Evento(T_inizio.plus(T_ARRIVAL), TipoEvento.ARRIVO_GRUPPO_CLIENTI));
		}
		
		
		
		//resetto le statistiche 
		  numero_totale_clienti=0;
		  numero_clienti_soddisfatti=0;
		  numero_clienti_insoddisfatti=0;
	}
	public void run() {
		while (!queue.isEmpty()) {
			Evento ev=queue.poll();
			switch (ev.getTipo()) {
			
			case ARRIVO_GRUPPO_CLIENTI:
				int numeroPersone=ev.getNum_persone();
				if(numeroPersone<=4 && tavolo4>0) {
					if(numeroPersone<=2) {
						if(ev.getTolleranza()< (float) Math.random()) {
							//vanno al bancone 
							  numero_totale_clienti= numero_totale_clienti+numeroPersone;
							  numero_clienti_soddisfatti+=numeroPersone;
							  
							
						} else {
							numero_clienti_insoddisfatti+=numeroPersone;
						}
					} else {
						tavolo4--;
						 numero_totale_clienti= numero_totale_clienti+numeroPersone;
						  numero_clienti_soddisfatti+=numeroPersone;
						  queue.add(new Evento(ev.getOra().plus(ev.getDurata()), TipoEvento.GRUPPO_ASSEGNATO));
						  ev.setTavolo(4);
						  break;
					} 
							
				} else if(numeroPersone<=6 && tavolo6>0) {
					if(numeroPersone<=3) {
						if(ev.getTolleranza()< (float) Math.random()) {
							//vanno al bancone 
							  numero_totale_clienti= numero_totale_clienti+numeroPersone;
							  numero_clienti_soddisfatti+=numeroPersone;
							  
							
						} else {
							numero_clienti_insoddisfatti+=numeroPersone;
						}
					} else {
						tavolo6--;
						 numero_totale_clienti= numero_totale_clienti+numeroPersone;
						  numero_clienti_soddisfatti+=numeroPersone;
						  queue.add(new Evento(ev.getOra().plus(ev.getDurata()), TipoEvento.GRUPPO_ASSEGNATO));
						  ev.setTavolo(6);
						  break;
					} 
							
				}
				else if(numeroPersone<=8 && tavolo8>0) {
					if(numeroPersone<=4) {
						if(ev.getTolleranza()< (float) Math.random()) {
							//vanno al bancone 
							  numero_totale_clienti= numero_totale_clienti+numeroPersone;
							  numero_clienti_soddisfatti+=numeroPersone;
							  
							
						} else {
							numero_clienti_insoddisfatti+=numeroPersone;
						}
					} else {
						tavolo8--;
						 numero_totale_clienti= numero_totale_clienti+numeroPersone;
						  numero_clienti_soddisfatti+=numeroPersone;
						  queue.add(new Evento(ev.getOra().plus(ev.getDurata()), TipoEvento.GRUPPO_ASSEGNATO));
						  ev.setTavolo(8);
						  break;
					} 
							
				}
				else  if(numeroPersone<=10 && tavolo10>0) {
					if(numeroPersone<=5) {
						if(ev.getTolleranza()< (float) Math.random()) {
							//vanno al bancone 
							  numero_totale_clienti= numero_totale_clienti+numeroPersone;
							  numero_clienti_soddisfatti+=numeroPersone;
							  
							
						} else {
							numero_clienti_insoddisfatti+=numeroPersone;
						}
					} else {
						tavolo10--;
						 numero_totale_clienti= numero_totale_clienti+numeroPersone;
						  numero_clienti_soddisfatti+=numeroPersone;
						  queue.add(new Evento(ev.getOra().plus(ev.getDurata()), TipoEvento.GRUPPO_ASSEGNATO));
						  ev.setTavolo(10);
						  break;
					} 
							
				}
			break;
			
			
			case GRUPPO_ASSEGNATO: 
				if(ev.getTavolo()==10) {
					tavolo10++;
				} else if(ev.getTavolo()==8) {
					tavolo8++;
				} else if(ev.getTavolo()==6) {
					tavolo6++;
				}else if(ev.getTavolo()==4) {
					tavolo4++;
				}
				
				break;
			
			}
		}
		
		
	}
	
		
	
	
}