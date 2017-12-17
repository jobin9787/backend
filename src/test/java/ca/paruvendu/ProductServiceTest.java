package ca.paruvendu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.paruvendu.domain.Product;
import ca.paruvendu.service.impl.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	@Autowired
	private ProductService productService;
	
	
	@Test
	public void testGetProductTest(){
		Product product= productService.getProductById("4028b8815b738246015b738328d50000");
		assertThat(product.getProductCondition()).isEqualTo("new");
		
	}

}
