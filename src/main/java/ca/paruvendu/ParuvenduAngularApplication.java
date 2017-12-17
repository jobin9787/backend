package ca.paruvendu;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ca.paruvendu.config.SecurityUtility;
import ca.paruvendu.domain.User;
import ca.paruvendu.domain.security.Role;
import ca.paruvendu.domain.security.UserRole;
import ca.paruvendu.service.UserService;

@SpringBootApplication
public class ParuvenduAngularApplication implements CommandLineRunner{

	
//	@Autowired 
//	private UserService userService;
//	
	
	public static void main(String[] args) {
		SpringApplication.run(ParuvenduAngularApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
//	@Override 
//	public void run(String... args){
//		
//		User user1 = new User();
//		user1.setFirstName("John");
//		user1.setLastName("Doe");
//		user1.setEmail("test@test.ca");
//		user1.setUsername("j");
//		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
//		Set<UserRole> userRole = new HashSet<>();
//		Role role1 = new Role();
//		role1.setName("USER_ROLE");
//		role1.setRoleId(1);
//		userRole.add(new UserRole(user1,role1));
//		
//		userService.createUser(user1,userRole);
//		
//		userRole.clear();
//		User user2 = new User();
//		user2.setFirstName("Admin");
//		user2.setLastName("Doe");
//		user2.setEmail("admin@test.ca");
//		user2.setUsername("test1@tst.ca");
//		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
//		
//		Role role2 = new Role();
//		role2.setName("ADMIN_ROLE");
//		role2.setRoleId(2);
//		userRole.add(new UserRole(user2,role2));
//
//		userService.createUser(user2,userRole);
//		
//		userRole.clear();
//		
//	}
}
