package com.libracore.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.libracore.app.dto.Book.BookRequest;
import com.libracore.app.dto.Book.BookResponse;
import com.libracore.app.entity.Book;
import com.libracore.app.repository.BookRepository;
import com.libracore.app.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    @Override
    public BookResponse addBook(BookRequest request) {
        if(bookRepository.existsByIsbn(request.getIsbn())){
            throw new IllegalArgumentException("Book with ISBN already exists");
        }

        Book book = Book.builder()
                        .isbn(request.getIsbn())
                        .title(request.getTitle())
                        .author(request.getAuthor())
                        .category(request.getCategory())
                        .availableCopies(request.getTotalCopies())
                        .build();
        Book saved = bookRepository.save(book);

        return mapToResponse(saved);
    }

    @Override
    public BookResponse updateBook(Long id, BookRequest request) {
        Book existing = bookRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("Book not found")
        );

        existing.setTitle(request.getTitle());
        existing.setAuthor(request.getAuthor());
        existing.setCategory(request.getCategory());
        existing.setTotalCopies(request.getTotalCopies());

        Book update = bookRepository.save(existing);
        return mapToResponse(update);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookResponse> getAllBook() {
        return bookRepository.findAll().stream().map(this::mapToResponse).toList();
    }
    
    private BookResponse mapToResponse(Book book){
        return new BookResponse(
            book.getId(), 
            book.getIsbn(), book.getTitle(),
            book.getAuthor(),
            book.getCategory(),
            book.getAvailableCopies()
        );
    }

}
