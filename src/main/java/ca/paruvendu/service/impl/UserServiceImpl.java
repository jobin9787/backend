package ca.paruvendu.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.paruvendu.domain.User;
import ca.paruvendu.domain.security.UserRole;
import ca.paruvendu.repository.RoleRepository;
import ca.paruvendu.repository.UserRepository;
import ca.paruvendu.service.UserService;

@Component(value="UserServiceImpl")
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public User createUser(User user, Set<UserRole> userRole) {
		User localUser = userRepository.findByUsername(user.getUsername());
		
        if(localUser!=null){
        	logger.info("User {} already exist" + user.getUsername());
        }else{
        	
        	for(UserRole ur : userRole)
        	{
        		roleRepository.save(ur.getRole());
        	}
        	
        	user.getUserRoles().addAll(userRole);
        	
        	localUser=userRepository.save(user);
        }
        
        return localUser;
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}
	
	

}
