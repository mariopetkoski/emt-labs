package com.example.emt_lab.model.dto;

import com.example.emt_lab.model.Author;
import com.example.emt_lab.model.enumerations.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {

    private Long id;
    private String name;
    private Category category;
    private Long authorId;
    private int availableCopies;

    public BookDto(String name, Category category, Long authorId, int availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}
