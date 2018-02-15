package it.eng.unipa.projectwork.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

import it.eng.unipa.projectwork.model.Auction;
import it.eng.unipa.projectwork.model.Image;
import it.eng.unipa.projectwork.model.Product;
import it.eng.unipa.projectwork.model.Supplier;
import it.eng.unipa.projectwork.model.pricingstrategy.PRICING;
import it.eng.unipa.projectwork.service.LazyArrayList;
import it.eng.unipa.projectwork.service.LazyList;
import it.eng.unipa.projectwork.web.dto.AuctionFullDTO;

public class ConverterUtils {
	
	public static <T> T convert(Object o,Class<T> clazzDTO,Converter<?,?>... p){
		ModelMapper modelMapper = new ModelMapper();
		for(Converter<?, ?> converter : p){
			modelMapper.addConverter(converter);
		}
		
		T tDTO = modelMapper.map(o, clazzDTO);
		return tDTO;
	}
	
	
	public static <T> List<T> convert(List<?> l,Class<T> clazzDTO){
		return l.stream().map(o -> convert(o, clazzDTO)).collect(Collectors.toList());
	}
	
	public static <T> LazyList<T> convert(LazyList<?> l,Class<T> clazzDTO){
		return new LazyArrayList<>(convert(l.getResults(), clazzDTO),l.getFirstResult(),l.getMaxResults(),l.getTotalRows());
	}
	
//	public static class AuctionFullDTOPropertyMap extends PropertyMap<Auction, AuctionFullDTO> {
//		
//		protected void configure() {
//			try{
//				List<Long> sourceObj = new ArrayList<>();
//				for(Image image : source.getProduct().getImages()){
//					sourceObj.add(image.getOid());
//				}
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//			//List<Long> sourceObj = .stream().map(e -> e.getOid()).collect(Collectors.toList());
//			ArrayList<Long> source2 = new ArrayList<>();
//			source2.add(2L);
//			map(source2,destination.getProductImagesOid());
//	    	//map().setProductImagesOid(collect);
//	    }
//		
//		
//		
//		
//	}
	
	public static class ImageConverter implements Converter<List<Image>, List<Long>>{

		@Override
		public List<Long> convert(MappingContext<List<Image>, List<Long>> context) {
			return context.getSource().stream().map(e->e.getOid()).collect(Collectors.toList());
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		Supplier supplier = new Supplier();
		Product product = new Product();
		product.setImages(new ArrayList<>());
		product.getImages().add(new Image(1L,"fileName", "contentType", new byte[]{}));
		
		Auction a = new Auction("title", "description", supplier , product , new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), PRICING.UPWARDS,false );
		AuctionFullDTO d = convert(a,AuctionFullDTO.class,new ImageConverter());	
		System.out.println(d);
	}

}
