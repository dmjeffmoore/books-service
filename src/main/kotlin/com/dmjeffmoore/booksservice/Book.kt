package com.dmjeffmoore.booksservice

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Book(

        @Id @GeneratedValue
        val id: Long? = null,
        val isbn: String? = null,
        val title: String? = null,
        val author: String? = null,
        var status: Status? = null
)