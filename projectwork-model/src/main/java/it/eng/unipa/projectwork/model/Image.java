package it.eng.unipa.projectwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Entity
public class Image extends AEntity<Long>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IMAGE_ID_SEQ") 
	@SequenceGenerator(name="IMAGE_ID_SEQ", sequenceName="IMAGE_ID_SEQ", allocationSize = 1)
	private Long oid;
	
	private byte[] body;
	
	
	private String fileName;
	
	private String contentType;
	
	@ManyToOne
	private Product product;
	
	
	@Override
	public Long getOid() {
		return oid;
	}
	
	public void setOid(Long oid) {
		this.oid = oid;
	}
	
	public void setBody(byte[] body) {
		this.body = body;
	}
	
	public byte[] getBody() {
		return body;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	

}
