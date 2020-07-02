/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tesina.services;

import java.util.ArrayList;
import org.tesina.models.FakeDatabase;
import org.tesina.models.Utente;


/**
 *
 * @author flavi
 */
public class LoginService {
    
    
        public static boolean login(String email, String password) {
            ArrayList<Utente> listaUtenti = FakeDatabase.getArrayUtente();
            boolean check = false;  
            for(Utente u : listaUtenti) {
                if(u.getEmail().equals(email)) {
                    if(u.getPassword().equals(password)) check = true;
                }
            }
            return check;
     }    
        
        
     
}
