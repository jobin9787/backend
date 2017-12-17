package ca.paruvendu.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ca.paruvendu.domain.Product;
import ca.paruvendu.repository.UserRepository2;

@Service
@Repository
public class UserServiceImpl2 implements UserRepository2{
	 
	   @PersistenceContext
	    private EntityManager em;
	
	@Override
	public Product save(Product user) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByEmailList(String email) {
		 Query query = this.em.createQuery("SELECT u FROM user u where u.email= :email");
	        query.setParameter("email", email);
	        return query.getResultList();
	}
	
	@Override
	public Product findById(String id) {
		 Query query = this.em.createQuery("Select p From Product p where p.ProductId= :id");
	        query.setParameter("id", id);
	        return (Product) query.getSingleResult();
	}
	
	@Override
	public List<Product> findAll() {
		 Query query = this.em.createQuery("Select p From Product p");
	       
	        return (List<Product>) query.getResultList();
	}

}
