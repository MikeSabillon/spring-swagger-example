package sabillon.spring.swagger.example.service;

import sabillon.spring.swagger.example.dto.PersonDTO;

import java.util.List;

public interface PersonService {

    PersonDTO save(PersonDTO personDTO);

    Boolean deleteById(Long id);

    PersonDTO findById(Long id);

    List<PersonDTO> findAll();

}
