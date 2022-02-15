package br.com.perycles.spring.springbootrest.controller;

import br.com.perycles.spring.springbootrest.data.vo.PersonVO;
import br.com.perycles.spring.springbootrest.model.Person;
import br.com.perycles.spring.springbootrest.service.PersonServices;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<ResponseEntity<PersonVO>> findAll(){
        return service.findAll();
    }

    @GetMapping(value="/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<PersonVO> findById(@PathVariable(value="id") Long id){
        return service.findById(id);
    }

    @GetMapping(value="findWithlink/{id}", produces = {"application/json", "application/xml"})
    public ResponseEntity<PersonVO> findByIdLink(@PathVariable(value="id") Long id){
        PersonVO personVO = service.findByHiperMedia(id);
        personVO.add(WebMvcLinkBuilder.linkTo(PersonController.class).slash(personVO.getId()).withSelfRel());
        return new ResponseEntity<PersonVO>(personVO, HttpStatus.OK) ;
    }

    @PostMapping( consumes = {"application/json", "application/xml"},
                    produces = {"application/json", "application/xml"})
    public ResponseEntity<PersonVO> createPerson(@RequestBody PersonVO person){
        return new ResponseEntity<PersonVO>(service.create(person), HttpStatus.OK);
    }

    @PutMapping( consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    public ResponseEntity<PersonVO> updatePerson(@RequestBody PersonVO person){
        return new ResponseEntity<PersonVO>(service.update(person), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value="id") Long id){
        service.delete(id);
    }
}
