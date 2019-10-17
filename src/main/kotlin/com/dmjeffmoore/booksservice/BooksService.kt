package com.dmjeffmoore.booksservice

import org.springframework.data.domain.Example
import org.springframework.stereotype.Service

@Service
class BooksService(private val booksRepository: BooksRepository) {

    fun getBooks(): List<Book> {
        return booksRepository.findAll()
    }

    fun checkoutBook(isbn: String, userEmail: String): Boolean {
        val book = booksRepository.findOne(Example.of(Book(isbn = isbn)))

        if (!book.isEmpty) {
            book.get().status = Status.CHECKED_OUT
            book.get().checkedOutBy = userEmail;
            booksRepository.save(book.get())
            return true
        }

        return false
    }

    fun returnBook(isbn: String): Boolean {
        val book = booksRepository.findOne(Example.of(Book(isbn = isbn)))

        if (!book.isEmpty) {
            book.get().status = Status.ON_SHELF
            book.get().checkedOutBy = ""
            booksRepository.save(book.get())
            return true
        }

        return false
    }

    fun addBook(book: BookDto): Boolean {
        val newBook = Book(null, book.isbn, book.title, book.author, Status.ON_SHELF)
        booksRepository.save(newBook)
        return true
    }

    fun removeBook(isbn: String): Boolean {
        val book = booksRepository.findOne(Example.of(Book(isbn = isbn)))

        if (!book.isEmpty) {
            booksRepository.delete(book.get())
            return true
        }

        return false
    }

    fun getCheckedOutBooks(userEmail: String): List<Book> {
        return booksRepository.findAll(Example.of(Book(checkedOutBy = userEmail)));
    }
}