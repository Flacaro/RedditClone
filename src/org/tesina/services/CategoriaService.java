package org.tesina.services;

import org.tesina.models.Categoria;
import org.tesina.models.Utente;

import java.io.*;
import java.util.ArrayList;

public class CategoriaService {

    public static Categoria trovaCategoria(String nomeCategoria){
        File file = new File("./src/org/tesina/Files/Categoria.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            while(br.lines() != null) {
                String[] riga = br.readLine().split("\n");
                if(riga[0].equals(nomeCategoria)) {
                   Categoria categoria = new Categoria(riga[0]);
                    return categoria;
                }
            }

        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void scriviCategoria(Categoria categoria) {
        File file = new File("./src/org/tesina/Files/Categoria.txt");
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(file, true))) {
            wr.write("montagna\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public static ArrayList<Categoria>  listaCategorie(){
         File file = new File("./src/org/tesina/Files/Categoria.txt");
         ArrayList<Categoria> categorie = new ArrayList<>();
         try(BufferedReader br = new BufferedReader(new FileReader(file))){
             String line = br.readLine();
             while(line != null) {
                 String[] riga = line.split("\n");
                 Categoria categoria = new Categoria(riga[0]);
                categorie.add(categoria);
                line = br.readLine();
             }
             } catch (IOException e){
             e.printStackTrace();
         } return categorie;

    }


}

