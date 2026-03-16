package com.example.BookSecurity.Controller;

import com.example.BookSecurity.DTO.BookRequest;
import com.example.BookSecurity.DTO.BookResponse;
import com.example.BookSecurity.service.BookService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor

public class BookController {
    private  final BookService bookService;


    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest request){
        return ResponseEntity.ok(bookService.addBook(request));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return
                 ResponseEntity.ok().build();
    }

}
