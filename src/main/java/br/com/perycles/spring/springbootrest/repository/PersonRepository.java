package br.com.perycles.spring.springbootrest.repository;

import br.com.perycles.spring.springbootrest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
