package ca.paruvendu.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import ca.paruvendu.domain.User;
import ca.paruvendu.domain.security.UserRole;

@Service
public interface UserService {
	
	public User createUser(User user , Set<UserRole> userRole);
    public User findByUserName(String userName);
    public  User findByEmail(String email);
    public User save (User user);
    public User findOne(Long id);
}
