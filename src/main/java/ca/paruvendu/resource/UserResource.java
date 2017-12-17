package ca.paruvendu.resource;

import java.security.Principal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.paruvendu.config.SecurityConfig;
import ca.paruvendu.config.SecurityUtility;
import ca.paruvendu.domain.User;
import ca.paruvendu.domain.security.Role;
import ca.paruvendu.domain.security.UserRole;
import ca.paruvendu.repository.UserRepository2;
import ca.paruvendu.service.UserService;
import ca.paruvendu.utility.MailConstructor;

@RestController
@RequestMapping("/user")
public class UserResource {

	private static Logger logger = LoggerFactory.getLogger(UserResource.class);
	@Autowired
	private UserService userService;
	@Autowired
	private MailConstructor mailConstructor;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	UserRepository2 userService2;

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public ResponseEntity newUserPost(HttpServletRequest request, @RequestBody HashMap<String, String> mapper

	) throws Exception {

		logger.info("newUserPost ");
		String username = mapper.get("username");
		String userEmail = mapper.get("email");

		if (userService.findByUserName(username) != null) {
			logger.info("username exist: " + username);
			return new ResponseEntity("UserNameExist", HttpStatus.BAD_REQUEST);

		}

		if (userService.findByEmail(userEmail) != null) {
			logger.info("username exist: " + userEmail);

			return new ResponseEntity("EmailExist", HttpStatus.BAD_REQUEST);

		}

		User user = new User();
		user.setUsername(username);
		user.setEmail(userEmail);

		String password = SecurityUtility.randomPassword();

		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);

		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user, role));
		userService.createUser(user, userRoles);

		SimpleMailMessage email = mailConstructor.constructNewUserEmail(user, password);
		mailSender.send(email);

		return new ResponseEntity("User Added Successfully!", HttpStatus.OK);

	}

	@RequestMapping(value = "/forgetpassword", method = RequestMethod.POST)
	public ResponseEntity forgetPasswordPost(HttpServletRequest request, @RequestBody HashMap<String,String> mapper

	) throws Exception {

		
		 String email = mapper.get("email");
		logger.info("forgetpassword "+email);

		User user = userService.findByEmail(email);

		if (user == null) {
			logger.info("username does not exist: ");
			return new ResponseEntity("Email not found", HttpStatus.BAD_REQUEST);

		}

		String password = SecurityUtility.randomPassword();

		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);
		userService.save(user);

		SimpleMailMessage newEmail = mailConstructor.constructNewUserEmail(user, password);
		mailSender.send(newEmail);

		return new ResponseEntity("Email sent", HttpStatus.OK);

	}
	
	@RequestMapping(value="/updateUserInfo", method=RequestMethod.POST)
	public ResponseEntity profileInfo(
				@RequestBody HashMap<String, Object> mapper
			) throws Exception{
		
		int id = (Integer) mapper.get("id");
		String email = (String) mapper.get("email");
		String username = (String) mapper.get("username");
		String firstName = (String) mapper.get("firstName");
		String lastName = (String) mapper.get("lastName");
		String newPassword = (String) mapper.get("newPassword");
		String currentPassword = (String) mapper.get("currentPassword");
		logger.info("currentPassword: "+ currentPassword);
		logger.info("newPassword: "+ newPassword);
		User currentUser = userService.findOne(Long.valueOf(id));
		
		if(currentUser == null) {
			throw new Exception ("User not found");
		}
		
		if(userService.findByEmail(email) != null) {
			if(userService.findByEmail(email).getId() != currentUser.getId()) {
				return new ResponseEntity("Email not found!", HttpStatus.BAD_REQUEST);
			}
		}
		
		if(userService.findByUserName(username) != null) {
			if(userService.findByUserName(username).getId() != currentUser.getId()) {
				return new ResponseEntity("Username not found!", HttpStatus.BAD_REQUEST);
			}
		}
		
		SecurityConfig securityConfig = new SecurityConfig();
		
		
			BCryptPasswordEncoder passwordEncoder = SecurityUtility.passwordEncoder();
			String dbPassword = currentUser.getPassword();
			logger.info("dbPassword: "+ dbPassword);
			if(null != currentPassword)
			if(passwordEncoder.matches(currentPassword, dbPassword)) {
				if(newPassword != null && !newPassword.isEmpty() && !newPassword.equals("")) {
					currentUser.setPassword(passwordEncoder.encode(newPassword));
				}
				currentUser.setEmail(email);
			} else {
				return new ResponseEntity("Incorrect current password!", HttpStatus.BAD_REQUEST);
			}
		
		
		currentUser.setFirstName(firstName);
		currentUser.setLastName(lastName);
		currentUser.setUsername(username);
		
		
		userService.save(currentUser);
		
		return new ResponseEntity("Update Success", HttpStatus.OK);
	}
	
	@RequestMapping("/getCurrentUser")
	public User getCurrentUser(Principal principal) {
		User user = new User();
		if (null != principal) {
			logger.info(principal.getName());
			user = userService.findByUserName(principal.getName());
		}

		return user;
	}

}
