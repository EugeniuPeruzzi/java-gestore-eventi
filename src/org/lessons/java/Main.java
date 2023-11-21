package org.lessons.java;

import java.time.LocalDate;


import org.lessons.java.pojo.Evento;

public class Main {
	public static void main(String[] args)  {
		Evento event;

		try {
			event = new Evento("concerto",LocalDate.parse("2023-12-28"), 1 );					
			System.out.println(event);
		} catch (Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}

	}
}