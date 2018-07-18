package org.spring.chatting.controller;

import java.security.Principal;

import org.spring.chatting.model.Criteria;
import org.spring.chatting.model.PageMaker;
import org.spring.chatting.model.User;
import org.spring.chatting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/user/*")
@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="joinUser", method=RequestMethod.GET)
	public String join() {
		return "common/join";
	}
	
	@RequestMapping(value="joinUser", method=RequestMethod.POST)
	public String joinUser(User user) {
		service.createUser(user);
		return "redirect:/";
	}
		
	@RequestMapping(value= "updateUser", method = RequestMethod.GET)
	public String userUpdate(Principal principal, Model model) {
		
		User user = service.getUser(principal.getName());

		model.addAttribute("user", user);
		
		return "common/updateUser";
	}
	
	@RequestMapping(value= "updateUser", method = RequestMethod.POST)
	public String userUpdate(User user) {
		
		service.updateUser(user);
		
		return "index";
	}
	
   @RequestMapping(value="userList", method=RequestMethod.GET)
   public String userList(Model model, Criteria cri) {
      PageMaker pagemaker = new PageMaker();
      pagemaker.setCri(cri);
      pagemaker.setTotalCount(service.getUserNum());
      
      model.addAttribute("userList", service.getUserList());
      model.addAttribute("pageMaker", pagemaker);
      
      
      System.out.println(service.getUserList());
      return "common/userList";
   }
   
 /*  @RequestMapping(value="userInfo", method=RequestMethod.GET)
   public String userInfo(Model model, String userId, Criteria cri) {
      model.addAttribute("user", service.getUser(userId));
      model.addAttribute("cri", cri);
      return "common/userInfo";
   }*/
   
   @RequestMapping(value="deleteUser", method = RequestMethod.POST)
   public String delUser(Principal prin){
	   
	   service.deleteUser(prin.getName());
	   
	   return "index";
   }
}
