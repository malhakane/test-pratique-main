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
		
		chattonController.postChatton(troisiemeChatton);
		List<Chatton> chattons = chattonRepository.findAll();
		
		assertTrue(chattons.size() == 2);
	} 
	
	
	@Test
	void testGetChattons() {
		List<Chatton> chattons = chattonController.getChattons();
		
		assertTrue(chattons.size() == 2);

	}
	
}
