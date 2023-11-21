package org.lessons.java;

import java.time.LocalDate;
import java.util.Scanner;

import org.lessons.java.pojo.Evento;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il titolo dell'evento:");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci la data dell'evento (formato: yyyy-mm-dd):");
        LocalDate data = LocalDate.parse(scanner.nextLine());

        System.out.println("Inserisci il numero di posti totali:");
        int postiTotali = scanner.nextInt();

        Evento evento;
        try {
            evento = new Evento(titolo, data, postiTotali);
        } catch (Exception e) {
            System.out.println("Errore nella creazione dell'evento: " + e.getMessage());
            return;
        }

        System.out.println("Quante prenotazioni vuoi fare?");
        int prenotazioni = scanner.nextInt();
        try {
            for (int i = 0; i < prenotazioni; i++) {
                evento.addPrenotazione();
            }
        } catch (Exception e) {
            System.out.println("Errore nelle prenotazioni: " + e.getMessage());
        }

        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));

        System.out.println("Quanti posti vuoi disdire?");
        int disdette = scanner.nextInt();
        try {
            for (int i = 0; i < disdette; i++) {
                evento.eliminatePrenotazione();
            }
        } catch (Exception e) {
            System.out.println("Errore nelle disdette: " + e.getMessage());
        }

        System.out.println("Posti prenotati: " + evento.getPostiPrenotati());
        System.out.println("Posti disponibili: " + (evento.getPostiTotali() - evento.getPostiPrenotati()));
    }
}