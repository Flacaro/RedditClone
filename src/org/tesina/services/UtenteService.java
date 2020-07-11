package org.tesina.services;

import org.tesina.models.Post;
import org.tesina.models.Utente;

import java.io.*;
import java.util.ArrayList;

public class UtenteService {
    private static  Utente utenteLoggato = null;

    public static Utente getUtenteLoggato() { return utenteLoggato;}
    public static void setUtenteLoggato(Utente u1){
        utenteLoggato = u1;
    }

    public static  void logoutUtente(){
        utenteLoggato = null;
    }

    //devo salvere l'ogg utente in una variuabile acc globalmente
    public static Utente trovaEmailUtente(String email) {
        File file = new File("./src/org/tesina/Files/Utente.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine = br.readLine();
            while (currentLine != null) {
                String[] riga = currentLine.split(",");
                if (riga[2].equals(email)) {
                    Utente utente = new Utente(riga[0], riga[1], riga[2], riga[3]);
                    // bisogna aggiungere i post dell'utente
                    for(Post p : PostService.trovaPostUtente(utente)) {
                        utente.aggiungiPost(p);
                    }
                    return utente;
                }
                currentLine = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static void listaUtenti(String nome) throws IOException {
        File file = new File("./src/org/tesina/Files/Utente.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String currentLine = br.readLine();
        while(currentLine != null){
            String[] riga = currentLine.split(",");
            if(riga[0].equals(nome)){
                System.out.println("Utente trovato");
            } else {
                System.out.println("L'utente non esiste");
            }
        }
    }



}
