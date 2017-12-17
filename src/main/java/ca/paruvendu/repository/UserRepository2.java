package ca.paruvendu.repository;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ca.paruvendu.domain.Product;



public interface UserRepository2 {
	
	public Product save(Product product) throws DataAccessException;
	
   public Product findById(String email);
   
   public List<Product> findByEmailList(String email);
   
   public  List<Product> findAll();
}
