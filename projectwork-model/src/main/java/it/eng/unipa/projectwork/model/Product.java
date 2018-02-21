package it.eng.unipa.projectwork.model;
/**
 * 
 * @author Giancarlo Compagno
 * 
 */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Entity
public class Product extends AEntity<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_ID_SEQ") 
	@SequenceGenerator(name="PRODUCT_ID_SEQ", sequenceName="PRODUCT_ID_SEQ", allocationSize = 1)
	private Long oid;
	private String description;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="product",cascade=CascadeType.ALL)
	private List<Image> images = new ArrayList<>();
	
	public Product(){
		
	}
	
	public Product(String description,List<Image> images) {
		this.description = description;
		setImages(images);
	}
	
	public Product(Long oid) {
		this.oid = oid;
	}
	
	
	
	
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Image> getImages() {
		return images;
	}
	
	public void setImages(List<Image> images) {
		this.images = images;
		if(this.images!=null){
			this.images.forEach((e)->{e.setProduct(this);});
		}
	}

	@Override
	public String toString() {
		return "Supplier [getOid()=" + getOid() + ", getDescription()=" + getDescription() + super.toString() + "]";
	}
	
	
	
	
}
