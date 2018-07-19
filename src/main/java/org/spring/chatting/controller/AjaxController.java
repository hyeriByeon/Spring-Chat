package org.spring.chatting.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.chatting.model.User;
import org.spring.chatting.service.AjaxService;
import org.spring.chatting.service.ChatService;
import org.spring.chatting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
		
		@Autowired
		BCryptPasswordEncoder bcry;
	
		@Autowired
		AjaxService service;
		
		@Autowired
		ChatService chatService;
		
		@Autowired
		UserService userService;
		
		private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
		
		@RequestMapping(value="/JoinCheck", method=RequestMethod.GET)
		public int checkUser(@RequestParam("userId") String userId) throws Exception {
			logger.info("joinCheck in" + userId);
			
			int data  = service.joinCheckId(userId);
		
			return data;
		}
		
	   @RequestMapping(value= "/checkPersonnel", method = RequestMethod.GET)
	   public int getPersonnel(@RequestParam("roomNo")int roomNo) throws Exception {
	
	      String members = chatService.getMembers(roomNo);
	      
	      
	      if(members == null) {
	    	  System.out.println("멤버가널인데?");
	      }
	      
	      if (members.startsWith(",")) {
	         members = members.replaceFirst(",", "");
	      }
	      
	      return members.split(",").length;
	   }
	   
	   @RequestMapping(value= "/isOwner", method = RequestMethod.GET)
	   public int isOwner(@RequestParam("roomNo")int roomNo, @RequestParam("member")String member) throws Exception{
		   	String owner = service.getOwner(roomNo);
	
		   	return owner.equals(member) ? 1 : -1;
	   }
	   
	   
	   @RequestMapping(value = "/updatePw", method = RequestMethod.GET)
	   public int updatePw(int roomNo, String newPass) throws Exception {
	      
	      return service.updatePass(roomNo, newPass);
	   }
		
	 @RequestMapping(value = "/memberOut", method = RequestMethod.GET)
	   public @ResponseBody int memberOut(@RequestParam("userId") String userId, 
			   									@RequestParam("roomNo")int roomNo) throws Exception {
		 int data = chatService.removeMember(roomNo, userId); // 멤버 제거후 방까지 제거되면 return 1 , else return -1
		 
		 return data;
	 }
	 
	 @RequestMapping(value = "/chkPass", method= RequestMethod.GET)
	 public int memberOut(@RequestParam("userPw") String userPw, Principal principal) {
		 User user = userService.getUser(principal.getName());
		
		 return bcry.matches(userPw , user.getUserPw()) ? 1 : -1;
	 }
	 
 
}
