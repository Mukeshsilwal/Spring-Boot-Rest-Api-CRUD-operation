package com.api.book.bookapi.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bookapi.Entites.Book;
import com.api.book.bookapi.services.BookService;



@RestController
public class BookController {
    @Autowired
    private BookService bookService;
@GetMapping("/books/{id}")
    public Book getBooks(@PathVariable("id") int id)
    {
     return this.bookService.getBookById(id);
        
    }
    @GetMapping("/books")
    public List<Book> getBook(){
return this.bookService.getAllBooks();
    }
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
    Book b=this.bookService.addBook(book);
        return b;

    }
    @DeleteMapping("/books/{bookid}")
    public void deleteBook(@PathVariable("bookid") int bookid){
this.bookService.deleteBook(bookid);
    }
    @PutMapping("/books/{BookId}")
    public Book updateBook(@RequestBody Book book,@PathVariable("BookId") int BookId){
        this.bookService.updateBook(book, BookId);
       return book;
    }

}