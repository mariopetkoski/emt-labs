package com.example.emt_lab.config;

import com.example.emt_lab.model.Author;
import com.example.emt_lab.model.Book;
import com.example.emt_lab.model.Country;
import com.example.emt_lab.model.dto.BookDto;
import com.example.emt_lab.model.enumerations.Category;
import com.example.emt_lab.repository.AuthorRepository;
import com.example.emt_lab.repository.BookRepository;
import com.example.emt_lab.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public DataInitializer(CountryRepository countryRepository, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @PostConstruct
    public void init(){

        Country country1 = new Country("Argentina","South America");
        Country country2 = new Country("Portugal","Europe");
        Country country3 = new Country("Macedonia", "Europe");


        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);

        Author author1 = new Author("Mario","Petkoski", country3);
        Author author2 = new Author("Cristiano","Ronaldo", country2);
        Author author3 = new Author("Lionel","Messi", country1);


        this.authorRepository.save(author1);
        this.authorRepository.save(author2);
        this.authorRepository.save(author3);

        Book book1 = new Book("Book 1", Category.NOVEL, author1,10);
        Book book2 = new Book("Book 2", Category.CLASSICS,author2,25);
        Book book3 = new Book("Book 3", Category.BIOGRAPHY, author3,5);

        BookDto bookDto1 = new BookDto(book1.getName(), book1.getCategory(), book1.getAuthor(), book1.getAvailableCopies());
        BookDto bookDto2 = new BookDto(book2.getName(), book2.getCategory(), book2.getAuthor(), book2.getAvailableCopies());
        BookDto bookDto3 = new BookDto(book3.getName(), book3.getCategory(), book3.getAuthor(), book3.getAvailableCopies());

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
        this.bookRepository.save(book3);

//        Country macedonia = new Country("Macedonia", "Europe");
//        Country portugal = new Country("Portugal", "Europe");
//        Country argentina = new Country("Argentina", "South America");
//
//        Author mario = new Author("Mario", "Petkoski", macedonia);
//        Author cristiano = new Author("Cristiano", "Ronaldo", portugal);
//        Author messi = new Author("Lionel", "Messi", argentina);
//
//        Book book1 = new Book("Book1", Category.DRAMA, mario, 5);
//        Book book2 = new Book("Book2", Category.HISTORY, cristiano, 10);
//        Book book3 = new Book("Book3", Category.BIOGRAPHY, messi, 15);
//
//        BookDto bookDto1 = new BookDto(book1.getName(), book1.getCategory(), book1.getAuthor(), book1.getAvailableCopies());
//        BookDto bookDto2 = new BookDto(book2.getName(), book2.getCategory(), book2.getAuthor(), book2.getAvailableCopies());
//        BookDto bookDto3 = new BookDto(book3.getName(), book3.getCategory(), book3.getAuthor(), book3.getAvailableCopies());
//
//        this.bookService.save(bookDto1);
//        this.bookService.save(bookDto2);
//        this.bookService.save(bookDto3);
    }
}
