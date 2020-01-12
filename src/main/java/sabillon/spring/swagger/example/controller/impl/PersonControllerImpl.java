package sabillon.spring.swagger.example.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sabillon.spring.swagger.example.controller.PersonController;
import sabillon.spring.swagger.example.dto.PersonDTO;
import sabillon.spring.swagger.example.service.PersonService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/person")
public class PersonControllerImpl implements PersonController {

    private final PersonService personService;

    @Override
    public ResponseEntity<PersonDTO> create(PersonDTO personDTO) {
        return new ResponseEntity<>(this.personService.save(personDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long id) {
        return new ResponseEntity<>(this.personService.deleteById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDTO> findById(Long id) {
        return new ResponseEntity<>(this.personService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonDTO>> findAll() {
        return new ResponseEntity<>(this.personService.findAll(), HttpStatus.OK);
    }
}
