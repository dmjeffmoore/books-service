package com.dmjeffmoore.booksservice

import com.fasterxml.jackson.annotation.JsonAutoDetect
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/v1/")
class BooksController {

    private val books = mutableMapOf(
            "ISBN1" to Book("title1", "author1", Status.ON_SHELF),
            "ISBN2" to Book("title2", "author2", Status.CHECKED_OUT)
    )

    @GetMapping("/books")
    fun getBooks() = books

    @PostMapping("/books/{isbn}/checkout")
    fun checkoutBook(@PathVariable("isbn") isbn: String): ResponseEntity<Unit> {
        return if (books.containsKey(isbn)) {
            books[isbn] = Book(books[isbn]!!.title, books[isbn]!!.author, Status.CHECKED_OUT)
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/books/{isbn}/return")
    fun returnBook(@PathVariable("isbn") isbn: String): ResponseEntity<Unit> {
        return if (books.containsKey(isbn)) {
            books[isbn] = Book(books[isbn]!!.title, books[isbn]!!.author, Status.ON_SHELF)
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class Book(val title: String, val author: String, val status: Status)

enum class Status { ON_SHELF, CHECKED_OUT  }