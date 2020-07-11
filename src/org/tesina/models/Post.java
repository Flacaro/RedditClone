/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tesina.models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author flavi
 */
public class Post {
    
    private final ArrayList<Commento> commenti;
    private String titolo;
    private LocalDate dataPost;
    private String contenuto;
    private String utente;
    private Categoria categoria;

    public Post() {
        this.commenti = new ArrayList<>();
    }

    public Post(String titolo, LocalDate dataPost, String contenuto, String u1, Categoria categoria) {
        this.commenti = new ArrayList<>();
        this.titolo = titolo;
        this.dataPost = dataPost;
        this.contenuto = contenuto;
        this.utente = u1;
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    
    
    
    public ArrayList<Commento> getCommenti() {
        return commenti;
    }

    public void rimuoviCommento(Commento commento) {
        this.commenti.remove(commento);
    }

    public void aggiungiCommento(Commento commento) {
        this.commenti.add(commento);
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataPost() {
        return dataPost;
    }

    public void setDataPost(LocalDate dataPost) {
        this.dataPost = dataPost;
    }

    public String getContenutoPost() {
        return contenuto;
    }

    public void setContenutoPost(String contenutoPost) {
        this.contenuto = contenutoPost;
    }

    @Override
    public String toString() {
        return "Post{" +
                "commenti=" + commenti +
                ", titolo='" + titolo + '\'' +
                ", dataPost=" + dataPost +
                ", contenuto='" + contenuto + '\'' +
                ", utente=" + utente +
                ", categoria=" + categoria +
                '}';
    }
}
