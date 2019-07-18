package com.dmjeffmoore.booksservice

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.model

@ExtendWith(SpringExtension::class)
@WebMvcTest(ModuleLayer.Controller::class)
class BooksControllerTests {

    @Autowired
    lateinit var mockMvc: MockMvc

//    @Test
//    @Tag("integration")
//    fun `books returns books`() {
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books"))
//                .andExpect(status().isOk)
//                .andExpect(model().attributeExists("ISBN1"))
//                .andExpect(model().attributeExists("ISBN2"))
//    }
}