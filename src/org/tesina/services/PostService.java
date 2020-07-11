/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tesina.services;

import java.io.*;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import org.tesina.models.Post;
import org.tesina.models.Utente;

/**
 * @author flavi
 */
public class PostService {


    public static ArrayList<Post> trovaPostUtente(Utente u) {
        ArrayList<Post> listaPost = new ArrayList<>();
        File file = new File("./src/org/tesina/Files/Posts.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String currentLine = br.readLine();
            while (currentLine != null) {
                String[] riga = currentLine.split(",");
                if (riga[3].equals(u.getEmail())) {
                    Post post = new Post(riga[0], LocalDate.parse(riga[1]), riga[2], u.getEmail(), CategoriaService.trovaCategoria(riga[4]));
                    listaPost.add(post);
                }
                currentLine = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPost;
    }

    public static Post trovaPost(String titoloPost) {
        File file = new File("./src/org/tesina/Files/Posts.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str = br.readLine();
            while (str != null) {
                String[] riga = str.split(",");
                if (riga[0].equals(titoloPost)) {
                    Post post = new Post(riga[0], LocalDate.parse(riga[1]), riga[2], riga[3], CategoriaService.trovaCategoria(riga[4]));
                    return post;
                }
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void scriviPost(Post post) {
        File file = new File("./src/org/tesina/Files/Posts.txt");
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(file, true))) {
            String post1 = post.getTitolo() + "," + post.getDataPost() + "," + post.getContenuto() + "," + post.getUtente() + "," + post.getCategoria().getArgomento();

            wr.write(post1 + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //elimina post
    public static void eliminaPost(String titoloPost) {
        File file = new File("./src/org/tesina/Files/Posts.txt");
        File tempFile = new File("./src/org/tesina/Files/TempFile.txt");
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(tempFile, true));
             BufferedReader br = new BufferedReader(new FileReader(file))) {

            String currentLine = br.readLine();
            while (currentLine != null) {
                String[] riga = currentLine.split(",");
                if (!riga[0].equals(titoloPost)) {
                    wr.write(currentLine + "\n");
                }
                currentLine = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.delete()) tempFile.renameTo(file);

    }


    public static ArrayList<Post> postDellaCategoria(String categoria) {
        ArrayList<Post> posts = new ArrayList<>();
        File file = new File("./src/org/tesina/Files/Posts.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String str = br.readLine();
            while (str != null) {
                String[] riga = str.split(",");
                if (riga[4].equals(categoria)) {
                    Post post = new Post(riga[0], LocalDate.parse(riga[1]), riga[2], riga[3], CategoriaService.trovaCategoria(riga[4]));
                    posts.add(post);
                }
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }

}



