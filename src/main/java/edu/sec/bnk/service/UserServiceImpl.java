package edu.sec.bnk.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.sec.bnk.repository.RoleRepository;
import edu.sec.bnk.repository.UserRepository;
import edu.sec.bnk.vo.Role;
import edu.sec.bnk.vo.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPass;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {		
		user.setPassword(bCryptPass.encode(user.getPassword()));
		user.setActive(1);		
		//int roleId = roleRepository.getRoleId(user.getId());
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
}
