package com.dmjeffmoore.booksservice

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Book(

        @Id @GeneratedValue val id: Long,
        @get: NotBlank val isbn: String,
        @get: NotBlank val title: String,
        @get: NotBlank val author: String,
        @get: NotBlank var status: Status
)