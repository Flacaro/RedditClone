package org.tesina.services;

import org.tesina.models.Categoria;
import org.tesina.models.Post;
import org.tesina.models.Utente;

import java.io.*;
import java.time.LocalDate;
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

    public static void scriviCategoria(String nomeCategoria) {
        File file = new File("./src/org/tesina/Files/Categoria.txt");
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(file, true))) {
            wr.write(nomeCategoria + "\n");
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


    public static void eliminaCategoria(String categoria) {
        File file = new File("./src/org/tesina/Files/Categoria.txt");
        File tempFile = new File("./src/org/tesina/Files/categoriaTemp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file));
             BufferedWriter wr = new BufferedWriter(new FileWriter(tempFile, true))) {

            String currentLine = br.readLine();

            while (currentLine != null) {

                if (!currentLine.equals(categoria))
                    wr.write(currentLine + "\n");

                currentLine = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if(file.delete())
            tempFile.renameTo(file);
    }



    public static ArrayList<Post> trovatPostCategoria(String nomeCategoria) {
        ArrayList<Post> post = new ArrayList<>();
        File file = new File("./src/org/tesina/Files/Posts.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String currentLine = br.readLine();
            while(currentLine != null) {
                String[] riga = currentLine.split(",");
                if(riga[4].equals(nomeCategoria)) {
                    post.add(new Post(riga[0], LocalDate.parse(riga[1]), riga[2], riga[3], CategoriaService.trovaCategoria(riga[4])));
                }
                currentLine = br.readLine();
            }

        } catch(IOException e){
            e.printStackTrace();
        }
        return post;
    }
}

