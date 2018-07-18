package org.spring.chatting.service;


import java.util.HashMap;
import java.util.Map;

import org.spring.chatting.persistence.ChatDAO;
import org.spring.chatting.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AjaxService {
	
	@Autowired
	UserDAO userdao;
	@Autowired
	ChatDAO chatdao;
	
	public int joinCheckId(String userId) {
		return userdao.userIdCheck(userId);
	}
	
	public String getOwner(int roomNo) throws Exception {
		return chatdao.getOwner(roomNo);
	}


	public void updatePass(int roomNo, String newPass) throws Exception {
		
      Map<String, String> params = new HashMap<>();
      
      params.put("roomNo", roomNo + "");
      params.put("newPass", newPass);
      
      chatdao.updatePass(params);
		   
	}
	
	 public String getUserList(int roomNo) throws Exception {
		 	
		 	String list = "";
		 
		    String members = chatdao.getMembers(roomNo); // 챗룸에 남아있는 멤버들
	
		    if (members.startsWith(",")) {
		       members = members.replaceFirst(",", "");		       
		    }
		    
		    String[] users = members.split(",");
		    
		    for (int i = 0; i < users.length; i++) {
		    	
		       list += userdao.getUser(users[i]).getUserName() + ",";
		    }
		    
		    return list;
	 }
			

}
