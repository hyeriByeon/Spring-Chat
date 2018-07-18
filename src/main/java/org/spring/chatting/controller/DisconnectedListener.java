//package org.spring.chatting.controller;
//
//import java.util.List;
//
//import org.spring.chatting.model.ChatRoom;
//import org.spring.chatting.model.Message;
//import org.spring.chatting.service.AjaxService;
//import org.spring.chatting.service.ChatService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//
//@Component
//public class DisconnectedListener implements ApplicationListener<SessionDisconnectEvent> {
//
//	@Autowired
//	AjaxService service;
//	@Autowired
//	ChatService chatService;
//	@Autowired
//	SimpMessagingTemplate templet;
//
//	@Override
//	public void onApplicationEvent(SessionDisconnectEvent sessionDisconnectEvent) {
////		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());
////		
////		try {
////			int roomNo = 0;
////			List<ChatRoom> list = chatService.listChatRoom();
////		a: for (int i = 0; i < list.size(); i++) {
////				String[] roomMember = list.get(i).getRoomMember().split(",");
////				for (int j = 0; j < roomMember.length; j++) {
////					if (roomMember[j].equals(headerAccessor.getUser().getName())) {
////						roomNo = list.get(i).getRoomNo();
////						break a;
////					}
////				}
////			}
////
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////	}
////	   
////		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(sessionDisconnectEvent.getMessage());
////		
////		try {
////			
////			Message msg = new Message();
////			
////			int roomNo = 0;
////			
////			String arr = ""; 
////			String[] roomMember = null;
////			List<ChatRoom> list = chatService.listChatRoom();
////
////			a: for (int i = 0; i < list.size(); i++) {
////				roomMember = list.get(i).getRoomMember().split(",");
////
////				for (int j = 0; j < roomMember.length; j++) {
////
////					if (roomMember[j].equals(headerAccessor.getUser().getName())) {
////						roomNo = list.get(i).getRoomNo();
////						
////						break a;
////					}
////				}
////			}
////			
////			
////			chatService.removeMember(roomNo, headerAccessor.getUser().getName());
////			arr = chatService.getMembers(roomNo);	
////			System.out.println("arr : " + arr + " roomNo : " + roomNo );
////			if(arr == null) {
////				return;
////			}
////			
////			msg.setMemberList(arr);
////			msg.setMessage(headerAccessor.getUser().getName()+"님이 퇴장하셨습니다.");
////			System.out.println("멤버" + roomNo + chatService.getMembers(roomNo));
////			
////			templet.convertAndSend("/subscribe/chat/" + roomNo, msg);
//
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
//	}
//
//}