package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class PostController {
	
	@GetMapping("myposts/{id}")
	public Post getMyPost(@PathVariable("id") String id) {
		System.out.println("In my get "+id);
		
		String url = "https://jsonplaceholder.typicode.com/posts/"+id;
		
		RestClient restClient = RestClient.create();
		Post response = restClient.get()
		.uri(url)
		.retrieve()
		.body(Post.class);
		
		return response;
		
	}
	

}
