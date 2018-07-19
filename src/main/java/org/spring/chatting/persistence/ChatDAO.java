package org.spring.chatting.persistence;

import java.util.List;
import java.util.Map;

import org.spring.chatting.model.ChatRoom;
import org.spring.chatting.model.Criteria;

public interface ChatDAO {

	public List<ChatRoom> listChatRoom(Criteria cri) throws Exception;
	public int getTotalRoomNum() throws Exception;
	public void createRoom(ChatRoom room) throws Exception;
	public void removeRoom(int roomNo) throws Exception;
	public ChatRoom getRoom(int roomNo) throws Exception;
	public ChatRoom getRoomByOwner(String owner) throws Exception;
	public String getMembers(int roomNo) throws Exception;
	public void addMember(Map<String, String> params) throws Exception;
	public int updatePass(Map<String, String> params) throws Exception;
	public String getOwner(int roomNo) throws Exception;
	public void updateOwner(Map<String, String> params2)throws Exception;
}
