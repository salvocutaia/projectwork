package it.eng.unipa.projectwork.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Basic(fetch = FetchType.LAZY) //Neither with @Lob
	private byte[] body;
	
	
	private String fileName;
	
	private String contentType;
	
	@ManyToOne
	private Product product;
	
	
	public Image() {
		// TODO Auto-generated constructor stub
	}
	
	public Image(String fileName,String contentType,byte[] body) {
		this.fileName = fileName;
		this.contentType = contentType;
		this.body = body;
	}
	
	public Image(Long oid,String fileName,String contentType,byte[] body) {
		this.oid = oid;
		this.fileName = fileName;
		this.contentType = contentType;
		this.body = body;
	}
	
	
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
