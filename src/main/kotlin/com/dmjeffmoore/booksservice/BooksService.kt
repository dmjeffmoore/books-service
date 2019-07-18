package com.dmjeffmoore.booksservice

import org.springframework.stereotype.Service

@Service
class BooksService(private val booksRepository: BooksRepository) {

    fun getBooks(): List<Book> {
        return booksRepository.findAll()
    }

    fun checkoutBook(isbn: String): Boolean {
        val books = booksRepository.findAll()

        for (book in books) {
            if (book.isbn == isbn) {
                book.status = Status.CHECKED_OUT
                booksRepository.save(book)
                return true
            } else {
                return false
            }
        }

        return false
    }

    fun returnBook(isbn: String): Boolean {
        val books = booksRepository.findAll()

        for (book in books) {
            if (book.isbn == isbn) {
                book.status = Status.ON_SHELF
                booksRepository.save(book)
                return true
            } else {
                return false
            }
        }

        return false
    }
}