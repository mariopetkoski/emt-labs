package com.example.emt_lab.service.impl;

import com.example.emt_lab.model.Author;
import com.example.emt_lab.repository.AuthorRepository;
import com.example.emt_lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> save(Author author) {
        return Optional.of(this.authorRepository.save(new Author(author.getName(), author.getSurname(), author.getCountry())));
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
