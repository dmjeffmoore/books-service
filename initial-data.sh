#!/bin/bash
curl -d '{"isbn": "9780399590504", "title": "Educated", "author": "Tara Westover"}' -H "Content-type: application/json" -X POST http://localhost:8080/api/v1/books
curl -d '{"isbn": "9781524763138", "title": "Becoming", "author": "Michelle Obama"}' -H "Content-type: application/json" -X POST http://localhost:8080/api/v1/books
curl -d '{"isbn": "9780735219090", "title": "Where the Crawdads Sing", "author": "Delia Owens"}' -H "Content-type: application/json" -X POST http://localhost:8080/api/v1/books
curl -d '{"isbn": "9781400201655", "title": "Girl, Wash Your Face: Stop Believing the Lies about Who You Are So You Can Become Who You Were Meant to Be", "author": "Rachel Hollis"}' -H "Content-type: application/json" -X POST http://localhost:8080/api/v1/books
curl -d '{"isbn": "9781607747307", "title": "The Life-Changing Magic of Tidying Up: The Japanese Art of Decluttering and Organizing", "author": "Marie Kondo"}' -H "Content-type: application/json" -X POST http://localhost:8080/api/v1/books
curl -d '{"isbn": "9781595620156", "title": "StrengthsFinder 2.0", "author": "Tom Rath"}' -H "Content-type: application/json" -X POST http://localhost:8080/api/v1/books
curl -d '{"isbn": "9780062457714", "title": "The Subtle Art of Not Giving a F*ck: A Counterintuitive Approach to Living a Good Life", "author": "Mark Manson"}' -H "Content-type: application/json" -X POST http://localhost:8080/api/v1/books
curl -d '{"isbn": "9781338236576", "title": "Brawl of the Wild (Dog Man Series #6)", "author": "Dav Pilkey"}' -H "Content-type: application/json" -X POST http://localhost:8080/api/v1/books
curl -d '{"isbn": "9780451524935", "title": "1984 (Signet Classics)", "author": "George Orwell"}' -H "Content-type: application/json" -X POST http://localhost:8080/api/v1/books
curl -d '{"isbn": "9780553380163", "title": "A Brief History of Time", "author": "Stephen Hawking"}' -H "Content-type: application/json" -X POST http://localhost:8080/api/v1/books
