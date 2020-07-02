/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tesina.services;

import java.util.ArrayList;
import org.tesina.models.FakeDatabase;
import org.tesina.models.Post;
import org.tesina.models.Utente;

/**
 *
 * @author flavi
 */
public class PostService {
 
    
    public static boolean cercaUtente(String nome){
        ArrayList<Utente> listaUtenti = FakeDatabase.getArrayUtente();
        boolean b = false;
        for (Utente u1: listaUtenti){
            if (u1.getNome().equals(nome)){
                b = true;
            }
        }  
        return b;
    }
    
    
    
    public static void eliminaPost(Post post) {
        
    }
    
    
}
