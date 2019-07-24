#!/bin/bash
curl -v -d '{"isbn": "9780399590504", "title": "Educated", "author": "Tara Westover"}' -H "Content-type: application/json" -X POST http://localhost:8080/api/v1/books

