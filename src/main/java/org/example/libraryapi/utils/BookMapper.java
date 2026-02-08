package org.example.libraryapi.utils;

import org.example.libraryapi.dto.BookRequest;
import org.example.libraryapi.dto.BookResponse;
import org.example.libraryapi.model.Book;
import org.example.libraryapi.patterns.BookFactory;

public final class BookMapper {

    private BookMapper() {}

    // Factory Pattern usage: creates EBook/PrintedBook and returns base type Book
    public static Book toEntity(BookRequest req) {
        return BookFactory.create(req);
    }

    public static BookResponse toResponse(Book b) {
        return new BookResponse(
                b.getId(),
                b.getTitle(),
                b.getAuthor(),
                b.getIsbn()
        );
    }
}

