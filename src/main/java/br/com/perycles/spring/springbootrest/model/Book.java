package br.com.perycles.spring.springbootrest.model;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name="books")
public class Book implements  Serializable{
    private static final long serialVersionUID = -1864518507884506590L;

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="author")
    private String author;
    @Column(name="launch_date")
    private LocalDate launchDate;
    @Column(name="pricer")
    private BigDecimal price;
    @Column(name="title")
    private String title;

}
