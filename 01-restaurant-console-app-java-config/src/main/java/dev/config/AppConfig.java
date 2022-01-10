package dev.config;



import dev.dao.PlatDaoMemoire;
import dev.ihm.Menu;
import dev.service.PlatServiceVersion2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class AppConfig {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
    @Bean
    public Menu createMenu(Scanner scanner){
        PlatDaoMemoire platDaoMemoire = new PlatDaoMemoire();
        PlatServiceVersion2 platServiceVersion2 = new PlatServiceVersion2(platDaoMemoire);
        return new Menu(scanner, platServiceVersion2);
    }
}
