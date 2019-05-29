package it.polito.tdp.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class Evento  implements Comparable<Evento>{
	public enum TipoEvento {
		ARRIVO_GRUPPO_CLIENTI,
		GRUPPO_ASSEGNATO,
	}
	
	private LocalTime ora;
	private int num_persone;
	private Duration durata;
	private float tolleranza;
	private TipoEvento tipo;
	
	private int tavolo;
	public Evento(LocalTime ora, TipoEvento tipo) {
		super();
		Random random = new Random();
		this.ora = ora;
		int a = 60; // numero minimo
		int b = 120; // numero massimo
		int c = ((b-a) + 1);
		this.tipo=tipo;
		
		int a1 = 1; // numero minimo
		int b1 = 10; // numero massimo
		int c1 = ((b1-a1) + 1);
		
		this.num_persone = (int) random.nextInt(c1) + a1;
		this.durata =Duration.ofMinutes(random.nextInt(c) + a);
		this.tolleranza = (float) Math.random();
		this.tavolo=0;
	}
	public LocalTime getOra() {
		return ora;
	}
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	public int getNum_persone() {
		return num_persone;
	}
	public void setNum_persone(int num_persone) {
		this.num_persone = num_persone;
	}
	public Duration getDurata() {
		return durata;
	}
	public void setDurata(Duration durata) {
		this.durata = durata;
	}
	public float getTolleranza() {
		return tolleranza;
	}
	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}
	
	public TipoEvento getTipo() {
		return tipo;
	}
	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
	
	
	public int getTavolo() {
		return tavolo;
	}
	public void setTavolo(int tavolo) {
		this.tavolo = tavolo;
	}
	@Override
	public int compareTo(Evento other) {
		
		return this.ora.compareTo(other.ora);
	}
	
	

}
