package com.example.emt_lab.service;

import com.example.emt_lab.model.Country;

import java.util.Optional;

public interface CountryService {

    Optional<Country> save(Country country);
}
