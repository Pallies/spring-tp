package dev.ihm;

import dev.exception.PlatException;
import dev.ihm.options.IOptionMenu;
import dev.ihm.options.OptionAjouterPlat;
import dev.ihm.options.OptionListerPlats;
import dev.ihm.options.OptionTerminer;
import dev.service.IPlatService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class Menu {

    private Map<Integer, IOptionMenu> actions = new HashMap<>();

    private String menu;
    private Scanner scanner;

    public Menu(Scanner scanner, IPlatService service, List<IOptionMenu> listOption) {
        AtomicInteger num = new AtomicInteger(0);
        for(IOptionMenu option : listOption){
            actions.put(num.incrementAndGet(),option);
        }
        this.scanner = scanner;
    }

    public void afficher() {

        boolean continuer = true;

        while (continuer) {

            System.out.println(getMenuTexte());

            int choix = this.scanner.nextInt();

            try {
                this.actions.get(choix).executer();
            } catch (PlatException e) {
                continuer = false;
                System.out.println(e.getMessage());
            }
        }
    }

    private String getMenuTexte() {
        if (menu == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("** Restaurant Console App **");
            sb.append("\n");
            this.actions.forEach((index, option) -> {
                sb.append(index);
                sb.append(". ");
                sb.append(option.getTitre());
                sb.append("\n");
            });
            this.menu = sb.toString();
        }
        return this.menu;
    }
}
