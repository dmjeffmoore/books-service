package com.dmjeffmoore.booksservice

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Book(

        @Id
        @GeneratedValue
        val id: Long? = null,
        @Column(unique=true)
        val isbn: String? = null,
        val title: String? = null,
        val author: String? = null,
        var status: Status? = null
)