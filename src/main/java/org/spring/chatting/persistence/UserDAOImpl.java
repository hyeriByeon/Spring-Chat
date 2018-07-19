package org.spring.chatting.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.chatting.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SqlSession sqlSession;
	@Inject
	private static final String name = "org.spring.mappers.userMapper";
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Override
	public int userIdCheck(String userId) {
		return sqlSession.selectOne(name + ".joinIdCheck", userId) != null ? 1 : -1;
	}

	@Override
	public void joinUser(User user) {
		sqlSession.insert(name + ".createUser", user);
	}

	@Override
	public User getUser(String userId) {
		return sqlSession.selectOne(name + ".joinIdCheck", userId);
	}

	@Override
	public void updateUser(User user) {
		sqlSession.update(name + ".updateUser", user);
	}

	@Override
	public int getUserNum() {
		return sqlSession.selectOne(name + ".countUser");
	}

	@Override
	public List<User> getUserList() {
		return sqlSession.selectList(name + ".getUserList");
	}

	@Override
	public void deleteUser(String userId) {
		sqlSession.delete(name + ".delUser");
	}


}
