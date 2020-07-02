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
    
    private String contenuto;
    private Utente autore;
    private LocalDate data;

    public Commento(String contenuto, Utente autore, LocalDate data) {
        this.contenuto = contenuto;
        this.autore = autore;
        this.data = data;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public Utente getAutore() {
        return autore;
    }

    public void setAutore(Utente autore) {
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
        return "Commento: " + this.contenuto + ", Autore: " + this.autore.getNome(); 
    }
    
}
