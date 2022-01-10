package dev;


import dev.ihm.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;


@Configuration
@ComponentScan
public class App {



    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder().sources(App.class)
                .profiles("prod")
                .build()
                .run(args);
        // Création d'un contexte Spring avec la configuration App.class
        //ApplicationContext context = SpringApplication.run(App.class, args);

        // Récupération du bean Menu
        Menu menu = context.getBean(Menu.class);

        // Lancement de l'application
        menu.afficher();


    }
}
