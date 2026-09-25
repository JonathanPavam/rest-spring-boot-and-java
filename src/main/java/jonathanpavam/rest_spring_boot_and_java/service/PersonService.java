package jonathanpavam.rest_spring_boot_and_java.service;


import jonathanpavam.rest_spring_boot_and_java.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById (String id){
        logger.info("Finding one person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Nome");
        person.setLastName("Lastname");
        person.setAdress("São João, São Paulo - Brasil");
        person.setGender("Masculino");
        return person;
    }

    public List <Person> findAll (){
        logger.info("Fiding peoples");
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < 8 ; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create (Person person){
        logger.info("Creating one Person!");
        return person;
    }

    public Person update (Person person){
        logger.info("Updadting one Person!");
        return person;
    }

    public void delete (String id){
        logger.info("Deleting one person");

    }


    private Person mockPerson(int i){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Nome" + i);
        person.setLastName("Lastname"+ i);
        person.setAdress("Adress" + i);
        person.setGender("Masculino" + i);
        return person;
    }
}
