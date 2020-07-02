/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tesina.models;

import java.util.ArrayList;

/**
 *
 * @author flavi
 */
public class Utente {
    
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private final ArrayList<Post> post;
    private final ArrayList<Categoria> categorie;
    
    
    public Utente(String nome, String cognome, String email, String password){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.post = new ArrayList<>();
        this.categorie = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Post> getPost() {
        return post;
    }

    public void rimuoviPost(Post post) {
        this.post.remove(post);
    }
    
    public void aggiungiPost(Post post) {
        this.post.add(post);
    }

    public ArrayList<Categoria> getCategorie() {
        return categorie;
    }

    public void rimuoviCategoria(Categoria categoria) {
        this.categorie.remove(categoria);
    }
    
    public void aggiungiCategoria(Categoria categoria) {
        this.categorie.add(categoria);
    }
    
    
    
}
