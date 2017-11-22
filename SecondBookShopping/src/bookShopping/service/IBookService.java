package bookShopping.service;

import java.util.List;

import bookShopping.model.Book;

public interface IBookService {
     public void addBook(Book b);
     public void updateBook(Book b);
     public List<Book> getBooks(String conditions);
     public Book getBookById(long id);
     public void deleteBook(long id);
}
