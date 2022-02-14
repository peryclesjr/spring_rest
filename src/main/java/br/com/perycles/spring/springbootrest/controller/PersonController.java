package br.com.perycles.spring.springbootrest.controller;

import br.com.perycles.spring.springbootrest.data.vo.PersonVO;
import br.com.perycles.spring.springbootrest.model.Person;
import br.com.perycles.spring.springbootrest.service.PersonServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonServices service;

    public PersonController(PersonServices service) {
        this.service = service;
    }

    @GetMapping
    public List<ResponseEntity<PersonVO>> findAll(){
        return service.findAll();
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<PersonVO> findById(@PathVariable(value="id") Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<PersonVO> createPerson(@RequestBody PersonVO person){
        return new ResponseEntity<PersonVO>(service.create(person), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PersonVO> updatePerson(@RequestBody PersonVO person){
        return new ResponseEntity<PersonVO>(service.update(person), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value="id") Long id){
        service.delete(id);
    }
}
