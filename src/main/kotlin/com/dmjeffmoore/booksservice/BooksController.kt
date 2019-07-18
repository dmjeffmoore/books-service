package com.dmjeffmoore.booksservice

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/api/v1/")
class BooksController(private val booksService: BooksService) {

    @GetMapping("/books")
    fun getBooks(): ResponseEntity<List<Book>> {
        return ResponseEntity.ok().body(booksService.getBooks())
    }

    @PostMapping("/books/{isbn}/checkout")
    fun checkoutBook(@PathVariable("isbn") isbn: String): ResponseEntity<Unit> {
        return if (booksService.checkoutBook(isbn)) {
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/books/{isbn}/return")
    fun returnBook(@PathVariable("isbn") isbn: String): ResponseEntity<Unit> {
        return if (booksService.returnBook(isbn)) {
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
