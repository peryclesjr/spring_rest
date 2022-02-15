package br.com.perycles.spring.springbootrest.data.vo;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BookVo extends RepresentationModel<BookVo> implements Serializable{

    private static final long serialVersionUID = -1864518507884506590L;

    public BookVo() {
    }

    private Long id;
    private String author;
    private LocalDate launchDate;
    private BigDecimal price;
    private String title;

}
