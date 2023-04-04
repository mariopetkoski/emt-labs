package com.example.emt_lab.service;


import com.example.emt_lab.model.Author;
import com.example.emt_lab.model.Country;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> save(Author author);

    List<Author> findAll();
}
