package org.spring.chatting.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.chatting.model.ChatRoom;
import org.spring.chatting.model.Criteria;
import org.spring.chatting.model.PageMaker;
import org.spring.chatting.model.User;
import org.spring.chatting.service.ChatService;
import org.spring.chatting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/chat/*")
@Controller
public class ChatController {

	@Autowired
	ChatService chatService;
	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

	@RequestMapping(value = "createRoom", method = RequestMethod.GET)
	public String createRoomGET(Criteria cri, Model model) {
		model.addAttribute("cri", cri);
		return "chat/createRoom";
	}

	@RequestMapping(value = "createRoom", method = RequestMethod.POST) // 방 만들 때
	public String createRoomPost(ChatRoom room, Criteria cri, Principal princ) throws Exception {
		logger.info("-------------------------------->>>>>>>>>>>>>>>>>>>>>>>" + room);

		room.setRoomType(room.getRoomPw() == "" ? "Normal" : "Secret");
		room.setOwner(princ.getName());
		room.setRoomMember(princ.getName());
		
		chatService.createRoom(room); // db에 방 넣어줌
		// 알아서 페이지값이 들어옴
		return	"redirect:/chat/enterRoom";
			
	}
	
	@RequestMapping(value="chatList", method = RequestMethod.GET)
	public String tempPage(Criteria cri, Model model) throws Exception {
		
		PageMaker pagemaker = new PageMaker();
		int total = chatService.totalRoomNum();
		
		pagemaker.setCri(cri);
		pagemaker.setTotalCount(total);
		
		if(cri.getPerPageNum() != 10 || cri.getPage() > pagemaker.getTempEndPage()) {// 
			
			cri.setPage(1);
			cri.setPerPageNum(10);
			
			pagemaker.setCri(cri);
			pagemaker.setTotalCount(total);
		}
		
		model.addAttribute("roomList", chatService.listChatRoom(cri));
		model.addAttribute("pageMaker", pagemaker);
		
		return "chat/chatList";
	}
//	RoomL


	@RequestMapping(value = "enterRoom", method =RequestMethod.GET) // 방 들어갈 때, createRoom후에 url 바꾸기 위해 만듦
	public String chat(Principal princ, Model model, Criteria cri) throws Exception {
		// 방에 멤버 추가해줌
		
		ChatRoom room2 = chatService.getRoomByOwner(princ.getName());
		
		model.addAttribute("room", room2);
		model.addAttribute("cri", cri);
		model.addAttribute("member", userService.getUser(princ.getName()).getUserName());
		return "chat/room";
	}
//	
	@RequestMapping(value = "enterRoom", method =RequestMethod.POST) // 방 들어갈 때, list에서 pick해서 들어갈 때
	public String chat(int roomNo, Principal princ,ChatRoom room, Model model
												, Criteria cri) throws Exception {
		// 방에 멤버 추가해줌
		System.out.println(roomNo +""+ room + "---- -------");

	
		chatService.addMember(roomNo, princ.getName());
		model.addAttribute("cri", cri);
		model.addAttribute("room", chatService.getRoom(roomNo));
		model.addAttribute("member", userService.getUser(princ.getName()).getUserName());

		return "chat/room";
	}
	
}
