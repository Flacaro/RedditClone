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
public class Categoria {
    
    private String argomento;
    private ArrayList<Post> post;

    public Categoria(String argomento) {
        this.argomento = argomento;
        this.post = new ArrayList<>();
    }

    public String getArgomento() {
        return argomento;
    }

    public void setArgomento(String argomento) {
        this.argomento = argomento;
    }

    public ArrayList<Post> getPost() {
        return post;
    }

    public void aggiungiPost(Post post) {
        this.post.add(post);
    }
    public void rimuoviPost(Post post){
        this.post.remove(post);
    }
    public String toString(){
        return "Argomento "+ this.argomento;
    }
    
    
}
