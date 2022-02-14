package br.com.perycles.spring.springbootrest.data.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class PersonVO implements Serializable {

    private static final long serialVersionUID = -4015272657077991030L;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

}
