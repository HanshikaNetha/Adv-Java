package com.example.BookSecurity.service;


import com.example.BookSecurity.DTO.BookRequest;
import com.example.BookSecurity.DTO.BookResponse;
import com.example.BookSecurity.entity.Book;
import com.example.BookSecurity.repository.BookRepository;
import com.example.BookSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private  final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    //method security: only Admin can add books(Checked before execution)
    @PreAuthorize("hasRole('ADMIN')")
    public BookResponse addBook(BookRequest request){
        Book book = modelMapper.map(request, Book.class);
        Book saved = bookRepository.save(book);

        return modelMapper.map(saved, BookResponse.class);
    }

    //Method security: Only admin can delete books (checked before executions)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    //All authenticated users can view books
    public List<BookResponse> getAllBooks(){
        return bookRepository.findAll().stream()
                .map(book -> modelMapper.map(book, BookResponse.class))
                .collect(Collectors.toList());
    }


    //

}
