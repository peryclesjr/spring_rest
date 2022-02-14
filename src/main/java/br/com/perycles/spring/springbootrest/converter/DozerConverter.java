package br.com.perycles.spring.springbootrest.converter;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerConverter {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O,D> D parseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }

    public static  <O,D> List<D> parseListObject(List<O> origins, Class<D> destination){
        List<D> destinationList = new ArrayList<>();
        for(Object origin : origins){
            destinationList.add(mapper.map(origin,destination));
        }
        return destinationList;
    }

}
