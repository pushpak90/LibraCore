package com.libracore.app.service;

import java.util.List;

import com.libracore.app.dto.Book.BookRequest;
import com.libracore.app.dto.Book.BookResponse;

public interface BookService {
    BookResponse addBook(BookRequest request);
    BookResponse updateBook(Long id, BookRequest request);
    void deleteBook(Long id);
    List<BookResponse> getAllBook();
}
