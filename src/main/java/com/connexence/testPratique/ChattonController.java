package com.connexence.testPratique;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Validated
public class ChattonController
{
	@Autowired
	private ChattonRepository chattonRepository;

	@GetMapping("/chattons")
	public List<Chatton> getChattons()
	{
		List<Chatton> chattons = chattonRepository.findAll();
		if (chattons.isEmpty())
		{
			Chatton premierChatton = new Chatton();
			premierChatton.setNom("Scott");
			premierChatton.setAge(4);
			premierChatton.setDescriptiion("Beau Chatton");
			chattonRepository.save(premierChatton);

			Chatton deuxiemeChatton = new Chatton();
			deuxiemeChatton.setNom("Marie-Antoinette");
			deuxiemeChatton.setAge(2);
			deuxiemeChatton.setDescriptiion("Mignon Chatton");
			chattonRepository.save(deuxiemeChatton);

			chattons = chattonRepository.findAll();
		}
		chattons = chattonRepository.findAll();
		
		// TODO: Filtrer et inverser la liste des chattons ici 
		chattons.removeIf(chatton -> chatton.getAge() > 15);
		Collections.reverse(chattons);
		
		return chattons;
	}
	
	@PostMapping("/chattons")
	public Chatton postChatton(@Valid @RequestBody Chatton chatton) {
			return chattonRepository.save(chatton);
	}
	

}
