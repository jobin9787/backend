package ca.paruvendu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import ca.paruvendu.domain.Product;

@Transactional
@Repository
public class ProductDAO implements IProductDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public List<Product> getAllProducts() {
		 String hql = "FROM Product as atcl ORDER BY atcl.productId";
		return (List<Product>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Product getProductById(String productId) {
		// TODO Auto-generated method stub
//		 return entityManager.find(Product.class,productId);
		
		 Query query = this.entityManager.createQuery("From Product p where p.productId= '4028b8815b738246015b738328d50000' ");
//	        query.setParameter("id", productId);
	        return (Product) query.getSingleResult();
	}

	@Override
	public boolean addArticle(Product product) {
		return false;
	}

}
