package br.com.perycles.spring.springbootrest.data.vo;

import br.com.perycles.spring.springbootrest.model.Person;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;
//import org.springframework.hateoas.ResourceSupport;
import java.io.Serializable;
import java.util.Objects;


public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    private static final long serialVersionUID = -4015272657077991030L;

//    @Mapping("id")
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonVO personVO = (PersonVO) o;
        return id.equals(personVO.id) && firstName.equals(personVO.firstName) && lastName.equals(personVO.lastName) && address.equals(personVO.address) && gender.equals(personVO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, firstName, lastName, address, gender);
    }
}
