package dev;


import dev.config.AppConfig;
import dev.ihm.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan
public class App {

    public static void main(String[] args) {
        // Création d'un contexte Spring avec la configuration App.class
        ApplicationContext context = SpringApplication.run(App.class, args);

        // Récupération du bean Menu
        Menu menu = context.getBean(Menu.class);

        // Lancement de l'application
        menu.afficher();


    }
}
