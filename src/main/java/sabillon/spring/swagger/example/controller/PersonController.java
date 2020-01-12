package sabillon.spring.swagger.example.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sabillon.spring.swagger.example.dto.PersonDTO;

import javax.validation.Valid;
import java.util.List;

public interface PersonController {

    @ApiOperation(value = "Creates a person via a json object")
    @PutMapping
    default ResponseEntity<PersonDTO> create(
            @Valid
            @RequestBody PersonDTO personDTO) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Deletes a person by its Id")
    @PostMapping("/{id}")
    default ResponseEntity<Boolean> deleteById(
            @ApiParam(value = "Id of person to delete by", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Returns a person by its Id")
    @GetMapping("/{id}")
    default ResponseEntity<PersonDTO> findById(
            @ApiParam(value = "Id of person to find by", required = true, example = "1")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Returns all the persons from the db")
    @GetMapping("/all")
    default ResponseEntity<List<PersonDTO>> findAll() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
