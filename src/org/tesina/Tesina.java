/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tesina;

import org.tesina.models.Menù;
import org.tesina.models.Post;
import org.tesina.services.PostService;

import java.io.*;


/**
 *
 * @author flavi
 */
public class Tesina {

    
    public static void main(String[] args) throws IOException {

//       Utente utente = UtenteService.cerca("Pincopallino");
//        if(utente != null){
//            System.out.println(utente.getNome());
//        } else {
//            System.out.println("Non c'è");
//        }
//
//        Categoria categoria = CategoriaService.trovaCategoria("cibo");
//            if(categoria != null){
//            System.out.println(categoria.getArgomento());
//        } else {
//            System.out.println("Non c'è");
//        }
//
//        Commento commento = CommentoService.trovaCommento("Al mare");
//        if(commento != null){
//            System.out.println(commento.getContenuto());
//        } else {
//            System.out.println("Commento non trovato");
//        }

//         Categoria montagna = new Categoria("montagna");
//         CategoriaService.scriviCategoria(montagna);
//         Utente u1 = new Utente("Stas", "Ant", "Stas@gmail.com","asd");
//         Post post = new Post("Bello",LocalDate.now(),"djflkwrjl",u1,montagna);
//         PostService.scriviPost(post);

            Menù.login();
    }





    public static void registrazione(String nome, String cognome, String email, String password) {
        if (nome.equals(" ")) System.out.println("Nome non valido");
        if (cognome.equals(" ")) System.out.println("Cognome non valido");
        if (email.equals(" ")) System.out.println("Email non valida");
        if (password.equals(" ")) System.out.println("Password non valida");
        if (password.length() < 5) System.out.println("Password inferiore a 5 caratteri");

    }


   
    
}


