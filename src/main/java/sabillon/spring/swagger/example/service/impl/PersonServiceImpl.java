package sabillon.spring.swagger.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sabillon.spring.swagger.example.dto.PersonDTO;
import sabillon.spring.swagger.example.model.Person;
import sabillon.spring.swagger.example.repository.PersonRepository;
import sabillon.spring.swagger.example.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public PersonDTO save(PersonDTO personDTO) {
        return PersonDTO.entityToDto
                (this.personRepository.save(PersonDTO.dtoToEntity(personDTO)));
    }

    @Override
    public Boolean deleteById(Long id) {
        this.personRepository.deleteById(id);
        return this.personRepository.existsById(id);
    }

    @Override
    public PersonDTO findById(Long id) {
        Optional<Person> dbPerson = this.personRepository.findById(id);
        return dbPerson.isPresent() ? PersonDTO.entityToDto(dbPerson.get()) : null;
    }

    @Override
    public List<PersonDTO> findAll() {
        List<PersonDTO> personDTOS = new ArrayList<>();
        this.personRepository.findAll()
                .forEach(person -> personDTOS.add(PersonDTO.entityToDto(person)));
        return personDTOS;
    }
}
