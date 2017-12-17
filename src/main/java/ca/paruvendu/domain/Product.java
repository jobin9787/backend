package ca.paruvendu.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;

@Entity
@Table(name="product")
public class Product {
	
	@Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
	private String productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	private Double productPrice;
	private String productStatus;
	private String productCondition;
	private int productUnitInStock;
	private String productManufacturer;
	
	@Transient
	private MultipartFile productImage;
	
		
	public int getProductUnitInStock() {
		return productUnitInStock;
	}
	public void setProductUnitInStock(int productUnitInStock) {
		this.productUnitInStock = productUnitInStock;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	

}
