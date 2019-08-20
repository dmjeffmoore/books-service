package com.dmjeffmoore.booksservice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@CrossOrigin
@RequestMapping("/api/v1/")
class BooksController(private val booksService: BooksService) {

    @GetMapping("/books")
    fun getBooks(): ResponseEntity<List<Book>> {
        return ResponseEntity.status(HttpStatus.OK).body(booksService.getBooks())
    }

    @PutMapping("/books/{isbn}/checkout")
    fun checkoutBook(@PathVariable("isbn") isbn: String): ResponseEntity<Unit> {
        return if (booksService.checkoutBook(isbn)) {
            ResponseEntity.status(HttpStatus.OK).build()
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PutMapping("/books/{isbn}/return")
    fun returnBook(@PathVariable("isbn") isbn: String): ResponseEntity<Unit> {
        return if (booksService.returnBook(isbn)) {
            ResponseEntity.status(HttpStatus.OK).build()
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PostMapping("/books")
    fun addBook(@RequestBody book: BookDto): ResponseEntity<Unit> {
        return if (booksService.addBook(book)) {
            ResponseEntity.status(HttpStatus.CREATED).build()
        } else {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

    @DeleteMapping("/books/{isbn}")
    fun removeBook(@PathVariable("isbn") isbn: String): ResponseEntity<Unit> {
        return if (booksService.removeBook(isbn)) {
            ResponseEntity.status(HttpStatus.OK).build()
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }
}
