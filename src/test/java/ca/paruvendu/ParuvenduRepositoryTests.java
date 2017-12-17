package ca.paruvendu;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import ca.paruvendu.domain.Product;
import ca.paruvendu.domain.User;
import ca.paruvendu.service.UserService;
import ca.paruvendu.service.impl.UserServiceImpl2;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.NONE)
@Transactional
public class ParuvenduRepositoryTests {
//	
//	@Autowired
//    private TestEntityManager entityManager;
////	
	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService repository;

	@Autowired
	private UserServiceImpl2 repository2;
	User user;
	
	@Before
	public void setUp() {

		 user = new User();
			user.setEmail("admin@test.ca");
			user.setId(2L);
			user.setLastName("daouad");
			user.setUsername("daouad");
	}
	
	
	@Test
	public void testExample(){
	    User user1 = this.repository.findByEmail("abdelhamidmtl@gmail.com");
        assertThat(user1.getUsername()).isEqualTo("t");
        assertThat(user1.getId()).isEqualTo(5);
//		
	}
	
//	@Test
	public void testExample2(){
	    User user1 = this.repository.findByEmail("admin@test.ca");
	    user1 = this.repository.findByEmail("admin@test.ca");
        assertThat(user1.getUsername()).isEqualTo("test1@tst.ca");
        assertThat(user1.getId()).isEqualTo(2L);
//		
	}
	
//	@Test
	public void testExample3(){
	    List<Product> user1 = this.repository2.findAll();
	 
	    assertThat(user1).isNotNull();
//		
	}
	
//	@Test
	public void testExample4(){
	    Product user1 = this.repository2.findById("4028b8815b738246015b738328d50000");
	 
	    assertThat(user1).isNotNull();
		 assertThat(user1.getProductCondition()).isEqualTo("new");
	}
}
