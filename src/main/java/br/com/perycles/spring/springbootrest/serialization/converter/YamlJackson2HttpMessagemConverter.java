package br.com.perycles.spring.springbootrest.serialization.converter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public class YamlJackson2HttpMessagemConverter extends AbstractJackson2HttpMessageConverter {
    public YamlJackson2HttpMessagemConverter(){
        super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
    }
}
