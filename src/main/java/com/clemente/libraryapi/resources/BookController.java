package com.clemente.libraryapi.resources;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clemente.libraryapi.dto.BookDTO;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookDTO create(){
		BookDTO dto = new BookDTO();
		dto.setAutor("Autor");
		dto.setTitle("Meu livro");
		dto.setIsbn("12345");
		dto.setId(1L);
		return dto;
	}
}
