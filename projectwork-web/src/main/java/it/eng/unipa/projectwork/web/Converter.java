package it.eng.unipa.projectwork.web;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import it.eng.unipa.projectwork.service.LazyArrayList;
import it.eng.unipa.projectwork.service.LazyList;

public class Converter {
	
	public static <T> T convert(Object o,Class<T> clazzDTO){
		ModelMapper modelMapper = new ModelMapper();
		T tDTO = modelMapper.map(o, clazzDTO);
		return tDTO;
	}
	
	
	public static <T> List<T> convert(List<?> l,Class<T> clazzDTO){
		return l.stream().map(o -> convert(o, clazzDTO)).collect(Collectors.toList());
	}
	
	public static <T> LazyList<T> convert(LazyList<?> l,Class<T> clazzDTO){
		return new LazyArrayList<>(convert(l.getResults(), clazzDTO),l.getFirstResult(),l.getMaxResults(),l.getTotalRows());
	}
}
