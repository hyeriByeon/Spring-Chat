package org.spring.chatting.persistence;

import java.util.List;

import org.spring.chatting.model.User;

public interface UserDAO {
	public int userIdCheck(String userId);
	public void joinUser(User user);
	public User getUser(String userId);
	public void updateUser(User user);
	public int getUserNum();
	public List<User> getUserList();
	public void deleteUser(String userId);
}
