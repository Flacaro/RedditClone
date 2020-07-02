package org.tesina.models;

import java.util.ArrayList;

public class FakeDatabase {

    private static ArrayList<Utente> utenti = new ArrayList<>();
    private static ArrayList<Categoria> arrayCategoria = new ArrayList<>();
    private static ArrayList<Post> arrayPost= new ArrayList<>();

    public static void aggiungiUtente(Utente utente) {
        utenti.add(utente);
    }

    public static ArrayList<Utente> getArrayUtente() {
        return utenti;
    }

    public static void aggiungiCategoria(Categoria categoria){
        arrayCategoria.add(categoria);

    }

    public static ArrayList<Categoria> getArrayCategoria(){
        return arrayCategoria;
    }

    public static void aggiungiArrayPost(Post post){
        arrayPost.add(post);
    }

    public static ArrayList<Post> getArrayPost(){
        return arrayPost;
    }

}