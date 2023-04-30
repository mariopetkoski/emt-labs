package com.example.emt_lab.service.impl;

import com.example.emt_lab.model.Author;
import com.example.emt_lab.model.Book;
import com.example.emt_lab.model.dto.BookDto;
import com.example.emt_lab.model.enumerations.Category;
import com.example.emt_lab.model.exceptions.AuthorNotFoundException;
import com.example.emt_lab.model.exceptions.BookNotFoundException;
import com.example.emt_lab.model.exceptions.notAvailableCopiesException;
import com.example.emt_lab.repository.AuthorRepository;
import com.example.emt_lab.repository.BookRepository;
import com.example.emt_lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {

        //TODO save by authorId instead of author object, fix this in edit too
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow(()->
                new AuthorNotFoundException(bookDto.getAuthorId()));
        Category category = Category.valueOf(bookDto.getCategory().toString());
//        this.bookRepository.deleteBookByName(bookDto.getName());
        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(), category, author, bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto){
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        Author author = this.authorRepository.findById(bookDto.getAuthorId()).orElseThrow(()-> new AuthorNotFoundException(bookDto.getAuthorId()));
        Category category = Category.valueOf(bookDto.getCategory().toString());
        book.setName(bookDto.getName());
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public void rentById(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        if (book.getAvailableCopies()>0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            this.bookRepository.save(book);
        }
        else {
            throw new notAvailableCopiesException();
        }
    }
}
