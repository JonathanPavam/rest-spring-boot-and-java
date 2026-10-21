package jonathanpavam.rest_spring_boot_and_java.config;

<<<<<<< HEAD
public class ObjectMapperConfig {
=======
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class ObjectMapperConfig {
        @Bean
        public ObjectMapper objectMapper(){
            ObjectMapper mapper = new ObjectMapper();
            SimpleFilterProvider filters = new SimpleFilterProvider()
                    .addFilter("PersonFilter", SimpleBeanPropertyFilter.serializeAllExcept("sensitiveData"));
            mapper.setFilterProvider(filters);
            return mapper;
        }
>>>>>>> 4c8ad5d (feat: 12 - Custom JSON Serialization)
}
