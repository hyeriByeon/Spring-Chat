package org.spring.chatting.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.spring.chatting.model.ChatRoom;
import org.spring.chatting.model.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChatDAOImpl implements ChatDAO {

	@Autowired
	SqlSession sqlSession;

	@Inject
	private static String name = "org.spring.mappers.chatMapper";

	@Override
	public List<ChatRoom> listChatRoom(Criteria cri) throws Exception {
		return sqlSession.selectList(name + ".listChatRoom", cri);
	}

	@Override
	public void createRoom(ChatRoom room) throws Exception {
		sqlSession.update(name + ".createRoom", room);
	}

	@Override
	public ChatRoom getRoom(int roomNo) throws Exception {
		return sqlSession.selectOne(name + ".getRoom", roomNo);
	}

	@Override
	public String getMembers(int roomNo) throws Exception {
		return sqlSession.selectOne(name+".getMembers", roomNo);
	}

	@Override
	public void addMember(Map<String, String> params) throws Exception {
		sqlSession.update(name+".addMember", params);
	}

	@Override
	public void removeRoom(int roomNo) throws Exception {
		sqlSession.delete(name+".removeRoom", roomNo);
	}

	@Override
	public ChatRoom getRoomByOwner(String owner) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(name + ".getRoomByOwner" , owner);
	}
	
	@Override
   public void updatePass(Map<String, String> params) throws Exception {
      sqlSession.update(name+".updatePass", params);
   }

	@Override
	public String getOwner(int roomNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(name + ".getOwner", roomNo);
	}

	@Override
	public void updateOwner(Map<String, String> params2) throws Exception {
		sqlSession.update(name + ".updateOwner", params2);
	}

	@Override
	public int getTotalRoomNum() throws Exception {
		return sqlSession.selectOne(name+".countRoom");
	}

}
