package com.api.book.bookapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bookapi.Entites.Book;
@Component
public class BookService {
    private static List<Book> list=new ArrayList<>();

    static {
        list.add(new Book(23,"Python","Benjamin"));
        list.add(new Book(33,"c#","Harry"));
    }
    public List<Book> getAllBooks(){
        return list;
    }
    public Book getBookById(int id){
        Book book=null;
book=list.stream().filter(i->(i.getId()==id)).findFirst().get();
return book;
    }
    public Book addBook(Book b){
list.add(b);
return b;
    }
    public void deleteBook(int bid){
list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    }
    public void updateBook(Book book,int BookId){
list=list.stream().map(i->{
    if(i.getId()==BookId){
        i.setAuthor(book.getAuthor());
        i.setTitle(book.getTitle());
    }
    return i;
}).collect(Collectors.toList());
    }
}
