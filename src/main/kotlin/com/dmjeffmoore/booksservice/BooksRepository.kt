package com.dmjeffmoore.booksservice

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BooksRepository: JpaRepository<Book, Long>