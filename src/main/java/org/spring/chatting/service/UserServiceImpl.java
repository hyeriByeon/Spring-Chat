package org.spring.chatting.service;

import java.util.List;
import java.util.Map;

import org.spring.chatting.model.User;
import org.spring.chatting.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userdao;
	
	@Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public void createUser(User user) {
		user.setUserPw(this.bcryptPasswordEncoder.encode(user.getUserPw()));
		userdao.joinUser(user);
	}

	@Override
	public User getUser(String userId) {
		return userdao.getUser(userId);
	}
	
	@Override
	public void updateUser(User user) {
		userdao.updateUser(user);
	}
	
   @Override
   public List<User> getUserList() {
      return userdao.getUserList();
   }

   @Override
   public int getUserNum() {
      return userdao.getUserNum();
   }

	@Override
	public void deleteUser(String userId) {
		userdao.deleteUser(userId);
		
	}

}
