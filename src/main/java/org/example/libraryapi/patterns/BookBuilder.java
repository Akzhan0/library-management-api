package org.example.libraryapi.patterns;

import org.example.libraryapi.model.Book;
import org.example.libraryapi.model.EBook;
import org.example.libraryapi.model.PrintedBook;

public class BookBuilder {

    private final Book book;

    private BookBuilder(Book book) {
        this.book = book;
    }

    public static BookBuilder ebook() {
        return new BookBuilder(new EBook());
    }

    public static BookBuilder printed() {
        return new BookBuilder(new PrintedBook());
    }

    // fluent common
    public BookBuilder title(String title) { book.setTitle(title); return this; }
    public BookBuilder author(String author) { book.setAuthor(author); return this; }
    public BookBuilder isbn(String isbn) { book.setIsbn(isbn); return this; }

    // optional EBook fields
    public BookBuilder downloadUrl(String url) {
        if (book instanceof EBook e) e.setDownloadUrl(url);
        return this;
    }

    public BookBuilder fileSizeMb(Double mb) {
        if (book instanceof EBook e) e.setFileSizeMb(mb);
        return this;
    }

    // optional PrintedBook fields
    public BookBuilder pages(Integer pages) {
        if (book instanceof PrintedBook p) p.setPages(pages);
        return this;
    }

    public BookBuilder coverType(String coverType) {
        if (book instanceof PrintedBook p) p.setCoverType(coverType);
        return this;
    }

    public Book build() {
        return book;
    }
}
