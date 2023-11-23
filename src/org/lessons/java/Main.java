package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.lessons.java.pojo.Concerto;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inserisci il titolo dell'evento:");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci la data dell'evento (formato: yyyy-mm-dd):");
            LocalDate data = LocalDate.parse(scanner.nextLine());

            System.out.println("Inserisci il numero di posti totali:");
            int postiTotali = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Inserisci l'ora del concerto (formato: HH:mm):");
            LocalTime ora = LocalTime.parse(scanner.nextLine());

            System.out.println("Inserisci il prezzo del concerto:");
            BigDecimal prezzo = scanner.nextBigDecimal();
            scanner.nextLine();

            Concerto concerto;
            try {
                concerto = new Concerto(titolo, data, postiTotali, ora, prezzo);
            } catch (Exception e) {
                System.out.println("Errore nella creazione del concerto: " + e.getMessage());
                continue;
            }

            System.out.println("Quante prenotazioni vuoi fare?");
            int prenotazioni = scanner.nextInt();
            try {
                for (int i = 0; i < prenotazioni; i++) {
                    concerto.addPrenotazione();
                }
            } catch (Exception e) {
                System.out.println("Errore nelle prenotazioni: " + e.getMessage());
            }

            System.out.println("Posti prenotati: " + concerto.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (concerto.getPostiTotali() - concerto.getPostiPrenotati()));

            System.out.println("Quanti posti vuoi disdire?");
            int disdette = scanner.nextInt();
            scanner.nextLine();
            try {
                for (int i = 0; i < disdette; i++) {
                    concerto.eliminatePrenotazione();
                }
            } catch (Exception e) {
                System.out.println("Errore nelle disdette: " + e.getMessage());
            }

            System.out.println("Posti prenotati: " + concerto.getPostiPrenotati());
            System.out.println("Posti disponibili: " + (concerto.getPostiTotali() - concerto.getPostiPrenotati()));

            System.out.println("Vuoi creare un altro concerto? (y/n)");
            String another = scanner.nextLine();
            if (!another.equalsIgnoreCase("y")) {
                break;
            }
        }
    }
}