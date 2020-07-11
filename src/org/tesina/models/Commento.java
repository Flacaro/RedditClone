/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tesina.models;

import java.time.LocalDate;

/**
 *
 * @author flavi
 */
public class Commento {

    private String titoloPost;
    private String contenuto;
    private String autore;
    private LocalDate data;


    public Commento(String titoloPost, String contenuto, String autore, LocalDate data) {
        this.contenuto = contenuto;
        this.autore = autore;
        this.data = data;
       this.titoloPost = titoloPost;
    }

    public Commento(String contenuto, String titoloPost) {
        this.contenuto = contenuto;
        this.titoloPost = titoloPost;
    }

    public String getTitoloPost() { return titoloPost; }

    public void setTitoloPost(String titoloPost) {
        this.titoloPost = titoloPost;
    }

    public String getContenuto() { return contenuto; }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    @Override
    public String toString(){
        return "Commento: " + this.contenuto + ", Autore: " + this.autore;
    }
    
}
