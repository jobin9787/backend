package ca.paruvendu.service.impl;

import java.util.List;

import ca.paruvendu.domain.Product;

public interface IProductService {
	
	List<Product> getAllProducts();
	Product getProductById(String id);

}
