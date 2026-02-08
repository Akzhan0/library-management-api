package org.example.libraryapi.patterns;

import org.example.libraryapi.dto.BookRequest;
import org.example.libraryapi.model.Book;
import org.example.libraryapi.model.EBook;
import org.example.libraryapi.model.PrintedBook;

public final class BookFactory {

    private BookFactory() {}

    public static Book create(BookRequest req) {
        String type = req.getType() == null ? "" : req.getType().toUpperCase();

        Book book;
        switch (type) {
            case "EBOOK" -> {
                EBook e = new EBook();
                e.setDownloadUrl(req.getDownloadUrl());
                e.setFileSizeMb(req.getFileSizeMb());
                book = e;
            }
            case "PRINTED" -> {
                PrintedBook p = new PrintedBook();
                p.setPages(req.getPages());
                p.setCoverType(req.getCoverType());
                book = p;
            }
            default -> throw new IllegalArgumentException("Unknown book type: " + req.getType());
        }

        book.setTitle(req.getTitle());
        book.setAuthor(req.getAuthor());
        book.setIsbn(req.getIsbn());

        return book;
    }
}

