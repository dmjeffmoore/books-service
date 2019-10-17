package com.dmjeffmoore.booksservice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@CrossOrigin
@RequestMapping("/api")
class BooksController(private val booksService: BooksService) {

    @GetMapping("/v1/books")
    fun getBooks(): ResponseEntity<List<Book>> {
        return ResponseEntity.status(HttpStatus.OK).body(booksService.getBooks())
    }

    @PutMapping("/v1/books/{isbn}/checkout")
    fun checkoutBook(@PathVariable("isbn") isbn: String, @RequestBody userEmail: String): ResponseEntity<Unit> {
        return if (booksService.checkoutBook(isbn, userEmail)) {
            ResponseEntity.status(HttpStatus.OK).build()
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PutMapping("/v1/books/{isbn}/return")
    fun returnBook(@PathVariable("isbn") isbn: String): ResponseEntity<Unit> {
        return if (booksService.returnBook(isbn)) {
            ResponseEntity.status(HttpStatus.OK).build()
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PostMapping("/v1/books")
    fun addBook(@RequestBody book: BookDto): ResponseEntity<Unit> {
        return if (booksService.addBook(book)) {
            ResponseEntity.status(HttpStatus.CREATED).build()
        } else {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

    @DeleteMapping("/v1/books/{isbn}")
    fun removeBook(@PathVariable("isbn") isbn: String): ResponseEntity<Unit> {
        return if (booksService.removeBook(isbn)) {
            ResponseEntity.status(HttpStatus.OK).build()
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @GetMapping("/v1/books/checked-out/{user-email}")
    fun checkedOutBooks(@PathVariable("user-email") userEmail: String): ResponseEntity<List<Book>> {
        return ResponseEntity.status(HttpStatus.OK).body(booksService.getCheckedOutBooks(userEmail))
    }
}
