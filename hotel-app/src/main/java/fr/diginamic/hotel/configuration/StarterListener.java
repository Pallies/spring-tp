package fr.diginamic.hotel.configuration;

import fr.diginamic.hotel.entite.Client;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class StarterListener {

    @EventListener(ApplicationReadyEvent.class)
    public void starter() {

        IntStream.of(1,2,3,4,5,6,7,8,9).mapToObj(i->new Client());
    }
}
