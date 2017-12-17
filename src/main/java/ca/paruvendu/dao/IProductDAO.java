package ca.paruvendu.dao;

import java.util.List;

import ca.paruvendu.domain.Product;



public interface IProductDAO {
	
	 List<Product> getAllProducts();
     Product getProductById(String productId);
     boolean addArticle(Product product);
     

}
