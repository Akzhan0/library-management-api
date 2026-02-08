package org.example.libraryapi.service;

import org.example.libraryapi.dto.BookRequest;
import org.example.libraryapi.dto.BookResponse;
import org.example.libraryapi.exception.NotFoundException;
import org.example.libraryapi.model.Book;
import org.example.libraryapi.repository.BookRepository;
import org.example.libraryapi.patterns.BookBuilder;
import org.example.libraryapi.patterns.BookFactory;   // ✅ Factory используется
import org.example.libraryapi.utils.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    // ===================== CREATE (BUILDER PATTERN) =====================
    public BookResponse create(BookRequest req) {
        Book book;

        if (req.getType() != null && req.getType().equalsIgnoreCase("EBOOK")) {
            book = BookBuilder.ebook()
                    .title(req.getTitle())
                    .author(req.getAuthor())
                    .isbn(req.getIsbn())
                    .downloadUrl(req.getDownloadUrl())
                    .fileSizeMb(req.getFileSizeMb())
                    .build();
        } else {
            // PRINTED BOOK по умолчанию
            book = BookBuilder.printed()
                    .title(req.getTitle())
                    .author(req.getAuthor())
                    .isbn(req.getIsbn())
                    .pages(req.getPages())
                    .coverType(req.getCoverType())
                    .build();
        }

        Book saved = repo.save(book);
        return BookMapper.toResponse(saved);
    }

    // ===================== READ ALL =====================
    public List<BookResponse> getAll() {
        return repo.findAll()
                .stream()
                .map(BookMapper::toResponse)
                .toList();
    }

    // ===================== READ BY ID =====================
    public BookResponse getById(Long id) {
        Book b = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found with id: " + id));
        return BookMapper.toResponse(b);
    }

    // ===================== UPDATE (FACTORY PATTERN) =====================
    public BookResponse update(Long id, BookRequest req) {
        Book existing = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found with id: " + id));

        // ✅ Factory создаёт нужный подкласс Book (EBook/PrintedBook)
        // и мы переносим id, чтобы обновление стало update, а не insert
        Book updated = BookFactory.create(req);
        setId(updated, existing.getId());

        Book saved = repo.save(updated);
        return BookMapper.toResponse(saved);
    }

    // ===================== DELETE =====================
    public void delete(Long id) {
        Book b = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found with id: " + id));
        repo.delete(b);
    }

    // Вспомогательный метод: установить id через reflection (потому что id private)
    // Это нужно, чтобы update работал корректно.
    private void setId(Book book, Long id) {
        try {
            var field = Book.class.getDeclaredField("id");
            field.setAccessible(true);
            field.set(book, id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set id for update", e);
        }
    }
}




