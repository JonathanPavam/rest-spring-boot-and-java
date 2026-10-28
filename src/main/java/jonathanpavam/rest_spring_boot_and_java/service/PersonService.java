package jonathanpavam.rest_spring_boot_and_java.service;


import jonathanpavam.rest_spring_boot_and_java.controllers.PersonController;
import jonathanpavam.rest_spring_boot_and_java.data.dto.PersonDTO;
import jonathanpavam.rest_spring_boot_and_java.exceptions.RequiredObjectsNullException;
import jonathanpavam.rest_spring_boot_and_java.exceptions.ResourceNotFOundException;
import jonathanpavam.rest_spring_boot_and_java.mapper.ObjectMapper;
import jonathanpavam.rest_spring_boot_and_java.model.Person;
import jonathanpavam.rest_spring_boot_and_java.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import static jonathanpavam.rest_spring_boot_and_java.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public PersonDTO findById (Long id){
        logger.info("Finding one person");
        var entity = repository.findById(id).orElseThrow(()
                -> new ResourceNotFOundException("No records found for this id"));
        var dto = parseObject(entity, PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public List <PersonDTO> findAll (){
        logger.info("Fiding peoples");
        var persons = ObjectMapper.parseListObjects(repository.findAll(), PersonDTO.class);
        persons.forEach(this::addHateoasLinks);
        return persons;
    }

    public PersonDTO create (PersonDTO person){

        if(person == null) throw new RequiredObjectsNullException();
        logger.info("Creating one Person!");
        var entity = parseObject(person, Person.class);
        var dto = parseObject(repository.save(entity), PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public PersonDTO update (PersonDTO person){
        if(person == null) throw new RequiredObjectsNullException();
        logger.info("Updadting one Person!");
        Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFOundException("No records found for this id"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var dto = parseObject(repository.save(entity), PersonDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public void delete (Long id){
        logger.info("Deleting one person");
        Person entity = repository.findById(id).orElseThrow(()-> new ResourceNotFOundException("No records found for this id"));
        repository.delete(entity);
    }

    private void addHateoasLinks(PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).put(dto)).withRel("put").withType("PUT"));
        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }

}
