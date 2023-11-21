package org.lessons.java.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;


	public Evento(String titolo, LocalDate data, int postiTotali) throws Exception {
		setTitolo(titolo);
		setData(data);
		setPostiTotali(postiTotali);
		setPostiPrenotati(0);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) throws Exception {
		titolo = titolo.trim();
		if(titolo.isEmpty()|| titolo.equals(" ")) {
			throw new Exception("il titolo non può essere vuoto");
		}
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws Exception {
		if(data.isBefore(LocalDate.now())) {
			throw new Exception("la data inserita e' passata");
		}
		this.data = data;
	}

	public int getPostiTotali() {

		return postiTotali;
	}

	private void setPostiTotali(int postiTotali) throws Exception{
		if(postiTotali <= 0) {
			throw new Exception("il numero di posti deve essere positivo");
		}
		this.postiTotali = postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	private void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}

	private String dataFormattata() {
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
          return data.format(formatter);
	}

	public void addPrenotazione() throws Exception {
		if(getData().isBefore(LocalDate.now())) {
			throw new Exception("l'evento è già passato");
		}
		else if(getPostiTotali() == getPostiPrenotati()) {
			throw new Exception("i posti sono finiti");
		}
		 setPostiPrenotati(getPostiPrenotati()+1);

	}

	public void eliminatePrenotazione() throws Exception {
		if(getData().isBefore(LocalDate.now())) {
			throw new Exception ("l'evento è già passato");
		}else if(getPostiPrenotati()==0) {
			throw new Exception ("non ci sono prenotazioni per l'evento");
		}
		setPostiPrenotati(getPostiPrenotati() - 1);
	}

	@Override
	public String toString() {
		return "titolo evento: " + getTitolo()+ "\n"
			+ "data evento: " +dataFormattata() + "\n"
			+ "posti totali: " + getPostiTotali() + "\n"
			+ "posti prenotati: " + getPostiPrenotati();
	}


}