package org.spring.chatting.service;

import java.util.List;

import org.spring.chatting.model.User;

public interface UserService {
	
	public void createUser(User user);
	public User getUser(String user);
	public void updateUser(User user);
	public int getUserNum();
	public List<User> getUserList();
	public void deleteUser(String userId);
}
