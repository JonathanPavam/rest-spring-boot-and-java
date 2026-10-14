package jonathanpavam.rest_spring_boot_and_java.service;


import jonathanpavam.rest_spring_boot_and_java.data.dto.v1.PersonDTO;
import jonathanpavam.rest_spring_boot_and_java.data.dto.v2.PersonDTOV2;
import jonathanpavam.rest_spring_boot_and_java.exceptions.ResourceNotFOundException;
import jonathanpavam.rest_spring_boot_and_java.mapper.ObjectMapper;
import jonathanpavam.rest_spring_boot_and_java.mapper.custom.PersonMapper;
import jonathanpavam.rest_spring_boot_and_java.model.Person;
import jonathanpavam.rest_spring_boot_and_java.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static jonathanpavam.rest_spring_boot_and_java.mapper.ObjectMapper.parseListObjects;
import static jonathanpavam.rest_spring_boot_and_java.mapper.ObjectMapper.parseObject;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper converter;



    public PersonDTO findById (Long id){
        logger.info("Finding one person");
        var entity = repository.findById(id).orElseThrow(()
                -> new ResourceNotFOundException("No records found for this id"));
        return parseObject(entity, PersonDTO.class);
    }

    public List <PersonDTO> findAll (){
        logger.info("Fiding peoples");
        return ObjectMapper.parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO create (PersonDTO person){
        logger.info("Creating one Person!");
        var entity = parseObject(person, Person.class);
        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public PersonDTOV2 createV2 (PersonDTOV2 person){
        logger.info("Creating one Person V2!");
        var entity = converter.convertDTOToEntity(person);
        return converter.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update (PersonDTO person){
        logger.info("Updadting one Person!");
        Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFOundException("No records found for this id"));
        entity.setFirstName(entity.getFirstName());
        entity.setLastName(entity.getLastName());
        entity.setAddress(entity.getAddress());
        entity.setGender(entity.getGender());

        return parseObject(repository.save(entity), PersonDTO.class);
    }

    public void delete (Long id){
        logger.info("Deleting one person");
        Person entity = repository.findById(id).orElseThrow(()-> new ResourceNotFOundException("No records found for this id"));
        repository.delete(entity);
    }

}
