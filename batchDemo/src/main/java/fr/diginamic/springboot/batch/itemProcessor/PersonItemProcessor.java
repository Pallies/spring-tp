package fr.diginamic.springboot.batch.itemProcessor;

import fr.diginamic.springboot.batch.entities.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {
    private final Logger LOGGER = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person person) throws Exception {
        final String firstName = Capitalize(person.getFirstName());
        final String lastName = Capitalize(person.getLastName());
        Person personCapitalize = new Person(firstName, lastName);
        LOGGER.info("Convert {} to {}", person, personCapitalize);
        return personCapitalize;
    }

    private String Capitalize(String str) {
        char capital = str.charAt(0);
        return String.valueOf(capital).toUpperCase() + str.toLowerCase().substring(1);
    }

}
