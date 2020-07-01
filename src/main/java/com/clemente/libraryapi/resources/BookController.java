package com.clemente.libraryapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clemente.libraryapi.dto.BookDTO;
import com.clemente.libraryapi.model.entity.Book;
import com.clemente.libraryapi.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookDTO create(@RequestBody BookDTO dto) {
		Book entity = Book.builder().autor(dto.getAutor()).title(dto.getTitle()).isbn(dto.getIsbn()).build();
		service.save(entity);
		return BookDTO.builder().id(entity.getId()).autor(entity.getAutor()).title(entity.getTitle()).isbn(entity.getIsbn()).build();
	}
}
