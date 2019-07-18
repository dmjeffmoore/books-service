package com.dmjeffmoore.booksservice

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BooksServiceApplicationTests {

    @Test
    @Tag("integration")
    fun contextLoads() {
    }
}
