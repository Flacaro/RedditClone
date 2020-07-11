/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tesina.services;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.tesina.models.Menù;
import org.tesina.models.Utente;


/**
 * @author flavi
 */
public class LoginService {


    public static void login() {
        System.out.println("Inserisci email");
        Scanner scan = new Scanner(System.in);
        String email = scan.next();
        System.out.println("Inserisci password");
        String password = scan.next();
        Utente utente = UtenteService.trovaEmailUtente(email);
        //la funzione può restituire null se non trova un utente
        if (utente != null) {
            if (utente.getPassword().equals(password)) {
                UtenteService.setUtenteLoggato(utente);
                Menù.homePage();
            }
        }
        Menù.login();
    }

    public static void registrazione() {
        File file = new File("./src/org/tesina/Files/Utente.txt");

        try (BufferedWriter wr = new BufferedWriter(new FileWriter(file, true))){

            System.out.println("Immettere i tuoi dati");
            Scanner scan = new Scanner(System.in);
            System.out.println("Nome: ");
            String nome = scan.next();
            System.out.println("Cognome: ");
            String cognome = scan.next();
            System.out.println("Email: ");
            String email = scan.next();
            System.out.println("Password: ");
            String password = scan.next();
            Utente utente = new Utente(nome, cognome, email, password);
            wr.write(utente.getNome() + "," + utente.getCognome() + "," + utente.getEmail() + "," + utente.getPassword() + "\n");
            UtenteService.setUtenteLoggato(utente);
            System.out.println("Benvenuto " + utente.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

