/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tesina;

import java.awt.event.MouseListener;
import org.tesina.models.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author flavi
 */
public class Tesina {

    
    public static void main(String[] args) {
        

        
    }

    public static void aggiungiPost(Post post, Categoria categoria, Utente utente) {
        categoria.aggiungiPost(post);
        utente.aggiungiPost(post);
        System.out.println(post);
    }

    public static void rimuoviPost(Post post, Categoria categoria, Utente utente) {
        categoria.rimuoviPost(post);
        utente.rimuoviPost(post);
    }

    public static void registrazione(String nome, String cognome, String email, String password) {
        if (nome.equals(" ")) System.out.println("Nome non valido");
        if (cognome.equals(" ")) System.out.println("Cognome non valido");
        if (email.equals(" ")) System.out.println("Email non valida");
        if (password.equals(" ")) System.out.println("Password non valida");
        if (password.length() < 5) System.out.println("Password inferiore a 5 caratteri");

    }


   
    
}


