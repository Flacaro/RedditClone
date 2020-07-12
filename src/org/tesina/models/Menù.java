package org.tesina.models;

import org.tesina.services.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menù {

    public static void login() {

        System.out.println("Premere 1 se si vuole effettuare il login, 2 per registrarsi");
        Scanner scan = new Scanner(System.in);
        String numero = scan.next();
        if (numero.equals("1")) {
            LoginService.login();
        } else if (numero.equals("2")) {
            LoginService.registrazione();
            homePage();
        } else {
            login();
        }
    }

    public static void homePage() {
        System.out.println("Premere 1 per scrivere un post, 2 per esplorare le categorie, 3 per visualizzare il profilo");
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\\n");
        int numero = scan.nextInt();
        switch (numero) {
            case 1:

                Post post = new Post();
                for (Categoria c : CategoriaService.listaCategorie()) {
                    System.out.println(c.getArgomento());
                }
                System.out.println("Scegli una categoria");
                String line = scan.next();
                Categoria categoria = CategoriaService.trovaCategoria(line);
                post.setCategoria(categoria);
                System.out.println("Metti un titolo");
                post.setTitolo(scan.next());
                System.out.println("Scrivi il contenuto del post");
                post.setContenuto(scan.next());
                post.setUtente(UtenteService.getUtenteLoggato().getEmail());
                post.setDataPost(LocalDate.now());
                PostService.scriviPost(post);
                UtenteService.getUtenteLoggato().aggiungiPost(post);
                System.out.println("Post salvato");
                homePage();
                break;
            case 2:
                //visualizza lgi ultimi post per la categoria che l'utente seleziona
                ArrayList<Categoria> listaCategoria = CategoriaService.listaCategorie();
                for (Categoria c : listaCategoria) {
                    System.out.println(c.getArgomento());
                }

                System.out.println("Scegli una categoria");

                String categoriaScelta = scan.next();
                Categoria c = CategoriaService.trovaCategoria(categoriaScelta);


                    // dobbiamo trovare tutti i post della categoria selezionata
                    ArrayList<Post> posts = PostService.postDellaCategoria(c.getArgomento());

                    if (!posts.isEmpty()) {
                        System.out.println("_____________________________ POST ______________________________");
                        for (Post p : posts) {
                            System.out.println("Titolo: " + p.getTitolo());
                        }
                        System.out.println("______________________________________________________________");
                        System.out.println("Seleziona il post da visualizzare");
                        String postScelto = scan.next();
                        Post postSelezionato = PostService.trovaPost(postScelto);

                        ArrayList<Commento> commentiPost = CommentoService.trovaCommento(postSelezionato.getTitolo());


                        System.out.println("titolo:" + postSelezionato.getTitolo() + "\ncontenuto: " + postSelezionato.getContenuto());

                            System.out.println("_____________________________ Commenti ______________________________");
                            for (Commento commento : commentiPost) {
                                System.out.println("Contenuto: " + commento.getContenuto());
                            }
                            System.out.println("______________________________________________________________");


                            //possibilità di commentare il post
                            System.out.println("Scegli 1 per commentare il post, 2 per tornare alla home");
                            int sceltaUtente = scan.nextInt();
                            if (sceltaUtente == 1) {
                                System.out.println("Inserisci il contenuto");
                                String contenutoCommento = scan.next();
                                Utente autoreCommento = UtenteService.getUtenteLoggato();
                                Commento commentoU = new Commento(postSelezionato.getTitolo(), contenutoCommento, autoreCommento.getNome(), LocalDate.now());
                                // scrivere il commento sul file
                                CommentoService.scriviCommento(commentoU);
                                homePage();
                            } else {
                                homePage();
                            }


                } else {
                        System.out.println("La categoria non ha nessun post");
                        homePage();
                    }

                break;
            case 3:
                Utente utente = UtenteService.getUtenteLoggato();
                System.out.println(utente.getNome() + " " + utente.getEmail());
                Menù.profilo();
                break;

        }
    }

    public static void profilo() {
        //nel profilo visualizzare i tuoi post, elimina post, logout
        System.out.println("Premi 1 per vedere i tuoi post o 2 per fare il logout");
        Scanner scan = new Scanner(System.in);
        int scelta = scan.nextInt();
        switch (scelta) {
            case 1:
                System.out.println("I tuoi post: ");
                ArrayList<Post> listaPost = UtenteService.getUtenteLoggato().getPost();
                for (Post p : listaPost) {
                    System.out.println(p.getTitolo() + "\n" + p.getContenuto());
                }
                if (listaPost.size() == 0) {
                    System.out.println("Non ci sono post da visualizzare, premi 1 per tornare alla home");
                    int numero = scan.nextInt();
                    if (numero == 1) {
                        Menù.homePage();
                    }
                } else {
                    System.out.println("Scegli 1 se vuoi eliminare un post, 2 se vuoi tornare alla home");
                    int scelta2 = scan.nextInt();
                    switch (scelta2) {
                        case 1:
                            System.out.println("Scrivi il titolo del post che vuoi eliminare");
                            Scanner sc = new Scanner(System.in);
                            String titoloPost = sc.next();
                            Post p = PostService.trovaPost(titoloPost);
                            CommentoService.eliminaCommenti(p.getTitolo());
                            PostService.eliminaPost(titoloPost);
                            UtenteService.getUtenteLoggato().rimuoviPost(p);
                            homePage();
                            break;
                        case 2:
                            homePage();
                            break;
                    }
                }
                break;
            case 2:
                UtenteService.logoutUtente();
                login();
        }


    }


    public static void adminHomepage() {
        System.out.println("Scegli 1 per gestire le categorie, 2 per gestire gli utenti, 3 per fare logout");
        Scanner sc = new Scanner(System.in);
        int scelta = sc.nextInt();

        switch (scelta) {
            case 1 :
                 Scanner scanner = new Scanner(System.in);
                 for(Categoria c: CategoriaService.listaCategorie()) {
                     System.out.println(c.getArgomento());
                 }

                adminMenu1();


            case 2:
                ArrayList<Utente> listaUtenti = UtenteService.listaUtenti();
                if(listaUtenti.size() != 0) {
                    for(Utente u: listaUtenti) {
                        System.out.println("Nome: " + u.getNome() + " Email: " + u.getEmail());
                    }
                    System.out.println("Scegli l'email dell'utente che vuoi eliminare");
                    String emailUtenteSelezionato = sc.next();
                    Utente utente = UtenteService.trovaEmailUtente(emailUtenteSelezionato);
                    for(Post p: PostService.trovaPostUtente(utente)) {
                        CommentoService.eliminaCommenti(p.getTitolo());
                    }
                    PostService.eliminaPostUtente(emailUtenteSelezionato);
                    UtenteService.eliminaUtente(emailUtenteSelezionato);
                } else {
                    System.out.println("Non ci sono utenti");
                }

                adminHomepage();
                break;

            case 3:
                login();
        }
    }



    public static void adminMenu1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Premi 1 per aggiungere una categoria, 2 per eliminare una categoria, 3 esplora post della categoria, 4 per tornare alla home");
        int sceltaUtente = 0;
        try {
           sceltaUtente =  scanner.nextInt();
        }catch(InputMismatchException e) {
            adminMenu1();
        }

        switch (sceltaUtente) {
            case 1:
                System.out.println("Inserisci il nome della categoria");
                String nomeCategoria = scanner.next();
                CategoriaService.scriviCategoria(nomeCategoria);
                System.out.println("Categoria aggiunta");
                adminMenu1();
                break;
            case 2:
                System.out.println("Inserisci il nome della categoria da eliminare");
                String categoria = scanner.next();
                for(Post p: PostService.postDellaCategoria(categoria)) {
                    CommentoService.eliminaCommenti(p.getTitolo());
                    PostService.eliminaPost(p.getTitolo());
                }
                CategoriaService.eliminaCategoria(categoria);
                System.out.println("Categoria eliminata con successo");
                adminMenu1();
                break;
            case 3:
                for(Categoria c: CategoriaService.listaCategorie()) {
                    System.out.println(c.getArgomento());
                }
                System.out.println("Seleziona il nome della categoria");
                String c = scanner.next();
                // trova tutti i post della categoria
                ArrayList<Post> postCategoria = CategoriaService.trovatPostCategoria(c);
                if(postCategoria.size() != 0) {
                    System.out.println("----------------- POST -----------------");
                    for(Post p: postCategoria) {
                        System.out.println("Titolo post: " + p.getTitolo());
                    }
                    System.out.println("---------------------------------------");
                    adminPostMenu();
                } else {
                    System.out.println("La categoria non contiene post");
                }

                adminMenu1();
                break;
            case 4:
                adminHomepage();
        }
    }//end method


    public static void adminPostMenu() {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\n");
        System.out.println("Seleziona il nome post da visualizzare");
        String postSelezionato = null;
        try {
            postSelezionato = sc.next();
        } catch(InputMismatchException e) {
            adminPostMenu();
        }

        Post post = null;
        // se l'utente ha inserito il nome del post corretto
        if(PostService.trovaPost(postSelezionato) != null) {

            post = PostService.trovaPost(postSelezionato);

            ArrayList<Commento> commentiPost = CommentoService.trovaCommento(postSelezionato);
            System.out.println("Titolo: " + post.getTitolo() + " contenuto: " + post.getContenuto() + " scritto il: " + post.getDataPost());
            System.out.println("-------------------Commenti---------------");
            for(Commento c: commentiPost) {
                System.out.println(c.getContenuto());
            }
            System.out.println("------------------------------------------");

            System.out.println("\nPremi 1 per eliminare il post, 2 per tornare alla home");
            int scelta = sc.nextInt();

            switch (scelta) {
                case 1:
                    CommentoService.eliminaCommenti(postSelezionato);
                    PostService.eliminaPost(postSelezionato);
                    System.out.println("Post eliminato");
                    adminMenu1();
                case 2:
                    adminHomepage();
            }

        }


    }


}




