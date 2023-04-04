package com.example.emt_lab.service.impl;

import com.example.emt_lab.model.Country;
import com.example.emt_lab.repository.CountryRepository;
import com.example.emt_lab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServiceImp implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImp(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> save(Country country) {
        return Optional.of(this.countryRepository.save(new Country(country.getName(), country.getContinent())));
    }
}
