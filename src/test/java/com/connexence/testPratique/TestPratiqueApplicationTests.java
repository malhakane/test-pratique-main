package com.connexence.testPratique;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestPratiqueApplicationTests {
	
	@Autowired
	private ChattonRepository chattonRepository;
	
	@Autowired
	private ChattonController chattonController;

	@Test
	void contextLoads() {
	}
	
	
	@Test
	void testPostChattons() {
		Chatton troisiemeChatton = new Chatton();
		troisiemeChatton.setNom("Marie-Josee");
		troisiemeChatton.setAge(34);
		troisiemeChatton.setDescriptiion("Douillet Chatton");
		chattonRepository.save(troisiemeChatton);
		
		//List<Chatton> chattons = chattonController.n;
		
		//assertTrue(chattons.size() == 0);
	} 
	
	
	@Test
	void testGetChattons() {

		/*Chatton premierChatton = new Chatton();
		premierChatton.setNom("Scott");
		premierChatton.setAge(4);
		premierChatton.setDescriptiion("Beau Chatton");
		chattonRepository.save(premierChatton);

		Chatton deuxiemeChatton = new Chatton();
		deuxiemeChatton.setNom("Marie-Antoinette");
		deuxiemeChatton.setAge(2);
		deuxiemeChatton.setDescriptiion("Mignon Chatton");
		chattonRepository.save(deuxiemeChatton);

		Chatton troisiemeChatton = new Chatton();
		troisiemeChatton.setNom("Marie-Josee");
		troisiemeChatton.setAge(34);
		troisiemeChatton.setDescriptiion("Douillet Chatton");
		chattonRepository.save(troisiemeChatton);*/

		List<Chatton> chattons = chattonController.getChattons();
		
		assertTrue(chattons.size() == 2);

	}
	
}
