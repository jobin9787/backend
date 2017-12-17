package ca.paruvendu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.paruvendu.dao.IProductDAO;
import ca.paruvendu.domain.Product;
@Service
public class ProductService implements IProductService{

	@Autowired
	private IProductDAO productDAO;
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts();
	}

	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return productDAO.getProductById(id);
	}

}
