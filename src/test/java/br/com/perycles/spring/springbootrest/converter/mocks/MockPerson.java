package br.com.perycles.spring.springbootrest.converter.mocks;

import br.com.perycles.spring.springbootrest.data.vo.PersonVO;
import br.com.perycles.spring.springbootrest.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {

    public Person mockEntyity(){
        return mockEntity(0);
    }

    public PersonVO mockVO(){
        return mockVO(0);
    }

    public List<Person> mockEntityList(){
        List<Person> people = new ArrayList<Person>();
        for (int i = 0; i <14; i++){
            people.add(mockEntity(i));
        }
        return people;
    }

    public List<PersonVO> mockVOList(){
        List<PersonVO> people = new ArrayList<>();
        for (int i = 0; i <14; i++){
            people.add(mockVO(i));
        }
        return people;
    }

    private Person mockEntity(long number) {
        Person person = new Person();
        person.setId(number);
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setLastName("Last Name Test"+ number );
        return person;
    }

    private PersonVO mockVO(long number) {
        PersonVO person = new PersonVO();

        person.setId(number);
        person.setAddress("Addres Test" + number);
        person.setFirstName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setLastName("Last Name Test" + number);
        return person;
    }
}
