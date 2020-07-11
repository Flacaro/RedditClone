package org.tesina.services;

import org.tesina.models.Commento;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CommentoService {



    public static void scriviCommento(Commento c) {
        File file = new File("./src/org/tesina/Files/Commenti.txt");
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(file, true))) {
            String commento = c.getTitoloPost() + "," + c.getContenuto() + "," + c.getAutore() + "," + c.getData();
            wr.write(commento + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Commento> trovaCommento(String titoloPost) {
        File file = new File("./src/org/tesina/Files/Commenti.txt");
        ArrayList<Commento> listaCommenti = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine = br.readLine();
            while (currentLine != null) {
                String[] riga = currentLine.split(",");
                if (riga[0].equals(titoloPost)) {
                    Commento commento1 = new Commento(riga[0],riga[1],riga[2],LocalDate.parse(riga[3]));
                    listaCommenti.add(commento1);
                }
                currentLine = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaCommenti;
    }

    //elimina commenti
    public static void eliminaCommenti(String titoloPost) throws IOException {
        File file = new File("./src/org/tesina/Files/Commenti.txt");
        File tempFile = new File("./src/org/tesina/Files/TempFile.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter wr = new BufferedWriter(new FileWriter(tempFile));
        String currentLine = br.readLine();
            while(currentLine != null) {
                String[] riga = currentLine.split(",");
                if(riga[0].equals(titoloPost)){

                } else{
                    wr.write(currentLine + "\n");
                }
                currentLine = br.readLine();
            }
        br.close();
        wr.close();
        file.delete();
        tempFile.renameTo(file);
        }

    }


