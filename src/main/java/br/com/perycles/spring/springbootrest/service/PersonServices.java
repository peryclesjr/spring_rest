package br.com.perycles.spring.springbootrest.service;

import br.com.perycles.spring.springbootrest.converter.DozerConverter;
import br.com.perycles.spring.springbootrest.data.vo.PersonVO;
import br.com.perycles.spring.springbootrest.exception.ResourceNotFoundException;
import br.com.perycles.spring.springbootrest.model.Person;
import br.com.perycles.spring.springbootrest.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServices {

    PersonRepository repository;

    public PersonServices(PersonRepository repository) {
        this.repository = repository;
    }

    public PersonVO create(PersonVO person){
        var entitiy = DozerConverter.parseObject(person, Person.class);
        return DozerConverter.parseObject(repository.save(entitiy), PersonVO.class);
    }

    public PersonVO update(PersonVO personVO){

        Person entity = repository.findById(personVO.getId()).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setAddress(personVO.getAddress());
        entity.setGender(personVO.getGender());

        return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
    }

    public ResponseEntity<PersonVO> findById(Long id){
        Person person =  repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));

        ResponseEntity<PersonVO> responseEntity =
                new ResponseEntity<PersonVO>(DozerConverter.parseObject(person, PersonVO.class) , HttpStatus.OK);
        return responseEntity;
    }

    public List<PersonVO> findAll(){
        List<PersonVO> people=  DozerConverter.parseListObject(repository.findAll(), PersonVO.class);
//        List<ResponseEntity<PersonVO>> responseEntityList = new ArrayList<>();

//        for(Person person : people){
//            responseEntityList.add(new ResponseEntity<PersonVO>(DozerConverter.parseObject(people, PersonVO.class), HttpStatus.OK));
//        }
        return people;
    }

    public void delete(Long id){
        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }
}
