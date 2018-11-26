package ca.paruvendu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import ca.paruvendu.config.SecurityConfig;
import ca.paruvendu.config.SecurityUtility;
import ca.paruvendu.domain.User;
import ca.paruvendu.service.UserService;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class PasswordEncriptingTest {
	SecurityConfig securityConfig = new SecurityConfig();
	BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService repository;
//	@Test
	public void passwordTest(){
	User user = repository.findByUserName("j");
	String dbPassword = user.getPassword();
	String encryptedPassword = SecurityUtility.passwordEncoder().encode("p");
	 assertThat(dbPassword).isEqualTo(encryptedPassword);
	 
	 assertThat(passwordEncoder.matches("p", dbPassword)).isTrue();
	}

}
