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
                    if(riga.length == 5) {
                        Utente admin = new Utente(riga[0], riga[1], riga[2], riga[3], Boolean.parseBoolean(riga[4]));
                        return admin;
                    }
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



    public static ArrayList<Utente> listaUtenti() {
        File file = new File("./src/org/tesina/Files/Utente.txt");
        ArrayList<Utente> listaUtenti = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine = br.readLine();

            while(currentLine != null){
                String[] riga = currentLine.split(",");
                if(riga.length == 4) listaUtenti.add(new Utente(riga[0], riga[1], riga[2], riga[3]));
                currentLine = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaUtenti;
    }


    public static void eliminaUtente(String email) {
        File file = new File("./src/org/tesina/Files/Utente.txt");
        File tempFile = new File("./src/org/tesina/Files/tempUtente.txt");
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(tempFile, true));
             BufferedReader br = new BufferedReader(new FileReader(file))) {

            String currentLine = br.readLine();
            while (currentLine != null) {
                String[] riga = currentLine.split(",");
                if (!riga[2].equals(email)) {
                    wr.write(currentLine + "\n");
                }
                currentLine = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.delete()) tempFile.renameTo(file);
    }

}
