package com.dmjeffmoore.booksservice

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import org.springframework.dao.IncorrectResultSizeDataAccessException
import org.mockito.Mockito.`when` as mockitoWhen
import java.util.*

class BooksServiceTests {

    val booksRepositoryMock: BooksRepository = Mockito.mock(BooksRepository::class.java)
    val booksService = BooksService(booksRepositoryMock)

    @Nested
    inner class CheckoutBook {

        @Test
        fun `returns true after updating status to checked out`() {
            mockitoWhen(booksRepositoryMock.findOne<Book>(any())).thenReturn(Optional.of(Book(null, "isbn1", "title", "author", Status.ON_SHELF)))

            val result = booksService.checkoutBook("isbn1")

            assertTrue(result)
        }

        @Test
        fun `returns false if book is not found`() {
            mockitoWhen(booksRepositoryMock.findOne<Book>(any())).thenReturn(Optional.empty())

            val result = booksService.checkoutBook("isbn1")

            assertFalse(result)
        }

        @Test
        fun `returns false if exception occurs`() {
            mockitoWhen(booksRepositoryMock.findOne<Book>(any())).thenThrow(IncorrectResultSizeDataAccessException::class.java)

            val result = booksService.checkoutBook("isbn1")

            assertFalse(result)
        }
    }

    @Nested
    inner class ReturnBook {

        @Test
        fun `returns true after updating status to on shelf`() {
            mockitoWhen(booksRepositoryMock.findOne<Book>(any())).thenReturn(Optional.of(Book(null, "isbn1", "title", "author", Status.CHECKED_OUT)))

            val result = booksService.returnBook("isbn1")

            assertTrue(result)
        }

        @Test
        fun `returns false if book is not found`() {
            mockitoWhen(booksRepositoryMock.findOne<Book>(any())).thenReturn(Optional.empty())

            val result = booksService.returnBook("isbn1")

            assertFalse(result)
        }

        @Test
        fun `returns false if exception occurs`() {
            mockitoWhen(booksRepositoryMock.findOne<Book>(any())).thenThrow(IncorrectResultSizeDataAccessException::class.java)

            val result = booksService.returnBook("isbn1")

            assertFalse(result)
        }
    }

    @Nested
    inner class AddBook {

        @Test
        fun `returns true after adding book`() {
            val result = booksService.addBook(BookDto("isbn1", "title", "author"))

            assertTrue(result)
        }
    }

    @Nested
    inner class RemoveBook {

        @Test
        fun `returns true after removing book`() {
            mockitoWhen(booksRepositoryMock.findOne<Book>(any())).thenReturn(Optional.of(Book(null, "isbn1", "title", "author", Status.CHECKED_OUT)))

            val result = booksService.removeBook("isbn1")

            assertTrue(result)
        }

        @Test
        fun `returns false if book is not found`() {
            mockitoWhen(booksRepositoryMock.findOne<Book>(any())).thenReturn(Optional.empty())

            val result = booksService.removeBook("isbn1")

            assertFalse(result)
        }

        @Test
        fun `returns false if exception occurs`() {
            mockitoWhen(booksRepositoryMock.findOne<Book>(any())).thenThrow(IncorrectResultSizeDataAccessException::class.java)

            val result = booksService.removeBook("isbn1")

            assertFalse(result)
        }
    }
}