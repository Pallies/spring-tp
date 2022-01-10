package dev;


import dev.config.AppConfig;
import dev.dao.PlatDaoFichier;
import dev.dao.PlatDaoMemoire;
import dev.ihm.Menu;
import dev.service.PlatServiceVersion2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        //try (Scanner scanner = new Scanner(System.in)) {
        // Choix du Dao
        //PlatDaoMemoire platDaoMemoire = new PlatDaoMemoire();
        //PlatDaoFichier platDaoFichier = new PlatDaoFichier("A_COMPLETER/2020-03-formation-spring/restaurant.txt");

        // Choix du service
        // PlatServiceVersion1 platServiceVersion1 = new PlatServiceVersion1(platDaoFichier);
        //PlatServiceVersion2 platServiceVersion2 = new PlatServiceVersion2(platDaoMemoire);

        // Construction du menu avec le service choisi
        // Menu menu = new Menu(scanner, platServiceVersion2);
        //menu.afficher();
        // }
        try (Scanner scanner = (Scanner) context.getBean("scanner")) {
            Menu menu = (Menu) context.getBean("createMenu");
            menu.afficher();
        }


    }
}
