package edu.sec.bnk.service;

import edu.sec.bnk.vo.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
